import com.translationdata.p040.com.translationdata.prototypes.P040_ChampernownesConstant
import org.junit.Assert._
import org.junit.Test

class P040_ChampernownesConstant {
  @Test def champernownesConstant() = {
    val product = P040_ChampernownesConstant.champernownesConstant

    checkResult {
      println("P040: Product d1 x d10 x ... x d1000000 = " + product)
      assertEquals(210, product)
    }
  }

  def checkResult(function: => Unit) {
    function
  }
}