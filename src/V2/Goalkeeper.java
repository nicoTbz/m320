package V2;

public class Goalkeeper extends Player {
    private double height;

    public Goalkeeper(String name, double height) {
        super(name);
        this.height = height;
    }

    @Override
    public void play() {
        System.out.println(name + " (Goalkeeper) protects the goal. Height: " + height + " m.");
    }
}
