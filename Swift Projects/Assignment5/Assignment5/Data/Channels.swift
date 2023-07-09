//
//  Channels.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import Foundation

struct Channels: Identifiable, Decodable {
  let id: UUID
  let name: String
  var messages: [Messages]
}
