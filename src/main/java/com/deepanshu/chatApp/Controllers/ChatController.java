package com.deepanshu.chatApp.Controllers;


import com.deepanshu.chatApp.Entity.Message;
import com.deepanshu.chatApp.Entity.Room;
import com.deepanshu.chatApp.Repository.RoomRepo;
import com.deepanshu.chatApp.Requests.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("${frontend.url}")
public class ChatController {

    @Autowired
    RoomRepo roomRepo;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest request){
        Room room=roomRepo.findByRoomId(request.getRoomId());
        Message message=new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTime(LocalDateTime.now());

        if(room!=null){
            room.getMessages().add(message);
            roomRepo.save(room);
        }else{
            throw new RuntimeException("Room not found");
        }
        return message;
    }
}
