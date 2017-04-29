package com.rs.game;

import com.cryo.DefaultCommandListener;
import com.cryo.DiscordBot;
import com.cryo.DiscordSettings;

public class DiscordBotHandler {
    
    static DiscordBot bot = new DiscordBot(DiscordSettings.build("Mjc5Nzk2NTA0NjQ0ODEyODEw.C-UzCQ.Qst1wbaav-m9tT2X45EyEgqirWs"));

    public static void init() {
	bot.run();
	bot.registerCommandListener(new DefaultCommandListener(bot, "~"));
    }
    
    public static void sendMessage(String channelId, String message) {
	bot.sendMessage(channelId, message);
    }
}
