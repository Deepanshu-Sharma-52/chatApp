package com.deepanshu.chatApp.Repository;

import com.deepanshu.chatApp.Entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends MongoRepository<Room,String> {
    Room findByRoomId(String roomId);
}
