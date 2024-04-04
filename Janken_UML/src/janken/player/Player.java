package janken.player;

public interface Player {
	
	//プレイヤー名取得
	public String getName();
	
	//じゃんけんの手情報取得
	public int getHand();
	
	//じゃんけんの手選択処理
	public void selectHand() throws IllegalArgumentException;

}
