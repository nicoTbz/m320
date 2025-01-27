package Project.ui;

public final class UnusedClass {
    private int unusedCount = 0;
    private String lastUsage = "Never";

    public UnusedClass() {
        System.out.println("UnusedClass created, but why?");
    }

    public void pretendToBeUseful() {
        System.out.println("Pretending to be useful... Done!");
    }

    public void countUsage() {
        unusedCount++;
        System.out.println("This class has now been used " + unusedCount + " time(s). Still unused?");
    }

    public String checkLastUsage() {
        System.out.println("Last usage was: " + lastUsage);
        return lastUsage;
    }

    public void markUsed() {
        lastUsage = java.time.LocalDateTime.now().toString();
        System.out.println("Marked as used on: " + lastUsage);
    }

    public static void globalAnnouncement() {
        System.out.println("Hey, why not use UnusedClass? It's cool, I promise!");
    }

}
