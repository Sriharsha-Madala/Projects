//
//  Channels.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

struct Channels: Identifiable, Decodable {
  let id: UUID
  let name: String
  var messages: Int
}
