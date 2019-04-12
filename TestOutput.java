package www.bit.java.io;
import java.io.File;
import java.io.*;
import java.io.OutputStreamWriter;

public class TestOutput {
    public static void main(String[] args)throws IOException {
        //取得终端对象
        File file = new File("C:\\Users\\xptyxx20170501A\\Desktop\\Testoutput.Txt");
        //根据终端对象取得输入输出流
        OutputStream out = new FileOutputStream(file);
        String str = "liyifeng";
        //根据输入输出流进行数据读取与写入
        out.write(str.getBytes());
        //关闭流
        out.close();

        InputStream in = new FileInputStream(file);
        //设置一个缓冲区
        byte[] data = new byte[1024];
        //read中传入data，每次读取数据大小
        int length = in.read(data);
        System.out.println(new String(data,0,length));
        in.close();


    }
}
