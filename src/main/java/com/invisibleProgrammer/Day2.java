package com.invisibleProgrammer;

import java.util.Arrays;
import java.util.stream.Stream;

public class Day2 extends Day {
  public Day2(Stream<String> input) {
    super(input);
  }

  @Override
  int partI() {
    int sum = 0;
    for (String gift : input) {
      int[] dimensions = Arrays.stream(gift.split("x"))
              .mapToInt(Integer::parseInt)
              .toArray();

      Arrays.sort(dimensions);

      sum +=    2 * dimensions[0] * dimensions[1]
              + 2 * dimensions[1] * dimensions[2]
              + 2 * dimensions[0] * dimensions[2];
      sum += dimensions[0] * dimensions[1];
    }

    return sum;
  }

  @Override
  int partII() {
    int sum = 0;
    for (String gift : input) {
      int[] dimensions = Arrays.stream(gift.split("x"))
              .mapToInt(Integer::parseInt)
              .toArray();

      Arrays.sort(dimensions);

      sum +=    2 * dimensions[0] + 2 * dimensions[1];
      sum += dimensions[0] * dimensions[1] * dimensions[2];
    }

    return sum;
  }
}
