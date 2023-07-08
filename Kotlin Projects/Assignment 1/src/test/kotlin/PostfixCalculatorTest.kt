/*
#######################################################################
#
# Copyright (C) 2022-2023 David C. Harrison. All right reserved.
#
# You may not use, distribute, publish, or modify this code without
# the express written permission of the copyright holder.
#
#######################################################################
*/

import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.fail

class PostfixCalculatorTest {
  @Test
  internal fun `integer addition`() {
    assertEquals(12.0, PostfixCalculator().parse("1.0 1.0 + 2.0 + 3.0 5.0 + +"))
  }
  @Test
  internal fun `rounding issue addition`() {
    assertEquals(3.3, PostfixCalculator().parse("1.1 2.2 +"), 0.001)
  }
  @Test
  internal fun `integer subtraction`() {
    assertEquals(1.0, PostfixCalculator().parse("2.0 1.0 -"))
  }
  @Test
  internal fun `integer multiplication`() {
    assertEquals(10.0, PostfixCalculator().parse("2.0 5.0 *"))
  }
  @Test
  internal fun `integer division`() {
    assertEquals(5.0, PostfixCalculator().parse("10.0 2.0 /"))
  }
  @Test
  internal fun `integer power`() {
    assertEquals(8.0, PostfixCalculator().parse("2.0 3.0 ^"))
  }
  @Test
  internal fun `negative number`() {
    assertEquals(-5.0, PostfixCalculator().parse("-2.0 3.0 -"))
  }
  @Test
  internal fun `Positive Infinity`() {
    assertEquals(Double.POSITIVE_INFINITY, PostfixCalculator().parse("-20000000000.0 30.0 ^"))
  }
  @Test
  internal fun `Negative Infinity`() {
    assertEquals(Double.NEGATIVE_INFINITY, PostfixCalculator().parse("-3000000000000000000.0 29.0 ^"))
  }
  @Test
  internal fun `incorrect number of arguments`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 1.0")
    }
  }
  @Test
  internal fun `invalid arguments`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 / 1.0")
    }
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 + 1.0")
    }
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 - 1.0")
    }
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 * 1.0")
    }
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 ^ 1.0")
    }
  }
  @Test
  internal fun `divide by zero`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 0.0 /")
    }
  }
  @Test
  internal fun `unknown operator`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1.0 1.0 !")
    }
  }
}