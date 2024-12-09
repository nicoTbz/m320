package V2;

public class Defender extends Player {

    public Defender(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(name + " (Defender) defends and blocks opposing strikers.");
    }
}
