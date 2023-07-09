//
//  LoginView.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct LoginView: View {
    @EnvironmentObject var model: ViewModel
    @State var email: String = ""
    @State var password: String = ""
    //@State var credentials: LoginCredentials
  var body: some View {
    VStack {
        //Spacer()
        Text("CSE118 Assignment 6")
        Image("SlugLogo")
            .resizable()
            .aspectRatio(contentMode: .fill)
            .frame(width: 150, height: 150)
            .clipped()
        TextField("Email", text: $email)
            //.textCase(.lowercase)
            .textInputAutocapitalization(.never)
            //.textCase(.lowercase)
            .accessibilityLabel("EMail")        //Spacer()
        SecureField("Password", text: $password) //TextField("Password", text: $password)
            
        //Spacer()
        Button(action: {
            // create a task , inside the task use await model.addWorkspace
            // task { await model.addworkspaces}
            //
            // model.getworkspaces
            model.login(credentials: LoginCredentials(email: email, password: password))
        }) {
            Text("Login")
        }
        .accessibilityIdentifier("Login")
      Spacer()
      Spacer()
    }
    .padding()
    //.onAppear {
     //   model.login(credentials: LoginCredentials(username: email, password: password))
    //}
  }
}

#if !TESTING
struct MainView_Previews: PreviewProvider {
  static var previews: some View {
      NavigationStack {
          Assignment6View()
      }
      .environmentObject(ViewModel())
  }
}
#endif

//struct LoginView_Previews: PreviewProvider {
//        static var previews: some View {
//        LoginView()
//    }
//}
