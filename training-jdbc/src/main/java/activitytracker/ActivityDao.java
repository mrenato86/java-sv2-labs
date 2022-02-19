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

}
