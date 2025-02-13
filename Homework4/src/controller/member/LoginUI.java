package controller.member;

import java.util.Date;
import java.util.regex.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JLabel Time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(96, 91, 64, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼：");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(96, 139, 64, 44);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(170, 100, 141, 27);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(170, 149, 141, 27);
		contentPane.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("會員登入",JLabel.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_2.setBounds(109, 20, 256, 44);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username = username.getText();
				String Password = password.getText();
				
				String usernameRegex = "^[a-zA-Z0-9]{4,10}$";
				Pattern usernamePattern = Pattern.compile(usernameRegex);
		        Matcher usernameMatcher = usernamePattern.matcher(Username);
		        
		        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$";
		        Pattern passwordPattern = Pattern.compile(passwordRegex);
		        Matcher passwordMatcher = passwordPattern.matcher(Password);
		        
		        if (!usernameMatcher.matches()) {
		     
		            JOptionPane.showMessageDialog(null, "帳號錯誤！請輸入 4 到 10 的英文與數字組合。");
		            return;  
		        }
		        
		        if (!passwordMatcher.matches()) {
		            
		            JOptionPane.showMessageDialog(null, "密碼錯誤！請輸入至少 4 個字，並包含至少一個英文和一個數字。");
		            return;  
		        }
				
				Member member = new MemberServiceImpl().Login(Username, Password);
				
				if(member!=null)
				{
					Tool.save(member, "member.txt");
					
//					PorderMainUI pordermain=new PorderMainUI();
//					pordermain.setVisible(true);
					
					LoginSuccessUI loginsuccess=new LoginSuccessUI();
					loginsuccess.setVisible(true);
					
					dispose();					
				}
				else
				{
					LoginErrorUI loginerror = new LoginErrorUI();
					loginerror.setVisible(true);
					
					dispose();					
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton.setBounds(109, 206, 108, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊會員");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddMemberUI addmember = new AddMemberUI();
				addmember.setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton_1.setBounds(257, 206, 108, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel Time = new JLabel("");
		Time.setFont(new Font("新細明體", Font.BOLD, 18));
		Time.setBounds(307, 261, 157, 27);
		contentPane.add(Time);
		
		Timer timer = new Timer(1000, e -> {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String currentTime = sdf.format(new Date());
		Time.setText(currentTime);
				
		});
		timer.start();
		
		JCheckBox showpassword = new JCheckBox("顯示密碼");
		showpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(password.getEchoChar() == (char)0) {
					password.setEchoChar('*');
					showpassword.setText("顯示密碼");
				}else {
					password.setEchoChar((char)0);
					showpassword.setText("隱藏密碼");
				}
				
			}
		});
		showpassword.setFont(new Font("新細明體", Font.BOLD, 14));
		showpassword.setBounds(322, 149, 95, 27);
		contentPane.add(showpassword);
		
		
	}
}
