import Foundation

class PostfixCalculator {
  func parse(expression: String) throws -> Double {
      let input = expression.components(separatedBy: " ")
      var stack: [Double] = []
      var answer: Double = 0.0
      for part in input {
          print("helelo")
          switch (part) {
          case "+":
              if stack.count < 2 {
                  throw PostfixCalculatorError.invalidExpression(expression)
              }
              answer = (stack.removeLast() + stack.removeLast())
              stack.append(answer)
          case "-":
              if stack.count < 2 {
                  throw PostfixCalculatorError.invalidExpression(expression)
              }
              let s: Double = stack.removeLast()
              let f: Double = stack.removeLast()
              answer = (f - s)
              stack.append(answer)
          case "*":
              if stack.count < 2 {
                  throw PostfixCalculatorError.invalidExpression(expression)
              }
              answer = (stack.removeLast() * stack.removeLast())
              stack.append(answer)
          case "/":
              if stack.count < 2 {
                  throw PostfixCalculatorError.invalidExpression(expression)
              }
              let s: Double = stack.removeLast()
              let f: Double = stack.removeLast()
              //if s == 0.0 {
               //   throw PostfixCalculatorError.invalidExpression(expression)
              //}
              answer = (f / s)
              stack.append(answer)
          case "^":
              if stack.count < 2 {
                  throw PostfixCalculatorError.invalidExpression(expression)
              }
              let s: Double = stack.removeLast()
              let f: Double = stack.removeLast()
              answer = pow(f, s)
              stack.append(answer)
          default:
              if Double(part) == nil {
                  throw PostfixCalculatorError.invalidExpression(expression)
              }
              stack.append(Double(part)!)
          }
      }
      if stack.count >= 2 {
          throw PostfixCalculatorError.invalidExpression(expression)
      }
      return answer
  }
}
