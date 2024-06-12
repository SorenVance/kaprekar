package org.kramer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class KaprekarIteratorTests {
  private KaprekarIterator finder;

  @BeforeEach
  void setup() {
    finder = new KaprekarIterator();
  }

  @ParameterizedTest
  @ValueSource(ints = {999, -1234, 10000, 10001, 1111})
  void givenIntegerOutOfRange_ShouldThrowException(int i) {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> finder.countIterations(i));
    assertEquals("Please supply a 4-digit number with at least 2 different digits", e.getMessage());
  }

  @ParameterizedTest
  @CsvSource({"1000,5","1234,3", "4980,7"})
  void givenValidInteger_ReturnsNumberOfIterations(int source, int expectedIterations) {
    int actualIterations = finder.countIterations(source);
    assertEquals(expectedIterations, actualIterations);
  }

  @ParameterizedTest
  @CsvSource({"1234,4321", "4980,9840", "0001,1000"})
  void sortDigitsDescending_SortsDescending(String source, String expected) {
    assertEquals(expected, finder.sortDigitsDescending(source));
  }


  @ParameterizedTest
  @CsvSource({"4321,1234", "4980,0489", "1000, 0001"})
  void sortDigitsAscending_SortsAscending(String source, String expected) {
    assertEquals(expected, finder.sortDigitsAscending(source));
  }
}