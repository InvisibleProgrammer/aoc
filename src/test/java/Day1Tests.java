import com.invisibleProgrammer.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.stream.Stream;

record TestCase(String input, int expected) { }

public class Day1Tests {

  static TestCase[] inputs1 = new TestCase[]{
          new TestCase("(())", 0),
          new TestCase("()()", 0),
          new TestCase("(((", 3),
          new TestCase("(()(()(", 3),
          new TestCase("))(((((", 3),
          new TestCase("())", -1),
          new TestCase("))(", -1),
          new TestCase(")))", -3),
          new TestCase(")())())", -3)
  };

  static TestCase[] inputs2 = new TestCase[]{
          new TestCase(")", 1),
          new TestCase("()())", 5)
  };

  @ParameterizedTest
  @FieldSource("inputs1")
  public void partI(TestCase testCase) {
    Day1 day1 = new Day1(Stream.of(testCase.input()));

    int result = day1.partI();

    Assertions.assertEquals(testCase.expected(), result);
  }

  @ParameterizedTest
  @FieldSource("inputs2")
  public void partII(TestCase testCase) {
    Day1 day1 = new Day1(Stream.of(testCase.input()));

    int result = day1.partII();

    Assertions.assertEquals(testCase.expected(), result);
  }

}
