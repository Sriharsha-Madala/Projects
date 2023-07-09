import XCTest
import Foundation

@testable import Assignment4

final class CalendarGeneratorTests: XCTestCase {
  
  // Your tests go here
    
    func test1stOnSunday() throws {
        let calendar = Calendar.current
        let dateComponenets = DateComponents(calendar: calendar, year: 2023, month: 1)
        let result = CalendarGenerator().generate(yearAndMonth: dateComponenets)
        var resultString = ""
        for row in 0...5 {
            for element in 0...6 {
                //print("element is ", element)
                resultString += String(result[row][element])
                if (element != 6) {
                    resultString += " "
                }
            }
            if row != 5 {
                resultString += "\n"
            }
        }
        print("result is", resultString)
        let expected = "1 2 3 4 5 6 7\n8 9 10 11 12 13 14\n15 16 17 18 19 20 21\n22 23 24 25 26 27 28\n29 30 31 1 2 3 4\n5 6 7 8 9 10 11"
        
        XCTAssertEqual(expected, resultString)
        
    }
    
    func test1stRegular() throws {
        let calendar = Calendar.current
        let dateComponenets = DateComponents(calendar: calendar, year: 2023, month: 5)
        let result = CalendarGenerator().generate(yearAndMonth: dateComponenets)
        var resultString = ""
        for row in 0...5 {
            for element in 0...6 {
                //print("element is ", element)
                resultString += String(result[row][element])
                if (element != 6) {
                    resultString += " "
                }
            }
            if row != 5 {
                resultString += "\n"
            }
        }
        print("result is", resultString)
        let expected = "30 1 2 3 4 5 6\n7 8 9 10 11 12 13\n14 15 16 17 18 19 20\n21 22 23 24 25 26 27\n28 29 30 31 1 2 3\n4 5 6 7 8 9 10"
        
        XCTAssertEqual(expected, resultString)
        
    }
}
