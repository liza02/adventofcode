import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ship {

    protected List<Stack> stacks;

    public Ship(List<String> stacks) {
        int numberOfStacks = stacks.get(stacks.size()-1).split("  ").length;
        this.stacks = new ArrayList<>();
        IntStream.range(0, numberOfStacks).forEach(stackIndex -> this.stacks.add(new Stack()));
        this.fillStacks(stacks);
    }

    public void fillStacks(List<String> stacks) {
        // we add 0 or 1 crate to each stack (treatment line by line of the input)
        for (int i=stacks.size()-2; i >= 0; i--) {

            // sanitation of the line of crates to match stacks
            List<String> crates = new ArrayList<>();
            int index = 0;
            for (index = 0; index < stacks.get(i).length(); index+=4) {
                crates.add(stacks.get(i).substring(index, Math.min(index + 4,stacks.get(i).length())).replace(" ", ""));
            }

            // filling each stack with th given line of crates
            IntStream.range(0, 9).forEach(stackIndex -> this.stacks.get(stackIndex).addCrate(new Crate(crates.get(stackIndex))));
        }
    }

    public void moveStacks(CrateMover cratemover, List<String> instructions) {
        instructions.forEach(instructionString -> {
            Instruction instruction = new Instruction(instructionString);
            cratemover.applyInstruction(instruction, this);
        });
    }
}
