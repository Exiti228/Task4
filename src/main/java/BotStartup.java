import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class BotStartup {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("OTgyODk5Mzk4MDg0Mjg0NDU2.Gjsqi1.ysqUlYOaraqfkQTWIDWMR9ttLJT-i5pYA-V6uE").build();
        Runnable rt = new Runnable() {
            @Override
            public void run() {
                    boolean write = false;
                try {
                    //Каждые 5 минут проверяется что занятие закончилось и выводится в текстовый файл логи
                    while (!write) {
                        Calendar calendar = Calendar.getInstance();
                        int day = calendar.get(Calendar.DAY_OF_WEEK);
                        int hour = calendar.get(Calendar.HOUR);
                        int min = calendar.get(Calendar.MINUTE);
                        Thread.sleep(300000);
                        if (day == 1 || day == 4) {
                            if (hour == 22 && min <= 10)
                                write = true;
                        }
                        if (day == 2 || day == 5) {
                            if (hour == 22 && min <= 10)
                                write = true;
                        }
                        if (day == 6 || day == 7) {
                            if (hour == 18 && min <= 10)
                                write = true;
                        }
                        if (write) {
                            File file = new File("log.txt");
                            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
                            for (String v : OnJoin.list) {
                                writer.append(v);
                            }
                            writer.close();
                        }
                    }

                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
        jda.addEventListener(new OnJoin());


}
}
