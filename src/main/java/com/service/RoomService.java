/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Room;
import com.entity.RoomUser;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface RoomService {
    public List<Room> getAllRooms();
    
    public List<Room> getAllRoomByPackage(int id);
    
    public void saveRoom(Room room);
    
    public void deleteRoom(Room room);
    
    public void changeRoomStatus(int room);
    
    public Room getRoomDetaile(int room);
    
    public void addUserToRoom(RoomUser roomUser);
    
    public void removeUserFromRoom(RoomUser roomUser);
    
    public List<RoomUser> getUsersOfRoom(int room);

}
