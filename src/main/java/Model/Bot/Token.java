package Model.Bot;

import io.github.cdimascio.dotenv.Dotenv;

public class Token {
    private static final String dotenv = System.getenv("discord.token");
    public static String getToken(){
        return dotenv;
    }
}
