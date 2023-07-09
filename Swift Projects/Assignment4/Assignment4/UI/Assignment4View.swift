import SwiftUI

struct Assignment4View: View {
    @State private var expression: String = ""
    @State private var result: String = ""
    
    private func evaluate() {
        do {
            result = try PostfixCalculator().parse(expression: expression).description
        } catch {
            result = "Error!"
        }
    }
    
    private func reset() {
        result = ""
        expression = ""
    }
    
    var body: some View {
        VStack {
            Label("Postfix Calculator", systemImage: "")
            VStack {
                TextField("Expression", text: $expression)
                    .textFieldStyle(.roundedBorder)
                TextField("Result", text: $result)
                    .disabled(true)
                    .textFieldStyle(.roundedBorder)
                HStack{
                    Button("Evaluate", action: evaluate)
                    Button("Clear", action: reset)
                }
            }
            Spacer()
            Label("Calendar Generator", systemImage: "")
            Spacer()
            
        }
        .padding()
        
    }
    
}

#if !TESTING
struct Assignment4View_Previews: PreviewProvider {
 static var previews: some View {
    Assignment4View()
 }
}
#endif
