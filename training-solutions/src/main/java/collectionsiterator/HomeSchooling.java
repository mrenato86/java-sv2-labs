package collectionsiterator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeSchooling {

    private final List<OnlineLesson> lessons = new ArrayList<>();

    public List<OnlineLesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    public void addNewLesson(OnlineLesson lesson) {
        int index = lessons.size();
        if (index == 1) {
            index = lessons.get(0).getStart().isBefore(lesson.getStart()) ? 1 : 0;
        }
        for (int i = 1; i < lessons.size(); i++) {
            LocalDateTime last = lessons.get(i - 1).getStart();
            LocalDateTime actual = lessons.get(i).getStart();
            LocalDateTime newTime = lesson.getStart();
            if (last.isBefore(newTime) && actual.isAfter(newTime)) {
                index = i;
            }
        }
        lessons.add(index, lesson);
    }

    public List<OnlineLesson> getLessonsByTitle(String title) {
        List<OnlineLesson> lessonsByTitle = new ArrayList<>();
        Iterator<OnlineLesson> iterator = lessons.iterator();
        while (iterator.hasNext()) {
            OnlineLesson actual = iterator.next();
            if (actual.getSubject().equalsIgnoreCase(title)) {
                lessonsByTitle.add(actual);
            }
        }
        return lessonsByTitle;
    }

    public void removeLesson(LocalDateTime startTime) {
        for (Iterator<OnlineLesson> iterator = lessons.iterator(); iterator.hasNext(); ) {
            if (iterator.next().getStart().equals(startTime)) {
                iterator.remove();
            }
        }
    }

}
