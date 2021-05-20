package menu;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Word extends JPanel {
  private static final long serialVersionUID = 1L;

  JButton btn = new JButton(");

  JButton back = new JButton(");

  JButton list;

  JButton test;

  JButton edit;

  MainFrame mf;

  String str;

  JPanel jp = this;

  public Word(MainFrame m, String s) {
    this.mf = m;
    this.str = s;
    setName(s);
    setLayout((LayoutManager)null);
    setSize(900, 600);
    JLabel paneltitle = new JLabel(", 0);
    paneltitle.setFont(new Font("MS , 1, 30));
    paneltitle.setBounds(110, MainFrame.RelativeDiv - 50, 689, 180);
    add(paneltitle);
    this.btn.setBounds(50, 450, 100, 40);
    this.btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Word.this.toHome();
          }
        });
    add(this.btn);
    this.back.setBounds(150, 450, 100, 40);
    this.back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Word.this.back();
          }
        });
    add(this.back);
    this.edit = new JButton(");
    this.edit.setFont(new Font("MS , 1, 20));
    this.edit.setBounds(730, 450, 100, 40);
    this.edit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Word.this.PanelChangeToEdit(Word.this.mf.PanelNames[6]);
          }
        });
    add(this.edit);
  }

  public void toHome() {
    CloseFunctionWordList(this.jp);
    this.mf.OpenHome();
  }

  public void back() {
    CloseFunctionWordList(this.jp);
    if (MainFrame.i == 1) {
      this.mf.OpenCourseInfomation();
    } else if (MainFrame.i == 2) {
      this.mf.OpenCourseAlgorithm();
    } else if (MainFrame.i == 3) {
      this.mf.OpenCourseCompiler();
    }
  }

  public void PanelChangeToEdit(String str) {
    CloseFunctionWordList(this.jp);
    this.mf.OpenFunctionEdit();
  }

  public void CloseFunctionWordList(JPanel jp) {
    this.mf.sp4.remove(this.mf.changeSource);
    this.mf.sp4 = (Word)jp;
    this.mf.sp4.setVisible(false);
  }
}
