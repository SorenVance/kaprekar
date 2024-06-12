package org.kramer;

import java.util.Comparator;

public class KaprekarIterator {
  private static final String KAPREKAR_CONSTANT = "6174";
  public int countIterations(int i) {
    validateValidNumber(i);
    return calculateIterations(String.valueOf(i));
  }

  private static void validateValidNumber(int i) {
    if(i < 1000 || i >= 10000 || i % 1111 == 0)
      throw new IllegalArgumentException("Please supply a 4-digit number with at least 2 different digits");
  }

  private int calculateIterations(String startingNumber) {

    int iterations = 0;
    String resultString = startingNumber;
    do {
      resultString = sortDigitsAndSubtract(resultString);
      iterations++;
    }
    while (!KAPREKAR_CONSTANT.equals(resultString));

    return iterations;
  }

  private String sortDigitsAndSubtract(String i) {
    String descending = sortDigitsDescending(i);
    String ascending = sortDigitsAscending(i);

    int result = toInteger(descending) - toInteger(ascending);
    return leftPad(String.valueOf(result));
  }

  private static Integer toInteger(String value) {
    return Integer.valueOf(value);
  }

  String sortDigitsDescending(String source) {
    return getSortedDigits(String.valueOf(source), Comparator.reverseOrder());
  }

  public String sortDigitsAscending(String source) {
    return getSortedDigits(String.valueOf(source), Comparator.naturalOrder());
  }

  private static String getSortedDigits(String sourceString, Comparator<Character> sortComparator) {
    String sortedDigits = sourceString.chars()
            .mapToObj(c -> (char) c)
            .sorted(sortComparator)
            .collect(StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append)
            .toString();

    return leftPad(sortedDigits);
  }

  private static String leftPad(String str)
  {
    return String.format("%4s", str).replace(' ', '0');
  }
}
