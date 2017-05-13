import com.translationdata.p050._
import main.scala.com.translationdata.p050.{P056_PowerfulDigitSum, P058_SpiralPrimes}
import org.hamcrest.CoreMatchers
import org.junit.Assert._
import org.junit.Test

class P050_ConsecutivePrimeSum {
  @Test def ConsecutivePrimeSum() = {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getMaxSum
    println( "P050: Maximum prime is " + maxPrimeSum )
    assertEquals( 997651, maxPrimeSum )
  }
}

s
class P051_PrimeDigitReplacements {
  @Test def test = {
    println("P051:")
    P051_PrimeDigitReplacements.positions foreach println
    P051_PrimeDigitReplacements.printCombinations(P051_PrimeDigitReplacements.positions, 4, 2)
  }
}

class P052_PermutedMultiples {
  @Test def PermutedMultiples() {
    val result = P052_PermutedMultiples.getNumber
    for ( multiplier <- 1 to 6 )
      printf("%dx = %d%n", multiplier, multiplier * result)
    assertEquals( 142857, result )
    printf( "%n P052: %d%n", result )
  }
}

class P053_CombinatoricSelections {
  @Test def CombinatoricSelections():Unit = {
    val count = P053_CombinatoricSelections.getCount( n = 100, upperLimit = 1000000 )
    printf( "P053: Count = %d%n", count )
    assertEquals( 4075, count )
  }
}

class P055_LychrelNumbers {
  @Test def lychrelNumbers() {
    val count = P055_LychrelNumbers.lychrelCount
    assertEquals(249, count)
    printf("P055: Lychrel count = %d%n", count )
  }
}

class P056_PowerfulDigitSum {
  @Test def testP056_PowerfulDigitSum() {
    val result = P056_PowerfulDigitSum.powerfulDigitSum
    assertThat("Incorrect sum.",
      result,
      CoreMatchers.is(972))
    println( "Maximum digital sum = " + result )
  }
}

class P058_SpiralPrimes {
  @Test
  def spiralPrimes:Unit = {
    val result = P058_SpiralPrimes.calcPrimes
    println ("P058_SprialPrimes: Height = " + result)
    assertThat("Incorrect height.",
      result,
      CoreMatchers.is(26241))
  }
}