/*
 * Copyright (C) 2022-2023 David C. Harrison. All right reserved.
 *
 * You may not use, distribute, publish, or modify this code without
 * the express written permission of the copyright holder.
 */

export default class {
  /**
   * @param {String} expression Postfix expression
   * @return {Number} result of evaluating expression
   * @throws
   */
  static evaluate(expression) {
    var answer = 0.0;
    const parts = expression.split(' ');
    let len = parts.length;
    var stack = [];
    for (let i = 0; i < len; i++) {
      if (
        parts[i] === '+' ||
        parts[i] === '-' ||
        parts[i] === '*' ||
        parts[i] === '/' ||
        parts[i] === '^'
      ) {
        if (stack.length < 2) {
          throw 'Invalid Expression';
        }
        if (parts[i] === '+') {
          var y = stack.pop();
          var x = stack.pop();
          stack.push(x + y);
        } else if (parts[i] === '-') {
          var y = stack.pop();
          var x = stack.pop();
          stack.push(x - y);
        } else if (parts[i] === '*') {
          var y = stack.pop();
          var x = stack.pop();
          stack.push(x * y);
        } else if (parts[i] === '/') {
          var y = stack.pop();
          var x = stack.pop();
          stack.push(x / y);
        } else {
          var y = stack.pop();
          var x = stack.pop();
          stack.push(Math.pow(x, y));
        }
      } else {
        var n = parseFloat(parts[i]);
        if (isNaN(n)) {
          throw 'Unknown Operator';
        }
        stack.push(n);
      }
    }
    answer = stack.pop();
    //console.log(answer);
    return answer;
  }
}
