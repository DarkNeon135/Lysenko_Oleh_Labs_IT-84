package Lab6;

import java.io.*;

public class CustomReader extends FilterReader {
private char key;

    protected CustomReader(Reader in, char key) {
        super(in);
        this.key= key;
    }



    @Override
    public int read(char[] output) throws IOException {
        int temp = super.read(output);
        for(int i =0;i<output.length;i++)
        {
            output[i] = decypt(output[i]);
        }

return temp;

    }
    public char decypt(char input){
        return (char)(input + (key-2));
    }
}
