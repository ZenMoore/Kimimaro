package Zool;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("Please Input Type.(Unzip,Zip)");
		String type=in.next();
		if(type.trim().contains("Zip")&&!type.trim().contains("Un")){
			Zip.play();
		}else if(type.trim().contains("zip")&&type.trim().contains("Un")){
			UnZip.play();
		}else{
			System.out.println("Waring:Input Error.");
		}
	}
}
