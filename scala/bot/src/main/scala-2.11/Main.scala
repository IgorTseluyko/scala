import http.HttpManager._
import model.From
import response.ResponseHandler._

object Main extends App {
  var offset = 0

  while (true) {
    val updates = getUpdates(offset)
    if (updates.ok && updates.result.nonEmpty) {
      updates.result.foreach { r =>
        var chatId: Int = 0
        var text: String = null
        var user: From = null
        var callback_query_id: String = null

        if (r.message.isEmpty){
          chatId = r.callback_query.get.message.get.chat.id
          text = r.callback_query.get.data.get
          user = r.callback_query.get.from
          callback_query_id = r.callback_query.get.id
        } else {
          chatId = r.message.get.chat.id
          text = r.message.get.text
          user = r.message.get.from
        }

        processResponse(chatId, text, user, callback_query_id)
        offset = r.update_id + 1
      }
    }
  }
}
