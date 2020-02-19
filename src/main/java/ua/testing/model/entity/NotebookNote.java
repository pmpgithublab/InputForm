/*
 * @(#)Note.java     1.00 2020/02/11
 *
 * This software can be used for free.
 */

package ua.testing.model.entity;

import ua.testing.view.*;

import java.util.Date;
import java.util.HashSet;

/**
 * Class for keeping data about a person for a notebook.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class NotebookNote {
    private String firstName;
    private String middleName;
    private String lastName;
    private String shortName;
    private String nickName;
    private String comment;
    private HashSet<Groups> personGroups;
    private String homePhoneNumber;
    private String sellPhoneNumber;
    private String sellPhoneNumber2;
    private String email;
    private String skype;
    private Address address;
    private String fullAddress;
    private Date creationDate;
    private Date lastChangeDate;

    {
        creationDate = new Date(System.currentTimeMillis());
        lastChangeDate = new Date(System.currentTimeMillis());
    }


    public NotebookNote(String firstName, String middleName, String lastName, String nickName, String comment,
                        HashSet<Groups> personGroups,
                        String homePhoneNumber, String sellPhoneNumber, String sellPhoneNumber2,
                        String email, String skype, Address address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.shortName = View.concatenatingStrings(lastName, View.SPACE_SIGN, firstName.substring(0, 1), View.POINT_SIGN);
        this.nickName = nickName;
        this.comment = comment;
        this.personGroups = personGroups;
        this.homePhoneNumber = homePhoneNumber;
        this.sellPhoneNumber = sellPhoneNumber;
        this.sellPhoneNumber2 = sellPhoneNumber2;
        this.email = email;
        this.skype = skype;
        this.address = address;
        this.fullAddress = address.getFullAddress();
    }
}
