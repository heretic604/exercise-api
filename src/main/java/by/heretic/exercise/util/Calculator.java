package by.heretic.exercise.util;

public final class Calculator {

    private Calculator() {
    }

    public static Integer calculateMetersPerMinute(Integer meters, Integer minutes) {
        var doubleMeters = meters.doubleValue();
        var doubleMinutes = minutes.doubleValue();
        return (int) (doubleMeters / doubleMinutes);
    }

    public static Integer calculateKilometersPerHour(Integer meters, Integer minutes) {
        var doubleMeters = meters.doubleValue();
        var doubleMinutes = meters.doubleValue();
        var doubleKm = doubleMeters / 1000;
        var doubleHours = doubleMinutes / 60;
        return (int) (doubleKm / doubleHours);
    }

}