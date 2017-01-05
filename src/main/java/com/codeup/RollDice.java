package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by Patrick on 1/4/17.
 */

@Controller
public class RollDice {
    @GetMapping("/roll-dice")
    public String welcome() {
        return "roll-dice";
    }

    @RequestMapping(path = "/roll-dice/{guess}", method = RequestMethod.GET)
    public String guess(@PathVariable int guess, Model model) {
        model.addAttribute("guess", guess);
        Random rand = new Random();
        int random = rand.nextInt(6) + 1;
        model.addAttribute("random", random);
        return "roll-dice";
    }
}
