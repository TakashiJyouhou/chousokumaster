package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  private static final long serialVersionUID = 1L;

  JButton btn;

  JButton btn2;

  JButton btn3;

  JLabel paneltitle;

  MainFrame mf;

  String str;

  JPanel jp = this;

  public MainPanel(MainFrame m, String s) {
    this.mf = m;
    this.str = s;
    setName(s);
    setLayout((LayoutManager)null);
    setSize(900, 600);
    this.mf.setTitle(");
    this.paneltitle = new JLabel(", 0);
    this.paneltitle.setFont(new Font("MS Gothic", 1, 35));
    this.paneltitle.setOpaque(true);
    this.paneltitle.setForeground(Color.BLACK);
    this.paneltitle.setBackground(Color.WHITE);
    this.paneltitle.setBounds(215, 80, 481, 40);
    add(this.paneltitle);
    this.btn = new JButton(");
    this.btn.setFont(new Font("MS Gothic", 1, 20));
    this.btn.setBounds(300, 200, 300, 50);
    this.btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainPanel.this.mf.CloseHome(MainPanel.this.jp);
            MainPanel.this.mf.OpenCourseInfomation();
          }
        });
    add(this.btn);
    this.btn2 = new JButton(");
    this.btn2.setFont(new Font("MS Gothic", 1, 20));
    this.btn2.setBounds(300, 300, 300, 50);
    this.btn2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainPanel.this.mf.CloseHome(MainPanel.this.jp);
            MainPanel.this.mf.OpenCourseAlgorithm();
          }
        });
    add(this.btn2);
    this.btn3 = new JButton(");
    this.btn3.setFont(new Font("MS Gothic", 1, 20));
    this.btn3.setBounds(300, 400, 300, 50);
    this.btn3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainPanel.this.mf.CloseHome(MainPanel.this.jp);
            MainPanel.this.mf.OpenCourseCompiler();
          }
        });
    add(this.btn3);
  }
}
