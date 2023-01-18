class Solution {

    static void main(String[] args) {
        def motions = new File("09/input.txt").collect { new Tuple2(it.split(" ")[0], it.split(" ")[1] as Integer)}
        Rope ropePart1 = new Rope(2)
        ropePart1.applyMotions(motions)
        println "(Part 1) Number of visited positions by tail : " + ropePart1.getNumberOfTailVisitedPositions()

        Rope ropePart2 = new Rope(10)
        ropePart2.applyMotions(motions)
        println "(Part 2) Number of visited positions by tail : " + ropePart2.getNumberOfTailVisitedPositions()
    }
}
