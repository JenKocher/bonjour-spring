package com.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * These are the examples covered in the pre-class prep work (modifications noted below)
 * <p>
 * All routes will be prefixed with `/prep`, since we have defined a @RequestMapping at the top of our class
 */
@Controller
@RequestMapping("/prep")
public class HelloPrepController {

    /**
     * Uses @RequestParam to extract our "name" request parameter
     * <p>
     * Example: `localhost:8080/prep?name=LaunchCode`
     *
     * @param name to create a greeting for
     * @return A greeting string
     */
    @ResponseBody
    @RequestMapping(value = "")
    public String index(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    /**
     * Serves a form to submit a greeting request
     * <p>
     * Example: `localhost:8080/prep/hello`
     *
     * @return an HTML input form
     */
    @RequestMapping("hello")
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    /**
     * Acts as the request handler from the above GET endpoint that serves up an HTML form
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name) {
        return "Hello " + name;
    }

    /**
     * An example of using @PathVariable to extract a variable
     *
     * @param name to greet
     * @return a personalized greeting
     */
    @ResponseBody
    @RequestMapping(value = "/hello/{name}")
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    /**
     * Example of a redirect
     *
     * @return rediret to the root
     */
    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/prep";
    }

}
