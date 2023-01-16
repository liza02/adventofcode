import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Grid {

    private List<List<Tree>> trees;

    private int height, width;

    public Grid(List<String> treesRawData) {
        trees = new ArrayList<>();
        AtomicInteger x = new AtomicInteger(0);
        AtomicInteger y = new AtomicInteger(0);
        treesRawData.forEach(lineTrees -> {
            trees.add(Arrays.stream(lineTrees.split("")).map(tree -> new Tree(parseInt(tree), x.getAndIncrement(), y.get())).toList());
            y.getAndIncrement();
            x.set(0);
        });

        this.height = trees.size();
        this.width = trees.get(0).size();
    }

    public Stream<List<Tree>> getAdjacentTrees(Tree tree) {
        List<Tree> left = new ArrayList<>(getLineBetween(tree.getY(), 0, tree.getX()));
        List<Tree> right = new ArrayList<>(getLineBetween(tree.getY(), tree.getX()+1, this.width));
        List<Tree> up = new ArrayList<>(getColumnBetween(tree.getX(), 0, tree.getY()));
        List<Tree> down = new ArrayList<>(getColumnBetween(tree.getX(), tree.getY()+1, this.height));
        Collections.reverse(left);
        Collections.reverse(up);
        return Stream.of(left, right, up, down);
    }

    private List<Tree> getLineBetween(int y, int x1, int x2) {
        return this.trees.get(y).subList(x1, x2);
    }

    private List<Tree> getColumnBetween(int x, int y1, int y2) {
        return this.trees.stream().map(line -> line.get(x)).toList().subList(y1, y2);
    }

    public int countVisibleTrees() {
        return this.trees.stream().map(lineTrees -> lineTrees.stream().filter(tree -> tree.isVisible(this)).toList()).mapToInt(List::size).sum();
    }

    public int findGreaterScenicScore() {
        return this.trees.stream().mapToInt(line -> line.stream().mapToInt(tree -> tree.computeScenicScore(this)).max().orElse(0)).max().orElse(0);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}