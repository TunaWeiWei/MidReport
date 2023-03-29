package Mid;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SQL {
		private final static String USER = "root";
				final static String PASSWORD = "root";
				final static String URL = "jdbc:mysql://localhost:3306/gamesql";
				final static String SQL_QUERY = "SELECT * FROM score";
				final static String SQL_Insert = "insert into score(ID, name, challenge)"+"values(?,?,?)";
					  static String name, challenge, scoreCheckResult;
					  static int ID ;
					  static JTextArea Result;
					
					  
		public static void scoreWin() {
			
			name = JOptionPane.showInputDialog(null,"請輸入名字" , "分數紀錄" , JOptionPane.QUESTION_MESSAGE  );			
			
			try {
				
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement column = conn.prepareStatement(SQL_Insert);
				challenge = "win";
				int i = 1;
				column.setInt(i++, ID);
				column.setString(i++, name);
				column.setString(i++, challenge);
				column.executeUpdate();								
				
				System.out.println("上傳成功 WIN");			//檢查用
			}catch (SQLException e) {
				System.out.println(e);
			}			
		}
		public static void scoreLose() {
			
			name = JOptionPane.showInputDialog(null,"請輸入名字" , "分數紀錄" , JOptionPane.QUESTION_MESSAGE  );			

			try {
				
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);						
				PreparedStatement column = conn.prepareStatement(SQL_Insert);
				challenge = "lose";
				int i = 1;
				column.setInt(i++, ID);
				column.setString(i++, name);
				column.setString(i++, challenge);
				column.executeUpdate();		
				
				System.out.println("上傳成功 LOSE");	   	//檢查用
			
			}catch (SQLException e) {
				System.out.println(e);
			}			
		}
		public static void scoreTie() {
			
			name = JOptionPane.showInputDialog(null,"請輸入名字" , "分數紀錄" , JOptionPane.QUESTION_MESSAGE  );			

			try {
				
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);						
				PreparedStatement column = conn.prepareStatement(SQL_Insert);
				challenge = "Tie";
				int i = 1;
				column.setInt(i++, ID);
				column.setString(i++, name);
				column.setString(i++, challenge);
				column.executeUpdate();		
				
				System.out.println("上傳成功 Tie");	   	//檢查用
			
			}catch (SQLException e) {
				System.out.println(e);
			}			
		}
		public static void scoreRankSearch() {
			
			Result = new JTextArea();
			Font font = new Font(null, Font.BOLD, 18);	
			Result.setFont(font);
			Result.setBackground(Color.lightGray);
			
			try {
			
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);	
				PreparedStatement scoreCheck = conn.prepareStatement(SQL_QUERY,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = scoreCheck.executeQuery();
				
				while(rs.next()) {
					String name = rs.getString("name");
					String challenge = rs.getString("challenge");			
//					String scoreCheckResult = "名字:"+ name + "挑戰:" + challenge; 							//檢查用
//					System.out.println(scoreCheckResult);
					Result.append(String.format("名字 %s / 挑戰 %s\n", name, challenge));	
					
				}
//				JOptionPane.showMessageDialog(null, "搜尋完畢" , "挑戰紀錄", JOptionPane.INFORMATION_MESSAGE);	//尚未使其結果直接秀在視窗上
				Result.setEditable(false);																	//禁止視窗JTextArea區域文字被直接從視窗上修改
				JOptionPane.showMessageDialog(null, Result , "挑戰紀錄", JOptionPane.INFORMATION_MESSAGE);		//2023/2/15完成可顯示於視窗上
				
			}catch (Exception e) {
				System.out.println(e);
			}
			

			
		}
}
