package loginProject;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;

import loginProject.Member;

class InputScore extends JFrame implements ActionListener {
	TextField ID, korean, Math, History;
	TextArea prt;
	Button inserbtn, searchbtn;
	JLabel jl, jl2, jl3, jl4;

	public void input() {
		setLayout(new FlowLayout());
		setTitle("점수 입력");

		ID = new TextField(15);
		korean = new TextField(3);
		Math = new TextField(3);
		History = new TextField(3);

		jl = new JLabel("ID");
		jl2 = new JLabel("korean");
		jl3 = new JLabel("Math");
		jl4 = new JLabel("History");

		inserbtn = new Button("insert");
		inserbtn.addActionListener(this);

		add(jl);
		add(ID);
		add(jl2);
		add(korean);
		add(jl3);
		add(Math);
		add(jl4);
		add(History);
		add(inserbtn);
	}

	public void score() {
		setLayout(new FlowLayout());
		setTitle("점수 입력");

		ID = new TextField(15);
		jl = new JLabel("ID");
		prt = new TextArea();

		searchbtn = new Button("search");
		searchbtn.addActionListener(this);

		add(jl);
		add(ID);
		add(searchbtn);
		add(prt);
	}


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == inserbtn) {
			try {
				FileWriter fw = new FileWriter("C:\\member\\" + ID.getText() + ".txt", true); // 파일명과 같은 파일명이 존재할시 //
																								// // 덧붙여쓸여부판단
				BufferedWriter bf = new BufferedWriter(fw);
				
				bf.write(korean.getText() + "\n");
				bf.write(Math.getText() + "\n");
				bf.write(History.getText() + "\n");//

				bf.close(); // 저장 후 텍스트필드의 값을 가져온 자원들을 해제한다.
				Member m = new Member();
				// System.exit(0);
				m.member();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (ae.getSource() == searchbtn) {
			try {
				FileReader fr = new FileReader("C:\\member\\" + ID.getText() + ".txt");
				BufferedReader br = new BufferedReader(fr); // 한줄씩읽기위해(그리고 빠른속도로 읽어들인다)
				String score = null; // while조건부
				int lineNum = 0;

				// String[] score = new String[5];
				while ((score = br.readLine()) != null) {
					lineNum++;
					if (lineNum >= 7 && lineNum <= 10) {
						prt.append(score + "\n");
					}
					if (lineNum == 10) {
						br.close();// 읽어온 자원들을 해제한다.
						setVisible(true);
						break;
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// String형으로 파일을 읽어온다.
			}
		}
	}
}