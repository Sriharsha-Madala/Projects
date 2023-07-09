//
//  NewMessageView.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct NewMessageView: View {
    @EnvironmentObject var model: ViewModel
    @Environment(\.dismiss) var dismiss
    @State var newmsg = ""
    var channel_id: UUID
    var channel_name: String
    var body: some View {
        VStack {
            TextField("Message", text: $newmsg)
                .lineLimit(150, reservesSpace: true)
                .accessibilityLabel("Message")
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
                    model.postMessage(id: channel_id, content: newmsg)
                    dismiss()
                }) {
                    Text("OK")
                }
            }
            .navigationTitle("New Message")
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
                            Text("\(channel_name)")
                        }
                    }
                }
            }
                
        }
        //Spacer()
    }
}

struct NewMessageView_Previews: PreviewProvider {
    static var previews: some View {
        NavigationStack {
            Assignment6View()
        }
        .environmentObject(ViewModel())
    }
}
