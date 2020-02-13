/*
 * @(#)Model.java     1.00 2020/02/11
 *
 * This software is free for use.
 */


package ua.testing.Model;


import ua.testing.Model.Entities.Notebook;
import ua.testing.Model.Entities.NotebookNote;

import java.util.*;

/**
 * Class implementing business logic (model in MVC model).
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class Model {
    private List<NotebookNote> noteBook = new Notebook();

    public void addNote(NotebookNote notebookNote) {
        noteBook.add(notebookNote);
    }

}
