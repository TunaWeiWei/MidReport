package Mid;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gameBody extends JFrame {
	
	private JButton Attack, Defend, Heal, Restart, Search;
	
	private game Game;
			
	public gameBody() {
		super("遊戲");		
		
		bodyBone();
		Button();	
		
	}
	
	public void bodyBone() {
		Attack = new JButton("攻擊");
		Defend = new JButton("防禦");
		Heal = new JButton("回復");
		Restart = new JButton("重新開始");
		Search = new JButton("挑戰紀錄查詢");
		
		JPanel function = new JPanel(new FlowLayout());
		function.add(Attack);function.add(Defend);function.add(Heal);function.add(Restart);function.add(Search);
		
		setLayout(new BorderLayout());
		add(function, BorderLayout.NORTH);
		
		Game = new game();
		add(Game,BorderLayout.CENTER);				
		
		setSize(600,480);
		setResizable(false);						//為設定視窗是否可以客製化拉伸
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
		private void Button() {
			Attack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {					
					Game.attack();
					
				}
			});
			Defend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Game.defend();
					
				}
			});
			Heal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Game.heal();
					
				}
			});
			Restart.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					game.restart();
					
				}
			});
			Search.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SQL.scoreRankSearch();
					
				}
			});
		}
	
	public static void main(String[] args) {
		
//(方法1)
//		Access test = new Access();						//為何一直是空指針而無法用其他CLASS內的方法?
//		test.access();									//==>解決方法:如果不同的類別(class)要引用的方法為非靜態(未加static) 
														//							-->只能通過物件來做呼叫(見方法1  用物件呼叫)
														//							要引用的方法為靜態(static) 
/*(方法2)*/												//							-->可通過類名及物件來做呼叫(見方法2  用類名呼叫)
		Access.access();		
		new gameBody();
		

	}

}
