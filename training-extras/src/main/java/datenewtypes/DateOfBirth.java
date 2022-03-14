package datenewtypes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private final LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String dateString) {
        validateString(dateString);
        this.dateOfBirth = LocalDate.parse(dateString);
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        validateString(dateString);
        validateString(pattern);
        validateLocale(locale);
        this.dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern, locale));
    }

    public DateOfBirth(String dateString, String pattern) {
        this(dateString, pattern, Locale.getDefault());
    }

    public boolean isWeekDay() {
        return findDayOfWeekEnum().getValue() < 6;
    }

    public boolean wasItALeapYear() {
        return this.dateOfBirth.isLeapYear();
    }

    public String findDayOfWeek() {
        return findDayOfWeekForBirthDate(Locale.getDefault());
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        validateLocale(locale);
        return findDayOfWeekEnum().getDisplayName(TextStyle.FULL, locale);
    }

    public String findBirthDayOfWeekLater(int year) {
        return findDayOfWeekForBirthDate(year, Locale.getDefault());
    }

    public String findDayOfWeekForBirthDate(int years, Locale locale) {
        validateLocale(locale);
        return dateOfBirth.plusYears(years).getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    private DayOfWeek findDayOfWeekEnum() {
        return dateOfBirth.getDayOfWeek();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString(String pattern) {
        validateString(pattern);
        return DateTimeFormatter.ofPattern(pattern).format(dateOfBirth);
    }

    public long countDaysSinceBirth(LocalDate date) {
        if (date.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return ChronoUnit.DAYS.between(dateOfBirth, date);
    }

    public long countDaysBetween(DateOfBirth other) {
        return ChronoUnit.DAYS.between(dateOfBirth, other.dateOfBirth);
    }

    private void validateString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + str);
        }
    }

    private void validateLocale(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
    }

}
