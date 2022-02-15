package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        ActivityTrackerMain activityTrackerMain = new ActivityTrackerMain();
        Properties props = new Properties();
        try (InputStream is = ActivityTrackerMain.class.getResourceAsStream("/connection.properties")) {
            props.load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Properties read error!", ioe);
        }

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser(props.getProperty("un"));
            dataSource.setPassword(props.getProperty("pd"));
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot reach DataBase!", se);
        }

        try (Connection conn = dataSource.getConnection()) {
            for (Activity activity : activityTrackerMain.makeActivities()) {
                activityTrackerMain.insertActivity(conn, activity);
            }
            System.out.println(activityTrackerMain.getActivityById(conn,3));
            System.out.println();
            activityTrackerMain.getActivities(conn).forEach(System.out::println);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot Connect!", se);
        }
    }

    public List<Activity> makeActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(LocalDateTime.of(2022, 2, 15, 6, 30), "running activity", Type.RUNNING));
        activities.add(new Activity(LocalDateTime.of(2022, 2, 13, 7, 0), "basketball activity", Type.BASKETBALL));
        activities.add(new Activity(LocalDateTime.of(2022, 2, 12, 19, 0), "hiking activity", Type.HIKING));
        activities.add(new Activity(LocalDateTime.of(2022, 2, 14, 6, 20), "running activity", Type.RUNNING));
        activities.add(new Activity(LocalDateTime.of(2022, 2, 15, 7, 20), "basketball activity", Type.BASKETBALL));
        activities.add(new Activity(LocalDateTime.of(2022, 2, 11, 20, 25), "biking activity", Type.BIKING));
        return activities;
    }

    public void insertActivity(Connection connection, Activity activity) {
        String sql = "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert activity.", se);
        }
    }

    public List<Activity> getActivities(Connection connection) {
        String sql = "SELECT * FROM activities";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            return getAllActivitiesByQuery(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Error executing SELECT.", se);
        }
    }

    public Activity getActivityById(Connection connection, int id) {
        String sql = "SELECT * FROM activities WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return getOneActivityByQuery(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Error executing SELECT.", se);
        }
    }

    private List<Activity> getAllActivitiesByQuery(PreparedStatement stmt) {
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
        } catch (SQLException se) {
            throw new IllegalStateException("Error executing SELECT.", se);
        }
    }

    private Activity getOneActivityByQuery(PreparedStatement stmt) {
        try (ResultSet result = stmt.executeQuery()) {
            if (result.next()) {
                return new Activity(
                        result.getInt("id"),
                        result.getTimestamp("start_time").toLocalDateTime(),
                        result.getString("activity_desc"),
                        Type.valueOf(result.getString("activity_type"))
                );
            } else {
                throw new IllegalArgumentException("Cannot find activity by query " + stmt);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Error executing SELECT.", se);
        }
    }

}
