package by.heretic.exercise.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SpeedCalculatorImplTest {

    @InjectMocks
    private SpeedCalculatorImpl calculator;

    private final Integer meters = 1000;
    private final LocalTime time = LocalTime.of(0, 10);


    @Test
    void calculateMetersPerMinute() {
        Double expected = 100.0;
        var actual = calculator.calculateMetersPerMinute(meters, time);

        assertEquals(expected, actual);
    }

    @Test
    void calculateKilometersPerHour() {
        Double expected = 6.0;
        var actual = calculator.calculateKilometersPerHour(meters, time);

        assertEquals(expected, actual);
    }

}