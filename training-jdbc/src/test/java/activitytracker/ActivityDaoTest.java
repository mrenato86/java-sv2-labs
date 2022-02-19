package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivityDaoTest {
    ActivityDao activityDao;
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

        activityDao = new ActivityDao(dataSource);

        testActivities = new ArrayList<>(List.of(
                new Activity(LocalDateTime.of(2022, 2, 15, 6, 30), "running activity", Type.RUNNING),
                new Activity(LocalDateTime.of(2022, 2, 13, 7, 0), "basketball activity", Type.BASKETBALL),
                new Activity(LocalDateTime.of(2022, 2, 12, 19, 0), "hiking activity", Type.HIKING),
                new Activity(LocalDateTime.of(2022, 2, 14, 6, 20), "running activity", Type.RUNNING),
                new Activity(LocalDateTime.of(2022, 2, 15, 7, 20), "basketball activity", Type.BASKETBALL),
                new Activity(LocalDateTime.of(2022, 2, 11, 20, 25), "biking activity", Type.BIKING)
        ));
        testActivities.forEach(activityDao::saveActivity);
    }

    @Test
    void testSaveActivity() {
        Activity last = new Activity(LocalDateTime.now().withNano(0), "biking activity", Type.BIKING);
        Activity activityWithKey = activityDao.saveActivity(last);
        assertEquals(7, activityWithKey.getId());
        assertEquals(last, activityWithKey);
    }

    @Test
    void testFindActivityById() {
        assertEquals(testActivities.get(2), activityDao.findActivityById(3));
    }

    @Test
    void testListActivities() {
        List<Activity> result = activityDao.listActivities();
        assertEquals(6, result.size());
    }

}