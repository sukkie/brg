package com.example.demo.message;

import java.util.ArrayList;
import java.util.List;

public class LinePushFormat {

    private String to;

    private List<StringMessage> messages = new ArrayList<StringMessage>();

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<StringMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<StringMessage> messages) {
        this.messages = messages;
    }

    public void addMessage(StringMessage message) {
        messages.add(message);
    }
}
