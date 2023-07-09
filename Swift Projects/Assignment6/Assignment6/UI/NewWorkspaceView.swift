//
//  NewWorkspaceView.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/22/23.
//

import SwiftUI

struct NewWorkspaceView: View {
    @EnvironmentObject var model: ViewModel
    @Environment(\.dismiss) var dismiss
    @State var newmsg = ""
    var body: some View {
        VStack {
            TextField("Name", text: $newmsg)
                .lineLimit(150, reservesSpace: true)
                .accessibilityLabel("Name")
            HStack {
                Button(action: {
                    dismiss()
                }) {
                    Text("Cancel")
                    // normal button but in action part, call presentation mode to dismiss current screen
                }
                .accessibilityLabel("Cancel")
                Button(action: {
                    // create a task , inside the task use await model.addWorkspace
                    // task { await model.addworkspaces}
                    //
                    // model.getworkspaces
                    model.postWorkspace(name: newmsg)
                    dismiss()
                }) {
                    Text("OK")
                }
            }
            .navigationTitle("New Workspace")
            .navigationBarBackButtonHidden(true)
            .toolbar {
                
                // 2
                ToolbarItem(placement: .navigationBarLeading) {
                    
                    Button {
                        // 3
                        dismiss()
                        
                    } label: {
                        // 4
                        HStack {
                            
                            Image(systemName: "chevron.backward")
                            Text("Workspaces")
                        }
                    }
                }
            }
                
        }
        //Spacer()
    }
}

struct NewWorkspaceView_Previews: PreviewProvider {
    static var previews: some View {
        NavigationStack {
            Assignment6View()
        }
        .environmentObject(ViewModel())
    }
}
