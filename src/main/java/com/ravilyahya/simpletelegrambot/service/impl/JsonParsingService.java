package com.ravilyahya.simpletelegrambot.service.impl;

import com.ravilyahya.simpletelegrambot.model.AppSpotJoke;
import com.ravilyahya.simpletelegrambot.model.ChuckNorrisJoke;
import com.ravilyahya.simpletelegrambot.model.DadJoke;
import com.ravilyahya.simpletelegrambot.model.JokeApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ravilyahya.simpletelegrambot.service.ParsingService;

@Service
@RequiredArgsConstructor
public class JsonParsingService implements ParsingService {

    private final RestTemplate restTemplate;

    @Override
    public Object parseNorris(String url) {
        return restTemplate.getForObject(url, ChuckNorrisJoke.class);
    }

    @Override
    public Object parseJokeApi(String url) {
        return restTemplate.getForObject(url, JokeApi.class);
    }

    @Override
    public Object parseDadJoke(String url) {
        return restTemplate.getForObject(url, DadJoke.class);
    }

    @Override
    public Object parseAppSpotJoke(String url) {
        return restTemplate.getForObject(url, AppSpotJoke.class);
    }


}
