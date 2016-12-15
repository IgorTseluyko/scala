package response

import java.lang.String.valueOf

import config.Config._
import http.HttpManager._
import model.ReplyMarkupJsonProtocol._
import model.{Button, From, ReplyMarkup}
import parser.html.OnTheSnow._
import spray.json._


object ResponseHandler {

  def getCurrentSnow(url: String): String = {
    sendMessage(url)
  }

  def createMarkup(user: From, chatId: String): JsValue = {
    ReplyMarkup(Array(
      Array(
        Button(s"Jasna $snowflake$snowflake$snowflake", "1")
      ),
      Array(
        Button(s"Bialka-Tatrzanska $snowboarder$snowflake$snowflake", "2")
      ),
      Array(
        Button(s"Zakopane $snowflake$snowflake$snowflake", "3")
      )
    )).toJson
  }

  def processResponse(chatId: Int, text: String, user: From, callbackQueryId: String): Unit = {
    text.toLowerCase match {
      case text if userTextPoland.split(", ").exists(m => m.equals(text)) =>
        sendMessage(chatId, "Click on button to see the snow forecast", createMarkup(user, valueOf(chatId)))
      case "1" => answerCallback(callbackQueryId, parse(getCurrentSnow(skiresortJasna), doc => doc.select("meta[name=description]").attr("content")))
      case "2" => answerCallback(callbackQueryId, parse(getCurrentSnow(skiresortBialka), doc => doc.select("meta[name=description]").attr("content")))
      case "3" => answerCallback(callbackQueryId, parse(getCurrentSnow(skiresortZakopane), doc => doc.select("meta[name=description]").attr("content")))
      case default => sendMessage(chatId, undefined)
    }
  }

}
