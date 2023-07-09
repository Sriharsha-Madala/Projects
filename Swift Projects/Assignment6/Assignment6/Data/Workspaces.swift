//
//  Workspaces.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

struct Workspaces: Identifiable, Decodable {
  let id: UUID
  let name: String
    let owner: UUID
  var channels: Int
}
