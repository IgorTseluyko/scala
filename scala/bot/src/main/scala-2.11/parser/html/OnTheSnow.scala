package parser.html

import org.jsoup.Jsoup
import org.jsoup.nodes.Document


object OnTheSnow extends Parser{

  override def parse(html :String, f: (Document) => String): String = f.apply(Jsoup.parse(html))

}
