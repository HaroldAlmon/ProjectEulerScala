import com.translationdata.p040._
import _root_.com.translationdata.p040.com.translationdata.prototypes.P040_ChampernownesConstant
import org.hamcrest.CoreMatchers
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

class P044_PentagonalNumbers {
  @Test def PentagonalNumbers() = {
    val difference = P044_PentagonalNumbers.findNumber()

    println("P044: Difference is " + difference)
    assertEquals(5482660, difference)
  }
}

class P045_TriangularPentagonalAndHexagonal {
  @Test def TriangularPentagonalAndHexagonal(): Unit = {
    val n = P045_TriangularPentagonalAndHexagonal.findSequence
    val triangleNumber = P045_TriangularPentagonalAndHexagonal.Tn(n)
    printf("T(%d) = P(%d) = H(%d) = %d%n",
      n,
      P045_TriangularPentagonalAndHexagonal.PnQuadraticRoot(triangleNumber).toInt,
      P045_TriangularPentagonalAndHexagonal.HnQuadraticRoot(triangleNumber).toInt,
      triangleNumber)
    println(f"P045: Next triangular number is $triangleNumber")
    assertEquals(1533776805L, triangleNumber)
  }
}

class P047_DistinctPrimeFactors {
  @Test def DistinctPrimeFactors(): Unit = {
    val firstNumber = P047_DistinctPrimeFactors.getNumber
    println(f"P047: First number is $firstNumber")
    assertEquals(134043, firstNumber)
  }
}

class P048_SelfPowers {
  @Test def SumMod10(): Unit = {
    val SumMod10 = P048_SelfPowers.sumMod10
    println(f"P048: Last ten digits = $SumMod10")
    assertEquals(9110846700L, SumMod10)
  }
}

class P049_PrimePermutations {
  @Test def PrimePermutations(): Unit = {
    val prime = P049_PrimePermutations.result
    val primeString = s"${prime(0)}${prime(1)}${prime(2)}"

    printf("P049: Prime Permutations = %d, %d, %d%n",
      prime(0),
      prime(1),
      prime(2))

    printf("The 12 digit string is %d%d%d%n",
      prime(0),
      prime(1),
      prime(2))

    assertThat(s"Incorrect sum.",
      primeString,
      CoreMatchers.is("296962999629"))
  }
}