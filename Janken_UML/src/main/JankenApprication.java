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

	/**
	 * CPUプレイヤーオブジェクト生成メソッド
	*/
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

	/**
	 * プレイヤー全体の数をチェックするメソッド
	*/
	private boolean checkPlayerCount() {

		if (playerList.size() >= 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * じゃんけんの手を選択するメソッド
	*/
	private void selectJankenHand() throws Exception {
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).selectHand();
		}
	}

	/**
	 * じゃんけん判定処理
	*/
	private int judge() {

		boolean rock = false;
		boolean scissors = false;
		boolean paper = false;

		for (Player list : playerList) {
			if (list.getHand() == JankenParam.ROCK.getInt()) {
				rock = true;
			} else if (list.getHand() == JankenParam.SCISSORS.getInt()) {
				scissors = true;
			} else if (list.getHand() == JankenParam.PAPER.getInt()) {
				paper = true;
			}
		}

		if (rock == true && scissors == true && paper == false) {
			return JankenParam.ROCK.getInt();
		} else if (rock == false && scissors == true && paper == true) {
			return JankenParam.SCISSORS.getInt();
		} else if (rock == true && scissors == false && paper == true) {
			return JankenParam.PAPER.getInt();
		} else {
			return JankenParam.DRAW.getInt();
		}

	}

	/**
	 * 勝利者表示処理
	*/
	private void viewWinner() throws Exception {
		String name = "";
		for (Player list : playerList) {
			if (winHand == list.getHand()) {
				name += list.getName() + " ";
			}
		}
		System.out.println(MessageProperties.getMessage("janken.msg.game.winner", name));
	}

	//ゲーム継続判定処理
	private boolean gameContinue() {
		return false;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public int getWinHand() {
		return winHand;
	}

	public void setWinHand(int winHand) {
		this.winHand = winHand;
	}

}
