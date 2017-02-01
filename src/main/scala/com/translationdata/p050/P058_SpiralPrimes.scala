package main.scala.com.translationdata.p050
import misc.SieveOfEratosthenes
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.Assert._

object P058_SpiralPrimes {
  val primeSieve = new SieveOfEratosthenes( 1000 )

  def calcPrimes:Int = {
      calcPrimesImpl(1, 1, 0, 0)
  }

  // Summation pattern:
  // 1 + 2 * 4 = 9,      1 + 2 = 3, 1+ 2*2 = 5, 1+ 3*2 = 7
  // 9 + 4 * 4 = 25,     9 + 4 = 13, 9 + 2*4 = 17, 9 + 3*4 = 21
  // 25 + 6 * 4 = 49
  // 49 + 8 * 4 = 81
  // upperRight = oldmaxValue + (height + 1) * 1
  // upperLeft = oldmaxValue + (height + 1) * 2
  // lowerLeft = oldmaxValue + (height + 1) * 3
  // lowerRight = oldmaxValue + (height + 1) * 4

  def calcPrimesImpl(height: Int, squareMax:Int, argLeftPrimeCount:Int, argRightPrimeCount: Int):Int = {
    val upperRight = squareMax + (height + 1) * 1
    val upperLeft  = squareMax + (height + 1) * 2
    val lowerLeft  = squareMax + (height + 1) * 3
    val lowerRight = squareMax + (height + 1) * 4
    val leftPrimeCount = argLeftPrimeCount +
    (if ( primeSieve.isPrime(upperLeft) )
      1
    else
      0) +
    (if ( primeSieve.isPrime(lowerRight) )
      1
    else
      0)

    val rightPrimeCount = argRightPrimeCount +
      (if ( primeSieve.isPrime(upperRight) )
        1
      else
        0) +
      (if ( primeSieve.isPrime(lowerLeft) )
        1
      else
        0)

    println("upperRight = " + upperRight + ", leftPrimeCount = " + leftPrimeCount + ",rightPrimeCount = " + rightPrimeCount)
    if (upperRight > 30 )
      return height

    calcPrimesImpl(height + 2, lowerRight, leftPrimeCount, rightPrimeCount)
  }
}

class P058_SpiralPrimes {
  def main(args: Array[String]): Unit = {
    P058_SpiralPrimes.calcPrimes
  }

  @Test
  def spiralPrimes:Unit = {
    P058_SpiralPrimes.calcPrimes
  }
}

