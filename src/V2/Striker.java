package V2;

public class Striker extends Player {

    public Striker(String name) {
        super(name);
    }

    public void doJoggingTraining() {
        System.out.println(name + " is doing jogging training to improve speed.");
    }

    @Override
    public void play() {
        System.out.println(name + " (Striker) attacks and tries to score a goal!");
    }
}
