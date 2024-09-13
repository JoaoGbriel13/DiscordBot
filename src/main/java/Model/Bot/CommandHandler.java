package Model.Bot;

import Model.Calculator.LapData;
import Model.Calculator.RaceData;
import Model.Calculator.TimedRaceData;
import Strategies.RaceBot;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class CommandHandler {
    public Mono<Void> handle(MessageCreateEvent event) {
        Message message = event.getMessage();
        String content = message.getContent();
        if (content.startsWith("!calcular")){
            return calculate(content, message);
        }
        if (content.startsWith("!moura")){
            return triste(message);
        }
        return Mono.empty();
    }

    private Mono<Void> triste(Message message) {
        return message.getChannel().flatMap(
                channel -> channel.createMessage("Chorar me acalma e me faz suportar o peso dos meus problemas").then()
        );
    }

    private Mono<Void> calculate(String content, Message message){
        String[] parts = content.split("\\s");
        if (parts.length == 3){
            try {
                double consumo = Double.parseDouble(parts[1]);
                double laps = Double.parseDouble(parts[2]);

                RaceData raceData = new LapData(consumo, laps);

                return handleCalculate(message, raceData);
            }catch (NumberFormatException e){
                return message.getChannel().flatMap(
                        channel -> channel.createMessage("Argumentos invalidos, PATETA!").then()
                );
            }
        }
        else if (parts.length == 4){
            try{
                double consumo = Double.parseDouble(parts[1]);
                double lapTime = Double.parseDouble(parts[2]);
                double raceDuration = Double.parseDouble(parts[3]);

                RaceData raceData = new TimedRaceData(consumo, lapTime, raceDuration);

                return handleCalculate(message, raceData);
            }catch (NumberFormatException e){
                return message.getChannel().flatMap(
                        channnel -> channnel.createMessage("Argumentos invalidos, PATETA!")
                ).then();
            }
        }else {
            return message.getChannel().flatMap(
                    channel -> channel.createMessage("Ai é foda de entender né paizão...").then()
            );
        }
    }
    private Mono<Void> handleCalculate(Message message, RaceData raceData) {
        RaceBot raceBot = new RaceBot();
        String response = raceBot.calculateAndReport(raceData); //
        return message.getChannel().flatMap(channel -> channel.createMessage(response).then());
    }
}
