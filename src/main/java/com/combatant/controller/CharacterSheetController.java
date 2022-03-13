package com.combatant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CharacterSheet/")
public class CharacterSheetController {


    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage() {
        return "CharacterSheet";
    }
}