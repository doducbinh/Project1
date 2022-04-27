import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Group extends JFrame {

	private JPanel contentPane;
	private JTextField txtmasp;
	private JTextField txttensp;
	private JTextField txtsl;
	private JTextField txtdg;
	
	JLabel lbltt = new JLabel("");
	JComboBox comboBox = new JComboBox();
	private JTable table;
	
	Vector Vtieude=new Vector(); 
	Vector Vndung=new Vector(); 
	Vector Vdong;
	float tt=0;
	DefaultTableModel dtm=new DefaultTableModel();
	
	void Tieude() {
		Vtieude.add("Mã sp");
		Vtieude.add("Tên sp");
		Vtieude.add("Loại sp");
		Vtieude.add("Khuyến mãi");
		Vtieude.add("Số lượng");
		Vtieude.add("Đơn giá");
		Vtieude.add("Thành tiền");
		
	}
	void Nhap(SANPHAM SP) {
		Vdong=new Vector();
		Vdong.add(SP.getMsp());
		Vdong.add(SP.getTensp());
		if(comboBox.getSelectedIndex()==0) {
			Vdong.add("Điện thoại");
			Vdong.add("20%");
		}
		if(comboBox.getSelectedIndex()==1) {
			Vdong.add("Điện máy");
			Vdong.add("10%");
		}
		Vdong.add(SP.getSoluong());
		Vdong.add(SP.getDongia());
		Vdong.add(SP.tinhtien());
		Vndung.add(Vdong);
		tt+=SP.tinhtien();
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Group frame = new Group();
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
	public Group() {
		Tieude();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   S\u1EA2N PH\u1EA8M");
		lblNewLabel.setBounds(10, 35, 118, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.BLACK);
		contentPane.add(lblNewLabel);
		comboBox.setBounds(28, 88, 135, 37);
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0110i\u1EC7n tho\u1EA1i", "\u0110i\u1EC7n m\u00E1y"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 sp");
		lblNewLabel_1.setBounds(186, 88, 73, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1);
		
		txtmasp = new JTextField();
		txtmasp.setBounds(279, 98, 189, 27);
		contentPane.add(txtmasp);
		txtmasp.setColumns(10);
		
		txttensp = new JTextField();
		txttensp.setBounds(279, 144, 189, 29);
		txttensp.setColumns(10);
		contentPane.add(txttensp);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn sp");
		lblNewLabel_1_1.setBounds(186, 136, 73, 37);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1);
		
		txtsl = new JTextField();
		txtsl.setBounds(279, 194, 189, 27);
		txtsl.setColumns(10);
		contentPane.add(txtsl);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1_1_1.setBounds(186, 184, 73, 37);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_1_1_2.setBounds(186, 232, 73, 37);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1_2);
		
		txtdg = new JTextField();
		txtdg.setBounds(279, 242, 189, 27);
		txtdg.setColumns(10);
		contentPane.add(txtdg);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.setBounds(57, 299, 118, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SANPHAM s=null;
				String masp=txtmasp.getText();
				String tensp=txttensp.getText();
				float sl=Float.parseFloat(txtsl.getText());
				float dg=Float.parseFloat(txtdg.getText());
				if(comboBox.getSelectedIndex()==0) {
					s=new DIENTHOAI(masp,tensp,sl,dg);
				}
				if(comboBox.getSelectedIndex()==1) {
					s=new DIENMAY(masp,tensp,sl,dg);
				}
				lbltt.setText(""+tt);
					Nhap(s);
					dtm.setDataVector(Vndung,Vtieude);
					table.setModel(dtm);
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xo\u00E1");
		btnNewButton_1.setBounds(217, 299, 118, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtdg.setText("");
				txtmasp.setText("");
				txtsl.setText("");
				txttensp.setText("");
				Vdong.clear();
				dtm.setDataVector(Vdong, Vtieude);
				table.setModel(dtm);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton_1);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setBounds(369, 299, 118, 37);
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnThot);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 381, 633, 124);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 sp", "T\u00EAn sp", "Lo\u1EA1i sp", "S\u1ED1 l\u01B0\u1EE3ng", "Khuy\u1EBFn m\u00E3i", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_2 = new JLabel("T\u1ED5ng th\u00E0nh ti\u1EC1n");
		lblNewLabel_1_2.setBounds(217, 516, 135, 37);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_2);
		lbltt.setBounds(398, 516, 155, 37);
		
		
		lbltt.setForeground(Color.RED);
		lbltt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbltt);
	}
}
