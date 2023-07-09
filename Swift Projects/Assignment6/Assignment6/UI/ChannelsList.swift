//
//  ChannelsList.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct ChannelsList: View {
    @EnvironmentObject var model: ViewModel
    @State var workspace_id: UUID
    @State var workspace_name: String
    @Environment(\.dismiss) var dismiss
    var body: some View {
        //self.navigationController?.navigationBar.backItem?.title = "Anything Else"
        VStack() {
            List {
                ForEach(model.channels) { channel in
                    NavigationLink(destination: MessagesList(channels_id: channel.id, workspace_id: workspace_id, name: channel.name)) {
                        ChannelsCard(channels: channel)
                    }
                    .accessibilityLabel("\(channel.name)")
                }
            }
            .navigationBarBackButtonHidden(true)
            .navigationBarTitle("\(workspace_name)")
            .toolbar {
                //Text("\(workspace_name)").font(.headline).frame(maxWidth: .infinity, alignment: .center)
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
            .refreshable {
                model.getChannels(id: workspace_id)
                model.getMember(id: workspace_id)
            }
        }
        //.navigationTitle("Workspaces")
        .onAppear {
            model.getChannels(id: workspace_id)
            model.getMember(id: workspace_id)
        }
    }
}
