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
  in
  that
  have
""".stripMargin.lines.toList

  val fileSpec = "U:\\Users\\Harold\\Documents\\ProjectEuler\\59 - XOR Decryption\\p059_cipher.txt"
  def main (Args: Array[String]): Unit = {

    println ("P059")
    val text = scala.io.Source.fromFile(fileSpec).mkString

    //val x = new String(Array[Byte](1,2,3,-1,-2,-127).map(_.toChar))

    //(new String(Array[Byte](1,2,3,-1,-2,-127).map(_.toChar))) .toCharArray.map(_.toByte)

    for(word <- commonWords)
      println(word)

    decryptText(text)
  }

  def decryptText(text: String) = {
    val charArray = text.split(",")

    val byteArray = charArray.map(_.toByte)

    //val charS = new String(byteArray)

    val newText = decrypt(byteArray)
    100
  }

  def decrypt(text: Array[Byte]) = {
    for(letter1 <- ('a' to 'z')) {
      for (letter2 <- ('a' to 'z')) {
        for (letter3 <- ('a' to 'z')) {
          print(letter1.toString + letter2 + letter3 + ' ')
        }
        println
      }
    }
  "dummy"
}
}
