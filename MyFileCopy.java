package www.bit.java.io;

import java.io.*;


public class MyFileCopy {
    public static void main(String[] args) throws Exception {
        //源文件路径
        String sourceFilePath = "C:\\Users\\xptyxx20170501A\\Desktop\\1.jpg";
        //目标文件名称
        String destFilePath = "C:\\Users\\xptyxx20170501A\\Desktop\\2.jpg";
        copyFile(sourceFilePath,destFilePath);
    }
    public static void copyFile(String sourceFilePath,
                                String destFielPath) throws Exception {
        //取得源文件及目标文件的File对象
        File sourcefile = new File(sourceFilePath);
        File destFile = new File(destFielPath);
        //取得输入输出流

        InputStream in = new FileInputStream(sourcefile);
        OutputStream out = new FileOutputStream(destFile);
        int len = 0;
        byte[] data = new byte[1024];
        long start = System.currentTimeMillis();
        while ((len = in.read(data)) != -1){
            out.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start)+"ms");

        in.close();
        out.close();

    }
}
