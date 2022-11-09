package com.ravilyahya.simpletelegrambot.service.impl;

import com.ravilyahya.simpletelegrambot.model.AppSpotJoke;
import com.ravilyahya.simpletelegrambot.model.ChuckNorrisJoke;
import com.ravilyahya.simpletelegrambot.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppSpotJokeService {
    private final ParsingService parsingService;
    private static final String url="https://official-joke-api.appspot.com/random_joke";

    public String getRandomJoke(){
        AppSpotJoke joke =(AppSpotJoke) parsingService.parseAppSpotJoke(url);
        String jokeText = joke.getSetup() + "\n" + joke.getPunchline();
        return jokeText;
    }
}
