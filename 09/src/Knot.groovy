class Knot {

    int x, y;

    def move(Movement movement) {
        x+=movement.xIncrement
        y+=movement.yIncrement
    }

}