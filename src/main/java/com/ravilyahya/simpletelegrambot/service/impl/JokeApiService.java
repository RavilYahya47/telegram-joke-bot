package com.ravilyahya.simpletelegrambot.service.impl;

import com.ravilyahya.simpletelegrambot.model.ChuckNorrisJoke;
import com.ravilyahya.simpletelegrambot.model.JokeApi;
import com.ravilyahya.simpletelegrambot.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokeApiService {
    private final ParsingService parsingService;
    private static final String url="https://v2.jokeapi.dev/joke/Any?type=single";

    public String getRandomJoke(){
        JokeApi joke =(JokeApi) parsingService.parseJokeApi(url);
        return joke.getJoke();
    }
}
