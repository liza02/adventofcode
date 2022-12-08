public class CrateMover9000 implements CrateMover{
    @Override
    public void applyInstruction(Instruction instruction, Ship ship) {
        Stack stackDestination = ship.stacks.get(instruction.getDestination() -1);
        Stack stackSource = ship.stacks.get(instruction.getSource() -1);
        for (int i = 0; i < instruction.getNumberOfCrateToMove(); i++) {
            Crate crateToMove = stackSource.popCrate();
            stackDestination.addCrate(crateToMove);
        }
    }
}
