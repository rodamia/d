package loginProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

class Membership extends JFrame {

	TextField id, pw, name, yymmdd, email;

	void membership() {

		setTitle("회원 가입");

		// 1. 컴포넌트
		JLabel title = new JLabel("회원가입", JLabel.CENTER);

		JButton check = new JButton("ID 중복");
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton(" 취소 ");

		JRadioButton male = new JRadioButton("남자");
		JRadioButton female = new JRadioButton("여자");

		id = new TextField(25); // 15는 열 길이인듯
		pw = new TextField(25);
		name = new TextField(25);
		email = new TextField(25);

		// form panel
		// 아이디
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(id);
		// 비번
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwdPanel.add(new JLabel("비밀번호 : "));
		pwdPanel.add(pw);
		// 이름
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("이름 : "));
		namePanel.add(name);
		// 연도
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl yymmdd = new JDatePickerImpl(datePanel);

		JPanel yearPanel = new JPanel();
		yearPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		yearPanel.add(new JLabel("출생연도 : "));
		yearPanel.add(yymmdd);
		// 이메일
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		emailPanel.add(new JLabel("Email : "));
		emailPanel.add(email);
		// 성별

		JPanel radioPanel = new JPanel();
		radioPanel.add(new JLabel("성별 : "));
		radioPanel.add(male);
		radioPanel.add(female);

		// formPanel
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(6, 1));
		formPanel.add(idPanel);
		formPanel.add(pwdPanel);
		formPanel.add(namePanel);
		formPanel.add(yearPanel);
		formPanel.add(emailPanel);
		formPanel.add(radioPanel);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(formPanel);

		// button panel
		JPanel panel = new JPanel();
		panel.add(check);
		panel.add(join);
		panel.add(cancel);

		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

//		setBounds(200, 200, 250, 300);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {					
					
					if (isBlank()) {
						JOptionPane.showMessageDialog(Membership.this, "모든정보를  입력해주세여.");
						return;
					}
					// 파일 읽어오기
					FileReader fr = new FileReader("C:\\member\\" + id.getText() + ".txt");
					BufferedReader br = new BufferedReader(fr); // 한줄씩읽기위해(그리고 빠른속도로 읽어들인다)

					String str = br.readLine();
					// 아이디 중복검사
					if (str.contentEquals(id.getText())) {
						JOptionPane.showMessageDialog(Membership.this, "아이디가 중복되었습니다.");
						id.requestFocus();
						return;
					}

				} catch (Exception e1) {
					System.out.println(e1);
				}
				JOptionPane.showMessageDialog(Membership.this, "사용 가능한 아이디입니다.");
			}

			// 회원정보의 빈칸 예외처리 해주는 메소드
			private boolean isBlank() {

				boolean result = false;

				if (id.getText().isEmpty()) {
					id.requestFocus();
					return true;
				}
				if (pw.getText().isEmpty()) {
					pw.requestFocus();
					return true;
				}
				if (name.getText().isEmpty()) {
					name.requestFocus();
					return true;
				}
				if (email.getText().isEmpty()) {
					email.requestFocus();
					return true;
				}
				
				return result;
			}
			
		});		
		
		// 가입 버튼에 이벤트를 부여하고
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					//회원가입 버튼을 누르면 먼저 id 중복 검사하라는 선행작업
					//조건식을 어떻게 적어야할지 모르겠음
					/* if(!check.isSelected()) {
						JOptionPane.showMessageDialog(Membership.this, "ID 중복검사를 먼저 해주세요.");
						return;
					} */
					
					if (isBlank()) {
						JOptionPane.showMessageDialog(Membership.this, "모든정보를  입력해주세요.");
						return;
					}
					// 파일을 만들고 쓰여지게 해주는 코드
					FileWriter fw = new FileWriter("C:\\member\\" + id.getText() + ".txt"); // 파일명과 같은 파일명이 존재할시
																							// 덧붙여쓸여부판단
					BufferedWriter bf = new BufferedWriter(fw); // 입력하게 하는 BufferedWriter

					bf.write(id.getText() + "\n");
					bf.write(pw.getText() + "\n");
					bf.write(name.getText() + "\n");
					bf.write(model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay() + "\n");
					bf.write(email.getText() + "\n");
					if (male.isSelected()) {
						bf.write(male.getText() + "\n");
					} else if (female.isSelected()) {
						bf.write(female.getText() + "\n");
					} else {
						System.out.println("");
					}
					bf.close(); // 저장 후 텍스트필드의 값을 가져온 자원들을 해제한다.

				} catch (Exception n) {
					System.out.println(n);
				}
				JOptionPane.showMessageDialog(Membership.this, "회원가입이 완료 되었습니다.");
				
				new Main();
				dispose();

			}

			// 회원정보의 빈칸 예외처리 해주는 메소드
			private boolean isBlank() {

				boolean result = false;

				if (id.getText().isEmpty()) {
					id.requestFocus();
					return true;
				}
				if (pw.getText().isEmpty()) {
					pw.requestFocus();
					return true;
				}
				if (name.getText().isEmpty()) {
					name.requestFocus();
					return true;
				}
				if (email.getText().isEmpty()) {
					email.requestFocus();
					return true;
				}
				
				return result;
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Main();
				dispose();// 이것은 프레임과 그 위에 포함된 모든 컴포넌트를 OS에게 반납하고 처분
							// 되는 메소드
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Membership m = new Membership();
		m.membership();
		m.setBounds(200, 200, 400, 300);
		m.setResizable(false); // 프레임 고정
		m.setVisible(true); // 화면 띄우는 명령어
	}
	
}
