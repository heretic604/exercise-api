package by.heretic.exercise.util;

import static java.lang.Math.round;

public final class Calculator {

    private Calculator() {
    }

    public static Integer calculateMetersPerMinute(Integer meters, Integer minutes) {
        var doubleMeters = meters.doubleValue();
        var doubleMinutes = minutes.doubleValue();
        return (int) round(doubleMeters / doubleMinutes);
    }

    public static Integer calculateKilometersPerHour(Integer meters, Integer minutes) {
        var doubleMeters = meters.doubleValue();
        var doubleMinutes = minutes.doubleValue();
        var doubleKm = doubleMeters / 1000;
        var doubleHours = doubleMinutes / 60;
        return (int) round(doubleKm / doubleHours);
    }

}