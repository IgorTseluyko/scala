package config

import com.typesafe.config.ConfigFactory.load


object Config {
  val url = load().getString("telegram.api.url") + load().getString("telegram.api.token")
  val timeout = load().getString("http.timeout")
  val jasna = load().getString("response.jasna")
  val undefined = load().getString("response.undefined")
  val connTimeOut = load().getInt("http.connectionTimeoutMs")
  val readTimeOut = load().getInt("http.readTimeOutMs")
}
