package com.ironyard;

import javax.persistence.*;

/**
 * Created by MattBrown on 11/9/15.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    Integer id;
    String text;
    String username;
    String password;


    public Message(){

    }

    public Message(Integer id, String text, String username, String password) {
        this.id = id;
        this.text = text;
        this.username = username;
        this.password = password;
    }
}
