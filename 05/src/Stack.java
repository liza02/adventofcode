public class Stack {

    protected java.util.Stack<Crate> crates;

    public Stack() {
        this.crates = new java.util.Stack<>();
    }

    public void addCrate(Crate crate) {
        if (!crate.getName().equals(""))
            this.crates.push(crate);
    }

    public Crate peekCrate() {
        return this.crates.peek();
    }

    public Crate popCrate() {
        return this.crates.pop();
    }
}
