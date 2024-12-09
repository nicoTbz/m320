package V2;

import java.util.ArrayList;

public class Team {
    private Goalkeeper goalkeeper;
    private ArrayList<Striker> strikers;
    private ArrayList<Defender> defenders;

    public Team() {
        strikers = new ArrayList<>();
        defenders = new ArrayList<>();
    }

    public void setGoalkeeper(Goalkeeper goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

    public void addStriker(Striker s) {
        strikers.add(s);
    }

    public void addDefender(Defender d) {
        defenders.add(d);
    }

    public void startMatch() {
        if (goalkeeper != null) {
            goalkeeper.play();
        }
        for (Striker s : strikers) {
            s.play();
        }
        for (Defender d : defenders) {
            d.play();
        }
    }
}
