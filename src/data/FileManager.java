/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import entity.Hotel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {

    public static List<Hotel> readFromFile() {
        List<Hotel> hotelList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Hotel.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String text[] = line.split("\\|");
                hotelList.add(new Hotel(text[0], text[1], text[2], text[3], text[4], text[5]));
            }
            fr.close();
        } catch (Exception e) {
            System.err.println("Fail to read data");
        }
        return hotelList;
    }

    public static void writeToFile(List<Hotel> hotelList) {
        try {
            FileWriter fw = new FileWriter("Hotel.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Hotel hotel : hotelList) {
                bw.write(hotel.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

}
