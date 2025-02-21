package edu.ucsc.cse118.assignment3.repo

import edu.ucsc.cse118.assignment3.data.Channels
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.data.Workspaces
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class WorkspacesRepository {
    fun getWorkspaces(member: Member?): ArrayList<Workspaces> { // what is member?
        with(URL(url).openConnection() as HttpsURLConnection) {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "text/html; charset=UTF-8n")
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Authorization", "Bearer ${member?.accessToken}")
            val response = StringBuffer()
            BufferedReader(InputStreamReader(inputStream)).use {
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
            }
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                return Json.decodeFromString(response.toString())
            }
            throw Exception("Failed to GET HTTP $responseCode")
        }
    }

//    fun getWorkspace(member: Member?, workspace: Workspaces?): ArrayList<Channels> {
//        val path = "$url/${workspace?.id}"
//        with(URL(path).openConnection() as HttpsURLConnection) {
//            requestMethod = "GET"
//            setRequestProperty("Content-Type", "text/html; charset=UTF-8n")
//            setRequestProperty("Accept", "application/json")
//            setRequestProperty("Authorization", "Bearer ${member?.accessToken}")
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//                print("at workspace repository")
//                return Json.decodeFromString(inputStream.bufferedReader().use { it.readText() })
//            }
//            throw Exception("Failed to GET HTTP $responseCode")
//        }
//    }

    companion object {
        private const val url = "https://cse118.com/api/v0/workspace"
    }
}