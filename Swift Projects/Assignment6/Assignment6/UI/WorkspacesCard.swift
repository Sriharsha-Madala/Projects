//
//  WorkspacesCard.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct WorkspacesCard: View {
    @EnvironmentObject var model: ViewModel
    var workspace: Workspaces
    var body: some View {
        HStack {
            Text("\(workspace.name)")
            Text("\(workspace.channels)")
        }
    }
}

