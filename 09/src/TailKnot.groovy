class TailKnot extends Knot {

    Set<Tuple2<Integer, Integer>> positions

    TailKnot() {
        super()
        this.positions = new HashSet()
        memorizePosition()
    }

    def follow(Tuple2<Integer, Integer> headPrecedentPosition) {
        x = headPrecedentPosition.getV1()
        y = headPrecedentPosition.getV2()
        memorizePosition()
    }

    def isAdjacentOrCovered(Knot head) {
        head.x-1 <=this.x && this.x <= head.x+1 && head.y-1 <= this.y && this.y <= head.y+1
    }

    def memorizePosition() {
        positions.add(new Tuple2(x, y))
    }
}
