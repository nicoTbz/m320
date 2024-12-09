package V2;

public class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println("My name is: " + name);
    }

    // This method will be overridden by subclasses
    public void play() {
        System.out.println(name + " is playing football.");
    }
}
