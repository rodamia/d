package loginProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login implements ActionListener {
	JFrame jf = new JFrame();
	JTextField id, pw;
	JButton btn;
	JLabel jl;

	void Login() {

		jf.setLocation(700, 400); // 내 화면의 가운데에 오게 위치값 잡아주기
		jf.setSize(380, 180);
		jf.setTitle("로그인");
		jf.setLayout(null);

		jl = new JLabel("아이디 : ");
		jl.setSize(80, 30);
		jl.setLocation(30, 30);
		jf.add(jl);

		id = new JTextField(15);
		id.setSize(120, 30);
		id.setLocation(110, 30);
		jf.add(id);

		jl = new JLabel("비밀번호 : ");
		jl.setSize(80, 30);
		jl.setLocation(30, 70);
		jf.add(jl);

		pw = new JTextField(15);
		pw.setSize(120, 30);
		pw.setLocation(110, 80);
		jf.add(pw);

		btn = new JButton("login");
		btn.addActionListener(this);
		jf.add(btn);
		btn.setSize(80, 30);
		btn.setLocation(280, 90);
		jf.setVisible(true);

	}

	public static void main(String[] args) {
		Login login = new Login();
		login.Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Member m = new Member();
		try {
			FileReader fr = new FileReader("C:\\member\\" + id.getText() + ".text");

			// String형으로 파일을 읽어온다.
			BufferedReader br = new BufferedReader(fr); // 한줄씩읽기위해(그리고 빠른속도로 읽어들인다)
			br.readLine(); // 이 코드로 첫번째 줄 읽는 것을 무시
			String str = br.readLine();// // 두번째 줄부터 변수로 담는다.
			if (str.contentEquals(pw.getText())) { // 두번째 줄부터 담은 br.readLine()에 pw.getText()가 들어있다라는것을 .contentEquals()를 써서 확인한 후 들어있으면  member()를 호출한다.
				m.member();
			} else {
				id.setText("");
				pw.setText("");
			}

		} catch (Exception e1) {
			id.setText("");
			pw.setText("");
			System.out.println(e1);
		}

	}
}
