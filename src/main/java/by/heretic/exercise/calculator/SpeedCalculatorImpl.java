package by.heretic.exercise.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

import static java.lang.Math.round;

@Component
@RequiredArgsConstructor
public class SpeedCalculatorImpl implements SpeedCalculator {

    @Override
    public Double calculateMetersPerMinute(Integer meters, LocalTime time) {
        var seconds = (double) time.toSecondOfDay();
        var metersDouble = meters.doubleValue();
        return round(metersDouble / seconds * 60.0 * 10.0) / 10.0;
    }

    @Override
    public Double calculateKilometersPerHour(Integer meters, LocalTime time) {
        var seconds = (double) time.toSecondOfDay();
        var metersDouble = meters.doubleValue();
        var speed = (metersDouble / 1000.0) / (seconds / 3600.0);
        return round(speed * 10.0) / 10.0;
    }

}