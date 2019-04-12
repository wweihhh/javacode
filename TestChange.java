package www.bit.java.io;


import java.io.*;

public class TestChange {
    public static void main(String[] args)throws IOException {
        File file =
                new File("C:\\Users\\xptyxx20170501A\\Desktop\\Testoutput.Txt");
        OutputStream out = new FileOutputStream(file);
        Writer output = new OutputStreamWriter(out);
        output.write("hello offila");
        output.close();

    }
}
