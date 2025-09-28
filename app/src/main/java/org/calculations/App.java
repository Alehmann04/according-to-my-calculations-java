package org.calculations;

public class App {

  public void TestStack() {
    Stack<String> stk = new Stack<String>(3);
    stk.push("a");
    stk.push("b");
    stk.push("c");
    System.out.println(stk);
  }

  public void TestOperations() {
    Operations ops = new Operations();
    System.out.println("Output: " + ops.evaluate("1 + 2 * ( 4 - 3 )"));
  }

  public void TestOperationsVerbose() {
    OperationsVerbose ops = new OperationsVerbose();
    System.out.println("Output: " + ops.evaluate("1 + 2 * ( 4 - 3 )"));
  }

  public static void main(String[] args) {
    new App().TestStack();
    new App().TestOperations();
    //new App().TestOperationsVerbose();
  }
}
