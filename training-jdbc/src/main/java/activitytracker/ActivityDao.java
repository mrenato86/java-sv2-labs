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

    public void saveActivity(Activity activity) {
        String sql = "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert activity.", se);
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
