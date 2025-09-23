package org.calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OperationsTest {

  @Test
  void operationsHasInfix2Postfix() {
    Operations ops = new Operations();
    assertNotNull(
      ops.infix2postfix("2"),
      "operations should have infix2postfix"
    );
    assertEquals(
      "2",
      ops.infix2postfix("2"),
      "operations infix2postfix should return 2"
    );
    assertEquals(
      "1 2 4 3 - * +",
      ops.infix2postfix("1 + 2 * ( 4 - 3 )"),
      "operations infix2postfix should return 1 2 4 3 - * +"
    );
    assertEquals(
      "10 2 3 * +",
      ops.infix2postfix("10 + 2 * 3"),
      "operations infix2postfix should return 10 2 3 * +"
    );
    assertEquals(
      "10 2 + 3 *",
      ops.infix2postfix("( 10 + 2 ) * 3"),
      "operations infix2postfix should return 10 2 + 3 *"
    );
    assertEquals(
      "2 5 +",
      ops.infix2postfix("2 + 5"),
      "operations infix2postfix should return 2 5 +"
    );
    assertEquals(
      "3 6 5 * +",
      ops.infix2postfix("3 + 6 * 5"),
      "operations infix2postfix should return 3 6 5 * +"
    );
    assertEquals(
      "4 2 3 + *",
      ops.infix2postfix("4 * ( 2 + 3 )"),
      "operations infix2postfix should return 4 2 3 + *"
    );
    assertEquals(
      "7 9 + 8 /",
      ops.infix2postfix("( 7 + 9 ) / 8"),
      "operations infix2postfix should return 7 9 + 8 /"
    );
  }

  @Test
  void operationsHasEvaluatePostfix() {
    Operations ops = new Operations();
    assertNotNull(
      ops.evaluatePostFix("2"),
      "operations should have evaluatePostFix"
    );
    assertEquals(
      2.0,
      ops.evaluatePostFix("2"),
      "operations evaluatePostFix should return 2.0"
    );
    assertEquals(
      -1.0,
      ops.evaluatePostFix("1 2 4 3 - * +"),
      "operations evaluatePostFix should return -1.0"
    );
    assertEquals(
      16.0,
      ops.evaluatePostFix("10 2 3 * +"),
      "operations evaluatePostFix should return 16.0"
    );
    assertEquals(
      36.0,
      ops.evaluatePostFix("10 2 + 3 *"),
      "operations evaluatePostFix should return 36.0"
    );
    assertEquals(
      7.0,
      ops.evaluatePostFix("2 5 +"),
      "operations evaluatePostFix should return 7.0"
    );
    assertEquals(
      33.0,
      ops.evaluatePostFix("3 6 5 * +"),
      "operations evaluatePostFix should return 33.0"
    );
    assertEquals(
      20.0,
      ops.evaluatePostFix("4 2 3 + *"),
      "operations evaluatePostFix should return 20.0"
    );
    assertEquals(
      0.5,
      ops.evaluatePostFix("7 9 + 8 /"),
      "operations infix2postfix should return 0.5"
    );
  }

  @Test
  void operationsHasEvaluate() {
    Operations ops = new Operations();
    assertNotNull(ops.evaluate("2"), "operations should have evaluate");
    assertEquals(
      2.0,
      ops.evaluate("2"),
      "operations evaluate should return 2.0"
    );
    assertEquals(
      -1.0,
      ops.evaluate("1 + 2 * ( 4 - 3 )"),
      "operations evaluate should return -1.0"
    );
    assertEquals(
      16.0,
      ops.evaluate("10 + 2 * 3"),
      "operations evaluate should return 16.0"
    );
    assertEquals(
      36.0,
      ops.evaluate("( 10 + 2 ) * 3"),
      "operations evaluate should return 36.0"
    );
    assertEquals(
      7.0,
      ops.evaluate("2 + 5"),
      "operations evaluate should return 7.0"
    );
    assertEquals(
      33.0,
      ops.evaluate("3 + 6 * 5"),
      "operations evaluate should return 33.0"
    );
    assertEquals(
      20.0,
      ops.evaluate("4 * ( 2 + 3 )"),
      "operations evaluate should return 20.0"
    );
    assertEquals(
      0.5,
      ops.evaluate("( 7 + 9 ) / 8"),
      "operations infix2postfix should return 0.5"
    );
  }
}
