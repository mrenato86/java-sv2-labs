package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ActivityRepositoryTest {

    ActivityRepository activityRepository;
    List<Activity> testActivities;

    @BeforeEach
    void init() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream is = ActivityTrackerMain.class.getResourceAsStream("/connection.properties")) {
            props.load(is);
        }

        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
        dataSource.setUser(props.getProperty("un"));
        dataSource.setPassword(props.getProperty("pd"));

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityRepository = new ActivityRepository(dataSource);

        testActivities = new ArrayList<>(List.of(
                new Activity(LocalDateTime.of(2022, 2, 15, 6, 30), "running activity", Type.RUNNING),
                new Activity(LocalDateTime.of(2022, 2, 13, 7, 0), "basketball activity", Type.BASKETBALL),
                new Activity(LocalDateTime.of(2022, 2, 12, 19, 0), "hiking activity", Type.HIKING),
                new Activity(LocalDateTime.of(2022, 2, 14, 6, 20), "running activity", Type.RUNNING),
                new Activity(LocalDateTime.of(2022, 2, 15, 7, 20), "basketball activity", Type.BASKETBALL),
                new Activity(LocalDateTime.of(2022, 2, 11, 20, 25), "biking activity", Type.BIKING)
        ));
        testActivities.forEach(activityRepository::saveActivity);
    }

    @Test
    void testSaveActivity() {
        Activity last = new Activity(LocalDateTime.now().withNano(0), "biking activity", Type.BIKING);
        Activity activityWithKey = activityRepository.saveActivity(last);
        assertEquals(7, activityWithKey.getId());
        assertEquals(last, activityWithKey);
    }

    @Test
    void testFindActivityById() {
        assertEquals(testActivities.get(2), activityRepository.findActivityById(3));
    }

    @Test
    void testListActivities() {
        List<Activity> result = activityRepository.listActivities();
        assertEquals(6, result.size());
    }

    @Test
    void testSaveActivityWithTrackPointsOK() {
        List<TrackPoint> trackPoints = List.of(
                new TrackPoint(LocalDate.of(2021, 2, 24), 47.2181020, 18.5411940),
                new TrackPoint(LocalDate.of(2021, 2, 24), 47.2181230, 18.5411780),
                new TrackPoint(LocalDate.of(2020, 12, 14), 47.2302470, 18.5472280)
        );
        Activity activity = new Activity(LocalDateTime.of(2020, 12, 14, 15, 30), "Running With GPS", Type.RUNNING, trackPoints);
        int id = activityRepository.saveActivityWithTrackPoints(activity);
        assertEquals(activity, activityRepository.findActivityWithTrackPointsById(id));
    }

    @Test
    void testSaveActivityWithTrackPointsWrong() {
        List<TrackPoint> trackPoints = List.of(
                new TrackPoint(LocalDate.of(2020, 12, 14), 47.2302470, 18.5472280),
                new TrackPoint(LocalDate.of(2020, 12, 14), 47.2302550, 181.5472310),
                new TrackPoint(LocalDate.of(2020, 12, 14), 47.2302552, 18.5472312)
        );
        Activity activity = new Activity(LocalDateTime.of(2020, 12, 14, 15, 30), "Running With GPS", Type.RUNNING, trackPoints);
        assertThrows(IllegalArgumentException.class,
                () -> activityRepository.saveActivityWithTrackPoints(activity));
    }

}