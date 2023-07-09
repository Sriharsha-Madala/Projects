//
//  ViewModel.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

class ViewModel: ObservableObject {
    @Published var response: LoginResponse?// = LoginResponse(id: UUID(), name: "placeHolder", accessToken: "placeHolder")
    @Published var loggedIn: Bool = false
    @Published var workspaces = [Workspaces]()
    @Published var channels = [Channels]()
    @Published var messages = [Messages]()
    @Published var member = [Member]()
    
    func login(credentials: LoginCredentials) {
        Task {
            let (lr, sc) = try await LoginRepo.get(credentials: credentials)
            DispatchQueue.main.async {
                self.response = lr
                if (sc == 200) {
                    self.loggedIn = true
                }
                else {
                    self.loggedIn = false
                }
            }
        }
    }
    
    func getWorkspaces() {
        Task {
            let (wr, sc) = try await WorkspacesRepo.get(accessToken: response!.accessToken)
            DispatchQueue.main.async {
                if sc == 200 {
                    self.workspaces = wr
                } else {
                    self.workspaces = []
                }
            }
        }
    }
    
    func postWorkspace(name: String) {
        Task {
            let (msg, sc) = try await WorkspacesRepo.post(accessToken: response!.accessToken, name: name)
            DispatchQueue.main.async {
                if sc == 201 {
                    self.workspaces.append(msg)                    //print(member)
                } else {
                    print("did not work")
                }
            }
        }
        
    }
    
    func deleteWorkspace(id: UUID) {
        Task {
            let (sc) = try await WorkspacesRepo.delete(accessToken: response!.accessToken, id: id)
            DispatchQueue.main.async {
                if sc == 200 {
                    print("deleted message")
                }
            }
        }
    }
    
    func getChannels(id: UUID) {
        Task {
            let (cr, sc) = try await ChannelsRepo.get(accessToken: response!.accessToken, id: id)
            DispatchQueue.main.async {
                if sc == 200 {
                    self.channels = cr
                } else {
                    self.channels = []
                }
            }
        }
        
    }
    
    func getMessages(id: UUID) {
        Task {
            let (mr, sc) = try await MessagesRepo.get(accessToken: response!.accessToken, id: id)
            DispatchQueue.main.async {
                if sc == 200 {
                    self.messages = mr
                } else {
                    self.messages = []
                }
            }
        }
        
    }
    
    func getMember(id: UUID) {
        Task {
            let (member, sc) = try await MemberRepo.get(accessToken: response!.accessToken, id: id)
            DispatchQueue.main.async {
                if sc == 200 {
                    self.member = member
                    //print(member)
                } else {
                    self.member = []
                }
            }
        }
        
    }
    
    func postMessage(id: UUID, content: String) {
        Task {
            let (msg, sc) = try await MessagesRepo.post(accessToken: response!.accessToken, id: id, content: content)
            DispatchQueue.main.async {
                if sc == 201 {
                    self.messages.append(msg)                    //print(member)
                } else {
                    print("did not work")
                }
            }
        }
    }
    
    func deleteMessage(id: UUID) {
        Task {
            let (sc) = try await MessagesRepo.delete(accessToken: response!.accessToken, id: id)
            DispatchQueue.main.async {
                if sc == 200 {
                    print("deleted message")
                } else {
                    print("did not work")
                }
            }
        }
    }
    
    func getName(id: UUID) -> String{
        
        for member in self.member {
            //print("is this id \(id) == to this id \(member.id)")
            if member.id == id {
                return member.name
            }
        }
        return "did not find!!!!!"
    }
}
