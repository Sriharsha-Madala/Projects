//
//  LoginResponse.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

struct LoginResponse: Identifiable, Decodable {
    var id: UUID
    var name: String
    var accessToken: String
}
