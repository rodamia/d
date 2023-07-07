package loginProject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Member extends JFrame implements ActionListener {
	JFrame f = new JFrame();
	JPanel jp = new JPanel();
	JButton inputBtn = new JButton("점수입력");
	JButton scorBtn = new JButton("점수 확인");

	public void member() {
		f.setTitle("Member Information");
		f.setLayout(new FlowLayout());
		jp.setLayout(new GridLayout(1, 2, 30, 30));
		f.add(jp);
		jp.add(inputBtn);
		jp.add(scorBtn);

		inputBtn.addActionListener(this);
		scorBtn.addActionListener(this);

		f.setSize(300, 300);
		f.setLocation(100, 200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Member m = new Member();
		m.member();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		InputScore i = new InputScore();// InputScore의 메소드 사용하기 위한 객체(생성자)
		if (e.getSource() == inputBtn) {
			i.setBounds(200, 200, 250, 300);//
			i.setVisible(true);
			i.input();
			//dispose();
			
		} else if (e.getSource() == scorBtn) {
//	         e.paramString();
			i.setBounds(200, 200, 250, 300);// input()을 사용하기 위해서 화면 이루는 코드를 여기에 적음.
			i.setVisible(true);
			i.score();
			//dispose();
		}
	}
}