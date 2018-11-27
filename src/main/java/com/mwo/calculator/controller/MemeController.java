package com.mwo.calculator.controller;

import com.mwo.calculator.model.MemeResponse;
import com.mwo.calculator.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mateusz
 */
@Controller
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    MemeService memeService;

    @GetMapping(headers = "Accept=application/json")
    public @ResponseBody
    MemeResponse get() {
        return memeService.getRandomMemeUrl();
    }
}
