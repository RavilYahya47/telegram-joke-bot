package com.ravilyahya.simpletelegrambot.service.impl;

import com.ravilyahya.simpletelegrambot.model.DadJoke;
import com.ravilyahya.simpletelegrambot.model.JokeApi;
import com.ravilyahya.simpletelegrambot.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DadJokeService {
    private final ParsingService parsingService;
    private static final String url="https://icanhazdadjoke.com/";

    public String getRandomJoke(){
        DadJoke joke =(DadJoke) parsingService.parseDadJoke(url);
        return joke.getJoke();
    }
}
