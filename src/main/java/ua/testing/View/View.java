/*
 * @(#)View.java     1.00 2020/02/11
 *
 * This software is free for use.
 */


package ua.testing.View;


import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class for output information (view in MVC model).
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class View implements SignConstants {
    private static final String PROPERTIES_FILE_NAME = "properties";
    private Locale[] locales = {Locale.ENGLISH, new Locale("ua", "UA")};

    static {
        // A default locale at the current developer computer is the Locale.ENGLISH (en_US)
        // In other case you can switch it with next command:

        // Switcher to English locale
        //Locale.setDefault(locales[0]);

        // Switcher to Ukrainian locale
        // Locale.setDefault(locales[1]);
    }

    private ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);


    public String getLocaleProperty(String propertyName) {
        return resourceBundle.getString(propertyName);
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static String concatenatingStrings(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

}
