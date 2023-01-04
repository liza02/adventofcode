import java.util.List;
import java.util.stream.Stream;

public class Tree {

    private final int height;

    private final int  x, y;

    public Tree(int height, int x, int y) {
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public boolean isHighterOrEqualThan(Tree otherTree) {
        return this.height >= otherTree.height;
    }

    public boolean isVisible(Grid grid) {
        if (this.isBorder(grid))
            return true;
        Stream<List<Tree>> adjacent = grid.getAdjacentTrees(this);
        return !(adjacent.allMatch(range -> range.stream().anyMatch(tree -> tree.isHighterOrEqualThan(this))));
    }

    public int computeScenicScore(Grid grid) {
        Stream<List<Tree>> adjacent = grid.getAdjacentTrees(this);
        return adjacent.mapToInt(this::countVisibleTrees).reduce(1, (left, right) -> left * right);
    }

    public int countVisibleTrees(List<Tree> line) {
        int count = 0;
        for (Tree tree : line) {
            count++;
            if (tree.height >= this.height)
                break;
        }
        return count;
    }

    public boolean isBorder(Grid grid) {
        return this.x == grid.getWidth()-1 || this.x == 0 || this.y == 0 || this.y == grid.getHeight()-1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
