/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Hotel {

    private String hotelId;
    private String hotelName;
    private String hotelRoomAvailable;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelRate;

    public Hotel() {
    }

    public Hotel(String hotelId, String hotelName, String hotelRoomAvailable, String hotelAddress, String hotelPhone, String hotelRate) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelRoomAvailable = hotelRoomAvailable;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelRate = hotelRate;
    }

    public void setName(String name) {
        this.hotelName = name;
    }

    public void setHotelRoomAvaliable(String hotelRoomAvaliable) {
        this.hotelRoomAvailable = hotelRoomAvaliable;
    }

    public void setAddress(String address) {
        this.hotelAddress = address;
    }

    public void setPhone(String phone) {
        this.hotelPhone = phone;
    }

    public void setRate(String rate) {
        this.hotelRate = rate;
    }

    public String getId() {
        return this.hotelId;
    }

    public String getName() {
        return this.hotelName;
    }

    public String getRoomAvailable() {
        return this.hotelRoomAvailable;
    }

    public String getAddress() {
        return this.hotelAddress;
    }

    public String getPhone() {
        return this.hotelPhone;
    }

    public String getRate() {
        return this.hotelRate;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s", getId(), getName(), getRoomAvailable(), getAddress(), getPhone(), getRate());
    }

    public String showList() {
        return String.format("%s | %s | %s | %s |  %s | %s", getId(), getName(), getRoomAvailable(), getAddress(), getPhone(), getRate());
    }

}
