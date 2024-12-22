package com.deepanshu.chatApp.Requests;

import java.time.LocalDateTime;

public class MessageRequest {

    private String content;
    private String sender;
    private String roomId;

    public MessageRequest() {
    }

    public MessageRequest(String roomId, String sender, String content) {
        this.roomId = roomId;
        this.sender = sender;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
