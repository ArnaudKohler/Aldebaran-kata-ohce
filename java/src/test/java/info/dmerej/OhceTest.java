package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class OhceTest {
  @Test
  void testMainLoop() {
    /*
     TODO: check that given the following inputs:
      - hello
      - oto
     - quit

    The following messages are shown to the user:
     - olleh
     - oto
     - That was a palindrome!

    */
    FakeInteractor fakeInteractor = new FakeInteractor("hello", "oto", "quit");
    ArrayList<String> expectedMessages = new ArrayList<>();
    expectedMessages.add("olleh");
    expectedMessages.add("oto");
    expectedMessages.add("That was a palindrome!");
    Ohce ohce = new Ohce(fakeInteractor);
    ohce.mainLoop();
    assertEquals(fakeInteractor.getReversedMessages(), expectedMessages);
  }

  class FakeInteractor implements InteractorInterface {
    private final String[] inputs;
    private int index = 0;
    public ArrayList<String> reversedMessages = new ArrayList<>();

    public FakeInteractor(String... inputs) {
      this.inputs = inputs;
    }

    @Override
    public String readInput() {
      return inputs[index++];
    }

    @Override
    public void printMessage(String message) {
      reversedMessages.add(message);
    }

    public ArrayList<String> getReversedMessages() {
      return reversedMessages;
    }
  }
}
