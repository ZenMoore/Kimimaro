package Zool;
import java.util.Scanner;
import java.util.zip.*;
import java.io.*;
public class Zip {
	public static void zip(String direction ,File source) throws Exception{
		ZipOutputStream out=new ZipOutputStream(new FileOutputStream(direction));
		if(source.isDirectory()){
			zip(out,source.listFiles(),"");
		}else{
			zip(out, new File[]{source}, "");
		}
		System.out.println("Zipping....");
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
	public static void play(){
		try{
			Scanner in=new Scanner(System.in);
			System.out.println("Please Input Source.");
			String source=in.next();
			System.out.println("Please Input Direction");
			String direction=in.next();
			System.out.println("Success.");
		 new Zip().zip(direction, new File(source));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
