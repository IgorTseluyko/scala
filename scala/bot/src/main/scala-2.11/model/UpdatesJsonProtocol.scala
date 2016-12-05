package model

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object UpdatesJsonProtocol extends DefaultJsonProtocol{
  implicit val chatFormat: RootJsonFormat[Chat] = jsonFormat3(Chat)
  implicit val fromFormat: RootJsonFormat[From] = jsonFormat3(From)
  implicit val messageFormat: RootJsonFormat[Message] = jsonFormat5(Message)
  implicit val resultFormat: RootJsonFormat[Result] = jsonFormat2(Result)
  implicit val updatesFormat: RootJsonFormat[Updates] = jsonFormat2(Updates.apply)
}
