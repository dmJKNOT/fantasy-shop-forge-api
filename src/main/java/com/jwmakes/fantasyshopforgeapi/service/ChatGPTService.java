package com.jwmakes.fantasyshopforgeapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwmakes.fantasyshopforgeapi.model.*;
import com.jwmakes.fantasyshopforgeapi.model.chat.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ChatGPTService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public List<GeneratedItem> getGeneratedItems(GenerateShopRequestDto request) {
        return callChatGPT(generateChatGPTPrompt(request));
    }


    public String generateChatGPTPrompt(GenerateShopRequestDto request) {
        StringBuilder promptBuilder = new StringBuilder("Generate a JSON list of 10 items for a fictional fantasy RPG shop.Cost is in Gold.");

        promptBuilder.append("The shop type is a ").append(ShopType.valueOf(request.getShopType().toUpperCase()).label).append(".");

        if (!request.getRarity().equals("any")) {
            promptBuilder.append("The items rarity is ").append(request.getRarity()).append(".");
        }

        if (!request.getAlignment().equals("any")) {
            promptBuilder.append("The items alignment is ").append(request.getAlignment()).append(".");
        }

        if (!request.getTone().equals("any")) {
            promptBuilder.append("The items tone is ").append(request.getTone()).append(".");
        }

        promptBuilder.append("Respond with JSON. This is an example [{\"Name\": \"\", \"Cost\": 100, \"Rarity\": \"\", \"Effects\": \"\", \"Requirements\": \"\"}]");

        return promptBuilder.toString();
    }

    private List<GeneratedItem> callChatGPT(String prompt) {
        final String API_KEY = "{OPENAPI-KEY-HERE}";
        final String API_URL = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        ChatGPTRequest requestPayload = new ChatGPTRequest();
        requestPayload.addMessage(new ChatGPTMessage(prompt));

        HttpEntity<ChatGPTRequest> requestEntity = new HttpEntity<>(requestPayload, headers);

        ResponseEntity<ChatGPTResponse> responseEntity = restTemplate.postForEntity(API_URL, requestEntity, ChatGPTResponse.class);

        String contentAsString = responseEntity.getBody().getChoices().stream().findFirst().get().getMessage().getContent();
        ObjectMapper mapper = new ObjectMapper();

        try {
            List toReturn = Arrays.asList(mapper.readValue(contentAsString, GeneratedItem[].class));
            return toReturn;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
