package parser.html

import org.jsoup.nodes.Document


trait Parser {

  def parse(html :String, f: (Document) => String): String

}
