import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashSet;
import java.util.Set;

public class OnJoin extends ListenerAdapter {
    static Set<String> list = new HashSet<>();
    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event){
        /*System.out.println("123");
        System.out.println( event.getMember().getEffectiveName());
        System.out.println(event.getChannelJoined().getName());*/
        boolean ok = Validator.writeIfIn();
        if (event.getChannelJoined().getName().equals("group1") || event.getChannelJoined().getName().equals("group2") || event.getChannelJoined().getName().equals("group3")) {
            if (ok && (event.getMember().getEffectiveName().equals("cirmiuwu") || event.getMember().getEffectiveName().equals("Bankai") ||
                    event.getMember().getEffectiveName().equals("Ktirskikh") )) {
                list.add(event.getMember().getEffectiveName());
            }
        }


    }
}