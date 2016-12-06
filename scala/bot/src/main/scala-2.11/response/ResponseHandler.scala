package response

import config.Config._
import http.HttpManager._
import model.ReplyMarkupJsonProtocol._
import model.{Button, ReplyMarkup}
import spray.json._


object ResponseHandler {

  def processResponse(chatId: Int, text: String): Unit = {
    text.toLowerCase match {
      case "snow" | "tatra" | "jasna" | "bialka" | "zakopane" | "chopok" =>
        val markup = ReplyMarkup(Array
        (Array(
          Button(s"Jasna $snowflake$snowflake$snowflake", jasna),
          Button(s"Bialka-Tatrzanska $snowboarder$snowflake$snowflake", bialka)),
          Array(Button(s"Zakopane $snowflake$snowflake$snowflake", zakopane))
        )).toJson
        sendMessage(chatId, "Click on button to see the snow forecast", markup)
      case default => sendMessage(chatId, undefined)
    }
  }

}
