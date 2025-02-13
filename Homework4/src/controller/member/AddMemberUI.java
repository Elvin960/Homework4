package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.Color;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新建會員資料",JLabel.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 10, 416, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(51, 72, 65, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(51, 139, 65, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼：");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(51, 198, 65, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址：");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(51, 263, 65, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話：");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(51, 333, 65, 32);
		contentPane.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(126, 76, 183, 27);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(126, 143, 183, 27);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(126, 208, 183, 27);
		contentPane.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(126, 273, 183, 27);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(126, 338, 183, 27);
		contentPane.add(phone);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username = username.getText();
				String PPassword = password.getText();
				
				String usernamePattern = "^[a-zA-Z0-9]{4,10}$";
		        if (!Pattern.matches(usernamePattern, Username)) {
		            JOptionPane.showMessageDialog(null, "帳號錯誤！請輸入 4 到 10 的英文與數字組合。", "錯誤", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }
		        
		        String passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,}$";
		        if (!Pattern.matches(passwordPattern, PPassword)) {
		            JOptionPane.showMessageDialog(null, "密碼錯誤！請輸入至少 4 個字，並包含至少一個英文和一個數字。", "錯誤", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		     
				
				if(new MemberServiceImpl().isUsernameBeenUse(Username))
				{
					AddMemberErrorUI addmembererror=new AddMemberErrorUI();
					addmembererror.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					
					Member member = new Member(Name,Username,Password,Address,Phone);
					
					new MemberServiceImpl().addMember(member);
					
					JOptionPane.showMessageDialog(null, "註冊成功！", "註冊成功", JOptionPane.INFORMATION_MESSAGE);
					
					LoginUI login=new LoginUI();
					login.setVisible(true);
					
//					AddMemberSuccessUI addmembersuccess=new AddMemberSuccessUI();
//					addmembersuccess.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.setBounds(149, 405, 146, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_5 = new JLabel("4到10個字，包含英文與數字");
		lblNewLabel_1_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_5.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(126, 180, 199, 18);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("至少4個字，包含英文與數字");
		lblNewLabel_1_5_1.setForeground(Color.RED);
		lblNewLabel_1_5_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBounds(126, 245, 199, 18);
		contentPane.add(lblNewLabel_1_5_1);
	}
}
