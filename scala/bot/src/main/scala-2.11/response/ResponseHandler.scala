package response

import config.Config.{jasna, undefined}
import http.HttpManager.sendMessage

object ResponseHandler {

  def processResponse(chatId: Int, text: String): Unit = {
    text.toLowerCase match {
      case "snow" | "tatra" | "jasna" => sendMessage(chatId, jasna)
      case default => sendMessage(chatId, undefined)
    }
  }

}
