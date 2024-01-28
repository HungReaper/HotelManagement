/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements Cloneable {

    private List<Hotel> hotelList = new ArrayList<>();

    public HotelDao() {
        try {
            this.hotelList = FileManager.readFromFile();
        } catch (Exception e) {
            System.err.println("fail to read file");
        }
    }

    public boolean isEmpty() {
        if (hotelList.isEmpty()) {
            System.out.println("Hotel list is empty");
            return true;
        }
        return false;
    }

    public List<Hotel> getList() {
        isEmpty();
        List<Hotel> cloneHotel = new ArrayList<>(hotelList);
        return cloneHotel;
    }

    public void sethotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public boolean writeDataToFile() throws Exception {
        try {
            FileManager.writeToFile(hotelList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addNew(Hotel hotell) {
        try {
            this.hotelList.add(hotell);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void updateHotelListInformation(List<Hotel> listOfHotel) {
        this.hotelList = listOfHotel;
    }

    public void deleteHotelInList(String hotelId) {
        for (Hotel hotel : this.hotelList) {
            if (hotel.getId().equalsIgnoreCase(hotelId)) {
                this.hotelList.remove(hotel);
                break;
            }
        }
    }

}
