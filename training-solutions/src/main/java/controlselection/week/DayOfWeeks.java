package controlselection.week;

public class DayOfWeeks {

    public String dayOfWeek(String day) {
        switch (day.toLowerCase()) {
            case "monday":
                return "Start of week";
            case "tuesday":
            case "wednesday":
            case "thursday":
                return "Midweek";
            case "friday":
                return "Almost weekend";
            case "saturday":
            case "sunday":
                return "Weekend";
            default:
                return "Unknown day";
        }
    }

}
