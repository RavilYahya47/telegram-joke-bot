package com.ravilyahya.simpletelegrambot.bot;

import com.ravilyahya.simpletelegrambot.service.impl.AppSpotJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.ChuckNorrisJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.DadJokeService;
import com.ravilyahya.simpletelegrambot.service.impl.JokeApiService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final ChuckNorrisJokeService chuckNorrisJokeService;
    private final AppSpotJokeService appSpotJokeService;
    private  final DadJokeService dadJokeService;
    private final JokeApiService jokeApiService;

    @Override
    public String getBotUsername() {
        return "Your bot name here";
    }

    @Override
    public String getBotToken() {
        return "Your bot api";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.getMessage().getText().equals("/chucknorrisjokes")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            System.out.println(update.getMessage().getText());
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId());
            String text = update.getMessage().getFrom().getFirstName()+", here is a joke for you.\n" + chuckNorrisJokeService.getRandomJoke();
            response.setText(text);
            try{
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else {
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            String text = "";
            switch (randomNumber) {
                case 0 -> text = appSpotJokeService.getRandomJoke();
                case 1 -> text = dadJokeService.getRandomJoke();
                case 2 -> text = jokeApiService.getRandomJoke();
            }
            System.out.println(update.getMessage().getFrom().getFirstName());
            System.out.println(update.getMessage().getText());

            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId());
            String responseText = update.getMessage().getFrom().getFirstName()+", here is a joke for you.\n\n" +text;
            response.setText(responseText);
            try{
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }




    }
}
