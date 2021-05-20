package menu;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JPanel {
  private static final long serialVersionUID = 1L;

  JButton btn = new JButton(");

  JButton back = new JButton(");

  JButton meaning = new JButton(");

  JButton japanese = new JButton(");

  MainFrame mf;

  String str;

  JPanel jp = this;

  public Test(MainFrame m, final String s) {
    this.mf = m;
    this.str = s;
    setName(s);
    setLayout((LayoutManager)null);
    setSize(900, 600);
    JLabel paneltitle = new JLabel();
    if (s == this.mf.PanelNames[5]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[7]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[8]) {
      paneltitle = new JLabel(", 0);
    }
    paneltitle.setFont(new Font("MS , 1, 30));
    paneltitle.setBounds(110, -50, 689, 180);
    add(paneltitle);
    if (s == this.mf.PanelNames[5]) {
      this.japanese.setFont(new Font("MS , 1, 20));
      this.japanese.setBounds(300, 200, 300, 50);
      this.japanese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Test.this.ExamJapanese();
            }
          });
      add(this.japanese);
      this.meaning.setFont(new Font("MS , 1, 20));
      this.meaning.setBounds(300, 300, 300, 50);
      this.meaning.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Test.this.ExamMeaning();
            }
          });
      add(this.meaning);
    }
    this.btn.setBounds(0, 0, 100, 40);
    this.btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Test.this.toHome(s);
          }
        });
    add(this.btn);
    this.back.setBounds(100, 0, 100, 40);
    this.back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            if (s == Test.this.mf.PanelNames[7] || s == Test.this.mf.PanelNames[8] || s == Test.this.mf.PanelNames[9] || s == Test.this.mf.PanelNames[10]) {
              Test.this.backTest(s);
            } else {
              Test.this.back();
            }
          }
        });
    add(this.back);
  }

  public void toHome(String s) {
    if (s == this.mf.PanelNames[5]) {
      CloseFunctionTest(this.jp);
    } else if (s == this.mf.PanelNames[7]) {
      CloseTestMeaning(this.jp);
    } else if (s == this.mf.PanelNames[8]) {
      CloseTestJapanese(this.jp);
    } else if (s == this.mf.PanelNames[9]) {
      this.mf.CloseTestNext(this.jp);
    } else if (s == this.mf.PanelNames[10]) {
      this.mf.CloseTestResult(this.jp);
    }
    this.mf.OpenHome();
  }

  public void back() {
    CloseFunctionTest(this.jp);
    if (MainFrame.i == 1) {
      this.mf.OpenCourseInfomation();
    } else if (MainFrame.i == 2) {
      this.mf.OpenCourseAlgorithm();
    } else if (MainFrame.i == 3) {
      this.mf.OpenCourseCompiler();
    }
  }

  public void backTest(String s) {
    if (s == this.mf.PanelNames[7]) {
      this.mf.CloseTestMeaning(this.jp);
    } else if (s == this.mf.PanelNames[8]) {
      this.mf.CloseTestJapanese(this.jp);
    } else if (s == this.mf.PanelNames[9]) {
      this.mf.CloseTestNext(this.jp);
    } else if (s == this.mf.PanelNames[10]) {
      this.mf.CloseTestResult(this.jp);
    }
    this.mf.OpenFunctionTest();
  }

  public void ExamMeaning() {
    CloseFunctionTest(this.jp);
    this.mf.OpenTestMeaning();
  }

  public void ExamJapanese() {
    CloseFunctionTest(this.jp);
    this.mf.OpenTestJapanese();
  }

  public void CloseFunctionTest(JPanel jp) {
    this.mf.sp5 = (Test)jp;
    this.mf.sp5.setVisible(false);
  }

  public void CloseTestMeaning(JPanel jp) {
    this.mf.sp7.remove(this.mf.changetitle);
    this.mf.sp7.remove(this.mf.changeans1);
    this.mf.sp7.remove(this.mf.changeans2);
    this.mf.sp7.remove(this.mf.changeans3);
    this.mf.sp7.remove(this.mf.changeans4);
    this.mf.sp7 = (Test)jp;
    this.mf.sp7.setVisible(false);
  }

  public void CloseTestJapanese(JPanel jp) {
    this.mf.sp8.remove(this.mf.changetitle);
    this.mf.sp8.remove(this.mf.changeans1);
    this.mf.sp8.remove(this.mf.changeans2);
    this.mf.sp8.remove(this.mf.changeans3);
    this.mf.sp8.remove(this.mf.changeans4);
    this.mf.sp8 = (Test)jp;
    this.mf.sp8.setVisible(false);
  }

  public void MRandW() {
    CloseTestMeaning(this.mf.sp7);
    this.mf.OpenTestNext(this.mf.sp7);
  }

  public void JRandW() {
    CloseTestJapanese(this.mf.sp8);
    this.mf.OpenTestNext(this.mf.sp8);
  }
}
