package model

case class Updates(ok: Boolean, result: List[Result])

case class Result(update_id: Int, message: Message)

case class Message(message_id: Int, from: From, chat: Chat, date: Long, text: String)

case class From(id: Int, first_name: String, last_name: String)

case class Chat(id: Int, first_name: String, last_name: String)
