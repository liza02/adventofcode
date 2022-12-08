import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrateMover9001 implements CrateMover{
    @Override
    public void applyInstruction(Instruction instruction, Ship ship) {
        Stack stackDestination = ship.stacks.get(instruction.getDestination() -1);
        Stack stackSource = ship.stacks.get(instruction.getSource() -1);
        List<Crate> cratesToMove = IntStream.range(0, instruction.getNumberOfCrateToMove()).mapToObj(i -> stackSource.popCrate()).collect(Collectors.toList());
        Collections.reverse(cratesToMove);
        cratesToMove.forEach(stackDestination::addCrate);
    }
}
