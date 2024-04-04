package util.keybord;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Keybord {
	
	private static Scanner scan;
	
	private static Scanner getScannerInstance() {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}
	
	public static int getInt() throws IOException{
		try {
			return Keybord.getScannerInstance().nextInt();
		}catch(InputMismatchException e){
			throw new IOException("入力値が不適切です。");
		}
	}

}
