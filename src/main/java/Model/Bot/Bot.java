package Model.Bot;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;


public class Bot {
    private final String token = Token.getToken();

    public Bot() {
    }

    public void Start(){
        GatewayDiscordClient gatewayDiscordClient = DiscordClientBuilder.create(token).build().login().block();

        gatewayDiscordClient.getEventDispatcher().on(MessageCreateEvent.class).flatMap(
                this::handleMessage)
                .subscribe();
        gatewayDiscordClient.onDisconnect().block();
    }

    private Mono<Void> handleMessage(MessageCreateEvent event) {
        return new CommandHandler().handle(event);
    }

}
