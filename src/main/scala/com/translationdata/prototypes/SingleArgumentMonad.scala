package com.translationdata.prototypes

// Note that the constructor creates the value-field...
class SingleArgumentMonad[A](val value: A) {
  // This function extracts the value-field from the monad and passes
  // it to f() and wraps the result from f() of type B into a Monad.
  // The value-field is mapped to the input of the lambda expression.
  def map[B](f:A => B) = new SingleArgumentMonad(f(value))

  // This function extracts the value-field from the monad and passes
  // back the result of f() which is a Monad that wraps type B...
  def flatMap[B](f:A => SingleArgumentMonad[B]) = f(value)
  def flatMapNoReturnMonad[B](f:A => B) = f(value)

  // Need this function to get the string value of the value-field...
  override def toString = value.toString}

object SingleArgumentMonad {
  def main(args: Array[String]) {
    val monadWith4 = new SingleArgumentMonad(4)
    val monadWith5 = new SingleArgumentMonad(5)

    val forResult = for {
      x <- monadWith4 // The flatMap function reads the value instance variable fom the monad
      y <- monadWith5 // The map function reads the value instance variable fom the monad
    } yield x + y

    println("for() result = " + forResult)

    // Now convert the for-comprehension into lambda expressions to demonstrate
    // that the for-comprehension is logically equivalent to lambda expressions
    // with map() and flatMap() calls.

    // Step 1. Convert for to flatMap...
    val flatMapAndForResult =
      monadWith4.flatMap { x =>
        for {
          y <- monadWith5
        } yield x + y
      }
    println("flatMap() + for() result = " + flatMapAndForResult)

    // Step 2. Convert for to map...
    val flatMapAndMapResult =
      monadWith4.flatMap { x =>
        monadWith5.map { y => x + y }
      }

    val flatMapAndMapresultNoReturnMonad =
      monadWith4.flatMapNoReturnMonad { x =>
        monadWith5.flatMapNoReturnMonad { y => x + y }
      }

    var monadValue = monadWith4.map(x => 2 * x)
    monadValue = monadValue.map(x => x * x)

    var intValue = monadWith4.flatMapNoReturnMonad(x => 2 * x)
    //  intValue = intValue.flatMapNoReturnMonad(x => x * x)  // COMPILER ERROR, Int() does not have this function

    flatMapAndForResult.map(x => x*x)
    flatMapAndForResult.flatMap(x => new SingleArgumentMonad(x*x*2) )

    // Based on what I see in the debugger this is how the code works.
    // 1. Execute the monadWith4.flatMap() function. This steps takes the 4
    // in the monad and substitutes the 4 into monadWith4.map { y => x + y }
    // which yields monadWith4.map { y => 4 + y }.
    //
    // 2. Execute the monadWith4.map() function.  This step takes the 5
    // in the monad and substitutes the 5 into y => 2 + y which yields 5 => 2 + 5
    //
    // 3. Evaluate 5 + 5 which yields 9. So 9 is the result BUT the monad member function in the class
    // wraps the 9 in a SingleArgumentMonad. So the flatMapAndMapResult variable ends up containing a monad
    // that contains a 9.

    // The constructor defines value as a val so we can read the data in the monad...
    val result = flatMapAndForResult.value
    println("flatMap() + map() result = " + result)

    // Two map() calls...
    val TwoMapsResult =
      monadWith4.map { x =>
        monadWith5.map { y => x + y }
      }

    // Two flatMap() calls...
    var twoFlatMapsResult =
      monadWith4.flatMapNoReturnMonad { x =>
        monadWith5.flatMapNoReturnMonad { y => x + y }
      }
    twoFlatMapsResult = null
  }
}


