class Solution {

    static void main(String[] args) {
        def motions = new File("09/input.txt").collect { new Tuple2(it.split(" ")[0], it.split(" ")[1] as Integer)}
        Rope rope = new Rope()
        rope.applyMotions(motions)
        println "Number of visited positions by tail : " + rope.getNumberOfTailVisitedPositions()
    }
}
