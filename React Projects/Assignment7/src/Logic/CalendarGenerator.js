/*
 * Copyright (C) 2022-2023 David C. Harrison. All right reserved.
 *
 * You may not use, distribute, publish, or modify this code without
 * the express written permission of the copyright holder.
 */

export default class {
  /**
   * @param {object} date
   * @return {[[Number]]} 6x7 array of integers
   */
  static generate(date) {
    //var actual = Date(date);
    // console.log(date.toString());
    var firstDay = new Date(date.getFullYear(), date.getMonth(), 1).getDay();

    var month = new Array(6);
    for (let i = 0; i < 6; i++) {
      month[i] = new Array(7);
    }

    var numDays = new Date(
      date.getFullYear(),
      date.getMonth() + 1,
      0,
    ).getDate();
    var prevDays = new Date(date.getFullYear(), date.getMonth(), 0).getDate();

    var fillDay = prevDays + 1 - firstDay;
    //console.log(numDays);

    for (var c = 0; c < firstDay; c++) {
      month[0][c] = fillDay;
      fillDay++;
    }

    var day = 1;

    for (var row = 0; row < 6; row++) {
      for (var col = row === 0 ? firstDay : 0; col < 7; col++) {
        if (day > numDays) {
          day = 1;
          month[row][col] = day;
          day++;
        } else {
          month[row][col] = day;
          day++;
        }
      }
    }
    return month;
  }
}
