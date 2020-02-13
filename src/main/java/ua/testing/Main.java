/*
 * @(#)Main.java     1.00 2020/02/11
 *
 * This software is free for use.
 */


package ua.testing;

import ua.testing.Controller.Controller;
import ua.testing.Model.Model;
import ua.testing.View.View;


/**
 * Class description goes here.
 *
 * @version 1.00 11 Feb 2020
 * @author Firstname Lastname
 */
public class Main {

    public static void main(String[] args) {

        new Controller(new Model(), new View()).start();

    }

}
