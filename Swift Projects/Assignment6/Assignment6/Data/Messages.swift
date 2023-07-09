//
//  Messages.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

struct Messages: Identifiable, Decodable {
    let id: UUID
    let member: UUID
    let posted: Date
    let content: String
}
