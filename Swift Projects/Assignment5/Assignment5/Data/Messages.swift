//
//  Messages.swift
//  Assignment5
//
//  Created by Sriharsha Madala on 5/11/23.
//

import Foundation

struct Messages: Identifiable, Decodable {
  let id: UUID
  let content: String
    let posted: Date
  let member: Member
}
