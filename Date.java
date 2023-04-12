import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date{
    private final int day;
    private final int month;
    private final int year;
    public Date(String day, String month, String year){
        this.day = Integer.parseInt(day);
        this.month = Integer.parseInt(month);
        this.year = Integer.parseInt(year);
    }
    Calendar calendar = new GregorianCalendar();

    public boolean isValidDate(){
        if(this.month >= 1 && this.month <= 12 && this.year >= 1000 && this.year < 2023){
           if((this.month < 7 && this.month % 2 != 0) || (this.month > 7 && this.month % 2 == 0)){
               return this.day >= 1 && this.day <= 31;
           }
           else if(this.month == 2 && (this.year % 4 == 0 || (this.year % 100 == 0 && this.year % 400 == 0))){
               return this.day >= 1 && this.day <= 29;
           }
           else if(this.month == 2 && !(this.year % 100 == 0 && this.year % 400 == 0)){
               return this.day >= 1 && this.day <= 28;
           }
           else{
               return this.day >= 1  && this.day <= 30;
           }
        }
        else{
            return false;
        }
    }
    public int ageCount(){
        if(calendar.get(Calendar.MONTH) - this.month+1 > 0){
            return calendar.get(Calendar.YEAR) - this.year;
        }
        else if(calendar.get(Calendar.MONTH) - this.month+1 == 0){
            if(calendar.get(Calendar.DAY_OF_MONTH) - this.day >= 0){
                return calendar.get(Calendar.YEAR) - this.year;
            }
            else{
                return calendar.get(Calendar.YEAR) - this.year - 1;
            }
        }
        else{
            return calendar.get(Calendar.YEAR) - this.year - 1;
        }
    }
}