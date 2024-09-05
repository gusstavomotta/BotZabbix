package Controller;

import model.BotZabbixClass;
import requisicao.MensagemRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enviar-mensagem")
public class BotController {

    private final BotZabbixClass bot;

    public BotController(BotZabbixClass bot) {
        this.bot = bot;
    }

    @PostMapping
    public void receberMensagem(@RequestBody MensagemRequest request) {
        bot.enviarMensagem(Long.parseLong(request.getChatId()), request.getMensagem());
    }
}

