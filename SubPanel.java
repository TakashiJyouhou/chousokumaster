package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubPanel extends JPanel {
  private static final long serialVersionUID = 1L;

  JButton btn = new JButton(");

  JButton list;

  JButton test;

  JButton edit;

  MainFrame mf;

  String str;

  JPanel jp = this;

  public SubPanel(MainFrame m, final String s) {
    this.mf = m;
    this.str = s;
    setName(s);
    setLayout((LayoutManager)null);
    setSize(900, 600);
    JLabel paneltitle = new JLabel(");
    if (s == this.mf.PanelNames[1]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[2]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[3]) {
      paneltitle = new JLabel(", 0);
    }
    paneltitle.setFont(new Font("MS , 1, 30));
    paneltitle.setForeground(Color.BLACK);
    paneltitle.setBounds(110, 0, 689, 180);
    add(paneltitle);
    this.btn.setBounds(50, 450, 100, 40);
    this.btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            SubPanel.this.toHome(s);
          }
        });
    add(this.btn);
    this.list = new JButton(");
    this.list.setFont(new Font("MS , 1, 20));
    this.list.setBounds(300, 220, 300, 50);
    this.list.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            SubPanel.this.PanelChangeToFunction(s, SubPanel.this.mf.PanelNames[4]);
          }
        });
    add(this.list);
    this.test = new JButton(");
    this.test.setFont(new Font("MS , 1, 20));
    this.test.setBounds(300, 320, 300, 50);
    this.test.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            SubPanel.this.PanelChangeToFunction(s, SubPanel.this.mf.PanelNames[5]);
          }
        });
    add(this.test);
  }

  public void toHome(String s) {
    if (s == this.mf.PanelNames[1]) {
      CloseCourseInfomation(this.jp);
    } else if (s == this.mf.PanelNames[2]) {
      CloseCourseAlgorithm(this.jp);
    } else if (s == this.mf.PanelNames[3]) {
      CloseCourseCompiler(this.jp);
    }
    this.mf.OpenHome();
  }

  public void BackGroundOfHome(URL url) {
    MediaTracker tracker = new MediaTracker(this);
    ImageIcon icon1 = new ImageIcon(url);
    Image bigImg = icon1.getImage().getScaledInstance((int)(icon1.getIconWidth() * 0.27D), -1, 4);
    tracker.addImage(bigImg, 1);
    ImageIcon bigIcon = new ImageIcon(bigImg);
    JLabel label1 = new JLabel(bigIcon);
    this.mf.add(label1);
    this.mf.changeBack = label1;
  }

  public void PanelChangeToFunction(String name, String str) {
    if (name == this.mf.PanelNames[1]) {
      CloseCourseInfomation(this.jp);
    } else if (name == this.mf.PanelNames[2]) {
      CloseCourseAlgorithm(this.jp);
    } else if (name == this.mf.PanelNames[3]) {
      CloseCourseCompiler(this.jp);
    }
    if (str == this.mf.PanelNames[4]) {
      this.mf.OpenFunctionWordList();
    } else if (str == this.mf.PanelNames[5]) {
      this.mf.OpenFunctionTest();
    }
  }

  public void CloseCourseInfomation(JPanel jp) {
    this.mf.remove(this.mf.changeBack);
    this.mf.sp = (SubPanel)jp;
    this.mf.sp.setVisible(false);
  }

  public void CloseCourseAlgorithm(JPanel jp) {
    this.mf.remove(this.mf.changeBack);
    this.mf.sp2 = (SubPanel)jp;
    this.mf.sp2.setVisible(false);
  }

  public void CloseCourseCompiler(JPanel jp) {
    this.mf.remove(this.mf.changeBack);
    this.mf.sp3 = (SubPanel)jp;
    this.mf.sp3.setVisible(false);
  }
}
