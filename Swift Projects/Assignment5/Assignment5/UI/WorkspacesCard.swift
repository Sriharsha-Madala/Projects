//
//  WorkspacesCard.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI

struct WorkspacesCard: View {
    var workspace: Workspaces
    var body: some View {
        Text("\(workspace.name)")
    }
}

struct WorkspacesCard_Previews: PreviewProvider {
    static var previews: some View {
        WorkspacesCard(workspace: Workspaces(id: UUID(), name: "Test", channels: [Channels(id: UUID(), name: "TEST for Channel", messages: [Messages(id: UUID(), content: "test for message", posted: Date(), member: Member(id: UUID(), name: "test for member"))])]))
    }
}
