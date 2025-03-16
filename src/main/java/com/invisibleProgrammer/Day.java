package com.invisibleProgrammer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Day {
  List<String> input;

  public Day(Stream<String> input) {
    this.input = input.collect(Collectors.toList());
  }

  int partI() {

    return 0;
  }

  int partII() {
    return 0;
  }
}
