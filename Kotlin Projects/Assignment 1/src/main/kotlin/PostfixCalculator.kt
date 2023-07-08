import java.lang.NumberFormatException
import kotlin.math.pow

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

class PostfixCalculator {
  /**
   * See assignment specification.
   */
  fun parse(expression: String): Double {
    var answer: Double = 0.0
    val parts = expression.split(" ")
    val deque = ArrayDeque<Double>(parts.size)
    for (value in parts) {
      if (value == "+") {
        if (deque.size < 2) {
          throw IllegalArgumentException("Invalid Number of Operands")
        }
        answer = addition(deque.removeFirst().toDouble(), deque.removeFirst().toDouble())
        deque.addFirst(answer)
      }
      else if (value == "-") {
        if (deque.size < 2) {
          throw IllegalArgumentException("Invalid Number of Operands")
        }
        answer = subtraction(deque.removeFirst().toDouble(), deque.removeFirst().toDouble())
        deque.addFirst(answer)
      }
      else if (value == "*") {
        if (deque.size < 2) {
          throw IllegalArgumentException("Invalid Number of Operands")
        }
        answer = multiplcation(deque.removeFirst().toDouble(), deque.removeFirst().toDouble())
        deque.addFirst(answer)
      }
      else if (value == "/") {
        if (deque.size < 2) {
          throw IllegalArgumentException("Invalid Number of Operands")
        }
        answer = division(deque.removeFirst().toDouble(), deque.removeFirst().toDouble())
        deque.addFirst(answer)
      }
      else if (value == "^") {
        if (deque.size < 2) {
          throw IllegalArgumentException("Invalid Number of Operands")
        }
        answer = power(deque.removeFirst().toDouble(), deque.removeFirst().toDouble())
        deque.addFirst(answer)
      }
      else {
        try {
          value.toDouble()
          deque.addFirst(value.toDouble())
        } catch (e: NumberFormatException) {
          throw IllegalArgumentException("Invalid Operator and or Input")
        }
      }
    }
    if (deque.size >= 2) {
      throw IllegalArgumentException("Invalid number of arguments: not enough operators")
    }
    return answer
  }

  fun addition(first: Double, second: Double): Double {
    return second + first
  }

  fun subtraction(first: Double, second: Double): Double {
    return second - first
  }

  fun multiplcation(first: Double, second: Double): Double {
    return second * first
  }

  fun division(first: Double, second: Double): Double {
    if (first == 0.0) {
      throw IllegalArgumentException("Cannot Divide by Zero")
    }
    return second / first
  }

  fun power(first: Double, second: Double): Double {
    return second.pow(first)
  }

}