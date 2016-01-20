package com.translationdata.prototypes

// Note that the constructor create the value-field...
class SingleArgumentMonad[A](value: A) {
  // This function extracts the value-field from the monad and passes
  // it to f() and wraps the result from f() of type B into a Monad.
  // So the value-field is mapped to the input of the lambda expression.
  def map[B](f:A => B) = new SingleArgumentMonad(f(value))

  // This function extracts the value-field from the monad and passes
  // back the result of f() which is a Monad that wraps type B...
  def flatMap[B](f:A => SingleArgumentMonad[B]) = f(value)

  // Need this function to get the string value of the value-field...
  override def toString() = value.toString()
}

object SingleArgumentMonad {
  def main(args:Array[String]) {
    val result = for {
      a <- new SingleArgumentMonad(2)
      b <- new SingleArgumentMonad(3)
    } yield a + b
    println(result)

    val n2 = new SingleArgumentMonad(2)
    val n3 = new SingleArgumentMonad(3)

    val result3 = for {
      a <- n2
      b <- n3
    } yield a + b

    // Convert for to flatMap...
    val result4 =
      n2.flatMap { x => for {
          b <- n3
        } yield x + b
      }
    println("result4 = " + result4)

    // Convert for to map...
    val result5 =
      n2.flatMap { x =>
        n3.map {y => x + y}
      }

    println("result5 = " + result5)
  }
}


