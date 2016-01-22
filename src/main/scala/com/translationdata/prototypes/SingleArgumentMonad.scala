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
    val monadWith2 = new SingleArgumentMonad(2)
    val monadWith3 = new SingleArgumentMonad(3)

    val forResult = for {
      x <- monadWith2 // The flatMap function reads the value instance variable fom the monad
      y <- monadWith3 // The map function reads the value instance variable fom the monad
    } yield x + y

    println("for() result = " + forResult)

    // Now convert the for-comprehension into lambda expressions to demonstrate
    // that the for-comprehension is logically equivalent to lambda expressions
    // with map() and flatMap() calls.

    // Step 1. Convert for to flatMap...
    val flatMapAndForResult =
      monadWith2.flatMap { x =>
        for {
          y <- monadWith3
        } yield x + y
      }
    println("flatMap() + for() result = " + flatMapAndForResult)

    // Step 2. Convert for to map...
    val flatMapAndMapResult =
      monadWith2.flatMap { x =>
        monadWith3.map { y => x + y }
      }

    val flatMapAndMapresultNoReturnMonad =
      monadWith2.flatMapNoReturnMonad { x =>
        monadWith3.flatMapNoReturnMonad { y => x + y }
      }

    var cc = monadWith2.map(x => 2 * x)
    cc = cc.map(x => x * x)

    var cc2 = monadWith2.flatMapNoReturnMonad(x => 2 * x)
    cc2 = cc2.flatMapNoReturnMonad(x => x * x)

    flatMapAndMapResult.map(x => x*x)
    flatMapAndMapResult.flatMap(x => new SingleArgumentMonad(x*x*2) )

    // Based on what I see in the debugger this is how the code works.
    // 1. Execute the monadWith2.flatMap() function. This steps takes the 2
    // in the monad and substitutes the 2 into monadWith3.map { y => x + y }
    // which yields monadWith3.map { y => 2 + y }.
    //
    // 2. Execute the monadWith3.map() function.  This step takes the 3
    // in the monad and substitutes the 3 into y => 2 + y which yields 3 => 2 + 3
    //
    // 3. Evaluate 2 + 3 which yields 5. So 5 is the result BUT the monad member function in the class
    // wraps the 5 in a SingleArgumentMonad. So the flatMapAndMapResult variable ends up containing a monad
    // that contains a 5.

    // The constructor defines value as a val so we can read the data in the monad...
    val result = flatMapAndMapResult.value
    println("flatMap() + map() result = " + result)
  }
}


