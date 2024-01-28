package ui;

import server.HotelManagement;
import data.DataInput;
import java.util.Collections;

public class Program {

    public static void main(String[] args) {
        HotelManagement hotelManagement = null;
        try {
            hotelManagement = new HotelManagement();
        } catch (Exception ex) {
            Menu.showErrMess("Fail to read data!");
        }
        System.out.println(String.join("", Collections.nCopies(10, "**********")));
        do {
            Menu.showMainMenu();
            int choice = DataInput.getIntegerNumber("1", "7");
            switch (choice) {
                case 1:
                    hotelManagement.addHotel();
                    break;
                case 2:
                    hotelManagement.checkExistHotel();
                    break;
                case 3:
                    hotelManagement.updateHotelInformation();
                    break;
                case 4:
                    hotelManagement.deleteHotel();
                    break;
                case 5:
                    hotelManagement.searchHotel();
                    break;
                case 6:
                    hotelManagement.showHotelList();
                    break;
                default:
                    hotelManagement.exitProgram();
                    System.exit(0);
            }
        } while (true);
    }
}
