package Mid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class game extends JPanel{
	private static JTextArea status;
	private int attack,enemyAttack,defend,heal;
	private static int HP=100,EnemyHP=100,monsterRandom;
	private static String monster1,monster2,secretMonster;
	private static JLabel enemy;
	private static BufferedImage monsterImage;
	private static Image showUpMonster;
//	private static Icon showMonsterIcon;
		
	public game() {
						
		setBackground(Color.gray);
		setLayout(new BorderLayout());
		
		status = new JTextArea();
		Font font = new Font(null, Font.BOLD, 18);
		status.setFont(font);
		status.setBackground(getBackground());
		status.setSelectedTextColor(Color.orange);			//設定顯示出的資料以滑鼠反白後的字體顏色
//		status.setCaretColor(Color.blue);					//設定插入符號本身的顏色		

		status(HP, EnemyHP);
		monster();
		
//		HP=100-enemyAttack;									//思考如何把action內的運算結果拿過來用 ==> 2023/2/8改由外部另外建立之函數方法做運算
//		EnemyHP=100-attack;
		
//		status = new JLabel();		
//		
//		String hp = String.valueOf(HP);						//把 int 數值轉成 String
//		String enemyHP = String.valueOf(EnemyHP);
//			
//		status.setText(hp + enemyHP);						//顯示資料
//		
		imagePost();										//放置版面位置		
		
	}
	public void imagePost() {
		add(status,BorderLayout.WEST);						//放置版面位置
		add(enemy,BorderLayout.CENTER);	
		
	}
	
	public static void monster() {
		
		monsterRandom = (int)(Math.random()*2+1);
		
//		monster1 = "f1/鯊鯊探頭圖.jpg";
//		monster2 = "f1/鎖鏈康妮.jpg";
		if (monsterRandom == 1) {
			try {
				monster1 = "monsterImage/鯊鯊探頭圖.jpg";
				monsterImage = ImageIO.read(game.class.getResource(monster1));	//使用此方法讀取圖片需先將圖片取用路徑放置於同一個package下,打包JAR時為將圖片一同包進去
			}catch (IOException e) {
				System.out.println(e);
			}
		}else if (monsterRandom == 2) {
			try {
				monster2 = "monsterImage/鎖鏈康妮.jpg";
				monsterImage = ImageIO.read(game.class.getResource(monster2));					
			}catch (IOException e) {
				System.out.println(e);
			}
		}else {
			try {
				secretMonster = "monsterImage/星爆氣流斬.jpg";
				monsterImage = ImageIO.read(game.class.getResource(secretMonster));							
			}catch (IOException e) {
				System.out.println(e);
			}
		}
		 
//		monster2 = monster1.getSubimage(100, 100, 450, 300);				// getSubimage ==> 裁剪圖片的指定位置	(monster2需先宣告為bufferedImage)
		
		showUpMonster = monsterImage.getScaledInstance(300, 250, monsterImage.SCALE_SMOOTH) ;	// getScaledInstance ==> 強制以設定數值縮放圖片尺寸(可能會破壞原始畫質
//		showMonsterIcon = new ImageIcon(showUpMonster);
		
		enemy = new JLabel(new ImageIcon(showUpMonster));										// 如何能讓敵人圖片在重新呼叫此方法時做圖片更新?
//		enemy.setIcon(showMonsterIcon);
		
		
		System.out.println(monsterRandom);					//檢查用
	}
	public void attack() {
		
		attack = (int)(Math.random()*49+1);
		enemyAttack();

		
			int result1,result2;		

			result1 = HP - enemyAttack;
			result2 = EnemyHP - attack;
			
			String Result = String.valueOf(result1);
			String Result2 = String.valueOf(result2);
			String Attack = String.valueOf(attack);
			String EnemyAttack = String.valueOf(enemyAttack);
			
			if (result1 <= 0) {
				Result = "dead";
			}
			if (result2 <= 0) {
				Result2 = "dead";
			}
			JOptionPane.showMessageDialog(null, "剩餘HP:"+ Result +"/受到Damage:"+EnemyAttack+"\n"+"剩餘EnemyHp:"+ Result2+"/受到Damage:"+Attack);
			
			HP(result1);
			EnemyHP(result2);
			status(HP, EnemyHP);
		
		//	要處裡這邊運算結果如何丟回BODY或game那裏
	
	}
	public void defend() {
		enemyAttack();
		defend = (int)(Math.random()*3+1);
		
		int result,result2,enemyAttack2;		

			result = HP - (enemyAttack/defend);
			result2 = EnemyHP;
			enemyAttack2 = (enemyAttack/defend);
			
			String Result = String.valueOf(result);
			String Result2 = String.valueOf(result2);
			String EnemyAttack = String.valueOf(enemyAttack2);
			
			if (result <= 0) {
				Result = "dead";
			}
			if (result2 <= 0) {
				Result2 = "dead";
			}
			JOptionPane.showMessageDialog(null, "剩餘HP:"+ Result +"/受到Damage:"+EnemyAttack+"\n"+"剩餘EnemyHp:"+ Result2);
			
			HP(result);
			EnemyHP(result2);
			status(HP, EnemyHP);
	}
	public void heal() {
		enemyAttack();
		heal = (int)(Math.random()*29+11);
		
		int result,result2,result3;		

			result = HP + heal - enemyAttack;
			result2 = EnemyHP;
			result3 = heal;
			
			String EnemyAttack = String.valueOf(enemyAttack);			
			String Result = String.valueOf(result);
			String Result2 = String.valueOf(result2);
			String Result3 = String.valueOf(result3);
			
			if (result <= 0) {
				Result = "dead";
			}
			if (result2 <= 0) {
				Result2 = "dead";
			}
			JOptionPane.showMessageDialog(null, "剩餘HP:"+ Result +"/恢復HP:"+Result3+"/受到Damage:"+EnemyAttack+"\n"+"剩餘EnemyHp:"+ Result2);
			
			HP(result);
			EnemyHP(result2);
			status(HP, EnemyHP);
	}
	public static void restart() {			
			HP = 100;EnemyHP = 100;				
			status(HP, EnemyHP);
			monster();
						
	}
	public void enemyAttack() {
	
		enemyAttack = (int)(Math.random()*49+1);
			
	}
	public int HP(int HP) {
		this.HP = HP;
		return HP;
	}
	public int EnemyHP(int EnemyHP) {
		this.EnemyHP = EnemyHP;
		return EnemyHP;
	}
	public static void status(int HP, int EnemyHP) {
		
		String hp = String.valueOf(HP);						//把 int 數值轉成 String
		String enemyHP = String.valueOf(EnemyHP);
		
		if ( HP <= 0 & EnemyHP <= 0 ) {
			String hpDead = String.valueOf(HP);	
			hpDead = "Dead";	
			String EnemyhpDead = String.valueOf(EnemyHP);	
			EnemyhpDead = "Dead";
			status.append(String.format("HP %s / EnemyHP %s\n", hpDead, EnemyhpDead));
			
			Access.accessTie();		
			
		}else if (HP <= 0) {
			String hpDead = String.valueOf(HP);	
			hpDead = "Dead";			
			status.append(String.format("HP %s / EnemyHP %s\n", hpDead, enemyHP));
			
			Access.accessLose();						//追加詢問視窗
			
		}else if (EnemyHP <=0) {
			String EnemyhpDead = String.valueOf(EnemyHP);	
			EnemyhpDead = "Dead";
			status.append(String.format("HP %s / EnemyHP %s\n", hp, EnemyhpDead));
						
			Access.accessWin();						//追加詢問視窗
			
		}else if (HP > 0 & EnemyHP > 0){				
		
		status.append(String.format("HP %s / EnemyHP %s\n", hp, enemyHP));						//顯示資料(append =>追加在顯示資料的最後
		}		
//		System.out.println(HP);								//檢查用
//		System.out.println(EnemyHP);
		
		}
	
	}


