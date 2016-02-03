package Zool;
import java.util.Scanner;
import java.util.zip.*;
import java.io.*;
public class UnZip {
	public static void unZip(String direction,File source){
		try{
			ZipInputStream zin=new ZipInputStream(new FileInputStream(source));
			ZipFile zipFile=new ZipFile(source);
			ZipEntry entry=null;
			File outFile=null;
			InputStream in=null;
			OutputStream out=null;
			File dir=new File(direction);
			System.out.println("UnZipping....");
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
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void play(){
		Scanner in=new Scanner(System.in);
		System.out.println("Please Input Source.");
		String source=in.next();
		System.out.println("Please Input Direction.");
		String direction=in.next();
		new UnZip().unZip(direction, new File(source));
		System.out.println("Success.");
		in.close();
	}
}

