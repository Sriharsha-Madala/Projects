//
//  WorkspacesList.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct WorkspacesList: View {
    @EnvironmentObject var model: ViewModel
    @State var name: String = "Workspaces"
    var body: some View {
        VStack() {
            if model.workspaces.isEmpty {
                ProgressView()
            }
            else {
                //NavigationView {
                
                List {
                    ForEach(model.workspaces) { workspace in
                        NavigationLink(destination: ChannelsList(workspace_id: workspace.id, workspace_name: workspace.name)) {
                            WorkspacesCard(workspace:workspace)
                                .swipeActions {
                                    if model.response?.id == workspace.owner {
                                        Button("Delete") {
                                            model.deleteMessage(id: workspace.id)
                                            model.getWorkspaces()
                                        }
                                        .tint(.green)
                                        .accessibilityLabel("Delete")
                                    }
                                }
                        }
                        .accessibilityLabel("\(workspace.name)")
                    }
                }
                //.navigationTitle("\(name)")
                .refreshable {
                    model.getWorkspaces()
                }
                
                .toolbar {
                    ToolbarItemGroup(placement: .navigationBarTrailing) {
                        NavigationLink(destination: NewWorkspaceView()) {
                            Image(systemName: "plus.square")
                            
                        }
                        .accessibilityLabel("New Workspace")
                    }
                    ToolbarItemGroup(placement: .navigationBarLeading) {
                        
                        Button(action: {
                            model.loggedIn = false
                        }) {
                            Image(systemName: "rectangle.portrait.and.arrow.forward")
                        }
                        .accessibilityIdentifier("Logout")
                    }
                }
                .navigationBarTitle("Workspaces")
            }
            //}
        }
        //.navigationTitle("Workspaces")
        .onAppear {
            model.getWorkspaces()
        }
    }
}

struct WorkspacesList_Previews: PreviewProvider {
    static var previews: some View {
        NavigationStack {
            Assignment6View()
        }
        .environmentObject(ViewModel())
    }
}
