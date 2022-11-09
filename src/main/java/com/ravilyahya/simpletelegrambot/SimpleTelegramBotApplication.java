package com.ravilyahya.simpletelegrambot;

import com.ravilyahya.simpletelegrambot.model.AppSpotJoke;
import com.ravilyahya.simpletelegrambot.service.impl.AppSpotJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.DadJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.JokeApiService;
import lombok.RequiredArgsConstructor;
import com.ravilyahya.simpletelegrambot.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SimpleTelegramBotApplication implements CommandLineRunner {
    private final DadJokeService dadJokeService;
    private final JokeApiService jokeApiService;
    private final AppSpotJokeService appSpotJokeService;
    private  final Main main;

    public static void main(String[] args) {
        SpringApplication.run(SimpleTelegramBotApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        main.registerBot();
    }
}
