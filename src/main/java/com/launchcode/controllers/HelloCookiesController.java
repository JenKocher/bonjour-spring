package com.launchcode.controllers;

import com.launchcode.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the bonus studio goal creating a client side counter using a Cookies
 * <p>
 * All routes will be prefixed with `/cookies`, since we have defined a @RequestMapping at the top of our class
 * <p>
 * Navigate to `localhost:8080/cookies` to view
 */
@Controller
@RequestMapping("/cookies")
public class HelloCookiesController {

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

    /**
     * I won't claim this is the best implementation of how to handle Cookies, but should give you an idea about
     * interacting with them.
     *
     * @param name
     * @param language
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String helloPost(@RequestParam String name,
                            @RequestParam String language,
                            HttpServletResponse response,
                            HttpServletRequest request) {

        String greeting = Greeting.createMessage(language);
        Cookie[] cookies = request.getCookies();
        Integer count = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    count = Integer.valueOf(cookie.getValue()) + 1;
                    Cookie newCookie = new Cookie(name, Integer.toString(count));
                    response.addCookie(newCookie);
                } else {
                    count = 1;
                    Cookie newCookie = new Cookie(name, "1");
                    response.addCookie(newCookie);
                }
            }
        } else {
            count = 1;
            Cookie newCookie = new Cookie(name, "1");
            response.addCookie(newCookie);
        }

        return greeting + name + " " + count;
    }

}




