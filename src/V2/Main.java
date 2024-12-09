package V2;

public class Main {
    public static void main(String[] args) {
        // Create players
        Goalkeeper g = new Goalkeeper("Manuel", 1.92);
        Striker s1 = new Striker("Ronaldo");
        Striker s2 = new Striker("Messi");
        Defender d1 = new Defender("Ramos");
        Defender d2 = new Defender("Chiellini");

        // Create a Team and add players
        Team team = new Team();
        team.setGoalkeeper(g);
        team.addStriker(s1);
        team.addStriker(s2);
        team.addDefender(d1);
        team.addDefender(d2);

        // Show names of the players
        g.showName();
        s1.showName();
        s2.showName();
        d1.showName();
        d2.showName();

        // Let one striker do extra training
        s1.doJoggingTraining();

        // Start the match and see how each player "plays" differently
        System.out.println("\n--- The match begins ---");
        team.startMatch();
    }
}
