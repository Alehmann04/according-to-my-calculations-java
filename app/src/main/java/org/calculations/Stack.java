package org.calculations;

import java.util.Arrays;

public class Stack<E> {

  private static int DEFAULT_SIZE = 10;

  private E[] elements;
  private int head = -1;

  @SuppressWarnings("unchecked")
  public Stack() {
    elements = (E[]) new Object[DEFAULT_SIZE];
  }

  @SuppressWarnings("unchecked")
  public Stack(int capacity) {
    elements = (E[]) new Object[capacity];
  }

  public int size() {
    return head;
  }

  public int length() {
    return elements.length;
  }

  public boolean isEmpty() {
    return (head < 0) ? true : false;
  }

  public boolean push(E entry) {
    head++;
    checkBounds();
    elements[head] = entry;
    return true;
  }

  public E pop() {
    E reply = elements[head];
    head--;
    return reply;
  }

  public E peek() {
    if (head < 0) {
      return null;
    }
    return elements[head];
  }

  public String toString() {
    String reply = "";
    for (int x = 0; x <= head; x++) {
      reply += elements[x] + " ";
    }
    return reply.substring(0, (reply.length() - 1));
  }

  private void checkBounds() {
    if (head < 0) {
      throw new IndexOutOfBoundsException(
        "Index: " + head + ", is out of bounds"
      );
    }
    if (head + 1 >= elements.length) {
      resize();
    }
  }

  private void resize() {
    int newsize = elements.length * 2;
    elements = Arrays.copyOf(elements, newsize);
  }
}
