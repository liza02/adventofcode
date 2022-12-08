public class Crate {

    private String name;

    public Crate(String name) {
        this.name = name.replace("[", "").replace("]", "");
    }

    public String getName() {
        return name;
    }
}
