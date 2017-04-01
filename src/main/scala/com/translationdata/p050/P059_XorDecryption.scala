package main.scala.com.translationdata.p050

import io.Source.fromFile

/**
  * Created by Harold on 3/31/2017.
  */
object P059_XorDecryption {
  //read cipher text file into string buffer
  val commonWords =
""""the
  be
  to
  of
  and
  a
  in
  that
  have
    """.stripMargin.lines.toList

  def main (Args: Array[String]): Unit = {
    println ("P059")

    val source = fromFile("U:\\Users\\Harold\\Documents\\ProjectEuler\\59 - XOR Decryption\\p059_cipher.txt")

   // val cols = source.toString
//    val cols = source.toString.split(",").map(_.trim)

/*    for (char <- source) {
      print(char.toUpper)
    }*/

    val text = source.foldLeft("") ( (theResult, charElement) => theResult + charElement )
    val cols = text.split(",").map(_.trim)

    source.close

    for(word <- commonWords)
      println(word)

/*    for(letter1 <- ('a' to 'z')) {
      for (letter2 <- ('a' to 'z')) {
        for (letter3 <- ('a' to 'z')) {
          print(letter1.toString + letter2 + letter3 + ' ')
        }
        println
      }
    }*/
  }

  def decryptText(text: String, key: String) = {
    val newText = decrypt(text: String)
    100
  }

  def decrypt(text: String) = {
  /*
    for letter1 in (a to z)
    for letter2 in (a to z)
    for letter3 in (a to z) {
    if( countCommonWord( letter1 + letter2 + letter3) > 20 ) */
  "dummy"
}
}
