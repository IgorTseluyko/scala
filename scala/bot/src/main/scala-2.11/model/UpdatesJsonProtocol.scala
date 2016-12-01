package model

import spray.json.DefaultJsonProtocol

object UpdatesJsonProtocol extends DefaultJsonProtocol{
  implicit val chatFormat = jsonFormat3(Chat)
  implicit val fromFormat = jsonFormat3(From)
  implicit val messageFormat = jsonFormat5(Message)
  implicit val resultFormat = jsonFormat2(Result)
  implicit val updatesFormat = jsonFormat2(Updates.apply)
}
