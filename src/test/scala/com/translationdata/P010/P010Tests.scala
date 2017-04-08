package test.scala.com.translationdata.P010

import org.hamcrest.CoreMatchers
import org.junit.Assert._
import org.junit.Test
import com.translationdata.P010._

/**
  * Created by Harold on 4/7/2017.
  */
class P010_SummationOfPrimes {
  @Test(timeout = 10000)
  def TwoMillionPrimes(): Unit = {
    val upperLimit = 2000000
    val primeSum = P010_SummationOfPrimes.primesSum(upperLimit)
    printf("P010: Result(%d) = %d%n", upperLimit, primeSum)
    assertThat("Incorrect sum.",
      primeSum,
      CoreMatchers.is(142913828922L))
  }
}

class P011_LargestProduct {
  @Test
  def LargestProduct() {
    val maximumProduct = P011_LargestProduct.largestProduct
    printf("P011: largestProduct() = %d%n", maximumProduct)
    assertEquals("Incorrect product", 70600674, maximumProduct)
  }
}
