package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GreeterTest {
  @Test
  void nightlyGreeting() {
    // Assert that greeter says "Good night" when current hour is 0 (midnight)
    Greeter greeter = new Greeter(new FakeClock(0));
    String greeting = greeter.greet();
    assertEquals("Good night", greeting);
  }

  @Test
  void neverAsserts() {
    // Assert that the assertion in greet() is never thrown, by checking all hours from 0 to 23
    FakeClock fakeClock = new FakeClock(0);
    Greeter greeter = new Greeter(fakeClock);
    for (int hour = 0; hour < 24; hour++) {
      fakeClock.setFixedHour(hour);
      try {
        greeter.greet();
      } catch (AssertionError e) {
        fail("Assertion failed at " + hour + " o'clock");
      }
    }
  }

  class FakeClock extends SystemClock {
    private int fixedHour;

    public FakeClock(int fixedHour) {
      this.fixedHour = fixedHour;
    }
  
    @Override
    public int getCurrentHour() {
      return fixedHour;
    }

    public void setFixedHour(int hour) {
      this.fixedHour = hour;
    }
  }
}
