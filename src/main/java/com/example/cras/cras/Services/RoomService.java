package com.example.cras.cras.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cras.cras.Models.Room;
import com.example.cras.cras.Models.RoomRepository;

@Service
public class RoomService {
    
  @Autowired
  private final RoomRepository roomRepository;

  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public List<Room> getAllRooms() {
    Iterable<Room> source = roomRepository.findAll();
    List<Room> target = new ArrayList<Room>();
    source.forEach(target::add);
    return target;
  }

  public boolean deleteRoom(long id) {
    Optional<Room> optionalCurrentRoom = roomRepository.findById(id);
    if (!optionalCurrentRoom.isPresent())
      return false;

      roomRepository.delete(optionalCurrentRoom.get());
    return true;
  }
}
