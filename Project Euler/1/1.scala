object one
{
  def fivethree_core(lst: Seq[Int]): List[Int] = {
		val crossed = lst.filter(x => (x % 3 == 0 || x % 5 == 0))
		crossed.toList
  }

	def fivethree(max: Int): List[Int] = fivethree_core(2 to max toList)


	def main(args: Array[String]): Unit =
  {
     print(fivethree(999).sum)
  }
}
