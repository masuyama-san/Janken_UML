package janken.player.impl;

import janken.JankenParam;
import janken.player.Player;
import util.keybord.Keybord;
import util.properties.MessageProperties;

public class HumanPlayerImpl implements Player {

	String name;

	int hand;

	public HumanPlayerImpl(String name) {
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
	public void selectHand() throws Exception {
		while (true) {
			try {
				System.out.println(MessageProperties.getMessage("janken.msg.select.hand.human"));
				int input = Keybord.getInt(1, 3);
				switch (JankenParam.getEnum(input)) {
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
					throw new Exception(MessageProperties.getMessage("error.arg"));
				}
				break;

			} catch (Exception e) {
				System.out.println(MessageProperties.getMessage("error.arg"));
			}
		}
	}

}
