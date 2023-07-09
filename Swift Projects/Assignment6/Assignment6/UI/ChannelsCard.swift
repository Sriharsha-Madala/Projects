//
//  ChannelsCard.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import SwiftUI

struct ChannelsCard: View {
    @EnvironmentObject var model: ViewModel
    var channels: Channels
    var body: some View {
        HStack {
            Text("\(channels.name)")
                .accessibilityLabel("\(channels.name)")
            Text("\(channels.messages)")
        }
    }
}
