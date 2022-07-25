public class Date {

    private int day;
    private int month;
    private int year; 
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String allDate) {
        String[] a=new String[3];
        a= allDate.split("\\.");
        this.day = Integer.parseInt(a[0]);
        this.month = Integer.parseInt(a[1]);
        this.year = Integer.parseInt(a[2]);
    }
    public boolean DateControl(Date sd,Date ed) {
    	if(sd.getYear()==ed.getYear()&&sd.getMonth()==ed.getMonth()&&sd.getDay()+3>=ed.getDay()) {
    		return true;
    	}
    	else return false;
    }

    public String toString() {
        return (day + "." + month + "." + year);
    }

    //Getters and Setters

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
