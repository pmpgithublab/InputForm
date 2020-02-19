/*
 * @(#)View.java     1.00 2020/02/11
 *
 * This software can be used for free.
 */


package ua.testing.view;


import java.util.Locale;

/**
 * Class for output information (view in MVC model).
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class View implements Constants {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;
    public String ASK_FIRST_NAME;
    public String ASK_MIDDLE_NAME;
    public String ASK_LAST_NAME;
    public String ASK_NICKNAME;
    public String ASK_COMMENT;
    public String ASK_USER_GROUPS;
    public String ASK_HOME_PHONE_NUMBER;
    public String ASK_CELL_PHONE_NUMBER;
    public String ASK_CELL_PHONE2_NUMBER;
    public String ASK_EMAIL;
    public String ASK_SKYPE;
    public String ASK_INDEX;
    public String ASK_CITY;
    public String ASK_STREET;
    public String ASK_BUILDING;
    public String ASK_FLAT;

    public String WRONG_INPUT;
    public String SUCCESSFULLY_ADDED;

    public String REGEX_FIRST_NAME_CHECK_OUT;
    public String REGEX_MIDDLE_NAME_CHECK_OUT;
    public String REGEX_LAST_NAME_CHECK_OUT;
    public String REGEX_NICKNAME_CHECK_OUT;
    public String REGEX_COMMENT_CHECK_OUT;
    public String REGEX_USER_GROUPS;
    public String REGEX_HOME_PHONE_CHECK_OUT;
    public String REGEX_CELL_PHONE_CHECK_OUT;
    public String REGEX_CELL_PHONE2_CHECK_OUT;
    public String REGEX_EMAIL_CHECK_OUT;
    public String REGEX_SKYPE_CHECK_OUT;
    public String REGEX_INDEX_CHECK_OUT;
    public String REGEX_CITY_CHECK_OUT;
    public String REGEX_STREET_CHECK_OUT;
    public String REGEX_BUILDING_CHECK_OUT;
    public String REGEX_FLAT_CHECK_OUT;


    public View() {
        initLocaleStrings();
    }

    public void changeLocale(Locale locale) {
        resourceManager.changeLocale(locale);
        initLocaleStrings();
    }

    private void initLocaleStrings() {
        ASK_FIRST_NAME = resourceManager.getLocaleProperty("ask.first.name");
        ASK_MIDDLE_NAME = resourceManager.getLocaleProperty("ask.middle.name");
        ASK_LAST_NAME = resourceManager.getLocaleProperty("ask.last.name");
        ASK_NICKNAME = resourceManager.getLocaleProperty("ask.nickname");
        ASK_COMMENT = resourceManager.getLocaleProperty("ask.comment");
        ASK_USER_GROUPS = resourceManager.getLocaleProperty("ask.user.groups");
        ASK_HOME_PHONE_NUMBER = resourceManager.getLocaleProperty("ask.home.phone.number");
        ASK_CELL_PHONE_NUMBER = resourceManager.getLocaleProperty("ask.cell.phone.number");
        ASK_CELL_PHONE2_NUMBER = resourceManager.getLocaleProperty("ask.cell.phone2.number");
        ASK_EMAIL = resourceManager.getLocaleProperty("ask.email");
        ASK_SKYPE = resourceManager.getLocaleProperty("ask.skype");
        ASK_INDEX = resourceManager.getLocaleProperty("ask.index");
        ASK_CITY = resourceManager.getLocaleProperty("ask.city");
        ASK_STREET = resourceManager.getLocaleProperty("ask.street");
        ASK_BUILDING = resourceManager.getLocaleProperty("ask.building");
        ASK_FLAT = resourceManager.getLocaleProperty("ask.flat");

        WRONG_INPUT = resourceManager.getLocaleProperty("wrong.input");
        SUCCESSFULLY_ADDED = resourceManager.getLocaleProperty("successfully.added");

        REGEX_FIRST_NAME_CHECK_OUT = resourceManager.getLocaleProperty("regex.first.name.check.out");
        REGEX_MIDDLE_NAME_CHECK_OUT = resourceManager.getLocaleProperty("regex.middle.name.check.out");
        REGEX_LAST_NAME_CHECK_OUT = resourceManager.getLocaleProperty("regex.last.name.check.out");
        REGEX_NICKNAME_CHECK_OUT = resourceManager.getLocaleProperty("regex.nickname.check.out");
        REGEX_COMMENT_CHECK_OUT = resourceManager.getLocaleProperty("regex.comment.check.out");
        REGEX_USER_GROUPS = resourceManager.getLocaleProperty("regex.user.groups");
        REGEX_HOME_PHONE_CHECK_OUT = resourceManager.getLocaleProperty("regex.home.phone.check.out");
        REGEX_CELL_PHONE_CHECK_OUT = resourceManager.getLocaleProperty("regex.cell.phone.check.out");
        REGEX_CELL_PHONE2_CHECK_OUT = resourceManager.getLocaleProperty("regex.cell.phone2.check.out");
        REGEX_EMAIL_CHECK_OUT = resourceManager.getLocaleProperty("regex.email.check.out");
        REGEX_SKYPE_CHECK_OUT = resourceManager.getLocaleProperty("regex.skype.check.out");
        REGEX_INDEX_CHECK_OUT = resourceManager.getLocaleProperty("regex.index.check.out");
        REGEX_CITY_CHECK_OUT = resourceManager.getLocaleProperty("regex.city.check.out");
        REGEX_STREET_CHECK_OUT = resourceManager.getLocaleProperty("regex.street.check.out");
        REGEX_BUILDING_CHECK_OUT = resourceManager.getLocaleProperty("regex.building.check.out");
        REGEX_FLAT_CHECK_OUT = resourceManager.getLocaleProperty("regex.flat.check.out");
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
