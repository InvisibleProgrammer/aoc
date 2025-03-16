package com.invisibleProgrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

import static java.lang.Class.forName;

public class Main {
  public static void main(String[] args)
  {
    String aocDay = "2";
    String sessionId = readSessionIdFromEnv();

    Stream<String> input = getInput(aocDay, sessionId);

    Day day = getDay(input, aocDay);
    System.out.printf("Part I: %d%n", day.partI());
    System.out.printf("Part I: %d%n", day.partII());
  }

  @SuppressWarnings("unchecked")
  private static Day getDay(Stream<String> input, String aocDay) {
    String className = "com.invisibleProgrammer.Day" + aocDay;
    try {
      Class<Day> day = (Class<Day>) forName(className);
      Class<?>[] parameterTypes = new Class<?>[]{Stream.class};
      var constructor = day.getConstructor(parameterTypes);
      return constructor.newInstance(input);
    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
             IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  private static Stream<String> getInput(String day, String sessionId) {
    System.out.println("Day: " + day);
//    System.out.println("SessionId: " + sessionId);
    try {
      URI uri = URI.create(String.format("https://adventofcode.com/2015/day/%s/input", day));
      URLConnection connection =uri.toURL().openConnection();
      connection.setRequestProperty("Cookie", String.format("session=%s", sessionId));

      connection.connect();
      InputStream inputStream = connection.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      return reader.lines();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private static String readSessionIdFromEnv() {

    try {
      Path path = Path.of(".env");
      try (Stream<String> lines = Files.lines(path)){
        return Objects.requireNonNull(lines.filter(line -> line.contains("session_cookie"))
                        .findFirst().orElse(null))
                .split("=")[1];
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}