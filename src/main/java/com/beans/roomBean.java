/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.PackageUser;
import com.entity.Room;
import com.entity.User;
import com.service.PackageService;
import com.service.PackageServiceImp;
import com.service.RoomService;
import com.service.RoomServiceImp;
import com.service.UserService;
import com.service.UserServiceImp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class roomBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private String pack,gropName;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getGropName() {
        return gropName;
    }

    public void setGropName(String gropName) {
        this.gropName = gropName;
    }
    
    
    
    public List<Room> getAllrooms(){
        RoomService roomService = new RoomServiceImp();
        return roomService.getAllRooms();
    }
    
    public void saveGroup(){
        RoomService roomService = new RoomServiceImp();
        Room or = new Room();
        or.setDate(new Date());
        or.setName(gropName);
        or.setPackageId(new com.entity.Package(Integer.parseInt(pack)));
        roomService.saveRoom(or);
        
    }
    public List<com.entity.Package> getPackage() {
        PackageService packageService = new PackageServiceImp();
        return packageService.getAllPakageByUserId(getUserID());

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Room) event.getObject()).getId();
        RoomService roomService = new RoomServiceImp();
        Room room = roomService.getRoomDetaile(id);
    

    }
    public void deleteRoom() {
        disable = true;
        RoomService roomService = new RoomServiceImp();
        Room or = new Room(id);
        roomService.deleteRoom(or);

    }
}
