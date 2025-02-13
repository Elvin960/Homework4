package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField blackcoffee;
	private JTextField cappuccino;
	private JTextField mocha;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂購單",JLabel.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 10, 316, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("黑咖啡");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(54, 60, 69, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("卡布奇諾");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(54, 97, 84, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("摩卡");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(54, 134, 84, 27);
		contentPane.add(lblNewLabel_1_2);
		
		blackcoffee = new JTextField();
		blackcoffee.setBounds(148, 60, 44, 21);
		contentPane.add(blackcoffee);
		blackcoffee.setColumns(10);
		
		cappuccino = new JTextField();
		cappuccino.setColumns(10);
		cappuccino.setBounds(148, 97, 44, 21);
		contentPane.add(cappuccino);
		
		mocha = new JTextField();
		mocha.setColumns(10);
		mocha.setBounds(148, 134, 44, 21);
		contentPane.add(mocha);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=member.getName();
				int Blackcoffee=Integer.parseInt(blackcoffee.getText());
				int Cappuccino=Integer.parseInt(cappuccino.getText());
				int Mocha=Integer.parseInt(mocha.getText());
				
				Porder p=new Porder(Name,Blackcoffee,Cappuccino,Mocha);
				
				JOptionPane.showMessageDialog(null, "訂購成功");
				porderserviceimpl.addPorder(p);
				
				Tool.gotoFinish();
				dispose();

			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton.setBounds(54, 190, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回主選單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton_1.setBounds(182, 190, 103, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("NT65");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(223, 60, 69, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("NT85");
		lblNewLabel_1_3_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(223, 97, 69, 27);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("NT80");
		lblNewLabel_1_3_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_3_2.setBounds(223, 134, 69, 27);
		contentPane.add(lblNewLabel_1_3_2);
	}
}
