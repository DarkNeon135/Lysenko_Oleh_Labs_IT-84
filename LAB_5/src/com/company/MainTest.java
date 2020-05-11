package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void convert() {
        List<String> actual = new ArrayList<>();
       List<String> expected = new ArrayList<>();
        expected.add("ssmfmfklmnklsnfjsnj");
        expected.add("weq");
        expected.add("ewqeeeeeeeeeeeeeeeeeee");
        expected.add("eeeeeee");
        expected.add("qqqqqqqqqqqqqe");
        expected.add("qw");

        try (Scanner s = new Scanner(new FileReader("demo.txt"))) {
            while (s.hasNextLine()) {
                actual.add(s.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(actual,expected);
    }
        @Test
    void compare() {
            List<String> actual = new ArrayList<>();
            actual.add("ssmfmfklmnklsnfjsnj");
            actual.add("weq");
            actual.add("ewqeeeeeeeeeeeeeeeeeee");
            actual.add("eeeeeee");
            actual.add("qqqqqqqqqqqqqe");
            actual.add("qw");
            List<String> expected = new ArrayList<>();
            expected.add("qw");
            expected.add("weq");
            expected.add("eeeeeee");
            expected.add("qqqqqqqqqqqqqe");
            expected.add("ssmfmfklmnklsnfjsnj");
            expected.add("ewqeeeeeeeeeeeeeeeeeee");
            actual.sort(Comparator.comparingInt(String::length));
            assertEquals(actual,expected);

        }

    @org.junit.jupiter.api.Test
    void write() {

    }
}