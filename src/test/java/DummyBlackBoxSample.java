import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Sample Black-Box tests
 * This class demonstrates how to write black-box tests using:
 *
 * Black-box testing focuses on testing the SPECIFICATION WITHOUT
 * looking at the implementation.
 *
 */
public class DummyBlackBoxSample {

        /**
         * SAMPLE TEST X: Dummy test.
         */
        @DisplayName("TX: Dummy Test Run")
        @Test
        public void testDummy() {
                double dummy = 0.0;
                // Dummy Test
                assertEquals(0.0, dummy, 0.01,
                        "Expected successful (0.0) for Dummy Test");
        }

}
