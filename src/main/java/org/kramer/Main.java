package org.kramer;

import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {

    KaprekarIterator iterator = new KaprekarIterator();
    IntStream.range(1000, 10000)
            .filter(i -> i % 1111 != 0)
            .forEach(i -> System.out.println(i + " took " + iterator.countIterations(i) + " iterations."));
  }
}