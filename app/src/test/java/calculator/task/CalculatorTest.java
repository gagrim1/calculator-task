package calculator.task;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Nested
    class Addition {
        @Test
        void shouldAddRoman() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("XVI", calculator.calculate("X + VI"));
        }

        @Test
        void shouldAddArabic() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("17", calculator.calculate("10 + 7"));
        }
    }

    @Nested
    class Subtraction {
        @Test
        void shouldSubtractRoman() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("VII", calculator.calculate("X - III"));
        }

        @Test
        void shouldNotSubtractRoman() {
            Calculator calculator = new CalculatorImpl();
            assertThrows(ValidationException.class, () -> calculator.calculate("II - III"));
        }

        @Test
        void shouldSubtractArabic() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("-2", calculator.calculate("5 - 7"));
        }
    }

    @Nested
    class Multiplication {
        @Test
        void shouldMultiplyRoman() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("C", calculator.calculate("X * X"));
        }

        @Test
        void shouldMultiplyArabic() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("25", calculator.calculate("5 * 5"));
        }
    }

    @Nested
    class Division {
        @Test
        void shouldDivideRoman() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("III", calculator.calculate("X / III"));
        }

        @Test
        void shouldDivideArabic() throws ValidationException {
            Calculator calculator = new CalculatorImpl();
            assertEquals("2", calculator.calculate("6 / 3"));
        }
    }
}
