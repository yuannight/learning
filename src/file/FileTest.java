package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by duyan on 2016/10/30.
 */
public class FileTest {

    public static void main(String[] args){
       /* File file = new File("123.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());*/


        File file = new File(".");
        String[] nameList = file.list(
                (dir,name)-> name.endsWith(".java") || new File(name).isDirectory()
        );

        for(String name : nameList){
            System.out.println(name);
        }
    }
}
