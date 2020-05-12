package com.company;

import java.io.*;
import java.util.*;


public class Main {
public static ArrayList<String> convert(){
    ArrayList<String> result = new ArrayList<>();
    try (Scanner s = new Scanner(new FileReader("demo.txt"))) {
        while (s.hasNextLine()) {
            result.add(s.nextLine());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return result;
}
public static ArrayList<String> compare(){
    ArrayList<String> result = convert();
    result.sort(Comparator.comparingInt(String::length));
    return result;
}
public static void write() {
    ArrayList<String> result = compare();
    FileWriter writer = null;
    try {
        writer = new FileWriter("output.txt");
        for (String line : result) {
            writer.write(line);

            writer.write(System.getProperty("line.separator"));
        }
        writer.flush();
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {

    convert();
    compare();
    write();

  }
}








