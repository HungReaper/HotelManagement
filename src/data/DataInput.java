/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Scanner;
import ui.Menu;

public class DataInput {

    static final Scanner sc = new Scanner(System.in);

    public static int getIntegerNumber(String max, String min) {
        String s;
        do {
            s = sc.nextLine();
            if (DataValidator.checkInputMainMenu(s, max, min)) {
                return Integer.parseInt(s);
            }
            Menu.showFalseInput();
        } while (true);
    }

    public static boolean inputYesNo() {
        do {
            String s = sc.nextLine();
            if (DataValidator.checkYesNO(s)) {
                if (DataValidator.checkEquals(s, "yes")) {
                    return true;
                } else if (DataValidator.checkEquals(s, "no")) {
                    return false;
                }
            }
            Menu.showFalseInput("input Invalue");
        } while (true);
    }

    public static String inpurId() {
        String s;
        do {
            s = sc.nextLine().toUpperCase();
            if (DataValidator.checkInputString(s, "^[a-zA-Z0-9]{3,}$")) {
                return s;
            }
            Menu.showFalseInput("ID invalue");
        } while (true);
    }

    public static String inputHotelName() {
        String s;
        do {
            s = sc.nextLine();
            if (DataValidator.checkInputString(s, "^[a-zA-Z0-9\\s&'-]*$")) {
                return Character.toUpperCase(s.charAt(0)) + s.substring(1);
            }
            Menu.showFalseInput("Hotel name invalue");
        } while (true);
    }

    public static String inputHotelRoomAvaliable() {
        String s;
        do {
            s = sc.nextLine();
            if (DataValidator.checkInputInteger(s)) {
                return s;
            }
            Menu.showFalseInput("Hotel room avaliable is invalue!");
        } while (true);
    }

    public static String inpuHotelAddress() {
        String s;
        do {
            s = sc.nextLine();
            if (DataValidator.checkHotelAddress(s)) {
                return s;
            }
            Menu.showFalseInput("Hotel address invalue!");
        } while (true);
    }

    public static String inpuHotelPhone() {
        String s;
        do {
            s = sc.nextLine();
            if (DataValidator.checkInputString(s, "^0[0-9]{9}$")) {
                return s;
            }
            Menu.showFalseInput("Hotel Phone invalue!");
        } while (true);
    }

    public static String inpuHotelRate() {
        String s;
        do {
            s = sc.nextLine();
            if (DataValidator.checkInputString(s, "^[0-6]{1}$")) {
                return s;
            }
            Menu.showFalseInput("Hotel rate invalue");
        } while (true);
    }

    public static String inputUpdataInfo(int i) {
        String s;
        do {
            s = sc.nextLine();
            if (s == "") {
                return s;
            }
            switch (i) {
                case 1:
                    if (DataValidator.checkInputString(s, "^[a-zA-Z0-9\\s&'-]*$")) {
                        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
                    }
                    Menu.showFalseInput("Hotel name invalue");
                    break;
                case 2:
                    if (DataValidator.checkInputInteger(s)) {
                        return s;
                    }
                    Menu.showFalseInput("Hotel room avaliable is invalue!");
                    break;
                case 3:
                    if (DataValidator.checkHotelAddress(s)) {
                        return s;
                    }
                    Menu.showFalseInput("Hotel address invalue!");
                    break;
                case 4:
                    s = sc.nextLine();
                    if (DataValidator.checkInputString(s, "^0[0-9]{9}$")) {
                        return s;
                    }
                    Menu.showFalseInput("Hotel Phone invalue!");
                    break;
                case 5:
                    if (DataValidator.checkInputString(s, "^[0-6]{1}$")) {
                        return s;
                    }
                    Menu.showFalseInput("Hotel rate invalue");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);
    }
}
