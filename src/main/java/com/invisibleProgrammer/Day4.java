package com.invisibleProgrammer;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.stream.Stream;

public class Day4 extends Day {
  private final String singleLineInput;

  public Day4(Stream<String> input) {
    super(input);
    singleLineInput = this.input.getFirst();
  }

  @Override
  int partI() {
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      String md5hash = DigestUtils.md5Hex(singleLineInput + i);

      if (md5hash.startsWith("00000")) {
        return i;
      }
    }

    return -1;
  }

  @Override
  int partII() {
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      String md5hash = DigestUtils.md5Hex(singleLineInput + i);

      if (md5hash.startsWith("000000")) {
        return i;
      }
    }

    return -1;
  }
}
