
import SwiftUI

struct Assignment6View: View {
    @EnvironmentObject var model: ViewModel
    var body: some View {
        if model.loggedIn == true {
            WorkspacesList()
        } else {
            LoginView()
        }
    }
}

//#if !TESTING
//struct MainView_Previews: PreviewProvider {
//  static var previews: some View {
//    Assignment6View()
//  }
//}
//#endif
