package com.translationdata.prototypes

import junit.framework.TestResult

class SingleArgumentMonad[A](val value: A) {
  def map[B](lambdaFunction: A => B) = new SingleArgumentMonad(lambdaFunction(value))
  def flatMap[B](lambdaFunction: A => SingleArgumentMonad[B]) = lambdaFunction(value)
  override def toString = value.toString

  // Not part of a normal Monad. It's here to show why map() is necessary.
  def flatMapNoLift[B](f: A => B) = f(value)
}

object SingleArgumentMonad {
  def main(args: Array[String]) {
    val monadWith4 = new SingleArgumentMonad(4)
    val monadWith5 = new SingleArgumentMonad(5)

    val forResult = for {
      x <- monadWith4 // The flatMap function reads the value instance variable fom the monad
      y <- monadWith5 // The map function reads the value instance variable fom the monad
    } yield x + y

    println("Result = " + forResult)

    // Now convert the for-comprehension into lambda expressions to demonstrate
    // that the for-comprehension is logically equivalent to lambda expressions
    // with map() and flatMap() calls.

    // Step 1. Convert for to flatMap...
    val flatMapStep1 =
      monadWith4.flatMap { x =>
        for {
          y <- monadWith5
        } yield x + y
      }
    println("flatMapStep1() = " + flatMapStep1)

    // Step 2. Convert for to map...
    val flatMapStep2 =
      monadWith4.flatMap { x =>
        monadWith5.map { y => x + y }
      }

    val noLift =
      monadWith4.flatMapNoLift { x =>
        monadWith5.flatMapNoLift { y => x + y }
      }

    var monadValue = monadWith4.map(x => 2 * x)
    monadValue = monadValue.map(x => x * x)

    var intValue = monadWith4.flatMapNoLift(x => 2 * x)
    //  intValue = intValue.flatMapNoReturnMonad(x => x * x)  // COMPILER ERROR, Int() does not have this function

    flatMapStep1.map(x => x*x)
    flatMapStep1.flatMap(x => new SingleArgumentMonad(x*x*2) )

    // Based on what I see in the debugger this is how the code works.
    // 1. Execute the monadWith4.flatMap() function. This steps takes the 4
    // in the monad and substitutes the 4 into monadWith4.map { y => x + y }
    // which yields monadWith4.map { y => 4 + y }.
    //
    // 2. Execute the monadWith4.map() function.  This step takes the 5
    // in the monad and substitutes the 5 into y => 4 + y which yields 5 => 4 + 5
    //
    // 3. Evaluate 4 + 5 which yields 9. So 9 is the result BUT the monad member function in the class
    // wraps the 9 in a SingleArgumentMonad. So the flatMapStep2 variable ends up containing a monad
    // that contains a 9.

    // The constructor defines value as a val so we can read the data in the monad...
    val result = flatMapStep1.value
    println("flatMap() + map() result = " + result)

    // Two map() calls that cause nested monads...
    val TwoMapsResult =
      monadWith4.map { x =>
        monadWith5.map { y => x + y }
      }

    println( "TwoMapsResult = " + TwoMapsResult )

    // Two flatMap() calls that result in an Int...
    val twoFlatMapsResult =
      monadWith4.flatMapNoLift { x =>
        monadWith5.flatMapNoLift { y => x + y }
      }

    val twoFlatMapsResultWrapped =
      new SingleArgumentMonad( monadWith4.flatMapNoLift { x =>
        monadWith5.flatMapNoLift { y => x + y }
      })

    twoFlatMapsResult
    twoFlatMapsResultWrapped

    val testResult = monadWith4.map(x => x * 2)
    new SingleArgumentMonad(12)

    // The following flatMap will not compile because the lambda must return a SingleArgumentMonad datatype...
    //val testResult3 = monadWith4.flatMap( x => x *3 )

    // This is the way to do it.  Wrap the result in a SingleArgumentMonad...
    val testResult2 = monadWith4.flatMap( x => new SingleArgumentMonad(x *3) )


    println( "TestResult2 = " + testResult2 )

    val list = List( 1, 2, 3)

    val x = list.map(x => x * x)
    val x2 = list.flatMap(x => x * x)

    x
  }



}


