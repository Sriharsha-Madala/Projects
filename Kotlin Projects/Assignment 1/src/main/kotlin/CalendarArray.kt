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

import java.time.YearMonth
import java.time.format.DateTimeFormatter




class CalendarArray {
  /**
   * See assignment specification.
   */
  fun generate(month: YearMonth): Array<IntArray> {
    val lastMonth = YearMonth.of(month.getYear(), month.getMonth()-1)
    val prevmonthLength = lastMonth.lengthOfMonth()+1

    var firstDay = zellars(month.getMonthValue(), month.getYear())
    var monthLength = 0
    var monthIter = 1

    if (month.isLeapYear()) {
      if (month.getMonthValue() == 2) {
        firstDay += 2
        monthLength = 29
      }
    }
    else {
      monthLength = month.lengthOfMonth()
    }
    var startDay = prevmonthLength - firstDay

    val rows = 6
    val cols = 7
    val arr = Array(rows) { IntArray(cols) }
    for ( r in 0 until 6) {
      for (c in 0 until 7) {
        if (firstDay != 0 && r == 0) {
          if (startDay != (prevmonthLength)) {
            arr[r][c] = startDay
            startDay++
          }
          else {
            arr[r][c] = monthIter
            monthIter++
          }
        }
        else {
          arr[r][c] = monthIter
          monthIter++
        }
        if (monthIter > monthLength ) {
          monthIter = 1
        }
      }
    }
    return arr
  }
  fun zellars(month: Int, Year: Int): Int {
    val centuryYear = Year % 100
    var zeroCentury = Year;
    while (zeroCentury > 100) {
      zeroCentury /= 100
    }
    var d = 1 + ((13 * (month + 1)) / 5) + centuryYear + (centuryYear / 4) + (zeroCentury / 4) - (2 * zeroCentury)
    d = Math.abs(d)
    d = d % 7
    d = ((d + 6) % 7)
    return d
  }
}