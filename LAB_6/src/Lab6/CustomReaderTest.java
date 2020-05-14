package Lab6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomReaderTest  {


    @Test
    void read() throws IOException {
    char[] dec = new char[10];
    String expected = "шототестим";
        CustomReader customReader = new CustomReader(new FileReader("enc_test.txt"), (char) 5);
        customReader.read(dec);
        StringBuilder sb = new StringBuilder();
        sb.append(dec);
        String actual = sb.toString();
        assertEquals(actual,  expected);
    }


}