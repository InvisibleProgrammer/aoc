package com.invisibleProgrammer;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Day3 extends Day {
  private final String singleLineInput;

  record Coordinate(int x, int y) {}

  public Day3(Stream<String> input) {
    super(input);
    singleLineInput = this.input.getFirst();
  }

  @Override
  int partI() {
    Set<Coordinate> houses = new HashSet<>();
    Coordinate lastCoordinate = new Coordinate(0, 0);
    houses.add(lastCoordinate);

    for (int i = 0; i < singleLineInput.length(); i++) {
      lastCoordinate = getNewCoordinate(lastCoordinate, singleLineInput.charAt(i));

      houses.add(lastCoordinate);
    }
    return houses.size();
  }

  @Override
  int partII() {
    Set<Coordinate> houses = new HashSet<>();
    Coordinate santaCoordinate = new Coordinate(0, 0);
    Coordinate roboSantaCoordinate = new Coordinate(0, 0);
    houses.add(santaCoordinate);

    for (int i = 0; i < singleLineInput.length(); i++) {
      if (i % 2 == 0) {
        santaCoordinate = getNewCoordinate(santaCoordinate, singleLineInput.charAt(i));
        houses.add(santaCoordinate);
      } else {
        roboSantaCoordinate = getNewCoordinate(roboSantaCoordinate, singleLineInput.charAt(i));
        houses.add(roboSantaCoordinate);
      }
    }
    return houses.size();
  }

  private Coordinate getNewCoordinate(Coordinate lastCoordinate, char direction) {
    return switch (direction) {
      case '>' -> new Coordinate(lastCoordinate.x, lastCoordinate.y + 1);
      case '<' -> new Coordinate(lastCoordinate.x, lastCoordinate.y - 1);
      case '^' -> new Coordinate(lastCoordinate.x - 1, lastCoordinate.y);
      case 'v' -> new Coordinate(lastCoordinate.x + 1, lastCoordinate.y);
      default -> throw new IllegalStateException("Unexpected value: " + direction);
    };
  }
}
