package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0)
      throw new IllegalArgumentException("Both arguments must be positive")

    if (c == 0 || r == 0 || c == r) {
      1
    } else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @scala.annotation.tailrec
    def balanceInner(charsList: List[Char], nbOpen: Int): Boolean = {
      if (charsList.isEmpty || nbOpen < 0)
        nbOpen == 0
      else if (charsList.head == '(')
        balanceInner(charsList.tail, nbOpen + 1)
      else if (charsList.head == ')')
        balanceInner(charsList.tail, nbOpen - 1)
      else
        balanceInner(charsList.tail, nbOpen)
    }

    balanceInner(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty) {
      0
    } else if (money == 0) {
      1
    } else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}
