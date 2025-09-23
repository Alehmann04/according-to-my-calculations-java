package org.calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void stackHasDefaultSize() {
    Stack<String> stk = new Stack<String>();
    assertNotNull(stk.length(), "stack should have default inital capacity");
  }

  @Test
  void stackHasDefinableSize() {
    Stack<String> stk = new Stack<String>(3);
    assertEquals(
      3,
      stk.length(),
      "stack should have definable inital capacity"
    );
  }

  @Test
  void stackHasPush() {
    Stack<String> stk = new Stack<String>();
    assertNotNull(stk.push("a"), "stack should have `push`");
  }

  @Test
  void stackHasPop() {
    Stack<String> stk = new Stack<String>();
    stk.push("a");
    assertNotNull(stk.pop(), "stack should have `pop`");
  }

  @Test
  void stackHasPeek() {
    Stack<String> stk = new Stack<String>();
    stk.push("a");
    assertEquals("a", stk.peek(), "stack should have `peek`");
  }

  @Test
  void stackHasResize() {
    Stack<String> stk = new Stack<String>(2);
    stk.push("a");
    stk.push("b");
    stk.push("c");
    assertEquals(4, stk.length(), "stack should have `resize`");
  }

  @Test
  void stackHasToString() {
    Stack<String> stk = new Stack<String>();
    stk.push("a");
    stk.push("b");
    stk.push("c");
    assertEquals("a b c", stk.toString(), "stack should have `toString`");
  }

  @Test
  void stackHasIsEmpty() {
    Stack<String> stk = new Stack<String>();
    assertTrue(stk.isEmpty(), "stack should be empty");
    stk.push("a");
    assertFalse(stk.isEmpty(), "stack should not be empty");
  }
}
