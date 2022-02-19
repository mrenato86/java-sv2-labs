package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private final DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        String sql = "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            return new Activity(getGeneratedKey(stmt), activity.getStartTime(), activity.getDesc(), activity.getType());
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert activity.", se);
        }
    }

    public int saveActivityWithTrackPoints(Activity activity) {
        String sql = "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            connection.setAutoCommit(false);
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            int id = getGeneratedKey(stmt);
            try {
                saveTrackPoints(id, activity.getTrackPoints(), connection);
            } catch (IllegalArgumentException iae) {
                connection.rollback();
                throw iae;
            }
            connection.commit();
            return id;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert activity.", se);
        }
    }

    private void saveTrackPoints(int activityId, List<TrackPoint> trackPoints, Connection connection) throws SQLException {
        String sql = "INSERT INTO track_points (tp_time, lat, lon, activity_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (TrackPoint tp : trackPoints) {
                if (Math.abs(tp.getLat()) > 90 || Math.abs(tp.getLon()) > 180) {
                    throw new IllegalArgumentException("Invalid Track point in activity!");
                }
                stmt.setDate(1, Date.valueOf(tp.getTime()));
                stmt.setDouble(2, tp.getLat());
                stmt.setDouble(3, tp.getLon());
                stmt.setInt(4, activityId);
                stmt.executeUpdate();
            }
        }
    }

    private int getGeneratedKey(PreparedStatement statement) throws SQLException {
        try (ResultSet rs = statement.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new IllegalStateException("No generated key!");
        }
    }

    public Activity findActivityById(int id) {
        String sql = "SELECT * FROM activities WHERE id=?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            return getOneActivityByQuery(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Error executing SELECT.", se);
        }
    }

    private Activity getOneActivityByQuery(PreparedStatement stmt) throws SQLException {
        try (ResultSet result = stmt.executeQuery()) {
            if (result.next()) {
                return new Activity(
                        result.getInt("id"),
                        result.getTimestamp("start_time").toLocalDateTime(),
                        result.getString("activity_desc"),
                        Type.valueOf(result.getString("activity_type"))
                );
            } else {
                throw new IllegalArgumentException("Cannot find activity by query!");
            }
        }
    }

    public List<Activity> listActivities() {
        String sql = "SELECT * FROM activities";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            return getAllActivitiesByQuery(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Error executing SELECT.", se);
        }
    }

    private List<Activity> getAllActivitiesByQuery(PreparedStatement stmt) throws SQLException {
        try (ResultSet result = stmt.executeQuery()) {
            List<Activity> activities = new ArrayList<>();
            while (result.next()) {
                activities.add(new Activity(
                        result.getInt("id"),
                        result.getTimestamp("start_time").toLocalDateTime(),
                        result.getString("activity_desc"),
                        Type.valueOf(result.getString("activity_type"))
                ));
            }
            return activities;
        }
    }

    public Activity findActivityWithTrackPointsById(int id) {
        String sql = "select * from activities where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            return getActivityWithTrackPointsByQuery(id, stmt, conn);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select activity or track points!", se);
        }
    }

    private Activity getActivityWithTrackPointsByQuery(int id, PreparedStatement stmt, Connection conn) throws SQLException {
        try (ResultSet result = stmt.executeQuery()) {
            if (result.next()) {
                return new Activity(
                        result.getInt("id"),
                        result.getTimestamp("start_time").toLocalDateTime(),
                        result.getString("activity_desc"),
                        Type.valueOf(result.getString("activity_type")),
                        getTrackPointsById(id, conn)
                );
            } else {
                throw new IllegalArgumentException("Cannot find activity by query!");
            }
        }
    }

    private List<TrackPoint> getTrackPointsById(int id, Connection conn) throws SQLException {
        String sql = "select * from track_points where activity_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return getTrackPointsFromResult(stmt);
        }
    }

    private List<TrackPoint> getTrackPointsFromResult(PreparedStatement stmt) throws SQLException {
        List<TrackPoint> trackPoints = new ArrayList<>();
        try (ResultSet result = stmt.executeQuery()) {
            while (result.next()) {
                trackPoints.add(new TrackPoint(
                        result.getInt("id"),
                        result.getDate("tp_time").toLocalDate(),
                        result.getDouble("lat"),
                        result.getDouble("lon"))
                );
            }
        }
        return trackPoints;
    }

}
