package model

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object ReplyMarkupJsonProtocol extends DefaultJsonProtocol{
  implicit val button: RootJsonFormat[Button] = jsonFormat2(Button)
  implicit val replyMarkup: RootJsonFormat[ReplyMarkup] = jsonFormat1(ReplyMarkup)
}
