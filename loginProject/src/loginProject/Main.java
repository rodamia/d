package loginProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btn1) {
			Membership m = new Membership();
			m.membership();
			m.setBounds(200, 400, 400, 400);
			m.setResizable(false); // 프레임의 사이즈를 조절할수 없게 한다.(고정되게..함)
			m.setVisible(true);
		} else if (e.getSource() == btn2) {
			Login lg = new Login();
			lg.Login();
		}

	}

	JFrame jf = new JFrame();
	JButton btn1 = new JButton("회원가입");
	JButton btn2 = new JButton("로그인");
	JPanel jp = new JPanel();

	public Main() {

		jp.setLayout(new FlowLayout(FlowLayout.CENTER)); // jp의 레이아웃을 보더 레이아웃으로 설정했다.
		jf.add(jp);
		jp.add(btn1);
		jp.add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		jp.setSize(400, 400);
		jf.setSize(400, 400);
		jf.setVisible(true);

	}

	public static void main(String[] args) {
		new Main();
		
	}
}