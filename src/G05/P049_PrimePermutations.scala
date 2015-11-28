package G05
import misc.SieveOfEratosthenes;

/** Strategy: Brute Force, Prime Sieve */
  object P049_PrimePermutations {
  val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( 10000 )
  
  def main(args: Array[ String ]) { 
    val prime = result
    printf( "Prime Permutations = %d, %d, %d", prime(0), prime(1), prime(2) ) 
  }
  
  def result:Array[Int] = {
    (1001 to 10000 - 2 * 3330).foreach  { firstCandidate =>
      val secondCandidate = firstCandidate + 3330
      val thirdCandidate = firstCandidate + 2 * 3330

      if ( areCandidatesPrime(firstCandidate, secondCandidate, thirdCandidate) &&
          isPermutation( firstCandidate, secondCandidate ) && 
          isPermutation( firstCandidate, thirdCandidate) ) {
        if ( firstCandidate != 1487) {
          return Array( firstCandidate, secondCandidate, thirdCandidate )
        }
      }
    }
    return Array( 0, 0, 0 )
  }
  
  def areCandidatesPrime(candidate:Int, secondCandidate: Int, thirdCandidate: Int) = {
    sieve.isPrime( candidate ) && 
    sieve.isPrime( secondCandidate ) && 
    sieve.isPrime( thirdCandidate )
  }

  def areCandidatesPermutations(candidate: Int, secondCandidate: Int, thirdCandidate: Int) = {
    isPermutation(candidate, secondCandidate) &&
    isPermutation(candidate, thirdCandidate)
  }
  
  def isPermutation( arg1:Int, arg2:Int ) = {
    val s1:String = arg1.toString()
    val s2:String = arg2.toString()

    if( s2.contains( s1( 0 ) ) && 
        s2.contains( s1( 1 ) ) && 
        s2.contains( s1( 2 ) ) && 
        s2.contains( s1( 3 ) ) )
      true
    else
      false
  }
}