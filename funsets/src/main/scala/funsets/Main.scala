package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  printSet(FunSets.map(FunSets.singletonSet(2), x => x * 2))
}
