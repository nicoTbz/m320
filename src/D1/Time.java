package D1;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hour, int minute, int second) {
        this.hours = hour;
        this.minutes = minute;
        this.seconds = second;
    }
    
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {    
        return seconds;
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0 and 23.");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59.");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    public void setTime(int hour, int minute, int second){
        setHours(hour);
        setMinutes(minute);
        setSeconds(second);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
    }


    public Time nextSecond() {
        int newSeconds = getSeconds() + 1;
        int newMinutes = getMinutes();
        int newHours = getHours();

        if (newSeconds >= 60) {
            newSeconds = 0;
            newMinutes++;
            if (newMinutes >= 60) {
                newMinutes = 0;
                newHours++;
                if (newHours >= 24) {
                    newHours = 0;
                }
            }
        }

        this.setTime(newHours, newMinutes, newSeconds);
        return this;
    }

}