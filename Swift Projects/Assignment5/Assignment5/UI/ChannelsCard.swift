//
//  ChannelsCard.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import SwiftUI
import Foundation

extension Channels {
    static func numberOFusers(channel: Channels) -> Int{
        var uniqueID = Set<UUID>()
        //let s = channel.messages.sorted(by: { $0.id.description < $1.id.description })
        for message in channel.messages {//{ message in
            uniqueID.insert(message.member.id)
        }
        return uniqueID.count
    }
}

extension Channels {
    static func lastMessage(channel: Channels) -> String{
        let m: [Messages] = channel.messages.sorted(by: { $0.posted < $1.posted })
        if m.count == 0 {
            return ""
        }
        let DC = Calendar.current.dateComponents([.hour, .minute, .second, .day], from: m[0].posted, to: Date())
        if DC.day! >= 1 {
            return String(DC.day!) + " days"
        }
        else if DC.hour! >= 1 {
            return String(DC.hour!) + " hours"
        }
        else if DC.minute! >= 1 {
            return String(DC.minute!) + " minutes"
        }
        else {
            return String(DC.second!) + " seconds"
        }
    }
}


struct ChannelsCard: View {
    var channel: Channels
    @State var name: String = ""//\(channel.messages.count)"
    var body: some View {
        
        VStack (alignment: .leading) {
            //let name : String = "\(channel.messages.count)"
            Text("\(channel.name)")
            Grid (alignment: .leading, horizontalSpacing: 5){
                GridRow (alignment: .firstTextBaseline) {
                    Image(systemName: "envelope")
                    TextField("count for \(channel.name)", text: .constant("\(channel.messages.count)"))
                        .disabled(true)
                        .font(.system(size:10))
                    Image(systemName: "person.3")
                    TextField("members active in \(channel.name)", text: .constant("\(Channels.numberOFusers(channel: channel))"))
                        .disabled(true)
                        .font(.system(size:10))
                    Image(systemName: "clock")
                    TextField("latest message in \(channel.name)", text: .constant("\(Channels.lastMessage(channel: channel))"))
                        .disabled(true)
                        .font(.system(size:10))
                }
                .padding(1)
            }
        }
    }
}

struct ChannelsCard_Previews: PreviewProvider {
    static var previews: some View {
        let min = Calendar.current.date(byAdding: .hour, value: -23, to: Date())!
        ChannelsCard(channel: Channels(id: UUID(), name: "TEST for Channel", messages: [Messages(id: UUID(), content: "test for message", posted: min, member: Member(id: UUID(), name: "test for member"))]))
    }
}
