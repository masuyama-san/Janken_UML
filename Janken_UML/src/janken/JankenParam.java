package janken;

import java.util.EnumSet;

public enum JankenParam {
	
	DRAW(0),
	ROCK(1),
	SCISSORS(2),
	PAPER(3),
	;
	
	private int enumValue;
	
	private JankenParam(int enumValue) {
		this.enumValue = enumValue;
	}
	
	public int getInt() {
		return this.enumValue;
	}
	
	// JankenParam型の列挙値を整数値で検索し、対応する列挙値を返すメソッド
	public static JankenParam getEnum(final int value) {
		// JankenParam列挙のすべての要素について繰り返す
		for(JankenParam jp : EnumSet.allOf(JankenParam.class)) {
			//指定された整数値が列挙値の順序と一致するかどうかを確認
			if(jp.ordinal() == value) {
				return jp;
			}
		}
		throw new IllegalArgumentException("入力値が不適切です：" + value);
	}

}
