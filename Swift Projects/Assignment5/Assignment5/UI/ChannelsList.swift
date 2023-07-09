//
//  ChannelsView.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI



struct ChannelsList: View {
    @State var workspace: Workspaces
    //@State var channels: [Channels]
    var body: some View {
        
        List {
            ForEach(workspace.channels) { channel in
                NavigationLink(destination: MessagesList(channel: channel)) {
                    ChannelsCard(channel: channel)
                }
            }
        }
        .navigationBarBackButtonHidden(true)
        .navigationTitle("\(workspace.name)")
        .padding(0)
    }
}

struct ChannelsList_Previews: PreviewProvider {
    static var previews: some View {
        let work = Workspaces(id: UUID(), name: "Test", channels: [Channels(id: UUID(), name: "TEST for Channel", messages: [Messages(id: UUID(), content: "test for message", posted: Date(), member: Member(id: UUID(), name: "test for member"))])])
        NavigationStack {
            ChannelsList(workspace: work)//, channels: work.channels)
        }
    }
}
