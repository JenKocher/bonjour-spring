package com.launchcode.controllers;

import com.launchcode.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * This is the bonus studio goal creating a server side counter using a HashMap
 * <p>
 * All routes will be prefixed with `/counter`, since we have defined a @RequestMapping at the top of our class
 *
 * Navigate to `localhost:8080/counter` to view
 *
 */
@Controller
@RequestMapping("/counter")
public class HelloCounterController {

    static HashMap<String, Integer> count = new HashMap<>();

    @ResponseBody
    @RequestMapping
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>\n" +
                "  <option value=\"mandarin\">Mandarin</option>\n" +
                "  <option value=\"swahili\">Swahili</option>\n" +
                "  <option value=\"persian\">Persian</option>\n" +
                "  <option value=\"hindi\">Hindi</option>\n" +
                "  <option value=\"arabic\">Arabic</option>\n" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {

        if (count.containsKey(name)) {
            count.replace(name, count.get(name) + 1);
        } else {
            count.put(name, 1);
        }

        String greeting = Greeting.createMessage(language);

        return greeting + " " + name + " " + count.get(name) + " times.";
    }


}




