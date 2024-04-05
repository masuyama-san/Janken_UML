package main;

import java.util.ArrayList;
import java.util.List;

import janken.JankenParam;
import janken.player.Player;
import janken.player.impl.CpuPlayerImpl;
import janken.player.impl.HumanPlayerImpl;
import util.keybord.Keybord;
import util.properties.MessageProperties;

public class JankenApprication {

	private int winHand;

	private List<Player> playerList;

	public static void main(String[] args) {

		JankenApprication app = new JankenApprication();

		try {
			while (true) {
				while (true) {

					System.out.println(MessageProperties.getMessage("janken.msg.start"));

					app.initialization();

					app.createHumanPlayer();

					app.createCpuPlayer();

					if (app.checkPlayerCount()) {
						break;
					}

					System.out.println(MessageProperties.getMessage("janken.msg.player.count.error"));
				}

				while (true) {

					app.selectJankenHand();

					app.winHand = app.judge();
					if (app.winHand != JankenParam.DRAW.getInt()) {
						break;
					}

					System.out.println(MessageProperties.getMessage("janken.msg.game.draw"));
				}

				app.viewWinner();

				if (app.gameContinue() == false) {
					break;
				}

			}

			System.out.println(MessageProperties.getMessage("janken.msg.end"));

		} catch (Exception e) {
			System.out.println("なんかエラー出てますよ");

		}
	}

	//ゲーム初期化用メソッド
	private void initialization() {

		if (this.playerList == null) {
			this.playerList = new ArrayList<Player>();
		} else {
			this.playerList.clear();
		}

	}

	//人間プレイヤーオブジェクト生成メソッド
	private void createHumanPlayer() throws Exception {

		while (true) {

			try {

				System.out.println(MessageProperties.getMessage("janken.msg.create.human"));
				int value = Keybord.getInt();

				for (int i = 0; i < value; i++) {
					Player player = new HumanPlayerImpl(
							MessageProperties.getMessage("janken.msg.playername.human") + (i + 1));
					playerList.add(player);
				}

				break;

			} catch (Exception e) {
				System.out.println(MessageProperties.getMessage("msg.retype"));
			}
		}
	}

	//CPUプレイヤーオブジェクト生成メソッド
	private void createCpuPlayer() throws Exception {

		while (true) {

			try {

				System.out.println(MessageProperties.getMessage("janken.msg.create.cpu"));
				int value = Keybord.getInt();

				for (int i = 0; i < value; i++) {
					Player player = new CpuPlayerImpl(
							MessageProperties.getMessage("janken.msg.playername.cpu") + (i + 1));
					playerList.add(player);
				}

				break;

			} catch (Exception e) {
				System.out.println(MessageProperties.getMessage("msg.retype"));
			}
		}

	}

	//プレイヤー全体の数をチェックするメソッド
	private boolean checkPlayerCount() {

		if (playerList.size() >= 2) {
			return true;
		} else {
			return false;
		}
	}

	//じゃんけんの手を選択するメソッド
	private void selectJankenHand() {

	}

	//じゃんけん判定処理
	private int judge() {
		return 0;
	}

	//勝利者表示処理
	private void viewWinner() {

	}

	//ゲーム継続判定処理
	private boolean gameContinue() {
		return false;
	}

}
