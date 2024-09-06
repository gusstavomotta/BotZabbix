package model;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotZabbixClass extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Bot zabbix";
    }

    @Override
    public String getBotToken() {
        // Substitua pelo seu token real
        return "7313265566:AAEfFonZx2ixlWFsRGfgk3JeS8uEoV5ftOs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = responder_mensagem(update);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder_mensagem(Update update) {
        if (update.hasMessage()) {

            Message message = update.getMessage();
            Long chatId = message.getChatId();
            String resposta = """
                              Bom dia! Obrigado por entrar em contato!!
                              
                              Neste momento estou em desenvolvimento e em breve terei novas funcionalidades!
                              Obrigado pela compreensão!
                              
                              Desenvolvido por: Gustavo Motta e Luis Miguel Tavares""";
            System.out.println(chatId);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            sendMessage.setText(resposta);

            return sendMessage;
        }

        return null;
    }

    public void enviarMensagem(Long chatId, String mensagem) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(mensagem);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
