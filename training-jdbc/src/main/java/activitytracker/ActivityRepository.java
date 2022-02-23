package activitytracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class ActivityRepository {

    private final JdbcTemplate jdbcTemplate;

    public ActivityRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Activity saveActivity(Activity activity) {
        String sql = "insert into activities(start_time, activity_desc, activity_type) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                    ps.setString(2, activity.getDesc());
                    ps.setString(3, activity.getType().name());
                    return ps;
                }, keyHolder
        );
        int id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
    }

    public int saveActivityWithTrackPoints(Activity activity) {
        checkTrackPoints(activity.getTrackPoints());
        int insertedActivityId = saveActivity(activity).getId();
        saveTrackPoints(insertedActivityId, activity.getTrackPoints());
        return insertedActivityId;
    }

    private void saveTrackPoints(int activityId, List<TrackPoint> trackPoints) {
        String sql = "INSERT INTO track_points (tp_time, lat, lon, activity_id) VALUES (?, ?, ?, ?)";
        trackPoints.forEach(tp -> jdbcTemplate.update(sql, tp.getTime(), tp.getLat(), tp.getLon(), activityId));
    }

    public Activity findActivityById(int id) {
        return jdbcTemplate.queryForObject("select * from activities where id = ?", getActivityRowMapper(), id);
    }

    public List<Activity> listActivities() {
        return jdbcTemplate.query("select * from activities", getActivityRowMapper());
    }

    public Activity findActivityWithTrackPointsById(int id) {
        return jdbcTemplate.queryForObject("select * from activities where id = ?", getActivityWithTrackPointsRowMapper(), id);
    }

    private List<TrackPoint> getTrackPointsById(int id) {
        String sql = "select * from track_points where activity_id = ?";
        return jdbcTemplate.query(sql, getTrackPointRowMapper(), id);
    }

    private void checkTrackPoints(List<TrackPoint> trackPoints) {
        if (trackPoints.stream().anyMatch(tp -> Math.abs(tp.getLat()) > 90 || Math.abs(tp.getLon()) > 180)) {
            throw new IllegalArgumentException("Invalid Track point in activity!");
        }
    }

    private RowMapper<Activity> getActivityRowMapper() {
        return (rs, rowNum) -> new Activity(
                rs.getInt("id"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getString("activity_desc"),
                Type.valueOf(rs.getString("activity_type")));
    }

    private RowMapper<Activity> getActivityWithTrackPointsRowMapper() {
        return (rs, rowNum) -> new Activity(
                rs.getInt("id"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getString("activity_desc"),
                Type.valueOf(rs.getString("activity_type")),
                getTrackPointsById(rs.getInt("id")));
    }

    private RowMapper<TrackPoint> getTrackPointRowMapper() {
        return (rs, rowNum) -> new TrackPoint(
                rs.getInt("id"),
                rs.getDate("tp_time").toLocalDate(),
                rs.getDouble("lat"),
                rs.getDouble("lon")
        );
    }

}
