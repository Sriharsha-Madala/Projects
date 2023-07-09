/*
 * Copyright (C) 2022-2023 David C. Harrison. All right reserved.
 *
 * You may not use, distribute, publish, or modify this code without
 * the express written permission of the copyright holder.
 */

import React from 'react';
import {Button, Text, StyleSheet, View} from 'react-native';

import CalendarGenerator from '../Logic/CalendarGenerator';

const CalendarGeneratorView = () => {
  const [month, setMonth] = React.useState(new Date().getMonth());
  const [date, setDate] = React.useState('May 2023');
  const [days, setDays] = React.useState(
    '30, 1, 2, 3, 4, 5, 6\n7, 8, 9, 10, 11, 12, 13\n14, 15, 16, 17, 18, 19, 20\n21, 22, 23, 24, 25, 26, 27\n28, 29, 30, 31, 1, 2, 3\n4, 5, 6, 7, 8, 9, 10',
  );
  var year = 2023;

  const monthsOfTheYear = [
    'January',
    'Febuary',
    'March',
    'April',
    'May',
    'June',
    'July',
    'August',
    'September',
    'October',
    'November',
    'December',
  ];
  const StartMonth = () => {
    var day = new Date();
    var calendar = generateString(day);
    setDays(calendar);
    setMonth(day.getMonth());
    setDate(
      monthsOfTheYear[day.getMonth()] + ' ' + day.getFullYear().toString(),
    );
  };
  const NextMonth = () => {
    var day = new Date(year, month + 1, 1);
    var calendar = generateString(day);
    setDays(calendar);
    setMonth(month + 1);
    setDate(
      monthsOfTheYear[day.getMonth()] + ' ' + day.getFullYear().toString(),
    );
    console.log(month);
  };
  const PrevMonth = () => {
    var day = new Date(year, month - 1, 1);
    var calendar = generateString(day);
    setDays(calendar);
    setMonth(month - 1);
    setDate(
      monthsOfTheYear[day.getMonth()] + ' ' + day.getFullYear().toString(),
    );
    console.log(month);
  };
  const generateString = value => {
    var arrays = CalendarGenerator.generate(value);
    var string = arrays[0].join(', ');
    string += '\n';
    for (var row = 1; row < 5; row++) {
      string += arrays[row].join(', ');
      string += '\n';
    }
    string += arrays[5].join(', ');
    return string;
  };
  return (
    <View style={styles.container}>
      <View style={styles.title}>
        <Text>Calendar Generator</Text>
      </View>
      <Text style={styles.month} accessibilityLabel="month">
        {date}
      </Text>
      <Text style={styles.days} accessibilityLabel="calendar">
        {days}
      </Text>
      <View style={styles.buttons}>
        <Button
          accessibilityLabel="previous"
          title="Previous"
          onPress={() => PrevMonth()}
        />
        <Button
          accessibilityLabel="today"
          title="Today"
          onPress={() => StartMonth()}
        />
        <Button
          accessibilityLabel="next"
          title="Next"
          onPress={() => NextMonth()}
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flexDirection: 'column',
  },
  title: {
    flexDirection: 'row',
    alignContent: 'center',
    paddingTop: 20,
    paddingBottom: 10,
    paddingLeft: 120,
    paddingRight: 120,
    justifyContent: 'space-around',
  },
  month: {
    flexDirection: 'row',
    alignContent: 'center',
    paddingTop: 0,
    paddingBottom: 10,
    paddingLeft: 150,
    paddingRight: 150,
    justifyContent: 'space-around',
  },
  days: {
    flexDirection: 'row',
    alignContent: 'center',
    paddingTop: 0,
    paddingBottom: 10,
    paddingLeft: 110,
    paddingRight: 110,
    justifyContent: 'space-around',
    fontFamily: 'Courier New',
  },
  input: {
    borderRadius: 10,
    height: 40,
    margin: 12,
    marginLeft: 32,
    marginRight: 32,
    borderWidth: 1,
    borderColor: '#d3d3d3',
    padding: 10,
  },
  buttons: {
    flexDirection: 'row',
    alignContent: 'center',
    paddingLeft: 60,
    paddingRight: 60,
    justifyContent: 'space-around',
  },
});

export default CalendarGeneratorView;
