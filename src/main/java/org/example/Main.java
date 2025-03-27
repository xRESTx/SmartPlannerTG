package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize TelegramBotsApi
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Register your bot
            CustomTelegramBot telegramBot = new CustomTelegramBot("7744441188:AAGCSkqC91WK_lAALGjcN3ntIBL_NZ-CtC8"); // Replace this with your bot instance
            botsApi.registerBot(telegramBot);

            System.out.println("Bot is running...");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to start the bot!");
        }
    }
}
