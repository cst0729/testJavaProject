package test;


import java.awt.EventQueue;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//public class ProductList extends JFrame {
 class ProductList1 extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTextField tfProdNo;
	private JTextField tfAddress;
	private JTextField tfProdName;
	private JTextField tfCompany;
	private JTextField tfProdDate;
	private JTextField tfDay;
	private JTextField tfPrice;
	private JTable table;
	
	private ProductDTO1 dto;
	private ProductDAO1 dao;
	private Vector<String> col;
	private DefaultTableModel model;
	private JButton btnSearch;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblNewLabel_9;
	private JTextField tfAmount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList1 frame = new ProductList1();
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
	 //ProductList() {
	public ProductList1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 215, 615, 180);
		contentPane.add(scrollPane);
		
		
		dao=new ProductDAO1();
		
		col=new Vector<String>();
		col.add("상품번호");
		col.add("지점명");
		col.add("상품명");
		col.add("제조사");
		col.add("생산일자");
		col.add("입고일자");
		col.add("단가");
		col.add("판매수량");
		col.add("총가격");
		
		list();
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				int idx=table.getSelectedRow();
				
				tfProdNo.setEditable(false);
				tfProdNo.setText(table.getValueAt(idx, 0)+"");
				
				tfAddress.setText(table.getValueAt(idx, 1)+"");
				tfProdName.setText(table.getValueAt(idx, 2)+"");
				tfCompany.setText(table.getValueAt(idx, 3)+"");
				tfProdDate.setText(table.getValueAt(idx, 4)+"");
				tfDay.setText(table.getValueAt(idx, 5)+"");
				tfPrice.setText(table.getValueAt(idx, 6)+"");
				tfAmount.setText(table.getValueAt(idx, 7)+"");
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("찾으시는 상품명을 입력하세요 ->");
		lblNewLabel.setBounds(12, 10, 203, 15);
		contentPane.add(lblNewLabel);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfSearch.setBounds(227, 7, 116, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("상품정보입력");
		lblNewLabel_1.setBounds(12, 61, 97, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("상품번호");
		lblNewLabel_2.setBounds(12, 101, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfProdNo = new JTextField();
		tfProdNo.setBounds(81, 98, 116, 21);
		contentPane.add(tfProdNo);
		tfProdNo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("지점명");
		lblNewLabel_3.setBounds(12, 126, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(81, 123, 116, 21);
		contentPane.add(tfAddress);
		tfAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("상품명");
		lblNewLabel_4.setBounds(12, 151, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		tfProdName = new JTextField();
		tfProdName.setBounds(81, 148, 116, 21);
		contentPane.add(tfProdName);
		tfProdName.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("제조사");
		lblNewLabel_5.setBounds(12, 176, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		tfCompany = new JTextField();
		tfCompany.setBounds(81, 173, 116, 21);
		contentPane.add(tfCompany);
		tfCompany.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("생산일자");
		lblNewLabel_6.setBounds(227, 101, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		tfProdDate = new JTextField();
		tfProdDate.setBounds(296, 98, 116, 21);
		contentPane.add(tfProdDate);
		tfProdDate.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("입고일자");
		lblNewLabel_7.setBounds(227, 126, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		tfDay = new JTextField();
		tfDay.setBounds(296, 123, 116, 21);
		contentPane.add(tfDay);
		tfDay.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("단가");
		lblNewLabel_8.setBounds(227, 151, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(296, 148, 116, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		lblNewLabel_9 = new JLabel("판매수량");
		lblNewLabel_9.setBounds(227, 176, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(296, 173, 116, 21);
		contentPane.add(tfAmount);
		tfAmount.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(355, 6, 97, 23);
		contentPane.add(btnSearch);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				input();
				
				int result=dao.insertProduct(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(ProductList1.this, "저장되었습니다.");
					
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnSave.setBounds(459, 97, 97, 23);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				input();
				
				int result=dao.updateProduct(dto);
				
				if(result==1) {
					JOptionPane.showMessageDialog(ProductList1.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(459, 122, 97, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String prod_no=tfProdNo.getText();
				int result=0;
				int response=JOptionPane.showConfirmDialog(ProductList1.this, "삭제하시겠습니까?");
				
				if(response==JOptionPane.YES_OPTION) {
					result=dao.deleteProduct(prod_no);
				}
				if(result==1) {
					JOptionPane.showMessageDialog(ProductList1.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnDelete.setBounds(459, 147, 97, 23);
		contentPane.add(btnDelete);
		
	}
	public void search() {
		String prod_name=tfSearch.getText();
		model=new DefaultTableModel(dao.searchProduct(prod_name),col) {
			public boolean isCellEditable(int row, int column) {
				return false;
				
			}
		};
		table.setModel(model);
	}
	
	public void input() {
		String prod_no=tfProdNo.getText();
		String address=tfAddress.getText();
		String prod_name=tfProdName.getText();
		String company=tfCompany.getText();
		String prod_date=tfProdDate.getText();
		String day=tfDay.getText();
		int price=Integer.parseInt(tfPrice.getText());
		int amount=Integer.parseInt(tfAmount.getText());
		dto=new ProductDTO1(prod_no, address, prod_name, company, prod_date, day, price, amount);
	
	}
	public void clear() {
		tfProdNo.setText("");
		tfAddress.setText("");
		tfProdName.setText("");
		tfCompany.setText("");
		tfProdDate.setText("");
		tfDay.setText("");
		tfPrice.setText("");
		tfProdNo.requestFocus();
		tfProdNo.setEditable(true);
	}
	
	public void list() {
		model=new DefaultTableModel(dao.listProduct(), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}

