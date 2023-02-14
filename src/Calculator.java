import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JPanel panel;
	JTextField textField;
	
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton dotButton,equButton,delButton,CButton,negButton;
	
	Font myFont = new Font("Bodoni",Font.BOLD,20);
	Font TextFont = new Font("Helvetica",Font.BOLD,40);
	
	ImageIcon DelIcon = new ImageIcon(new ImageIcon("images.png")
			.getImage()
			.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame("calculator"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(50,25,300,50);
		textField.setFont(TextFont);
		textField.setEditable(false);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		dotButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton(DelIcon);
		CButton = new JButton("C");
		negButton = new JButton("-/+");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = dotButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = CButton;
		functionButtons[8] = negButton;
				
		for(int i=0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int i=0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		divButton.setContentAreaFilled(false);
		divButton.setBounds(282,120,67,50);
		CButton.setContentAreaFilled(false);
		CButton.setBounds(51,120,144,50);
		delButton.setContentAreaFilled(false);
		delButton.setBounds(205,120,67,50);
		
		panel = new JPanel();
		panel.setBounds(50,175,300,200);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.black);
		panel.add(numberButtons[7]).setBackground(Color.white);
		panel.add(numberButtons[8]).setBackground(Color.white);
		panel.add(numberButtons[9]).setBackground(Color.white);
		panel.add(addButton)	   .setBackground(Color.white);
		panel.add(numberButtons[4]).setBackground(Color.white);
		panel.add(numberButtons[5]).setBackground(Color.white);
		panel.add(numberButtons[6]).setBackground(Color.white);
		panel.add(subButton)	   .setBackground(Color.white);
		panel.add(numberButtons[1]).setBackground(Color.white);
		panel.add(numberButtons[2]).setBackground(Color.white);
		panel.add(numberButtons[3]).setBackground(Color.white);
		panel.add(mulButton)       .setBackground(Color.white);
		panel.add(negButton)       .setBackground(Color.white);
		panel.add(numberButtons[0]).setBackground(Color.white);
		panel.add(dotButton)       .setBackground(Color.white);
		panel.add(equButton)       .setBackground(Color.white);
		
		
		
		frame.add(panel);	
		frame.add(divButton);
		frame.add(delButton);
		frame.add(CButton);
		frame.add(textField);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Calculator Calc = new Calculator();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==dotButton) {
			textField.setText(textField.getText().concat("."));
				
			}
		
		if(e.getSource()==addButton) {
			num1= Double.parseDouble(textField.getText());
			operator='+';
			textField.setText("");
		}
	
		if(e.getSource()==subButton) {
		num1= Double.parseDouble(textField.getText());
		operator='-';
		textField.setText("");
	}
		if(e.getSource()==mulButton) {
			num1= Double.parseDouble(textField.getText());
			operator='*';
			textField.setText("");
		}
		if(e.getSource()==divButton) {
			num1= Double.parseDouble(textField.getText());
			operator='/';
			textField.setText("");
		}
		if(e.getSource()==equButton) {
			num2= Double.parseDouble(textField.getText());
			switch(operator) {
			case'+':
				result=num1+num2; 
				break;
			case'-':
				result=num1-num2; 
				break;
			case'*':
				result=num1*num2; 
				break;	
			case'/':
				result=num1/num2; 
				break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
			
		}
			if(e.getSource()==CButton) {
				textField.setText("");
		}
			if(e.getSource()==delButton) {
				String string = textField.getText();
				textField.setText("");
				for(int i=0;i<string.length()-1;i++) {
					textField.setText(textField.getText()+string.charAt(i));
				}
			}
			if(e.getSource()==negButton) {
				double temp = Double.parseDouble(textField.getText());
				temp*=-1;
				textField.setText(String.valueOf(temp));
		}
		
	}
}

