enum Movement {

    UP('U', 0, 1),
    DOWN('D',0,-1),
    LEFT('L',-1,0),
    RIGHT('R',1,0);

    final String direction
    final int xOffset, yOffset

    private Movement(String direction, int xOffset, int yOffset) {
        this.direction = direction
        this.xOffset = xOffset
        this.yOffset = yOffset
    }

    static of(String direction) {
        values().find() {it.direction == direction}
    }

}