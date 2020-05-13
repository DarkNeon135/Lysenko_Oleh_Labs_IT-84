import static org.junit.jupiter.api.Assertions.*;

class Lab6Test {

    @org.junit.jupiter.api.Test
    void encrypt() {
String str = "abba5";
char a = 1;
StringBuilder sb = new StringBuilder();

for(Character b : str.toCharArray()){
    char result = (a+b)> Character.MAX_VALUE ? Character.MAX_VALUE: (char)(a+b);
    sb.append(result);
}
sb.toString();
String actual = sb.toString();
String expected = "bccb6";
assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void decrypt() {
        String str = "bccb6";
        char a = 1;
        StringBuilder sb = new StringBuilder();

        for(Character b : str.toCharArray()){
            char result = (b-a) < 0 ? (char) 0: (char)(b-a);
            sb.append(result);
        }
        sb.toString();
        String actual = sb.toString();
        String expected = "abba5";
        assertEquals(expected,actual);
    }

    }
