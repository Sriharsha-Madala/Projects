import Foundation

class CalendarGenerator {
  func generate(yearAndMonth: DateComponents) -> [[Int]]  {
      var days: [[Int]] = []
      let calendar = Calendar.current
      
      days.append([])
      days.append([])
      days.append([])
      days.append([])
      days.append([])
      days.append([])
      
      var dateC = DateComponents()
      dateC.year = yearAndMonth.year
      dateC.month = yearAndMonth.month
      dateC.day = 1
      
      var date = calendar.date(from: dateC)
      
      
      let range = calendar.range(of: .day, in: .month, for: date!)
      let num_days = range!.count
      print("the number is: ", num_days)
      
      date = calendar.date(from: dateC)
      
      let weekday = calendar.component(.weekday, from: date!)
      print("the weekday is: ", weekday)
      
      //var daysBefore = 1
      
      var onedayago = calendar.date(byAdding: DateComponents(day:-(weekday-1)), to: date!)
      var saveTheDate = calendar.date(byAdding: DateComponents(day:-1), to: date!)
      
      var firstD = calendar.component(.day, from: onedayago!)
      var lastD = calendar.component(.day, from: saveTheDate!)
      
      
      print("the day is ", calendar.component(.day, from: onedayago!))
      var startRow = 1
      
      if (weekday > 1) {
          for _ in 1...7{
              days[0].append(firstD)
              //print(firstD)
              firstD+=1
              if (firstD > lastD) {
                  firstD = 1
              }
          }
          
      } else {
          firstD = 1
          startRow = 0
      }
      for row in startRow...5 {
          for _ in 0...6 {
              days[row].append(firstD)
              //print(firstD)
              firstD+=1
              if (firstD > num_days) {
                  firstD = 1
              }
          }
      }
      
      print("the previous day is ", onedayago)
    return days
  }
}

