package Lab6;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomWriterTest {

    @Test
    void write() throws IOException {
        char[] WhatToEncrypt = {'ш','о','т','о','т','е','с','т','и','м'};
        char[] enc = new char[10];
        String expected = "хлплпвопей";

        CustomWriter customWriter = new CustomWriter(new FileWriter("enc_test.txt"), (char) 5);
        customWriter.write(WhatToEncrypt);
        customWriter.close();

        FileReader fr = new FileReader("enc_test.txt");
        fr.read( enc);

        StringBuilder sb = new StringBuilder();
        sb.append(enc);
        String actual = sb.toString() ;


        assertEquals(actual,expected);
    }
}