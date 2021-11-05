package controlselection.month;

public class DayInMonth {

    public int numberOfDays(int year, String month) {
        switch (month.toLowerCase()) {
            case "january":
            case "march":
            case "may":
            case "july":
            case "august":
            case "october":
            case "december":
                return 31;
            case "april":
            case "june":
            case "september":
            case "november":
                return 30;
            case "february":
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }

    }

}
