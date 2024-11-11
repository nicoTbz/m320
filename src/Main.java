import D1.Time;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Time time = new Time(10,10,10);
        
        System.out.println(time.toString());
        time.setHours(21);
        System.out.println(time.toString());
        time.setHours(23);
        time.setMinutes(58);
        while(true){
            time.nextSecond();
            System.out.println(time.toString());
            Thread.sleep(100);
        }
    }
}