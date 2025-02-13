package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.JScrollPane;

public class FinishUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private PorderServiceImpl porderService = new PorderServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishUI frame = new FinishUI();
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
	public FinishUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂單明細",JLabel.CENTER);
		lblNewLabel.setBounds(10, 10, 440, 34);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("離開");
		btnNewButton.setBounds(311, 300, 139, 39);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 440, 236);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 22));
		
		
		String orderDetails = porderService.AllPorder2();
		textArea.setText(orderDetails);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tool.gotoPorderManager();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton_1.setBounds(162, 300, 139, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("列印");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					textArea.print();
				} catch (PrinterException P) {
					P.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton_2.setBounds(10, 300, 139, 39);
		contentPane.add(btnNewButton_2);
	}
}
