class Rope {

    private Knot head
    private TailKnot tail

    Rope() {
        head = new Knot(x: 0, y: 0)
        tail = new TailKnot(x: 0 , y: 0)
    }

    def applyMotions(List<Tuple2<Character, Integer>> motions) {
        motions.each(motion -> {
            def movement = Movement.of(motion.getV1())
            (1..motion.getV2()).each {
                def headPrecedentPosition = new Tuple2(head.x, head.y)
                head.move(movement)
                if (!tail.isAdjacentOrCovered(head)) {
                    tail.follow(headPrecedentPosition)
                }
            }

        })
    }

    def getNumberOfTailVisitedPositions() {
        tail.positions.size()
    }
}
