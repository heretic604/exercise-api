package by.heretic.exercise.calculator;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public interface SpeedCalculator {

    /**
     * Calculate meters per minute speed
     *
     * @param meters jogging meters
     * @param time   jogging joggingTime
     * @return meters per minute
     */
    Double calculateMetersPerMinute(Integer meters, LocalTime time);

    /**
     * Calculate kilometers per hour speed
     *
     * @param meters jogging meters
     * @param time   jogging joggingTime
     * @return kilometers per hour
     */
    Double calculateKilometersPerHour(Integer meters, LocalTime time);

}