class Rope {

    private List<Knot> knots

    Rope(int numberOfKnots = 2) {
        knots = new ArrayList<Knot>(numberOfKnots)
        knots.add(new Knot(x: 0, y: 0))
        (2..numberOfKnots).each {knots.add(new FollowerKnot(x: 0, y: 0))}
    }

    def applyMotions(List<Tuple2<Character, Integer>> motions) {
        motions.each(motion -> {
            def movement = Movement.of(motion.getV1())
            (1..motion.getV2()).each {
                applyMotion(movement)
            }
        })
    }

    def applyMotion(Movement motion) {
        knots.head().move(motion)
        def frontKnot = knots.head().copy()
        knots.tail().eachWithIndex {knot, index->
            if (!(knot as FollowerKnot).isAdjacentOrCovered(frontKnot)) {
                (knot as FollowerKnot).follow(frontKnot)

            }
            frontKnot = knot
        }
        (knots.last() as FollowerKnot).memorizePosition()
    }

    def getNumberOfTailVisitedPositions() {
        (knots.last() as FollowerKnot).positions.size()
    }
}
