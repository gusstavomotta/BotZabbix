package com.mycompany.botzabbix;

import model.BotZabbixClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany.botzabbix", "model", "Controller", "requisicao"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public TelegramBotsApi telegramBotsApi(BotZabbixClass botZabbixClass) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(botZabbixClass);
            return telegramBotsApi;
        } catch (TelegramApiException e) {
            throw new RuntimeException("Erro ao registrar o bot no Telegram", e);
        }
    }
}
