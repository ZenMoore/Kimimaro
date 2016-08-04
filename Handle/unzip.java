package Handle;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by admin on 2016/8/5.
 */
public class unzip {
    public static void unZip(String direction,File source){
        try{
            ZipInputStream zin=new ZipInputStream(new FileInputStream(source));
            ZipFile zipFile=new ZipFile(source);
            ZipEntry entry=null;
            File outFile=null;
            InputStream in=null;
            OutputStream out=null;
            File dir=new File(direction);
            JOptionPane.showMessageDialog(null,"Unzipping...");
            if(!dir.exists()){
                dir.mkdirs();
            }
            while((entry=zin.getNextEntry())!=null){
                outFile=new File(dir.getAbsolutePath()+File.separator+entry.getName());
                if(!outFile.getParentFile().exists()){
                    outFile.getParentFile().mkdir();
                }
                if(!outFile.exists()){
                    outFile.createNewFile();
                }
                in=zipFile.getInputStream(entry);
                out=new FileOutputStream(outFile);
                int len;
                while((len=in.read())!=-1){
                    out.write(len);
                }
            }
            zin.close();
            out.close();
            in.close();
            zipFile.close();
            JOptionPane.showMessageDialog(null,"Succeed.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Fail. "+e.getMessage());
        }
    }
    public static void play(String source,String direction){
        new unzip().unZip(direction, new File(source));
    }
}
