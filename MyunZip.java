import java.util.zip.*;

import javax.swing.plaf.synth.SynthScrollBarUI;

import java.io.*;
public class MyunZip{
	public static void unzip(File source,String Direction){
		try{
			ZipInputStream zin=new ZipInputStream(new FileInputStream(source)); 
			ZipFile zipFile=new ZipFile(source);
			ZipEntry entry=null;
			File outFile=null;
			OutputStream out=null;
			InputStream in=null;
			File dir=new File(Direction);
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
				int  temp;
				while((temp=in.read())!=-1){
					out.write(temp);
				}
			}
			zin.close();
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MyunZip.unzip(new File("E:/L.zip"),"E:/L");
		System.out.println(System.getProperty("user.dir"));
	}
}
