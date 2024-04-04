package janken.player.impl;

import java.util.Random;

import janken.JankenParam;
import janken.player.Player;

public class CpuPlayerImpl implements Player{
	
	//プレーヤー名
	private String name;
	
	//プレーヤーが選択した手
	private int hand;
	
	public CpuPlayerImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getHand() {
		return this.hand;
	}

	@Override
	public void selectHand() throws IllegalArgumentException {
		
		switch(JankenParam.getEnum(new Random().nextInt(3) + 1)) {
		case ROCK:
			hand = JankenParam.ROCK.getInt();
			break;
		case SCISSORS:
			hand = JankenParam.SCISSORS.getInt();
			break;
		case PAPER:
			hand = JankenParam.PAPER.getInt();
			break;
		default:
			throw new IllegalArgumentException("値が不適切です");
		
		}
	}
	
	

}
