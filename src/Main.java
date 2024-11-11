import D1.Time;

public class Main {
    public static void main(String[] args) {
        Time time = new Time(10,10,10);
        
        System.out.println(time.toString());
        time.setHours(21);
        System.out.println(time.toString());
        time.setHours(29);
        System.out.println(time.toString());
        time.setMinutes(29);
        System.out.println(time.toString());
        
    }
}