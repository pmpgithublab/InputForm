/*
 * @(#)Main.java     1.00 2020/02/11
 *
 * This software can be used for free.
 */


package ua.testing;

import ua.testing.controller.Controller;
import ua.testing.model.Model;
import ua.testing.view.View;


/**
 * Main class for start this application.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class Main {

    public static void main(String[] args) {

        new Controller(new Model(), new View()).start();

    }

}
