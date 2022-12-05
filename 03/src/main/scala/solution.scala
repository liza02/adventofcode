object solution {

  def read_data(file_name: String): List[String] = {
    scala.io.Source.fromFile(file_name).getLines.toList
  }

  def part_1() : Unit = {
    val rucksacks = read_data("./input.txt")
    val total_priority = map_priority(rucksacks)
    println("Sum of all priority : " + total_priority)
  }

  def map_priority(rucksacks: List[String]): Int = rucksacks match {
    case Nil => 0
    case rucksack :: tail => {
      compute_priority_of_rucksack(rucksack) + map_priority(tail)
    }
  }

  def compute_priority_of_rucksack(rucksack : String) : Int = {
    val middle_of_rucksack = rucksack.length / 2
    val compartments = List(rucksack.substring(middle_of_rucksack), rucksack.substring(0, middle_of_rucksack))
    val item = (compartments(0) intersect compartments(1)).charAt(0)
    compute_priority_of_item(item)
  }

  def compute_priority_of_item(item : Char) : Int= {
    (('a' to 'z').toList ++ ('A' to 'Z').toList).indexOf(item) +1
  }

  def part_2() = {
    val rucksacks = read_data("./input.txt")
    val total_priority =  map_group(rucksacks)
    println("Sum of all priority : " + total_priority)
  }

  def map_group(rucksacks: List[String]): Int = rucksacks match {
    case Nil => 0
    case group_1 :: group_2 :: group_3 :: tail => {
      val common_item = (group_1 intersect group_2 intersect group_3).charAt(0)
      compute_priority_of_item(common_item) + map_group(tail)
    }
  }

  def main(args: Array[String]) {
    try {
      println("--- PARTIE 1 ---")
      part_1()
      println("--- PARTIE 2 ---")
      part_2()
    } catch {
      case e: Exception => println("Error : " + e.getMessage);
    }
  }
}
