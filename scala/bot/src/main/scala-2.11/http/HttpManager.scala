package http

import config.Config._
import model.Updates
import model.UpdatesJsonProtocol._
import spray.json._

import scalaj.http.Http

object HttpManager {

  def getUpdates(offset: Int): Updates = {
    handleException({
      val updates = Http(url + "/getupdates")
        .postForm(Seq("offset" -> offset.toString, "timeout" -> timeout))
        .timeout(connTimeOut, readTimeOut)
        .asString
        .body
      println(s"updates received = $updates")
      updates.parseJson.convertTo[Updates]
    })
  }

  def sendMessage(chatId: Int, text: String): Unit = {
    handleException({
      val response = Http(url + "/sendmessage")
        .postForm(Seq("chat_id" -> chatId.toString, "text" -> text))
        .timeout(connTimeOut, readTimeOut)
        .asString
        .body
      println(s"response sent = $response")
    })
  }

  def sendMessage(chatId: Int, text: String, markup: JsValue): Unit = {
    handleException({
      val response = Http(url + "/sendmessage")
        .postForm(Seq("chat_id" -> chatId.toString, "text" -> text, "reply_markup" -> markup.toString))
        .timeout(connTimeOut, readTimeOut)
        .asString
        .body
      println(s"response sent = $response")
    })
  }

  //TODO: google similar solutions, see scalaj.http doc
  def handleException[T](f: => T): T = {
    try {
      f
    } catch {
      case e: Exception =>
        println(e)
        println(s"sleep for $retryRequest ms")
        Thread sleep retryRequest
        println("trying to repeat function after sleep")
        handleException(f)
    }
  }

}
