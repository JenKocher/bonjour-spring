package com.launchcode.models;

public class Greeting {

    /**
     * Returns a localized greeting
     *
     * @param language to find greeting for
     * @return greeting message
     */
    public static String createMessage(String language) {
        String greeting = "";

        if (language.equals("mandarin")) {
            greeting = "Ni hau";
        } else if (language.equals("swahili")) {
            greeting = "Jambo";
        } else if (language.equals("persian")) {
            greeting = "Salaam";
        } else if (language.equals("hindi")) {
            greeting = "Namaste";
        } else if (language.equals("arabic")) {
            greeting = "Marhaba";
        } else {
            greeting = "Hello";
        }

        return greeting;
    }
}
