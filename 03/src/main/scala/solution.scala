object solution {

  def readData(fileName: String): List[String] = {
    scala.io.Source.fromFile(fileName).getLines.toList
  }

  def part1(rucksacks: List[String]) : Unit = {
    val totalPriority = mapPriority(rucksacks)
    println("Sum of all priority : " + totalPriority)
  }

  def mapPriority(rucksacks: List[String]): Int = rucksacks match {
    case Nil => 0
    case rucksack :: tail => {
      computePriorityOfRucksack(rucksack) + mapPriority(tail)
    }
  }

  def computePriorityOfRucksack(rucksack: String) : Int = {
    val middleOfRucksack = rucksack.length / 2
    val compartments = List(rucksack.substring(middleOfRucksack), rucksack.substring(0, middleOfRucksack))
    val item = (compartments(0) intersect compartments(1)).charAt(0)
    computePriorityOfItem(item)
  }

  def computePriorityOfItem(item: Char) : Int= {
    (('a' to 'z').toList ++ ('A' to 'Z').toList).indexOf(item) +1
  }

  def part2(rucksacks: List[String]) = {
    val totalPriority =  mapGroup(rucksacks)
    println("Sum of all priority : " + totalPriority)
  }

  def mapGroup(rucksacks: List[String]): Int = rucksacks match {
    case Nil => 0
    case group1 :: group2 :: group3 :: tail => {
      val commonItem = (group1 intersect group2 intersect group3).charAt(0)
      computePriorityOfItem(commonItem) + mapGroup(tail)
    }
  }

  def main(args: Array[String]) {
    try {
      val rucksacks = readData("./input.txt")
      println("--- PARTIE 1 ---")
      part1(rucksacks)
      println("--- PARTIE 2 ---")
      part2(rucksacks)
    } catch {
      case e: Exception => println("Error : " + e.getMessage);
    }
  }
}
