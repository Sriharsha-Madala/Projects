//
//  MemberView.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI

struct MemberView: View {
    @State var message: Messages
    var body: some View {
        List {
            VStack(alignment: .leading) {
                //Text("\(message.member.name)")
                Text("\(message.content)")//.listRowSeparator(.hidden)
                Text("\(message.posted.formatted(.dateTime.day().month().year().hour().minute()))")
            }
        }
        .navigationTitle(message.member.name)
    }
}

struct MemberView_Previews: PreviewProvider {
    static var previews: some View {
        let messa = Messages(id: UUID(), content: "test for message", posted: Date(), member: Member(id: UUID(), name: "test for member"))
        NavigationStack {
            MemberView(message: messa)
        }
    }
}
