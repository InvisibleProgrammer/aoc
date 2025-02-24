package com.invisibleProgrammer;

import java.util.stream.Stream;

public class Day1 extends Day{
  String oneLineInput;

  public Day1(Stream<String> input) {
    super(input);

    oneLineInput = input.findFirst().orElse("");
  }

  @Override
  public int partI() {
    int floor = 0;

    for (char c : oneLineInput.toCharArray()) {
      if (c == '('){
        floor++;
      } else {
        floor --;
      }
    }

    return floor;
  }

  @Override
  public int partII() {
    int floor = 0;

    for (int i = 0; i < oneLineInput.length(); i++) {
      if (oneLineInput.charAt(i) == '('){
        floor++;
      } else {
        floor --;
      }

      if (floor == -1){
        return i + 1;
      }
    }

    return floor;
  }
}
