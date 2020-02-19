/*
 * @(#)Controller.java     1.00 2020/02/11
 *
 * This software is free for use.
 */


package ua.testing.controller;


import ua.testing.model.Model;
import ua.testing.view.View;

import java.util.Locale;


/**
 * Class for input information (controller in MVC model).
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class Controller {
    Model model;
    View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.changeLocale(new Locale("uk", "UA"));
        new ReadNote(model, view).readNewNoteFromScanner();
    }

}

