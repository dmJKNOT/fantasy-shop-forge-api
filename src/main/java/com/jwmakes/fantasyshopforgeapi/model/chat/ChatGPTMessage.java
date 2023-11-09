package com.jwmakes.fantasyshopforgeapi.model.chat;

public class ChatGPTMessage {
    private String role;
    private String content;


    public ChatGPTMessage() {}

    public ChatGPTMessage(String content) {
        this.role = "user";
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
