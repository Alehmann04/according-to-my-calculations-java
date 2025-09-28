package org.calculations;

public class OperationsVerbose extends Operations {

  public double evaluateVerbose(String expression) {
    String postfix_expression = infix2postfix(expression);
    return evaluatePostFix(postfix_expression);
  }

  public double evaluatePostFix(String postfix_expression) {
    String[] postfix_expression_arr = postfix_expression.split(" ");
    Stack<Double> stk = new Stack<Double>();
    System.out.println("PostFixExpression: " + postfix_expression);
    double temp_a, temp_b = 0.0;
    for (String token : postfix_expression_arr) {
      System.out.println("Token: " + token);
      if (token.matches("^\\d.*")) {
        stk.push(Double.valueOf(token));
      } else {
        if (token.equals("+")) {
          temp_a = stk.pop();
          temp_b = stk.pop();
          System.out.println(
            "Operation: " + temp_a + " + " + temp_b + " = " + (temp_a + temp_b)
          );
          stk.push(temp_a + temp_b);
        } else if (token.equals("-")) {
          temp_a = stk.pop();
          temp_b = stk.pop();
          System.out.println(
            "Operation: " + temp_a + " - " + temp_b + " = " + (temp_a - temp_b)
          );
          stk.push(temp_a - temp_b);
        } else if (
          token.equals("*") || token.equals("x") || token.equals("X")
        ) {
          temp_a = stk.pop();
          temp_b = stk.pop();
          System.out.println(
            "Operation: " + temp_a + " * " + temp_b + " = " + (temp_a * temp_b)
          );
          stk.push(temp_a * temp_b);
        } else if (token.equals("/")) {
          temp_a = stk.pop();
          temp_b = stk.pop();
          System.out.println(
            "Operation: " + temp_a + " / " + temp_b + " = " + (temp_a / temp_b)
          );
          stk.push(temp_a / temp_b);
        }
      }
      System.out.println("Stack: " + stk);
    }
    return stk.pop();
  }

  public String infix2postfix(String infix_expression) {
    Stack<String> output = new Stack<String>();
    Stack<String> stk = new Stack<String>();
    String[] infix_expression_arr = infix_expression.split(" ");
    for (String token : infix_expression_arr) {
      if (token.matches("^\\d.*")) {
        System.out.println("Token: " + token + " is a number: push to output");
        output.push(token);
      } else if (token.equals("(")) {
        System.out.println("Token is a (: push to holding stack");
        stk.push(token);
      } else if (token.equals(")")) {
        System.out.println(
          "Token is a ): empty holding stack into the output until reaching ("
        );
        while (!stk.isEmpty() & !stk.peek().equals("(")) {
          output.push(stk.pop());
        }
        stk.pop();
      } else {
        if (!stk.isEmpty()) {
          System.out.println(
            "Token: " +
            token +
            " is an operator: compair the token and the top of the holding stack"
          );
          while (getPEMDAS(stk.peek()) >= getPEMDAS(token)) {
            System.out.println(
              "Token is " +
              token +
              " and the head of the holding stack is " +
              stk.peek() +
              ": the token's priority of " +
              getPEMDAS(token) +
              " is <= the head of the holding stack's priority of " +
              getPEMDAS(stk.peek()) +
              ": dump the holding stack into the output"
            );
            output.push(stk.pop());
          }
          System.out.println(
            "Token is " +
            token +
            " and the head of the holding stack is " +
            stk.peek() +
            ": the token's priority of " +
            getPEMDAS(token) +
            " is > the head of the holding stack's priority of " +
            getPEMDAS(stk.peek()) +
            ": push the token into the holding stack"
          );
        } else {
          System.out.println(
            "Token: " +
            token +
            " is an operator and holding stack is empty: push into holding stack"
          );
        }
        stk.push(token);
      }
    }
    System.out.println("No more expression: dump holding stack into output");
    while (!stk.isEmpty()) {
      output.push(stk.pop());
    }
    return output.toString();
  }

  private int getPEMDAS(String op) {
    if (op.equals("-")) {
      return 1;
    } else if (op.equals("+")) {
      return 2;
    } else if (op.equals("*") || op.equals("x") || op.equals("X")) {
      return 3;
    } else if (op.equals("/")) {
      return 4;
    } else {
      return 0;
    }
  }
}
