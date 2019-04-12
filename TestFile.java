package www.bit.java.io;

import javax.tools.ForwardingFileObject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TestFile {
    public static void main(String[] args) {
//        File file = new File("C:"+File.separator+"Users"
//                +File.separator+"xptyxx20170501A"+File.separator+"Desktop"
//        +File.separator+"TestIO.java");
//        if(file.exists()){
//            System.out.println(file.getParent());
//        }else{
//            try{
//                file.createNewFile();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }

//
//        File file = new File("C:"+File.separator+"Users"
//                +File.separator+"xptyxx20170501A"+File.separator+"Desktop"
//        +File.separator+ "www"+File.separator+"bit"+File.separator+
//                "java"+File.separator+"TestIO.java");
//        if(!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//
//        else{
//            System.out.println("文件已经存在");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        File f = new File("C:"+File.separator+"Users"
//                +File.separator+"xptyxx20170501A"+File.separator+"Desktop"
//        +File.separator+"TestIO.java");
//        if(f.exists() && f.isFile()){
//            System.out.println(f.length()/1024);
//            Date date = new Date(f.lastModified());
//            SimpleDateFormat simpleDateFormat =
//                    new SimpleDateFormat("yyyy-MM-dd HH:mm:SS:");
//            System.out.println(simpleDateFormat.format(date));
//        }


        //打开全部目录
        File f1 = new File("C:"+File.separator+"Users"
                +File.separator+"xptyxx20170501A"+File.separator+"Desktop");
       listAllFiles(f1);
        }
    
    public static void listAllFiles(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            if(file.exists() && file.isDirectory()){
                File[] files = file.listFiles();
                for (File file1 : files){
                    listAllFiles(file1);
                }
            }
        }
    }
}
