
import Foundation

struct Workspaces: Identifiable, Decodable {
  let id: UUID
  let name: String
  var channels: [Channels]
}

