package com.jwmakes.fantasyshopforgeapi.model.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatGPTRequest {

    private final String model = "gpt-3.5-turbo";
    private List<ChatGPTMessage> messages = new ArrayList<>();

    public void addMessage(ChatGPTMessage message) {
        this.messages.add(message);
    }

    public String getModel() {
        return model;
    }

    public List<ChatGPTMessage> getMessages() {
        return messages;
    }
}
