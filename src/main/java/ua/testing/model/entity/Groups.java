/*
 * @(#)Groups.java     1.00 2020/02/11
 *
 * This software can be used for free.
 */


package ua.testing.model.entity;

import ua.testing.view.View;


/**
 * User groups enum.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public enum Groups {
    FAMILY,
    FRIEND,
    OTHER;


    public String getList() {
        StringBuilder result = new StringBuilder(View.OPEN_SQUARE_BRACKET_SIGN);
        for (Groups group : Groups.values()) {
            result.append(group.name());
            result.append(View.concatenatingStrings(View.COMMA_SIGN, View.SPACE_SIGN));
        }
        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        result.append(View.CLOSE_SQUARE_BRACKET_SIGN);
        return result.toString();
    }

    public String getRegexNames() {
        StringBuilder result = new StringBuilder();
        result.append(View.OPEN_PARENTHESIS_SIGN);
        for (Groups groups : Groups.values()) {
            result.append(groups.name());
            result.append(View.SEPARATE_SIGN);
            result.append(groups.name().toLowerCase());
            result.append(View.SEPARATE_SIGN);
        }
        result.append(View.COMMA_SIGN);
        result.append(View.SEPARATE_SIGN);
        result.append(View.REGEX_SPACE);
        result.append(View.CLOSE_PARENTHESIS_SIGN);
        result.append(View.ASTERISC_SIGN);
        return result.toString();
    }
}
