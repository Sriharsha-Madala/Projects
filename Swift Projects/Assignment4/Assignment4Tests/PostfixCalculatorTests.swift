import XCTest
@testable import Assignment4

final class PostfixCalculatorTests: XCTestCase {
  
  // Your tests go here
    func testSimpleAddition() throws {
        let result = try PostfixCalculator().parse(expression: "5.0 5.0 +")
        XCTAssertEqual(10.0, result)
    }
    func testSimpleSubtraction() throws {
        let result = try PostfixCalculator().parse(expression: "8.0 5.0 -")
        XCTAssertEqual(3.0, result)
    }
    func testSimpleMultiplication() throws {
        let result = try PostfixCalculator().parse(expression: "2.0 5.0 *")
        XCTAssertEqual(10.0, result)
    }
    func testSimpleDivision() throws {
        let result = try PostfixCalculator().parse(expression: "10.0 2.0 /")
        XCTAssertEqual(5.0, result)
    }
    func testSimplePower() throws {
        let result = try PostfixCalculator().parse(expression: "2.0 3.0 ^")
        XCTAssertEqual(8.0, result)
    }
    func testNegativeNumber() throws {
        let result = try PostfixCalculator().parse(expression: "-8.0 5.0 -")
        XCTAssertEqual(-13.0, result)
    }
    func testRoundingIssue() throws {
        let result = try PostfixCalculator().parse(expression: "1.1 2.2 +")
        XCTAssertEqual(3.3, result, accuracy: 0.001)
    }
    func testInvalidArguments() throws {
        do {
            let _ = try PostfixCalculator().parse(expression: "5.0 + 5.0")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
        do {
            let _ = try PostfixCalculator().parse(expression: "5.0 - 5.0")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
        do {
            let _ = try PostfixCalculator().parse(expression: "5.0 * 5.0")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
        do {
            let _ = try PostfixCalculator().parse(expression: "5.0 / 5.0")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
        do {
            let _ = try PostfixCalculator().parse(expression: "5.0 ^ 5.0")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
        
    }
    func testDivideByZero() throws {
        let result = try PostfixCalculator().parse(expression: "10.0 0.0 /")
        XCTAssertEqual(Double.infinity, result)
        
    }
    func testIncorrectNumberOfArguments() throws {
        do {
            let _ = try PostfixCalculator().parse(expression: "10.0 0.0")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
    }
    func testUnknownOperator() throws {
        do {
            let _ = try PostfixCalculator().parse(expression: "5.0 5.0 !")
            XCTFail("Expecting Error")
        } catch PostfixCalculatorError.invalidExpression {
            print("passed")
        }
        
    }
    
}
