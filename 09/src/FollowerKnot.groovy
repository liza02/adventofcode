class FollowerKnot extends Knot {

    Set<Tuple2<Integer, Integer>> positions

    FollowerKnot() {
        super()
        this.positions = new HashSet()
        memorizePosition()
    }

    def follow(Knot knot) {
        move(Math.signum(knot.x - x) as int, Math.signum(knot.y - y) as int)
    }

    def isAdjacentOrCovered(Knot head) {
        head.x-1 <=this.x && this.x <= head.x+1 && head.y-1 <= this.y && this.y <= head.y+1
    }

    def memorizePosition() {
        positions.add(new Tuple2(x, y))
    }
}
