/*
 * @(#)ControllerEngTest.java     1.00 2020/02/11
 *
 * This software can be used for free.
 */
package ua.testing.controller;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ua.testing.model.entity.Groups;
import ua.testing.model.Model;
import ua.testing.view.View;

import java.util.HashSet;
import java.util.Locale;

import static org.junit.Assert.*;


/**
 * Class for testing english locale.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
//@Ignore
public class ControllerEngTest {
    private static View view = new View();
    private Model model = new Model();
    private ReadNote readNote = new ReadNote(model, view);


    @BeforeClass
    public static void init() {
        view.changeLocale(Locale.ENGLISH);
    }

    @Test
    public void getInput_correctEngNames() {
        assertTrue("Abcdef".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertTrue("Abcdefghijklmnopqrst".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngNames() {
        assertFalse("".matches(view.REGEX_FIRST_NAME_CHECK_OUT));

        assertFalse("asdlkjlaskjd".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("asdlkj laskjd".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("sdkfjkshdfksjdfhsjkskldjfhldsk".matches(view.REGEX_FIRST_NAME_CHECK_OUT));

        assertFalse("A".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("Asjfkdghdkjfhdkfjhgdklfjghdkljkdfjhl".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("AsjfkShgfjgGhjkd".matches(view.REGEX_FIRST_NAME_CHECK_OUT));

        assertFalse(";;;;,.,.,;!!!!??????".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse(",".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("Alkjdfl8lsdkjf".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("fkjdl;gjlds;skflh".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
        assertFalse("Akdsgj.sagg;lh".matches(view.REGEX_FIRST_NAME_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngNicknames() {
        assertTrue("dfgbcdef".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertTrue("AkjY097_-".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertTrue("lk-kjl98UU".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertTrue("439-857983".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertTrue("-klsjf_987-".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertTrue("Abcdefghijklmnopqrst".matches(view.REGEX_NICKNAME_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngNicknames() {
        assertFalse("".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertFalse("dsfsaa".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertFalse("987-98_".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertFalse("AJ-7HHy".matches(view.REGEX_NICKNAME_CHECK_OUT));

        assertFalse("asdlkjl340580928-435_askjd".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertFalse("asdlkj laskjd".matches(view.REGEX_NICKNAME_CHECK_OUT));
        assertFalse("sdkfjkshdfksjdfhsjkskldjfhldsk".matches(view.REGEX_NICKNAME_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngUserGroups() {
        assertTrue("FAMILY".matches(Groups.FAMILY.getRegexNames()));
        assertTrue("family".matches(Groups.FAMILY.getRegexNames()));
        assertTrue("FRIEND".matches(Groups.FAMILY.getRegexNames()));
        assertTrue("friend".matches(Groups.FAMILY.getRegexNames()));
        assertTrue("OTHER".matches(Groups.FAMILY.getRegexNames()));
        assertTrue("other".matches(Groups.FAMILY.getRegexNames()));
        assertTrue("FAMILY, friend,OTHER".matches(Groups.FAMILY.getRegexNames()));

        HashSet<Groups> hashSet = new HashSet<>();
        hashSet.add(Groups.FAMILY);
        hashSet.add(Groups.OTHER);
        assertTrue(hashSet.equals(readNote.createGroupList("FAMILY , other,OTHER")));
    }

    @Test
    public void getInput_incorrectEngUserGroups() {
        assertFalse("Pal".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("families".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("friends".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("OTHERS".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("anther".matches(Groups.FAMILY.getRegexNames()));
    }

    @Test
    public void getInput_correctEngHomePhoneNumbers() {
        assertTrue("123-45-67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngHomePhoneNumbers() {
        assertFalse("12-45-67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("1234-45-67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("123-435-67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("123 35-67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("123_35_67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("123-35-647".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("(123)45-67".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
        assertFalse("".matches(view.REGEX_HOME_PHONE_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngCellPhoneNumbers() {
        assertTrue("123-45-67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngCellPhoneNumbers() {
        assertFalse("12-45-67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("1234-45-67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("123-435-67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("123 35-67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("123_35_67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("123-35-647".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("(123)45-67".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
        assertFalse("".matches(view.REGEX_CELL_PHONE_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngCellPhone2Numbers() {
        assertTrue("123-45-67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertTrue("".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngCellPhone2Numbers() {
        assertFalse("12-45-67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertFalse("1234-45-67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertFalse("123-435-67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertFalse("123 35-67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertFalse("123_35_67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertFalse("123-35-647".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
        assertFalse("(123)45-67".matches(view.REGEX_CELL_PHONE2_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngEmail() {
        assertTrue("wer@sdf.com".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertTrue("sdf98_sdf@gmail.com".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertTrue("klkjfgj@kljlk.dsf".matches(view.REGEX_EMAIL_CHECK_OUT));
    }


    @Test
    public void getInput_incorrectEngEmail() {
        assertFalse("213@123".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("345@46@345".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("dfs@fgs@fg".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("23kh@kdjf32@34kj".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("2hkjk@4l33l.l".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("2hkjk@4l33l.".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("2hkjk@4l33l.jlkjn".matches(view.REGEX_EMAIL_CHECK_OUT));
        assertFalse("".matches(view.REGEX_EMAIL_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngSkype() {
        assertTrue("t453kj3h45k3jh".matches(view.REGEX_SKYPE_CHECK_OUT));
        assertTrue("live435lkjlkj435lkj".matches(view.REGEX_SKYPE_CHECK_OUT));
        assertTrue("lDkjHHG.KJHhkv".matches(view.REGEX_SKYPE_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngSkype() {
        assertFalse("8lkljlaskjd".matches(view.REGEX_SKYPE_CHECK_OUT));
        assertFalse("asda".matches(view.REGEX_SKYPE_CHECK_OUT));
        assertFalse("".matches(view.REGEX_SKYPE_CHECK_OUT));
        assertFalse("lsdkflksdjflksdjlfkjlskdjfldskjflksdjlfkjsldkf".matches(view.REGEX_SKYPE_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngIndex() {
        assertTrue("23467".matches(view.REGEX_INDEX_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngIndex() {
        assertFalse("3241435747".matches(view.REGEX_INDEX_CHECK_OUT));
        assertFalse("".matches(view.REGEX_INDEX_CHECK_OUT));
        assertFalse("dfs".matches(view.REGEX_INDEX_CHECK_OUT));
        assertFalse("sdfsdfsdew45345ergds".matches(view.REGEX_INDEX_CHECK_OUT));
        assertFalse("34er3".matches(view.REGEX_INDEX_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngCity() {
        assertTrue("Cdsfdsdf".matches(view.REGEX_CITY_CHECK_OUT));
        assertTrue("Cdsfdsdf-sdfs".matches(view.REGEX_CITY_CHECK_OUT));
        assertTrue("Cdsfdsdf-Ddfs".matches(view.REGEX_CITY_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngCity() {
        assertFalse("".matches(view.REGEX_CITY_CHECK_OUT));
        assertFalse("adgdfg".matches(view.REGEX_CITY_CHECK_OUT));
        assertFalse("dfs435dfdsfs345".matches(view.REGEX_CITY_CHECK_OUT));
        assertFalse("sdfsdfsde-w45345ergds".matches(view.REGEX_CITY_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngStreet() {
        assertTrue("Cdsfdsdf".matches(view.REGEX_STREET_CHECK_OUT));
        assertTrue("Cdsfdsdf-sdfs".matches(view.REGEX_STREET_CHECK_OUT));
        assertTrue("Cdsfdsdf-Ddfs".matches(view.REGEX_STREET_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngStreet() {
        assertFalse("".matches(view.REGEX_STREET_CHECK_OUT));
        assertFalse("adgdfg".matches(view.REGEX_STREET_CHECK_OUT));
        assertFalse("dfs435dfdsfs345".matches(view.REGEX_STREET_CHECK_OUT));
        assertFalse("sdfsdfsde-w45345ergds".matches(view.REGEX_STREET_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngBuilding() {
        assertTrue("233".matches(view.REGEX_BUILDING_CHECK_OUT));
        assertTrue("1".matches(view.REGEX_BUILDING_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngBuilding() {
        assertFalse("".matches(view.REGEX_BUILDING_CHECK_OUT));
        assertFalse("345345435".matches(view.REGEX_BUILDING_CHECK_OUT));
        assertFalse("sd34".matches(view.REGEX_BUILDING_CHECK_OUT));
    }

    @Test
    public void getInput_correctEngFlat() {
        assertTrue("233".matches(view.REGEX_FLAT_CHECK_OUT));
        assertTrue("1".matches(view.REGEX_FLAT_CHECK_OUT));
    }

    @Test
    public void getInput_incorrectEngFlat() {
        assertFalse("".matches(view.REGEX_FLAT_CHECK_OUT));
        assertFalse("345345435".matches(view.REGEX_FLAT_CHECK_OUT));
        assertFalse("sd34".matches(view.REGEX_FLAT_CHECK_OUT));
    }
}