package model

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object ReplyMarkupJsonProtocol extends DefaultJsonProtocol {
  implicit val chatFormat: RootJsonFormat[Chat] = jsonFormat3(Chat)
  implicit val from: RootJsonFormat[From] = jsonFormat3(From)
  implicit val button: RootJsonFormat[Button] = jsonFormat2(Button)
  implicit val replyMarkup: RootJsonFormat[ReplyMarkup] = jsonFormat1(ReplyMarkup)
  implicit val fromFormat: RootJsonFormat[From] = jsonFormat3(From)
}
