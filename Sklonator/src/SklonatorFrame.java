import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SklonatorFrame extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -385559757180952496L;
	private JTextField inputTextField = new JTextField();
	private JTextArea outputTextArea = new JTextArea();
	private JButton button = new JButton("Склонять");

	public SklonatorFrame() 
	{
		super("Склонятор");
						
		button.addActionListener(this);
		
		inputTextField.setToolTipText("Введите слово");
				
		this.add(inputTextField, BorderLayout.NORTH);
		this.add(button, BorderLayout.SOUTH);
		this.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);
		
		this.setSize(400,600);
		this.setLocation(250, 100);
		this.setVisible(true);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		SklonatorAPI.getResults(inputTextField.getText());
	}
}
