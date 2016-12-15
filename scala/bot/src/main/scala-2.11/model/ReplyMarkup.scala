package model

case class Button(text: String, callback_data: String)

case class ReplyMarkup(inline_keyboard: Array[Array[Button]])

case class CallbackQuery(id: String, from: From, chat_instance: String, message: Option[Message], data: Option[String])
