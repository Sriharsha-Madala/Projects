//
//  MessagesCard.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct MessagesCard: View {
    @EnvironmentObject var model: ViewModel
    var name: String
    var messages: Messages
    var body: some View {
        VStack {
            Text("\(name)")
            Text("\(messages.content)")
            Text("\(messages.posted.formatted(.dateTime.day().month().year().hour().minute()))")
        }
    }
}
