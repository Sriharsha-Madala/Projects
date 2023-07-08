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
import java.time.YearMonth
import kotlin.test.fail
import java.util.Arrays
import kotlin.test.assertTrue

// leap year, none leap year, random year

class CalendarArrayTest {
  @Test
  internal fun `June Month`() {
    val arr = Array(6) { IntArray(7) }
    var monthIter = 26
    for ( r in 0 until 6) {
      for (c in 0 until 7) {
        if (r == 0) {
          arr[r][c] = monthIter
          monthIter++
          if (monthIter == 32) {
            monthIter = 1
          }
        }
        else {
          arr[r][c] = monthIter
          monthIter++
          if (monthIter == 31) {
            monthIter=1
          }
        }
      }
    }
    assertTrue { arr.contentDeepEquals(CalendarArray().generate(YearMonth.of(2023, 4))) }
  }
  @Test
  internal fun `Random August Month in 1930`() {
    val arr = Array(6) { IntArray(7) }
    var monthIter = 27
    for ( r in 0 until 6) {
      for (c in 0 until 7) {
        if (r == 0) {
          arr[r][c] = monthIter
          monthIter++
          if (monthIter == 32) {
            monthIter = 1
          }
        }
        else {
          arr[r][c] = monthIter
          monthIter++
          if (monthIter == 32) {
            monthIter=1
          }
        }
      }
    }
    assertTrue { arr.contentDeepEquals(CalendarArray().generate(YearMonth.of(1930, 8))) }
  }
  @Test
  internal fun `Leap Month`() {
    CalendarArray().generate(YearMonth.of(2024, 4))
    val leaparr = Array(6) { IntArray(7) }
    var monthIter = 28
    for ( r in 0 until 6) {
      for (c in 0 until 7) {
        if (r == 0) {
          leaparr[r][c] = monthIter
          monthIter++
          if (monthIter == 32) {
            monthIter = 1
          }
        }
        else {
          leaparr[r][c] = monthIter
          monthIter++
          if (monthIter == 30) {
            monthIter=1
          }
        }
      }
    }
    assertTrue { leaparr.contentDeepEquals(CalendarArray().generate(YearMonth.of(2024, 2))) }
  }
  @Test
  internal fun `First Month Sunday`() {
    val leaparr = Array(6) { IntArray(7) }
    var monthIter = 1
    for ( r in 0 until 6) {
      for (c in 0 until 7) {
        leaparr[r][c] = monthIter
        monthIter++
        if (monthIter == 32) {
          monthIter = 1
        }
      }
    }
    assertTrue { leaparr.contentDeepEquals(CalendarArray().generate(YearMonth.of(2023, 1))) }
  }
}