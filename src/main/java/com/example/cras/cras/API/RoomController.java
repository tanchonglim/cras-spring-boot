package com.example.cras.cras.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.cras.cras.Models.Room;
import com.example.cras.cras.Services.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    
  @Autowired
  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  public List<Room> getAllRooms() {
    return roomService.getAllRooms();
  }

  @DeleteMapping(path = "{id}")
  public void deleteRoom(@PathVariable("id") long id) {
    boolean isSuccess = roomService.deleteRoom(id);
    if (!isSuccess)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found");
  }
}
