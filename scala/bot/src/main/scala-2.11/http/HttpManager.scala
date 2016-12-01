package http

import config.Config
import config.Config.{connTimeOut, readTimeOut, timeout, url}
import model.Updates
import model.UpdatesJsonProtocol._
import spray.json._

import scalaj.http.Http

object HttpManager {

  def getUpdates(offset: Int): Updates = {
    val updates = Http(url + "/getupdates")
      .postForm(Seq("offset" -> offset.toString, "timeout" -> timeout))
      .timeout(connTimeOut, readTimeOut)
      .asString
      .body
    println(s"updates received = $updates")
    updates.parseJson.convertTo[Updates]
  }

  def sendMessage(chatId: Int, text: String): Unit = {
    val response = Http(url + "/sendmessage")
      .postForm(Seq("chat_id" -> chatId.toString, "text" -> text))
      .timeout(connTimeOut, readTimeOut)
      .asString
      .body
    println(s"response sent = $response")
  }

}
