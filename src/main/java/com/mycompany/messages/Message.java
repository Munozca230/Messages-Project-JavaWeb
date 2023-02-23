package com.mycompany.messages;

public class Message {
    private int id;
    private String message;
    private String nickname;
    private String date;

    public Message() {
    }

    public Message(int id) {
        this.id = id;
    }

    public Message(String message, String nickname) {
        this.message = message;
        this.nickname = nickname;
    }

    public Message(int id, String message, String nickname) {
        this.id = id;
        this.message = message;
        this.nickname = nickname;
    }

    public Message(int id, String message, String nickname, String date) {
        this.id = id;
        this.message = message;
        this.nickname = nickname;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", message=" + message + ", nickname=" + nickname + ", date=" + date + '}';
    }
    
    
}
