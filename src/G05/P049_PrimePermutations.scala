package G05
import misc.SieveOfEratosthenes;

/** Strategy: Brute Force, Prime Sieve */
  object P049_PrimePermutations {
  val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( 10000 )
  def main(args: Array[ String ]) { println ( "Prime Permutations = " + result ) }
  def result:String = {

    (1001 to 10000 - 2 * 3330).foreach  { candidate =>
      val secondCandidate = candidate + 3330
      val thirdCandidate = candidate + 2 * 3330

      if ( areCandidatesPrime(candidate, secondCandidate, thirdCandidate) &&
          isPermutation( candidate, secondCandidate ) && 
          isPermutation( candidate, thirdCandidate) ) {
        if ( candidate != 1487) {
          return candidate.toString() + "," + secondCandidate.toString() + "," + thirdCandidate.toString()
        }
      }
    }
    return ""
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

    if( s2.contains( s1.charAt( 0 ) ) && 
        s2.contains( s1.charAt( 1 ) ) && 
        s2.contains( s1.charAt( 2 ) ) && 
        s2.contains( s1.charAt( 3 ) ) )
      true
    else
      false
  }
  
  /*
  seq 1001 to 10_000 - 2*3330 foreach
    if x is prime &&
      x + 3330 is prime &&
      x + 3330 * 2 is prime
      x + 3330 is permutation
      x + 2*3330 is permutation
      return x.tostring + (x +3330).tostring + (x + 2*3330).tostring
  */
}