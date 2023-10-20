public class Time {
    //created the private data fields
    private int hours;
    private int minutes;
    private int seconds;
    //default constructor sets time to midnight
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    //constructor that takes proper input
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    //increment function
    public void increment(int newSeconds) {
        this.seconds = this.seconds + newSeconds;

        while (this.seconds > 59) {
            this.seconds = this.seconds - 60;
            this.minutes++;
        }

        while (this.minutes > 59) {
            this.minutes = this.minutes - 60;
            this.hours++;
        }

        while (this.hours > 23) {
            this.hours = this.hours - 24;
        }

    }
    //print function that utilizes helper function for formatting
    public void print(boolean military) {
        String amOrPm = "AM";

        if (military) {
            System.out.println(this.hours + ":" + formatter(this.minutes) + ":" + formatter(this.seconds));
        } else {
            //converts to standard time or whatever its called
            if (this.hours > 11) {
                amOrPm = "PM";
                this.hours = this.hours - 12;
            }
            System.out.println(this.hours + ":" + formatter(this.minutes) + ":" + formatter(this.seconds) + " " + amOrPm);
        }
    }
    //creates new Time object from the string being split into an array and the array values being organized
    public static Time fromString(String timeString) {
        String[] timeStringArray = timeString.split(":");

        int hoursP = Integer.parseInt(timeStringArray[0]);
        int minutesP = Integer.parseInt(timeStringArray[1]);
        int secondsP = Integer.parseInt(timeStringArray[2]);

        Time t4 = new Time(hoursP, minutesP, secondsP);
        return t4;
    }
    /*helper array that takes in whatever int you pass it, checks if its single digit, adds a zero to the front of it,
    then returns (tl;dr it formats things)*/
    public String formatter(int value) {
        String result;

        if (value < 10) {
            result = "0" + Integer.toString(value);
        } else {
            result = Integer.toString(value);
        }
        return result;
    }
}
