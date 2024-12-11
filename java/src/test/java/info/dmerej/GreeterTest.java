package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GreeterTest {
  @Test
  void nightlyGreeting() {
    // Assert that greeter says "Good night" when current hour is 0 (midnight)
    Greeter greeter = new Greeter();
    String greeting = greeter.greet(0);
    assertEquals("Good night", greeting);
  }

  @Test
  void neverAsserts() {
    // Assert that the assertion in greet() is never thrown, by checking all hours from 0 to 23
    Greeter greeter = new Greeter();
    for (int hour = 0; hour < 24; hour++) {
      greeter.greet(hour);
    }
  }
}
