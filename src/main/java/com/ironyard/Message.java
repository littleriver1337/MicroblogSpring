package com.ironyard;

import javax.persistence.*;

/**
 * Created by MattBrown on 11/9/15.
 */
@Entity
public class Message {
    String text;
    int id;

    public Message(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
