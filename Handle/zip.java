package Handle;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by admin on 2016/8/5.
 */
public final class zip {
    public static void zip(String direction ,File source) throws Exception{
        ZipOutputStream out=new ZipOutputStream(new FileOutputStream(direction));
        if(source.isDirectory()){
            zip(out,source.listFiles(),"");
        }else{
            zip(out, new File[]{source}, "");
        }
        JOptionPane.showMessageDialog(null,"Zipping...");
        out.close();
    }
    public static void zip(ZipOutputStream out,File[] files,String base)throws Exception{
        if(files!=null){
            for(File currentFile:files){
                if(currentFile.isDirectory()){
                    zip(out,currentFile.listFiles(),currentFile.getName()+File.separator);
                    continue;
                }
                out.putNextEntry(new ZipEntry(base+currentFile.getName()));
                FileInputStream in=new FileInputStream(currentFile);
                int len;
                byte byt[]=new byte[1024];
                while((len=in.read(byt))!=-1){
                    out.write(byt);
                }
            }
        }

    }
    public static void play(String source,String direction){
        try{
            new zip().zip(direction, new File(source));
            JOptionPane.showMessageDialog(null,"Succeed.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Fail. "+e.getMessage());
        }
    }
}
