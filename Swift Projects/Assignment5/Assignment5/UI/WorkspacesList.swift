//
//  WorkspacesList.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI

extension Workspaces {
    static func fromJSONResource(name: String) -> [Workspaces] {
        if let bundlePath = Bundle.main.path(forResource: "Workspaces", ofType: "json") {
            do {
                if let jsonData = try String(contentsOfFile: bundlePath).data(using: .utf8) {
                    let decoder = JSONDecoder()
                    decoder.dateDecodingStrategy = .iso8601
                    return try decoder.decode([Workspaces].self, from: jsonData)
                }
            } catch {
                return [Workspaces(id: UUID(), name: "Test2", channels: [Channels(id: UUID(), name: "TEST2 for Channel2", messages: [Messages(id: UUID(), content: "test2 for message", posted: Date(), member: Member(id: UUID(), name: "test2 for member"))])])]            }
        }
        return [Workspaces(id: UUID(), name: "Test", channels: [Channels(id: UUID(), name: "TEST for Channel", messages: [Messages(id: UUID(), content: "test for message", posted: Date(), member: Member(id: UUID(), name: "test for member"))])])]
    }
}

struct WorkspacesList: View {
    @State private var workspaces: [Workspaces] = Workspaces.fromJSONResource(name: "Workspaces")
    var body: some View {
        List {
            ForEach(workspaces) { workspace in
                NavigationLink(destination: ChannelsList(workspace: workspace)) {//, channels: workspace.channels)) {
                    WorkspacesCard(workspace: workspace)
                }
            }
        }
        .navigationTitle("Workspaces")
    }
}

struct WorkspacesList_Previews: PreviewProvider {
    static var previews: some View {
        NavigationStack {
            WorkspacesList()
        }
    }
}
