import http.HttpManager._
import response.ResponseHandler.processResponse

object Main extends App {
  var offset = 0

  while (true) {
    val updates = getUpdates(offset)
    if (updates.ok && updates.result.nonEmpty) {
      updates.result.foreach { r =>
        offset = r.update_id + 1
        processResponse(r.message.chat.id, r.message.text)
      }
    }
  }
}
