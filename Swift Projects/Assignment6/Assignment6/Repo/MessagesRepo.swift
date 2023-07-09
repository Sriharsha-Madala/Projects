//
//  MessagesRepo.swift
//  Assignment6
//
//  Created by Sriharsha Madala on 5/19/23.
//

import Foundation

struct MessagesRepo {
    static func get(accessToken: String, id: UUID) async throws -> ([Messages], Int) {
        let url = URL(string: "https://cse118.com/api/v2/channel/\(id)/message")!
        var request = URLRequest(url: url)
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.setValue("application/json", forHTTPHeaderField: "Accept")
        request.addValue("Bearer " + accessToken, forHTTPHeaderField: "Authorization")
        request.httpMethod = "GET"
        //let jsonEncoder = JSONEncoder()
        //let jsonData = try jsonEncoder.encode(id)
        //let json = String(data: jsonData, encoding: String.Encoding.utf8)
        //print(json)
        //let bodyData = json?.data(using: .utf8)//try JSONSerialization.data(withJSONObject: json, options: [])
        //request.httpBody = bodyData
        //usleep(200*500) // half second delay to simulate network latency
        let (data, response) = try await URLSession.shared.data(for: request)
        let httpresponse = response as? HTTPURLResponse
        print(data)
        print(httpresponse?.statusCode as Any)
        return (try JSONDecoder.javaScriptISO8601().decode([Messages].self, from: data), httpresponse!.statusCode)
    }
    
    static func post(accessToken: String, id: UUID, content: String) async throws -> (Messages, Int) {
        let url = URL(string: "https://cse118.com/api/v2/channel/\(id)/message")!
        var request = URLRequest(url: url)
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.setValue("application/json", forHTTPHeaderField: "Accept")
        request.addValue("Bearer " + accessToken, forHTTPHeaderField: "Authorization")
        request.httpMethod = "POST"
        
        struct messageToSend: Codable {
            var content: String
        }
        
        let jsonEncoder = JSONEncoder()
        let mes = messageToSend(content: content)
        let jsonData = try jsonEncoder.encode(mes)
        let json = String(data: jsonData, encoding: String.Encoding.utf8)
        print(json as Any)
        let bodyData = json?.data(using: .utf8)//try JSONSerialization.data(withJSONObject: json, options: [])
        request.httpBody = bodyData
        
        //usleep(500*1000) // half second delay to simulate network latency
        let (data, response) = try await URLSession.shared.data(for: request)
        let httpresponse = response as? HTTPURLResponse
        print(json as Any)
        print(request)
        print(id)
        print(data)
        print(httpresponse?.statusCode as Any)
        return (try JSONDecoder.javaScriptISO8601().decode(Messages.self, from: data), httpresponse!.statusCode)
    }
    
    static func delete(accessToken: String, id: UUID) async throws -> (Int) {
        let url = URL(string: "https://cse118.com/api/v2/message/\(id)")!
        var request = URLRequest(url: url)
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.setValue("application/json", forHTTPHeaderField: "Accept")
        request.addValue("Bearer " + accessToken, forHTTPHeaderField: "Authorization")
        request.httpMethod = "DELETE"
        //let jsonEncoder = JSONEncoder()
        //let jsonData = try jsonEncoder.encode(id)
        //let json = String(data: jsonData, encoding: String.Encoding.utf8)
        //print(json)
        //let bodyData = json?.data(using: .utf8)//try JSONSerialization.data(withJSONObject: json, options: [])
        //request.httpBody = bodyData
        //usleep(200*500) // half second delay to simulate network latency
        let (data, response) = try await URLSession.shared.data(for: request)
        let httpresponse = response as? HTTPURLResponse
        print(data)
        print(httpresponse?.statusCode as Any)
        return (httpresponse!.statusCode)
    }
    
}
