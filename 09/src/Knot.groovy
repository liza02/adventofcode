class Knot {

    int x, y;

    def move(Movement movement) {
        move(movement.xOffset, movement.yOffset)
    }

    def move(int xOffset, int yOffset) {
        x+=xOffset
        y+=yOffset
    }

    Knot copy() {
        new Knot(x: x, y: y)
    }

}