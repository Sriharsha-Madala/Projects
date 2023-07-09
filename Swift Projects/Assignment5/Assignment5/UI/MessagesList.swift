//
//  MessagesList.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI

//extension Channels {
//    static func sorting(channel: Channels){
//        channel.messages = channel.messages.sorted(by: { $0.posted < $1.posted })
//    }
//}

struct MessagesList: View {
    @State var channel: Channels
    var body: some View {
        let m: [Messages] = channel.messages.sorted(by: { $0.posted < $1.posted })
        List {
            ForEach(m) { message in
                NavigationLink(destination: MemberView(message: message)) {
                    MessagesCard(message: message)
                }
            }
        }
        .navigationTitle("\(channel.name)")
        .padding(0)
    }
}

struct MessagesList_Previews: PreviewProvider {
    static var previews: some View {
        let min = Calendar.current.date(byAdding: .minute, value: -20, to: Date())!
        let moremin = Calendar.current.date(byAdding: .minute, value: -40, to: Date())!
        let messa = Channels(id: UUID(), name: "TEST for Channel", messages: [Messages(id: UUID(), content: "test2 for message", posted: min, member: Member(id: UUID(), name: "test2 for member")), Messages(id: UUID(), content: "test3 for message", posted: moremin, member: Member(id: UUID(), name: "test3 for member")), Messages(id: UUID(), content: "test for message", posted: Date(), member: Member(id: UUID(), name: "test for member"))])
        NavigationStack {
            MessagesList(channel: messa)
        }
    }
}
