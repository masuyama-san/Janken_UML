package util.keybord;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.properties.MessageProperties;

public class Keybord {
	
	private static Scanner scan;
	
	private static Scanner getScannerInstance() {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}
	
	//ユーザーの数を選択時の入力メソッド
	public static int getInt() throws IOException{
		try {
			return Keybord.getScannerInstance().nextInt();
		}catch(InputMismatchException e){
			throw new IOException("入力値が不適切です。");
		}
	}
	
	//じゃんけんの手を選択時の入力メソッド
	public static int getInt(int from, int to) throws Exception {
		hasCheckRangeValue(from, to);
		int no = getInt();
		isRange(no, from, to);
		return no;
	}
	
	//入力された値の範囲をチェックするメソッド
	private static void isRange(int value, int from, int to) throws Exception{
		if(value < from || value > to) {
			throw new IOException(MessageProperties.getMessage(""));
		}
	}
	
	//引数に設定された値をチェックするメソッド
	private static void hasCheckRangeValue(int from, int to) throws Exception{
		if(from >= to) {
			throw new IOException(MessageProperties.getMessage(""));
		}
	}
	
}
