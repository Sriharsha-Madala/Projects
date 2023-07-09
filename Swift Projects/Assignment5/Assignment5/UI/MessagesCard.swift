//
//  MessagesCard.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI

struct MessagesCard: View {
    var message: Messages
    var body: some View {
        VStack(alignment: .leading) {
            Text("\(message.member.name)")
            Text("\(message.content)").lineLimit(2)
            Text("\(message.posted.formatted(.dateTime.day().month().year().hour().minute()))")
        }
    }
}

struct MessagesCard_Previews: PreviewProvider {
    static var previews: some View {
        MessagesCard(message: Messages(id: UUID(), content: "test for message", posted: Date(), member: Member(id: UUID(), name: "test for member")))
    }
}
