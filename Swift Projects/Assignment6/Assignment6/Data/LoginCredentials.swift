//
//  LoginCredentials.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

struct LoginCredentials: Encodable, Decodable {
    let email: String
    let password: String
}
