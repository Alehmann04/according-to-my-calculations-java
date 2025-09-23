package org.calculations;

public class App {

  public String getGreeting() {
    return "Hello World!";
  }

  public void TestStack() {
    Stack<String> stk = new Stack<String>(3);
    stk.push("a");
    stk.push("b");
    stk.push("c");
    System.out.println(stk);
  }

  public void TestOperations() {
    Operations ops = new Operations();
    System.out.println("Output: " + ops.evaluateVerbose("1 + 2 * ( 4 - 3 )"));
  }

  public static void main(String[] args) {
    //new App().TestStack();
    //System.out.println(new App().TestStack());
    new App().TestOperations();
  }
}
