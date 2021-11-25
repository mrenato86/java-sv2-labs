package methodvarargs.examstats;

public class ExamStats {

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Results cannot be empty!");
        }
        int countOfTop = 0;
        int limit = (int) (maxPoints * (limitInPercent / 100.));
        for (int result : results) {
            if (result > limit) {
                countOfTop++;
            }
        }
        return countOfTop;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Results cannot be empty!");
        }
        int limit = (int) (maxPoints * (limitInPercent / 100.));
        for (int result : results) {
            if (result < limit) {
                return true;
            }
        }
        return false;
    }

}
