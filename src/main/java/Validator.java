import java.util.Calendar;
import java.util.Date;

public class Validator {
    public static boolean writeIfIn() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        boolean in = false;
        if (day == 1 || day == 4) {
            if (hour >= 20 && hour <= 21)
                in = true;
        }
        if (day == 2 || day == 5) {
            if (hour >= 20 && hour <= 21)
                in = true;
        }
        if (day == 6 || day == 7) {
            if (hour >= 16 && hour <= 17)
                in = true;
        }
        return in;
    }
}
