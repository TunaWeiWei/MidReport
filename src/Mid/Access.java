package Mid;

import javax.swing.JOptionPane;

public class Access {		
	private game Game;	
	

	public static void access()  {
				
//		JOptionPane.showConfirmDialog(null, "您確定要啟動遊戲嗎?","啟動確認", JOptionPane.YES_NO_OPTION);				//留著這行會讓詢問視窗跳2次
		int a = JOptionPane.showConfirmDialog(null, "您確定要啟動遊戲嗎?","啟動確認", JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.NO_OPTION) {
			System.out.println("Bye");							//檢查用
			System.exit(0);										//關閉視窗
						
		}else if (a == JOptionPane.YES_OPTION) {
			
			System.out.println("Welcome");							//檢查用
		}
	}
	
	public static void accessWin() {
		int a = JOptionPane.showConfirmDialog(null, "敵人已被你打倒\n您要繼續下個挑戰嗎?","挑戰確認", JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.NO_OPTION) {			
//			System.out.println("Choose NO");							//檢查用			
			System.exit(0);
		}else if (a == JOptionPane.YES_OPTION) {	
			
			SQL.scoreWin();
			Mid.game.restart();	
			
//			System.out.println("Choose YES");							//檢查用
	}
}
	public static void accessLose() {
		int a = JOptionPane.showConfirmDialog(null, "你死了\n您要重新挑戰嗎?","接關確認", JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.NO_OPTION) {			
//			System.out.println("Choose NO");							//檢查用			
			System.exit(0);
		}else if (a == JOptionPane.YES_OPTION) {
			
			SQL.scoreLose();
			Mid.game.restart();										
//			System.out.println("Choose YES");							//檢查用
	}
}
	public static void accessTie() {
		int a = JOptionPane.showConfirmDialog(null, "你跟敵人同歸於盡了\n您要重新挑戰嗎?","接關確認", JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.NO_OPTION) {			
//			System.out.println("Choose NO");							//檢查用			
			System.exit(0);
		}else if (a == JOptionPane.YES_OPTION) {
			
			SQL.scoreTie();
			Mid.game.restart();										
//			System.out.println("Choose YES");							//檢查用
	}
}
}
