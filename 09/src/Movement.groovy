enum Movement {

    UP('U', 0, 1),
    DOWN('D',0,-1),
    LEFT('L',-1,0),
    RIGHT('R',1,0);

    final String direction
    final int xIncrement, yIncrement

    private Movement(String direction, int xIncrement, int yIncrement) {
        this.direction = direction
        this.xIncrement = xIncrement
        this.yIncrement = yIncrement
    }

    static of(String direction) {
        values().find() {it.direction == direction}
    }

}