import http.HttpManager._
import response.ResponseHandler._

object Main extends App {
  var offset = 0

  while (true) {
    val updates = getUpdates(offset)
    if (updates.ok && updates.result.nonEmpty) {
      updates.result.foreach { r =>
        processResponse(r.message.chat.id, r.message.text)
        offset = r.update_id + 1
      }
    }
  }
}
