package model

case class Updates(ok: Boolean, result: List[Result])

case class Result(update_id: Int, message: Option[Message], callback_query: Option[CallbackQuery])

case class Message(message_id: Int, from: From, chat: Chat, date: Long, text: String)

case class From(id: Int, first_name: String, last_name: Option[String])

case class Chat(id: Int, first_name: String, last_name: String)
