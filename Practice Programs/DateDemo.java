
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateDemo {

    public void displayDate() {
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        GregorianCalendar gcalendar = new GregorianCalendar();

        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println("" + gcalendar.get(Calendar.YEAR));

        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));
    }

    public void newYorkTime() {

        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Calendar calNewYork = Calendar.getInstance();
        calNewYork.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        System.out.print("Date: ");
        System.out.print(months[calNewYork.get(Calendar.MONTH)]);
        System.out.print(" " + calNewYork.get(Calendar.DATE) + " ");
        System.out.println("" + calNewYork.get(Calendar.YEAR));

        System.out.print("Time: ");
        System.out.print(calNewYork.get(Calendar.HOUR_OF_DAY) + ":");
        System.out.print(calNewYork.get(Calendar.MINUTE) + ":");
        System.out.println(calNewYork.get(Calendar.SECOND));
    }
    
    public void lastDayOfCurrentMonth()
    {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
    public void firstDayOfCurrentMonth()
    {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
    }

    public static void main(String[] args) {
        DateDemo obj = new DateDemo();
        //obj.displayDate();
        //obj.newYorkTime();
        //obj.lastDayOfCurrentMonth();
        obj.firstDayOfCurrentMonth();
    }

}
