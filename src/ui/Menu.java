/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author Admin
 */
public class Menu {

    public Menu() {
    }

    public static void showFalseInput() {
        System.err.print("Data invalue! \n Select: ");
    }

    public static void showFalseInput(String displayMesser) {
        System.err.print("" + displayMesser + "\nEnter again: ");
    }

    public static void print(String displayMess) {
        System.out.print(displayMess);
    }

    public static void showErrMess(String displayMesser) {
        System.err.print(displayMesser);
    }

    public static void showMainMenu() {
        System.out.print("\n******Hotel******\n"
                + " 1. Add hotel.\n"
                + " 2. Check exits hotel.\n"
                + " 3. Update hotel information.\n"
                + " 4. Delete hotel.\n"
                + " 5. Search hotel\n"
                + " 6. Display hotel list.\n"
                + " 7. exit.\n"
                + " Select: ");
    }

    public static void showOptionToGoBack() {
        System.out.print("Do you you want to continue?(Yes & No): ");
    }

    public static void showListMenu() {
        System.out.println(String.format("%s | %s | %s | %s | %s | %s", "Hotel_ID", "Hotel_Name", "Hotel_Room_Avaliable", "Hotel_Address", "Hotel_Phone", "Hotel_Rating"));
    }

    public static void showSearchHotelMenu() {
        System.out.print("\n******Hotel search******\n"
                + " 1. Search by Hotel Id. \n"
                + " 2. Search by Hotel name.\n"
                + " 3. Exit.\n"
                + "Select: ");
    }

}
