/*
 * @(#)ReadNote.java     1.00 2020/02/11
 *
 * This software is free for use.
 */
package ua.testing.Controller;

import ua.testing.Model.Entities.Address;
import ua.testing.Model.Entities.Groups;
import ua.testing.Model.Entities.NotebookNote;
import ua.testing.Model.Model;
import ua.testing.View.View;

import java.util.HashSet;
import java.util.Scanner;


/**
 * Class for input Note data.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class ReadNote {
    Model model;
    View view;
    Scanner scanner = new Scanner(System.in);

    public ReadNote(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void readNewNote() {
        model.addNote(new NotebookNote(getScannerInputWithProperties("ASK_FIRST_NAME", "REGEX_FIRST_NAME_CHECK_OUT"),
                getScannerInputWithProperties("ASK_MIDDLE_NAME", "REGEX_MIDDLE_NAME_CHECK_OUT"),
                getScannerInputWithProperties("ASK_LAST_NAME", "REGEX_LAST_NAME_CHECK_OUT"),
                getScannerInputWithProperties("ASK_NICKNAME", "REGEX_NICKNAME_CHECK_OUT"),
                getScannerInputWithProperties("ASK_COMMENT", "REGEX_COMMENT_CHECK_OUT"),
                createGroupList(getScannerInput(View.concatenatingStrings(view.getLocaleProperty("ASK_USER_GROUPS"), Groups.FAMILY.getList()), Groups.FAMILY.getRegexNames())),
                getScannerInputWithProperties("ASK_HOME_PHONE_NUMBER", "REGEX_HOME_PHONE_CHECK_OUT"),
                getScannerInputWithProperties("ASK_CELL_PHONE_NUMBER", "REGEX_CELL_PHONE_CHECK_OUT"),
                getScannerInputWithProperties("ASK_CELL_PHONE2_NUMBER", "REGEX_CELL_PHONE2_CHECK_OUT"),
                getScannerInputWithProperties("ASK_EMAIL", "REGEX_EMAIL_CHECK_OUT"),
                getScannerInputWithProperties("ASK_SKYPE", "REGEX_SKYPE_CHECK_OUT"),
                new Address(getScannerInputWithProperties("ASK_INDEX", "REGEX_INDEX_CHECK_OUT"),
                        getScannerInputWithProperties("ASK_CITY", "REGEX_CITY_CHECK_OUT"),
                        getScannerInputWithProperties("ASK_STREET", "REGEX_STREET_CHECK_OUT"),
                        getScannerInputWithProperties("ASK_BUILDING", "REGEX_BUILDING_CHECK_OUT"),
                        getScannerInputWithProperties("ASK_FLAT", "REGEX_FLAT_CHECK_OUT"))
        ));
        View.showMessage("SUCCESSFULLY_ADDED");
    }

    private String getScannerInputWithProperties(String propertyNameMessage, String propertyNameRegex) {
        String wrongMessage = view.getLocaleProperty("WRONG_INPUT");
        View.showMessage(view.getLocaleProperty(propertyNameMessage));
        String regex = view.getLocaleProperty(propertyNameRegex);
        while (!scanner.hasNext(regex)) {
            View.showMessage(wrongMessage);
            scanner.next();
        }
        return scanner.next();
    }

    private String getScannerInput(String messageForUser, String regexForReading) {
        String wrongMessage = view.getLocaleProperty("WRONG_INPUT");
        View.showMessage(messageForUser);
        while (!scanner.hasNext(regexForReading)) {
            View.showMessage(wrongMessage);
            scanner.next();
        }
        return scanner.next();
    }

    public HashSet<Groups> createGroupList(String user_groups) {
        String regexForGroups = view.getLocaleProperty("REGEX_USER_GROUPS");
        HashSet<Groups> result = new HashSet<>();
        for (Groups group : Groups.values()) {
            if (user_groups.matches(View.concatenatingStrings(regexForGroups, group.toString(), regexForGroups))) {
                result.add(group);
            }
            if (user_groups.matches(View.concatenatingStrings(regexForGroups, group.toString().toLowerCase(), regexForGroups))) {
                result.add(group);
            }
        }
        return result;
    }

}
