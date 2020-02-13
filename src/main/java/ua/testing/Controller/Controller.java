/*
 * @(#)Controller.java     1.00 2020/02/11
 *
 * This software is free for use.
 */


package ua.testing.Controller;


import ua.testing.Model.Model;
import ua.testing.View.View;


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
        new ReadNote(model, view).readNewNote();
    }

}

