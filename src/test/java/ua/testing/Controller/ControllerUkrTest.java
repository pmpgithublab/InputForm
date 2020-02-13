/*
 * @(#)ControllerUkrTest.java     1.00 2020/02/11
 *
 * This software is free for use.
 */
package ua.testing.Controller;


import org.junit.Ignore;
import org.junit.Test;
import ua.testing.Model.Entities.Groups;
import ua.testing.Model.Model;
import ua.testing.View.View;

import java.util.HashSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Class for testing ukrainian locale.
 *
 * @version 1.00 11 Feb 2020
 * @author Firstname Lastname
 */
@Ignore
public class ControllerUkrTest {
    private View view = new View();
    private Model model = new Model();
   // private Controller controller = new Controller(model, view);
    private ReadNote readNote = new ReadNote(model, view);

    @Test
    public void getInput_correctUkrNames(){
        assertTrue("Іван".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertTrue("Брженжищикевич".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrNames(){
        assertFalse("".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));

        assertFalse( "іван".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "марко вовчок".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "Марко вовчок".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "іпвпвапвапвапвва".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));

        assertFalse( "І".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "Ііваіваівавпатмссивпрв".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "МаділоЛдлвіа".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));

        assertFalse( ";;;;,.,.,;!!!!??????".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( ",".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "Мдлвао7іва".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "Адлв87.віа".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
        assertFalse( "Ві.уцк;66".matches(view.getLocaleProperty("REGEX_FIRST_NAME_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrNicknames(){
        assertTrue("dfgbcdef".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertTrue("AkjY097_-".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertTrue("lk-kjl98UU".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertTrue("439-857983".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertTrue("-klsjf_987-".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertTrue("Abcdefghijklmnopqrst".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrNicknames(){
        assertFalse( "".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertFalse( "dsfsaa".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertFalse( "987-98_".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertFalse( "AJ-7HHy".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));

        assertFalse( "asdlkjl340580928-435_askjd".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertFalse( "asdlkj laskjd".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
        assertFalse( "sdkfjkshdfksjdfhsjkskldjfhldsk".matches(view.getLocaleProperty("REGEX_NICKNAME_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrUserGroups(){
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
    public void getInput_incorrectUkrUserGroups(){
        assertFalse("Pal".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("families".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("friends".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("OTHERS".matches(Groups.FAMILY.getRegexNames()));
        assertFalse("anther".matches(Groups.FAMILY.getRegexNames()));
    }

    @Test
    public void getInput_correctUkrHomePhoneNumbers(){
        assertTrue("123-45-67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrHomePhoneNumbers(){
        assertFalse("12-45-67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("1234-45-67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("123-435-67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("123 35-67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("123_35_67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("123-35-647".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("(123)45-67".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
        assertFalse("".matches(view.getLocaleProperty("REGEX_HOME_PHONE_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrCellPhoneNumbers(){
        assertTrue("123-45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrCellPhoneNumbers(){
        assertFalse("12-45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("1234-45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("123-435-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("123 35-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("123_35_67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("123-35-647".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("(123)45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
        assertFalse("".matches(view.getLocaleProperty("REGEX_CELL_PHONE_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrCellPhone2Numbers(){
        assertTrue("123-45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertTrue("".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrCellPhone2Numbers(){
        assertFalse("12-45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertFalse("1234-45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertFalse("123-435-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertFalse("123 35-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertFalse("123_35_67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertFalse("123-35-647".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
        assertFalse("(123)45-67".matches(view.getLocaleProperty("REGEX_CELL_PHONE2_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrEmail(){
        assertTrue("wer@sdf.com".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertTrue("sdf98_sdf@gmail.com".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
    }


    @Test
    public void getInput_incorrectUkrEmail(){
        assertFalse("213@123".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("345@46@345".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("dfs@fgs@fg".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("23kh@kdjf32@34kj".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("2hkjk@4l33l.l".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("2hkjk@4l33l.".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("2hkjk@4l33l.jlkjn".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
        assertFalse("".matches(view.getLocaleProperty("REGEX_EMAIL_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrSkype(){
        assertTrue("t453kj3h45k3jh".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
        assertTrue("live435lkjlkj435lkj".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
        assertTrue("lDkjHHG.KJHhkv".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrSkype(){
        assertFalse("8lkljlaskjd".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
        assertFalse("asda".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
        assertFalse("".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
        assertFalse("lsdkflіваіваkjlskdjfldskjflkвіауцукkjsldkf".matches(view.getLocaleProperty("REGEX_SKYPE_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrIndex(){
        assertTrue("23467".matches(view.getLocaleProperty("REGEX_INDEX_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrIndex(){
        assertFalse("3241435747".matches(view.getLocaleProperty("REGEX_INDEX_CHECK_OUT")));
        assertFalse("".matches(view.getLocaleProperty("REGEX_INDEX_CHECK_OUT")));
        assertFalse("dfs".matches(view.getLocaleProperty("REGEX_INDEX_CHECK_OUT")));
        assertFalse("sdfsddfgввіаfsdew45345ergds".matches(view.getLocaleProperty("REGEX_INDEX_CHECK_OUT")));
        assertFalse("34er3".matches(view.getLocaleProperty("REGEX_INDEX_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrCity(){
        assertTrue("Київ".matches(view.getLocaleProperty("REGEX_CITY_CHECK_OUT")));
        assertTrue("Белгород-Дністровський".matches(view.getLocaleProperty("REGEX_CITY_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrCity(){
        assertFalse("".matches(view.getLocaleProperty("REGEX_CITY_CHECK_OUT")));
        assertFalse("київ".matches(view.getLocaleProperty("REGEX_CITY_CHECK_OUT")));
        assertFalse("ставрополь".matches(view.getLocaleProperty("REGEX_CITY_CHECK_OUT")));
        assertFalse("івано-франківськ".matches(view.getLocaleProperty("REGEX_CITY_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrStreet(){
        assertTrue("Політехнічна".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
        assertTrue("Жовто-Блакитна".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
        assertTrue("30 кроків".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrStreet(){
        assertFalse("".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
        assertFalse("іваіва".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
        assertFalse("іва234ваа".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
        assertFalse("іваіукц-іваіваів".matches(view.getLocaleProperty("REGEX_STREET_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrBuilding(){
        assertTrue("233".matches(view.getLocaleProperty("REGEX_BUILDING_CHECK_OUT")));
        assertTrue("1".matches(view.getLocaleProperty("REGEX_BUILDING_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrBuilding(){
        assertFalse("".matches(view.getLocaleProperty("REGEX_BUILDING_CHECK_OUT")));
        assertFalse("345345435".matches(view.getLocaleProperty("REGEX_BUILDING_CHECK_OUT")));
        assertFalse("sd34".matches(view.getLocaleProperty("REGEX_BUILDING_CHECK_OUT")));
    }

    @Test
    public void getInput_correctUkrFlat(){
        assertTrue("233".matches(view.getLocaleProperty("REGEX_FLAT_CHECK_OUT")));
        assertTrue("1".matches(view.getLocaleProperty("REGEX_FLAT_CHECK_OUT")));
    }

    @Test
    public void getInput_incorrectUkrFlat(){
        assertFalse("".matches(view.getLocaleProperty("REGEX_FLAT_CHECK_OUT")));
        assertFalse("345345435".matches(view.getLocaleProperty("REGEX_FLAT_CHECK_OUT")));
        assertFalse("sd34".matches(view.getLocaleProperty("REGEX_FLAT_CHECK_OUT")));
    }
}
