import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static List<String> readData() throws FileNotFoundException {
        List<String> dataList = new ArrayList<>();
        Scanner sc = new Scanner(new File("08/input.txt"));
        while (sc.hasNextLine()) {
            dataList.add(sc.nextLine());
        }
        sc.close();
        return dataList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> rawData = readData();
        Grid grid = new Grid(rawData);
        System.out.println("STEP 1 :");
        System.out.println("Number of visible trees : " + grid.countVisibleTrees());
        System.out.println("STEP 2 :");
        System.out.println("Greater scenic score : " + grid.findGreaterScenicScore());

    }
}
