package janken.player.impl;

import janken.player.Player;

public class HumanPlayerImpl implements Player{
	
	String name;
	
	int hand;
	
	public HumanPlayerImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int getHand() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void selectHand() throws IllegalArgumentException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
