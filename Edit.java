package menu;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Edit extends JPanel {
  private static final long serialVersionUID = 1L;

  JButton btn = new JButton(");

  JButton back = new JButton(");

  JButton add;

  JButton delete;

  JButton update;

  JButton UpdateWord;

  JButton UpdateJapanese;

  JButton UpdateMeaning;

  JButton UpdateFrequency;

  MainFrame mf;

  String str;

  JPanel jp = this;

  public Edit(MainFrame m, final String s) {
    this.mf = m;
    this.str = s;
    setName(s);
    setLayout((LayoutManager)null);
    setSize(900, 600);
    JLabel paneltitle = new JLabel();
    JLabel panelWord = new JLabel(");
    JLabel panelJapanese = new JLabel(");
    JLabel panelMeaning = new JLabel(");
    JLabel panelFrequency = new JLabel(");
    if (s == this.mf.PanelNames[6]) {
      paneltitle = new JLabel(", 0);
      this.add = new JButton(");
      this.add.setFont(new Font("MS , 1, 20));
      this.add.setBounds(300, 150, 300, 50);
      this.add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Edit.this.MoveEditCourse(Edit.this.mf.PanelNames[11]);
            }
          });
      add(this.add);
      this.delete = new JButton(");
      this.delete.setFont(new Font("MS , 1, 20));
      this.delete.setBounds(300, 235, 300, 50);
      this.delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Edit.this.MoveEditCourse(Edit.this.mf.PanelNames[12]);
            }
          });
      add(this.delete);
      this.update = new JButton(");
      this.update.setFont(new Font("MS , 1, 20));
      this.update.setBounds(300, 320, 300, 50);
      this.update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Edit.this.MoveEditCourse(Edit.this.mf.PanelNames[13]);
            }
          });
      add(this.update);
    } else if (s == this.mf.PanelNames[11]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[12]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[13]) {
      paneltitle = new JLabel(", 0);
    } else if (s == this.mf.PanelNames[14]) {
      paneltitle = new JLabel(", 0);
      panelJapanese.setFont(new Font("MS , 1, 20));
      panelJapanese.setBounds(210, 90, 689, 180);
      add(panelJapanese);
      panelMeaning.setFont(new Font("MS , 1, 20));
      panelMeaning.setBounds(250, 190, 689, 180);
      add(panelMeaning);
      panelFrequency.setFont(new Font("MS , 1, 20));
      panelFrequency.setBounds(250, 290, 689, 180);
      add(panelFrequency);
    } else if (s == this.mf.PanelNames[15]) {
      paneltitle = new JLabel(", 0);
      paneltitle.setFont(new Font("MS , 1, 30));
      paneltitle.setBounds(110, 0, 689, 180);
      add(paneltitle);
      panelWord.setFont(new Font("MS , 1, 20));
      panelWord.setBounds(250, 90, 689, 180);
      add(panelWord);
      panelJapanese.setFont(new Font("MS , 1, 20));
      panelJapanese.setBounds(210, 170, 689, 180);
      add(panelJapanese);
      panelMeaning.setFont(new Font("MS , 1, 20));
      panelMeaning.setBounds(250, 250, 689, 180);
      add(panelMeaning);
      panelFrequency.setFont(new Font("MS , 1, 20));
      panelFrequency.setBounds(250, 330, 689, 180);
      add(panelFrequency);
    }
    paneltitle.setFont(new Font("MS , 1, 30));
    paneltitle.setBounds(110, 0, 689, 180);
    add(paneltitle);
    this.btn.setBounds(50, 450, 100, 40);
    this.btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Edit.this.toHome();
          }
        });
    add(this.btn);
    this.back.setBounds(150, 450, 100, 40);
    this.back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            if (s == Edit.this.mf.PanelNames[14]) {
              Edit.this.backAdd();
            } else if (s == Edit.this.mf.PanelNames[11] || s == Edit.this.mf.PanelNames[12] || s == Edit.this.mf.PanelNames[13] || s == Edit.this.mf.PanelNames[15]) {
              Edit.this.backEdit();
            } else {
              Edit.this.back();
            }
          }
        });
    add(this.back);
  }

  public void toHome() {
    if (this.str == this.mf.PanelNames[6])
      CloseFunctionEdit(this.jp);
    if (this.str == this.mf.PanelNames[11]) {
      this.mf.CloseEditAdd(this.jp);
    } else if (this.str == this.mf.PanelNames[12]) {
      this.mf.CloseEditDelete(this.jp);
    } else if (this.str == this.mf.PanelNames[13]) {
      this.mf.CloseEditUpdata(this.jp);
    } else if (this.str == this.mf.PanelNames[14]) {
      this.mf.CloseEditAddNewWord(this.jp);
    } else if (this.str == this.mf.PanelNames[15]) {
      this.mf.CloseEditWordDetail(this.jp);
    }
    this.mf.OpenHome();
  }

  public void back() {
    CloseFunctionEdit(this.jp);
    this.str = this.mf.PanelNames[MainFrame.i];
    this.mf.OpenFunctionWordList();
  }

  public void backAdd() {
    this.mf.CloseEditAddNewWord(this.jp);
    this.mf.OpenFunctionEdit();
  }

  public void backEdit() {
    if (this.str == this.mf.PanelNames[11]) {
      this.mf.CloseEditAdd(this.jp);
    } else if (this.str == this.mf.PanelNames[12]) {
      this.mf.CloseEditDelete(this.jp);
    } else if (this.str == this.mf.PanelNames[13]) {
      this.mf.CloseEditUpdata(this.jp);
    } else if (this.str == this.mf.PanelNames[15]) {
      this.mf.CloseEditWordDetail(this.jp);
    }
    this.mf.OpenFunctionEdit();
  }

  public void MoveEditCourse(String str) {
    CloseFunctionEdit(this.jp);
    if (str == this.mf.PanelNames[11]) {
      this.mf.OpenEditAdd(str);
    } else if (str == this.mf.PanelNames[12]) {
      this.mf.OpenEditDelete(str);
    } else if (str == this.mf.PanelNames[13]) {
      this.mf.OpenEditUpdata(str);
    }
  }

  public void CloseFunctionEdit(JPanel jp) {
    this.mf.sp6 = (Edit)jp;
    this.mf.sp6.setVisible(false);
  }
}
