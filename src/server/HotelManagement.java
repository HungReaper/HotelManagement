/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import data.DataInput;
import ui.Menu;
import entity.Hotel;
import java.util.List;
import data.HotelDao;
import data.DataValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelManagement {

    HotelDao hotelList = new HotelDao();
    List<Hotel> hotelListBackUp;

    public HotelManagement() throws Exception {
        hotelListBackUp = hotelList.getList();
    }

    public void addHotel() {
        do {
            Menu.print("Enter hotel id: ");
            String hotelId;
            boolean flag = true;
            do {
                hotelId = DataInput.inpurId();
                if (DataValidator.checkExitsHotel(hotelList.getList(), hotelId)) {
                    Menu.showFalseInput("Hote ID exits!");
                } else {
                    flag = false;
                }
            } while (flag);
            Menu.print("Enter hotel name: ");
            String hotelName = DataInput.inputHotelName();
            Menu.print("Enter hotel room avaliable: ");
            String hotelRoomAvaliable = DataInput.inputHotelRoomAvaliable();
            Menu.print("Enter hotel address: ");
            String hotelAddress = DataInput.inpuHotelAddress();
            Menu.print("Enter hotel phone: ");
            String hotelPhone = DataInput.inpuHotelPhone();
            Menu.print("Enter hotel Rate: ");
            String hotelRate = DataInput.inpuHotelRate() + " star";
            Hotel newHotel = new Hotel(hotelId, hotelName, hotelRoomAvaliable, hotelAddress, hotelPhone, hotelRate);
            try {
                if (hotelList.addNew(newHotel)) {
                    hotelListBackUp = hotelList.getList();
                    System.out.println("success add new hotel");
                } else {
                    System.out.println("Fail to add hotel");
                }
            } catch (Exception e) {
                System.out.println("Fail to add hotel");
            }
            Menu.showOptionToGoBack();
            if (!DataInput.inputYesNo()) {
                return;
            }
        } while (true);
    }

    public void checkExistHotel() {
        if (hotelList.isEmpty()) {
            return;
        }
        do {
            Menu.print("Enter hotel id: ");
            String hotelId = DataInput.inpurId();
            if (DataValidator.checkExitsHotel(hotelList.getList(), hotelId)) {
                Menu.print("Exist Hotel\n");
            } else {
                Menu.showErrMess("\nNo Hotel Found!");
            }
            Menu.showOptionToGoBack();
            if (!DataInput.inputYesNo()) {
                return;
            }
        } while (true);
    }

    public void updateHotelInformation() {
        hotelListBackUp = hotelList.getList();
        if (hotelList.isEmpty()) {
            return;
        }
        Menu.print("Enter hotel id: ");
        String hotelId = DataInput.inpurId();
        if (DataValidator.checkExitsHotel(hotelList.getList(), hotelId)) {
            for (Hotel hotel : hotelList.getList()) {
                if (hotel.getId().equalsIgnoreCase(hotelId)) {
                    Menu.print("Enter hotel name: ");
                    String hotelName = DataInput.inputUpdataInfo(1);
                    if (hotelName != "") {
                        hotel.setName(hotelName);
                    }
                    Menu.print("Enter hotel room avaliable: ");
                    String hotelRoomAvaliable = DataInput.inputUpdataInfo(2);
                    if (hotelRoomAvaliable != "") {
                        hotel.setHotelRoomAvaliable(hotelRoomAvaliable);
                    }
                    Menu.print("Enter hotel address: ");
                    String hotelAddress = DataInput.inputUpdataInfo(3);
                    if (hotelAddress != "") {
                        hotel.setAddress(hotelAddress);
                    }
                    Menu.print("Enter hotel phone: ");
                    String hotelPhone = DataInput.inputUpdataInfo(4);
                    if (hotelPhone != "") {
                        hotel.setPhone(hotelPhone);
                    }
                    Menu.print("Enter hotel Rate: ");
                    String hotelRate = DataInput.inputUpdataInfo(5) + " star";
                    if (hotelRate != "") {
                        hotel.setRate(hotelRate);
                    }
                    System.out.println(hotel.showList());
                    Menu.print("Hotel succcess updata!");
                }
            }
        } else {
            System.err.println("\nNo Hotel Found!");
        }
    }

    public void deleteHotel() {
        if (hotelList.isEmpty()) {
            return;
        }
        Menu.print("Enter hotel id: ");
        String hotelId = DataInput.inpurId();
        if (DataValidator.checkExitsHotel(hotelList.getList(), hotelId)) {
            hotelList.deleteHotelInList(hotelId);
        }
        System.out.println("Do you really want to delete this hotel ?");
        if (!DataInput.inputYesNo()) {
            hotelList.sethotelList(hotelListBackUp);
            return;
        }
        Menu.print("Hotel succcess delete!");
    }

    public void searchHotel() {
        Menu.showSearchHotelMenu();
        int choice = DataInput.getIntegerNumber("1", "3");
        switch (choice) {
            case 1:
                Menu.print("Enter hotel id: ");
                String hotelId = DataInput.inputHotelName();
                List<Hotel> hoteListMatID = new ArrayList<>();
                for (Hotel hotel : hotelList.getList()) {
                    if (hotel.getId().toLowerCase().contains(hotelId.toLowerCase())) {
                        hoteListMatID.add(hotel);
                    }
                }
                if (hoteListMatID.isEmpty()) {
                    Menu.showErrMess("No Hotel Found!");
                } else {
                    Comparator<Hotel> h = new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel o1, Hotel o2) {
                            return -o1.getId().compareTo(o2.getId());
                        }
                    };
                    Collections.sort(hoteListMatID, h);
                    for (Hotel hotel : hoteListMatID) {
                        System.out.println(hotel.showList());
                    }
                }
                break;
            case 2:
                Menu.print("Enter hotel name: ");
                String hotelName = DataInput.inputHotelName();
                if (DataValidator.checkExitsHotel(hotelList.getList(), hotelName)) {
                    for (Hotel hotel : hotelList.getList()) {
                        if (hotel.getName().equalsIgnoreCase(hotelName)) {
                            System.out.println(hotel.showList());
                        }
                    }
                } else {
                    Menu.showErrMess("No Hotel Found!");
                }
                break;
            default:
                break;
        }
    }

    public void showHotelList() {
        if (hotelList.isEmpty()) {
            return;
        }
        List<Hotel> cloneHotel = hotelList.getList();
        Comparator<Hotel> h = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                if (o1.getName().equalsIgnoreCase(o2.getName())) {
                    return -o1.getId().compareTo(o2.getId());
                }
                return -o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(cloneHotel, h);
        Menu.showListMenu();
        for (Hotel hotel : cloneHotel) {
            System.out.println(hotel.showList());
        }
    }

    public void exitProgram() {
        try {
            hotelList.writeDataToFile();
        } catch (Exception ex) {

        }
    }

}
