package com.ravilyahya.simpletelegrambot.main;

import com.ravilyahya.simpletelegrambot.bot.TelegramBot;
import com.ravilyahya.simpletelegrambot.service.impl.AppSpotJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.ChuckNorrisJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.DadJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.JokeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class Main {
    private final ChuckNorrisJokeService chuckNorrisJokeService;
    private final AppSpotJokeService appSpotJokeService;
    private  final DadJokeService dadJokeService;
    private final JokeApiService jokeApiService;
    public void registerBot(){
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot(chuckNorrisJokeService,appSpotJokeService,dadJokeService,jokeApiService));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
