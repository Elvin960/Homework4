package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField updateId;
	private JTextField blackcoffee;
	private JTextField cappuccino;
	private JTextField mocha;
	private JTextField deleteId;
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
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
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 10, 414, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 394, 101);
		panel.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 169, 414, 115);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 23, 24);
		panel_1.add(lblNewLabel);
		
		updateId = new JTextField();
		updateId.setBounds(89, 12, 96, 21);
		panel_1.add(updateId);
		updateId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("黑咖啡");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 44, 54, 24);
		panel_1.add(lblNewLabel_1);
		
		blackcoffee = new JTextField();
		blackcoffee.setColumns(10);
		blackcoffee.setBounds(89, 43, 96, 21);
		panel_1.add(blackcoffee);
		
		JLabel lblNewLabel_2 = new JLabel("卡布奇諾");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(226, 10, 72, 24);
		panel_1.add(lblNewLabel_2);
		
		cappuccino = new JTextField();
		cappuccino.setColumns(10);
		cappuccino.setBounds(308, 12, 96, 21);
		panel_1.add(cappuccino);
		
		JLabel lblNewLabel_3 = new JLabel("摩卡");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(226, 44, 41, 24);
		panel_1.add(lblNewLabel_3);
		
		mocha = new JTextField();
		mocha.setColumns(10);
		mocha.setBounds(308, 46, 96, 21);
		panel_1.add(mocha);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(10, 294, 414, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Id");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 10, 23, 24);
		panel_2.add(lblNewLabel_4);
		
		deleteId = new JTextField();
		deleteId.setColumns(10);
		deleteId.setBounds(89, 12, 96, 21);
		panel_2.add(deleteId);
		
		JButton btnNewButton_1_1 = new JButton("刪除");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id=Integer.parseInt(deleteId.getText());
				porderserviceimpl.deletePorderById(Id);
				
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(317, 11, 87, 23);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				output.setText(porderserviceimpl.AllPorder());
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton.setBounds(317, 121, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("匯出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					output.print();
				} catch (PrinterException P) {
					P.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton_2.setBounds(220, 121, 87, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id=Integer.parseInt(updateId.getText());
				int Blackcoffee=Integer.parseInt(blackcoffee.getText());
				int Cappuccino=Integer.parseInt(cappuccino.getText());
				int Mocha=Integer.parseInt(mocha.getText());
				
				porderserviceimpl.updatePorder(Blackcoffee,Cappuccino,Mocha,Id);
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton_1.setBounds(317, 82, 87, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1 = new JButton("回主選單");
		btnNewButton_1_1_1.setBounds(152, 349, 130, 29);
		contentPane.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
	}
}
