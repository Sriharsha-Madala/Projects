//
//  MessagesList.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct MessagesList: View {
    @EnvironmentObject var model: ViewModel
    @State var channels_id: UUID
    @State var workspace_id: UUID
    @State var name: String
    var body: some View {
        VStack() {
            List {
                ForEach(model.messages) { message in
                    MessagesCard(name: model.getName(id: message.member), messages: message)
                        .swipeActions {
                            if model.response?.id == message.member {
                                Button("Delete") {
                                    model.deleteMessage(id: message.id)
                                    model.getMessages(id: channels_id)
                                }
                                .tint(.green)
                                .accessibilityLabel("Delete")
                            }
                        }
                }
            }
            .navigationBarTitle("\(name)")
            
            .toolbar {
                Text("\(name)").font(.headline).frame(maxWidth: .infinity, alignment: .center)
                NavigationLink(destination: NewMessageView(channel_id: channels_id, channel_name: name)) {
                    Image(systemName: "plus.square")
                    
                }
                .accessibilityLabel("New Message")
            }
            .refreshable {
                model.getMessages(id: channels_id)
                model.getMember(id: workspace_id)
            }
            Spacer()
            Spacer()
            
        }
        .onAppear {
            model.getMessages(id: channels_id)
            //model.getMember(id: workspace_id)
        }
    }
}
        //.navigationTitle("Workspaces")
        

struct MessagesList_Previews: PreviewProvider {
    static var previews: some View {
        NavigationStack {
            Assignment6View()
        }
        .environmentObject(ViewModel())
    }
}
