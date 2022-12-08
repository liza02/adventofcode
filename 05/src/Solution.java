import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {



    public static List<String> readData() throws FileNotFoundException {
        List<String> dataList = new ArrayList<>();
        File myObj = new File("05/input.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            dataList.add(data);
        }
        myReader.close();
        return dataList;
    }

    public static void extractData (List<String> inputData, List<String> stacks, List<String> instructions) {
        int[] indexesOfSplit = Stream.of(IntStream.of(-1), IntStream.range(0, inputData.size())
                            .filter(i -> inputData.get(i).equals("")), IntStream.of(inputData.size()))
                            .flatMapToInt(s -> s).toArray();
        List<List<String>> subLists = IntStream.range(0, indexesOfSplit.length - 1)
                                        .mapToObj(i -> inputData.subList(indexesOfSplit[i] + 1, indexesOfSplit[i + 1]))
                                        .collect(Collectors.toList());
        stacks.addAll(subLists.get(0));
        instructions.addAll(subLists.get(1));
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> raw_data = readData();
        List<String> stacks = new ArrayList<>();
        List<String> instructions = new ArrayList<>();
        extractData(raw_data, stacks, instructions);
        Ship shipStep1 = new Ship(stacks);

        System.out.println("STEP 1 :");
        CrateMover crateMover = new CrateMover9000();
        shipStep1.moveStacks(crateMover, instructions);
        shipStep1.stacks.forEach(stack -> System.out.print(stack.peekCrate().getName()));

        Ship shipStep2 = new Ship(stacks);
        System.out.println("\nSTEP 2 :");
        crateMover = new CrateMover9001();
        shipStep2.moveStacks(crateMover, instructions);
        shipStep2.stacks.forEach(stack -> System.out.print(stack.peekCrate().getName()));

    }
}