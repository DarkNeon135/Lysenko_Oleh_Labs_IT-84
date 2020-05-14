package Lab6;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CustomWriter extends FilterWriter

{
    private char key;

    /**
     * Create a new filtered writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @throws NullPointerException if {@code out} is {@code null}
     */
    protected CustomWriter(Writer out, char key) {
        super(out);
        this.key = key;
    }


    @Override
    public void write(char[] input) throws IOException {
        for(int i = 0; i < input.length;i++){
            input[i] = encrypt(input[i]);
        }
        super.write(input);
    }
    private char encrypt(char input){
        return (char)((input - key+2) );
    }
}
