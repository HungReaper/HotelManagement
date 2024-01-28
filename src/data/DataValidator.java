/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.regex.Pattern;
import entity.Hotel;
import java.util.List;

public class DataValidator {

    public DataValidator() {
    }

    public static boolean checkInputMainMenu(String i, String max, String min) {
        String format = "[" + max + "-" + min + "]";
        if (i.matches(format)) {
            return true;
        }
        return false;
    }

    public static boolean checkEquals(String i, String ie) {
        if (i.equalsIgnoreCase(ie)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkYesNO(String i) {
        if (checkEquals(i, "yes") || checkEquals(i, "no")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkInputMainMenu(String i, String regex) {
        if (i.matches(regex)) {
            return true;
        }
        return false;
    }

    public static boolean checkInputInteger(String i) {
        return Pattern.matches("^\\d+", i);
    }

    public static boolean checkInputString(String i, String regex) {
        return Pattern.matches(regex, i);
    }

    public static boolean checkHotelAddress(String i) {
        return Pattern.matches("^[a-zA-Z0-9\\s,.'-]+$", i);
    }

    public static boolean checkExitsHotel(List<Hotel> hotelList, String hotelId) {
        for (Hotel hotel : hotelList) {
            if (hotel.getId().equalsIgnoreCase(hotelId)) {
                return true;
            }
        }
        for (Hotel hotel : hotelList) {
            if (hotel.getName().equalsIgnoreCase(hotelId)) {
                return true;
            }
        }
        return false;
    }
}
