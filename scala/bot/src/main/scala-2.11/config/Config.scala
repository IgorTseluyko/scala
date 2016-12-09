package config

import com.typesafe.config.ConfigFactory.load


object Config {
  val url = load().getString("telegram.api.url") + load().getString("telegram.api.token")
  val timeout = load().getString("http.timeout")
  val jasna = load().getString("response.jasna")
  val zakopane = load().getString("response.zakopane")
  val bialka = load().getString("response.bialka")
  val undefined = load().getString("response.undefined")
  val snowboarder = load().getString("emojis.snowboarder")
  val snowflake = load().getString("emojis.snowflake")
  val connTimeOut = load().getInt("http.connectionTimeoutMs")
  val readTimeOut = load().getInt("http.readTimeOutMs")
  val retryRequest = load().getInt("http.retryRequestMs")
}
