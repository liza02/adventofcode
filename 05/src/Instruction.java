public class Instruction {

    private int numberOfCrateToMove;
    private int source;
    private int destination;

    public Instruction(String instruction) {
        String [] words = instruction.split(" ");
        this.numberOfCrateToMove = Integer.parseInt(words[1]);
        this.source = Integer.parseInt(words[3]);
        this.destination = Integer.parseInt(words[5]);
    }

    public int getNumberOfCrateToMove() {
        return numberOfCrateToMove;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }
}
