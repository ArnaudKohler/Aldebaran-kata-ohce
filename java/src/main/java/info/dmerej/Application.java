package info.dmerej;

public class Application {

  private static final SystemClock clock = new SystemClock();

  public static void main(String[] args) {
    var greeter = new Greeter();
    int currentHour = clock.getCurrentHour();
    String greetings = greeter.greet(currentHour);
    System.out.println(greetings);

    var ohce = new Ohce();
    ohce.mainLoop();
  }
}
