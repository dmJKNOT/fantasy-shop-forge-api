package com.jwmakes.fantasyshopforgeapi.controller;

import com.jwmakes.fantasyshopforgeapi.model.GenerateShopRequestDto;
import com.jwmakes.fantasyshopforgeapi.model.chat.GeneratedItem;
import com.jwmakes.fantasyshopforgeapi.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generate")
@CrossOrigin(origins = "http://localhost:3000")
public class GenerateController {

    @Autowired
    ChatGPTService chatGPTService;

    @PostMapping(value="/shop", produces = "application/json")
    public List<GeneratedItem> generateShopInventory(@RequestBody GenerateShopRequestDto request) {
        return chatGPTService.getGeneratedItems(request);
    }

    @PostMapping(value="/prompt", produces = "application/json")
    public String generatePrompt(@RequestBody GenerateShopRequestDto request) {
        return "{\"data\":\"" + chatGPTService.generateChatGPTPrompt(request) + "\"}";
    }
}
