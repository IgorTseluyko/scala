package model

case class Button(text: String, url: String)
case class ReplyMarkup(inline_keyboard: Array[Array[Button]])
