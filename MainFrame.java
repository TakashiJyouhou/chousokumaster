package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MainFrame extends JFrame {
  private static final long serialVersionUID = 1L;

  static int datanum = 0;

  static int i = 0;

  int Correct = 0;

  int count = 0;

  int countCorrect = 0;

  static int RelativeDiv = 0;

  static String[] AnswerJapanese = new String[4];

  static String[] AnswerMeaning = new String[4];

  static String correctJ;

  static String correctM;

  static String[] questions = new String[30];

  static String[] yourAns = new String[30];

  static String[] corrAns = new String[30];

  static String[] truth = new String[30];

  static String[][] result = new String[30][4];

  static String[] add = new String[3];

  static String[] delete = new String[4];

  static String[] update = new String[4];

  static int setfreq = 0;

  static int nowfreq = 0;

  static String theWord;

  static String theJapanese;

  static String theMeaning;

  static String UpdateW;

  static String UpdateJ;

  static String UpdateM;

  static int UpdateF;

  JScrollPane changeSource = new JScrollPane();

  JPanel changePanel = new JPanel();

  JPanel changeJapanese = new JPanel();

  JPanel changeMean = new JPanel();

  JPanel changeFreq = new JPanel();

  JLabel changetitle = new JLabel();

  JLabel changeBack = new JLabel();

  JTextField changeWText = new JTextField();

  JTextField changeJText = new JTextField();

  JTextField changeMText = new JTextField();

  JTextField changeFText = new JTextField();

  JButton changeans1 = new JButton();

  JButton changeans2 = new JButton();

  JButton changeans3 = new JButton();

  JButton changeans4 = new JButton();

  JButton changeButton = new JButton();

  JButton removeNext = new JButton();

  public String[] PanelNames = new String[] {
      "mp", ", ", ",
      ", ", ",
      ", ", ",
      ",
      ", ", ",
      ", "};

  int[] solved = new int[30];

  public static String URL = "jdbc:sqlite:words.db";

  public static String SQL = "";

  MainPanel mp = new MainPanel(this, this.PanelNames[0]);

  SubPanel sp = new SubPanel(this, this.PanelNames[1]);

  SubPanel sp2 = new SubPanel(this, this.PanelNames[2]);

  SubPanel sp3 = new SubPanel(this, this.PanelNames[3]);

  Word sp4 = new Word(this, this.PanelNames[4]);

  Test sp5 = new Test(this, this.PanelNames[5]);

  Edit sp6 = new Edit(this, this.PanelNames[6]);

  Test sp7 = new Test(this, this.PanelNames[7]);

  Test sp8 = new Test(this, this.PanelNames[8]);

  Test sp9 = new Test(this, this.PanelNames[9]);

  Test sp10 = new Test(this, this.PanelNames[10]);

  Edit sp11 = new Edit(this, this.PanelNames[11]);

  Edit sp12 = new Edit(this, this.PanelNames[12]);

  Edit sp13 = new Edit(this, this.PanelNames[13]);

  Edit sp14 = new Edit(this, this.PanelNames[14]);

  Edit sp15 = new Edit(this, this.PanelNames[15]);

  public static int width = 900;

  public static int height = 600;

  public static URL url;

  Dimension dim;

  public static class Words {
    private String word;

    private String japanese;

    private String mean;

    private int freq;

    public void setWord(String word) {
      this.word = word;
    }

    public void setJapanese(String japanese) {
      this.japanese = japanese;
    }

    public void setMean(String mean) {
      this.mean = mean;
    }

    public void setFreq(int freq) {
      this.freq = freq;
    }

    public String getWord() {
      return this.word;
    }

    public String getJapanese() {
      return this.japanese;
    }

    public String getMean() {
      return this.mean;
    }

    public int getFreq() {
      return this.freq;
    }
  }

  public static void selectDatabase() {
    if (i == 1) {
      SQL = "SELECT * FROM info_math ORDER BY frequency DESC";
    } else if (i == 2) {
      SQL = "SELECT * FROM algorithm ORDER BY frequency DESC";
    } else if (i == 3) {
      SQL = "SELECT * FROM compiler ORDER BY frequency DESC";
    }
  }

  public static List<Words> InstallData(List<Words> WordList) {
    datanum = 0;
    selectDatabase();
    try {
      Exception exception2, exception1 = null;
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return WordList;
  }

  public static void main(String[] args) {
    MainFrame mf = new MainFrame();
    mf.setLocationRelativeTo((Component)null);
    mf.setDefaultCloseOperation(3);
    mf.setVisible(true);
  }

  public void reset() {
    this.count = 0;
    for (int j = 0; j < 30; j++)
      this.solved[j] = -1;
  }

  void BackGroundOfHomeAndInfoMath(URL url) {
    MediaTracker tracker = new MediaTracker(this);
    ImageIcon icon1 = new ImageIcon(url);
    Image bigImg = icon1.getImage().getScaledInstance((int)(icon1.getIconWidth() * 0.27D), -1, 4);
    tracker.addImage(bigImg, 1);
    ImageIcon bigIcon = new ImageIcon(bigImg);
    JLabel label1 = new JLabel(bigIcon);
    add(label1);
    this.changeBack = label1;
  }

  void BackGroundOfAlgorithmAndCompiler(URL url) {
    MediaTracker tracker = new MediaTracker(this);
    ImageIcon icon1 = new ImageIcon(url);
    Image bigImg = icon1.getImage().getScaledInstance((int)(icon1.getIconWidth() * 0.5D), -1, 4);
    tracker.addImage(bigImg, 1);
    ImageIcon bigIcon = new ImageIcon(bigImg);
    JLabel label1 = new JLabel(bigIcon);
    add(label1);
    this.changeBack = label1;
  }

  public MainFrame() {
    this.dim = Toolkit.getDefaultToolkit().getScreenSize();
    add(this.mp);
    this.mp.setVisible(false);
    add(this.sp);
    this.sp.setVisible(false);
    add(this.sp2);
    this.sp2.setVisible(false);
    add(this.sp3);
    this.sp3.setVisible(false);
    add(this.sp4);
    this.sp4.setVisible(false);
    add(this.sp5);
    this.sp5.setVisible(false);
    add(this.sp6);
    this.sp6.setVisible(false);
    add(this.sp7);
    this.sp7.setVisible(false);
    add(this.sp8);
    this.sp8.setVisible(false);
    add(this.sp9);
    this.sp9.setVisible(false);
    add(this.sp10);
    this.sp10.setVisible(false);
    add(this.sp11);
    this.sp11.setVisible(false);
    add(this.sp12);
    this.sp12.setVisible(false);
    add(this.sp13);
    this.sp13.setVisible(false);
    add(this.sp14);
    this.sp14.setVisible(false);
    add(this.sp15);
    this.sp15.setVisible(false);
    setSize(width, height);
    OpenHome();
  }

  public void CloseHome(JPanel jp) {
    remove(this.changeBack);
    this.mp = (MainPanel)jp;
    this.mp.setVisible(false);
  }

  public void OpenHome() {
    if (getExtendedState() == 6)
      this.mp.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    reset();
    url = getClass().getResource("/home.png");
    BackGroundOfHomeAndInfoMath(url);
    this.mp.setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.mp.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.mp.setLocation(0, 0);
            }
          }
        });
    this.mp.setVisible(true);
  }

  public void OpenCourseInfomation() {
    if (getExtendedState() == 6)
      this.sp.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    i = 1;
    this.sp.setVisible(true);
    reset();
    url = getClass().getResource("/info_math.png");
    BackGroundOfHomeAndInfoMath(url);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp.setLocation(0, 0);
            }
          }
        });
    this.sp.setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
  }

  public void OpenCourseAlgorithm() {
    if (getExtendedState() == 6)
      this.sp2.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    i = 2;
    this.sp2.setVisible(true);
    reset();
    url = getClass().getResource("/algorithm.png");
    BackGroundOfAlgorithmAndCompiler(url);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp2.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp2.setLocation(0, 0);
            }
          }
        });
    this.sp2.setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
  }

  public void OpenCourseCompiler() {
    if (getExtendedState() == 6)
      this.sp3.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    i = 3;
    reset();
    url = getClass().getResource("/compiler.png");
    BackGroundOfAlgorithmAndCompiler(url);
    this.sp3.setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp3.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp3.setLocation(0, 0);
            }
          }
        });
    this.sp3.setVisible(true);
  }

  public void OpenFunctionWordList() {
    this.changeSource = createTable();
    this.sp4.add(this.changeSource);
    this.sp4.setBackground(Color.WHITE);
    if (getExtendedState() == 6) {
      this.sp4.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
      RelativeDiv = ((int)this.dim.getHeight() - height) / 2;
    }
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp4.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
              MainFrame.this.changeSource.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 9, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 3);
              MainFrame.RelativeDiv = ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2;
            } else {
              MainFrame.this.changeSource.setLocation(40, 100);
              MainFrame.this.sp4.setLocation(0, 0);
              MainFrame.RelativeDiv = 0;
            }
          }
        });
    this.sp4.setVisible(true);
  }

  public void OpenFunctionTest() {
    if (getExtendedState() == 6)
      this.sp5.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    reset();
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp5.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp5.setLocation(0, 0);
            }
          }
        });
    this.sp5.setVisible(true);
  }

  public void CloseTestMeaning(JPanel jp) {
    this.sp7.remove(this.changetitle);
    this.sp7.remove(this.changeans1);
    this.sp7.remove(this.changeans2);
    this.sp7.remove(this.changeans3);
    this.sp7.remove(this.changeans4);
    this.sp7 = (Test)jp;
    this.sp7.setVisible(false);
  }

  public void CloseTestJapanese(JPanel jp) {
    this.sp8.remove(this.changetitle);
    this.sp8.remove(this.changeans1);
    this.sp8.remove(this.changeans2);
    this.sp8.remove(this.changeans3);
    this.sp8.remove(this.changeans4);
    this.sp8 = (Test)jp;
    this.sp8.setVisible(false);
  }

  public void CloseTestNext(JPanel jp) {
    this.sp9.remove(this.changetitle);
    this.sp9.remove(this.removeNext);
    this.sp9 = (Test)jp;
    this.sp9.setVisible(false);
  }

  public void CloseTestResult(JPanel jp) {
    this.sp10.remove(this.changetitle);
    this.count = 0;
    this.countCorrect = 0;
    this.sp10.remove(this.changeSource);
    this.sp10 = (Test)jp;
    this.sp10.setVisible(false);
  }

  public void OpenTestMeaning() {
    if (getExtendedState() == 6)
      this.sp7.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    questions[this.count] = test();
    JLabel paneltitle = new JLabel(questions[this.count], 0);
    paneltitle.setFont(new Font("MS , 1, 35));
    paneltitle.setBounds(200, 60, 500, 90);
    paneltitle.setOpaque(true);
    paneltitle.setBackground(Color.WHITE);
    this.sp7.add(paneltitle);
    this.changetitle = paneltitle;
    corrAns[this.count] = correctM;
    JButton ans1 = new JButton(AnswerMeaning[0]);
    ans1.setBounds(200, 200, 500, 50);
    ans1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerM(MainFrame.AnswerMeaning[0]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerMeaning[0];
            MainFrame.this.MRandW();
          }
        });
    this.changeans1 = ans1;
    JButton ans2 = new JButton(AnswerMeaning[1]);
    ans2.setBounds(200, 260, 500, 50);
    ans2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerM(MainFrame.AnswerMeaning[1]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerMeaning[1];
            MainFrame.this.MRandW();
          }
        });
    this.changeans2 = ans2;
    JButton ans3 = new JButton(AnswerMeaning[2]);
    ans3.setBounds(200, 320, 500, 50);
    ans3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerM(MainFrame.AnswerMeaning[2]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerMeaning[2];
            MainFrame.this.MRandW();
          }
        });
    this.changeans3 = ans3;
    JButton ans4 = new JButton(AnswerMeaning[3]);
    ans4.setBounds(200, 380, 500, 50);
    ans4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerM(MainFrame.AnswerMeaning[3]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerMeaning[3];
            MainFrame.this.MRandW();
          }
        });
    this.changeans4 = ans4;
    this.sp7.add(ans1);
    this.sp7.add(ans2);
    this.sp7.add(ans3);
    this.sp7.add(ans4);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp7.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp7.setLocation(0, 0);
            }
          }
        });
    this.sp7.setVisible(true);
  }

  public void OpenTestJapanese() {
    if (getExtendedState() == 6)
      this.sp8.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    questions[this.count] = test();
    JLabel paneltitle = new JLabel(questions[this.count], 0);
    paneltitle.setFont(new Font("MS , 1, 35));
    paneltitle.setBounds(200, 60, 500, 90);
    paneltitle.setOpaque(true);
    paneltitle.setBackground(Color.WHITE);
    this.sp8.add(paneltitle);
    this.changetitle = paneltitle;
    corrAns[this.count] = correctJ;
    JButton ans1 = new JButton(AnswerJapanese[0]);
    ans1.setBounds(180, 200, 250, 50);
    ans1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerJ(MainFrame.AnswerJapanese[0]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerJapanese[0];
            MainFrame.this.JRandW();
          }
        });
    this.changeans1 = ans1;
    JButton ans2 = new JButton(AnswerJapanese[1]);
    ans2.setBounds(180, 300, 250, 50);
    ans2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerJ(MainFrame.AnswerJapanese[1]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerJapanese[1];
            MainFrame.this.JRandW();
          }
        });
    this.changeans2 = ans2;
    JButton ans3 = new JButton(AnswerJapanese[2]);
    ans3.setBounds(480, 200, 250, 50);
    ans3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerJ(MainFrame.AnswerJapanese[2]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerJapanese[2];
            MainFrame.this.JRandW();
          }
        });
    this.changeans3 = ans3;
    JButton ans4 = new JButton(AnswerJapanese[3]);
    ans4.setBounds(480, 300, 250, 50);
    ans4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.Correct = MainFrame.this.answerJ(MainFrame.AnswerJapanese[3]);
            MainFrame.yourAns[MainFrame.this.count] = MainFrame.AnswerJapanese[3];
            MainFrame.this.JRandW();
          }
        });
    this.changeans4 = ans4;
    this.sp8.add(ans1);
    this.sp8.add(ans2);
    this.sp8.add(ans3);
    this.sp8.add(ans4);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp8.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp8.setLocation(0, 0);
            }
          }
        });
    this.sp8.setVisible(true);
  }

  public void OpenTestNext(JPanel jp) {
    if (getExtendedState() == 6)
      this.sp9.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    final String name = jp.getName();
    JLabel Result = new JLabel();
    if (this.Correct == 1) {
      Result = new JLabel(", 0);
      Result.setForeground(Color.GREEN);
    }
    if (this.Correct == 0) {
      Result = new JLabel(", 0);
      Result.setForeground(Color.BLACK);
    }
    Result.setFont(new Font("MS , 1, 70));
    Result.setBounds(90, 100, 689, 180);
    this.changetitle = Result;
    JButton next = new JButton(");
    next.setBounds(700, 450, 100, 50);
    next.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.this.count++;
            if (MainFrame.this.count >= 30) {
              MainFrame.this.finish();
            } else if (name == MainFrame.this.PanelNames[7]) {
              MainFrame.this.NextM();
            } else if (name == MainFrame.this.PanelNames[8]) {
              MainFrame.this.NextJ();
            }
          }
        });
    this.removeNext = next;
    this.sp9.add(next);
    this.sp9.add(Result);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp9.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp9.setLocation(0, 0);
            }
          }
        });
    this.sp9.setVisible(true);
  }

  public void OpenTestResult() {
    if (getExtendedState() == 6)
      this.sp10.setLocation(((int)this.dim.getWidth() - 900) / 9, ((int)this.dim.getHeight() - 600) / 4);
    JLabel paneltitle = new JLabel("30+ this.countCorrect + ", 0);
    paneltitle.setFont(new Font("MS , 1, 35));
    paneltitle.setBounds(300, 20, 300, 50);
    paneltitle.setOpaque(true);
    paneltitle.setForeground(Color.GREEN);
    this.sp10.add(paneltitle);
    this.changetitle = paneltitle;
    String[] col = { ", ", ", "};
    for (int j = 0; j < this.count; j++) {
      result[j][0] = questions[j];
      result[j][1] = yourAns[j];
      result[j][2] = corrAns[j];
      result[j][3] = truth[j];
    }
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    model = new DefaultTableModel((Object[][])result, (Object[])col);
    table.setModel(model);
    table.setAutoResizeMode(0);
    table.setFont(new Font("MS , 1, 10));
    DefaultTableColumnModel columnModel =
      (DefaultTableColumnModel)table.getColumnModel();
    table.setRowHeight(25);
    TableColumn column = null;
    column = columnModel.getColumn(0);
    column.setPreferredWidth(160);
    column = columnModel.getColumn(1);
    column.setPreferredWidth(200);
    column = columnModel.getColumn(2);
    column.setPreferredWidth(380);
    column = columnModel.getColumn(3);
    column.setPreferredWidth(30);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(40, 100, 790, 300);
    this.changeSource = scrollPane;
    this.sp10.add(this.changeSource);
    if (getExtendedState() == 6)
      scrollPane.setLocation(((int)this.dim.getWidth() - width) / 9, ((int)this.dim.getHeight() - height) / 4);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp10.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
              MainFrame.this.changeSource.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 9, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 4);
            } else {
              MainFrame.this.changeSource.setLocation(40, 100);
              MainFrame.this.sp10.setLocation(0, 0);
            }
          }
        });
    this.sp10.setVisible(true);
  }

  public void OpenFunctionEdit() {
    if (getExtendedState() == 6)
      this.sp6.setLocation(((int)this.dim.getWidth() - 900) / 2, ((int)this.dim.getHeight() - 600) / 2);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp6.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp6.setLocation(0, 0);
            }
          }
        });
    this.sp6.setVisible(true);
  }

  public void CloseEditAdd(JPanel jp) {
    this.changePanel.remove(this.changeWText);
    this.sp11.remove(this.changePanel);
    this.sp11.remove(this.changeButton);
    this.sp11 = (Edit)jp;
    this.sp11.setVisible(false);
  }

  public void CloseEditDelete(JPanel jp) {
    this.changePanel.remove(this.changeWText);
    this.sp12.remove(this.changePanel);
    this.sp12.remove(this.changeButton);
    this.sp12 = (Edit)jp;
    this.sp12.setVisible(false);
  }

  public void CloseEditUpdata(JPanel jp) {
    this.changePanel.remove(this.changeWText);
    this.sp13.remove(this.changePanel);
    this.sp13.remove(this.changeButton);
    this.sp13 = (Edit)jp;
    this.sp13.setVisible(false);
  }

  public void CloseEditAddNewWord(JPanel jp) {
    this.changeJapanese.remove(this.changeJText);
    this.sp14.remove(this.changeJapanese);
    this.changeMean.remove(this.changeMText);
    this.sp14.remove(this.changeMean);
    this.changeFreq.remove(this.changeFText);
    this.sp14.remove(this.changeFreq);
    this.sp14.remove(this.changeButton);
    this.sp14 = (Edit)jp;
    this.sp14.setVisible(false);
  }

  public void CloseEditWordDetail(JPanel jp) {
    this.changePanel.remove(this.changeWText);
    this.sp15.remove(this.changetitle);
    this.changeJapanese.remove(this.changeJText);
    this.sp15.remove(this.changeJapanese);
    this.changeMean.remove(this.changeMText);
    this.sp15.remove(this.changeMean);
    this.changeFreq.remove(this.changeFText);
    this.sp15.remove(this.changeFreq);
    this.sp15 = (Edit)jp;
    this.sp15.setVisible(false);
  }

  public void OpenEditAdd(final String str) {
    if (getExtendedState() == 6)
      this.sp11.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    final JTextField word = new JTextField();
    word.setPreferredSize(new Dimension(300, 50));
    word.setFont(new Font("MS , 1, 20));
    word.setHorizontalAlignment(0);
    JPanel textline = new JPanel();
    textline.setBounds(300, 150, 300, 300);
    textline.add(word);
    this.changeWText = word;
    this.changePanel = textline;
    JButton addButton = new JButton(");
    addButton.setFont(new Font("MS , 1, 20));
    addButton.setBounds(300, 300, 300, 50);
    addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.add[0] = word.getText();
            MainFrame.this.UpdateAction(str);
          }
        });
    this.changeButton = addButton;
    this.sp11.add(addButton);
    this.sp11.add(textline);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp11.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp11.setLocation(0, 0);
            }
          }
        });
    this.sp11.setVisible(true);
  }

  public void OpenEditDelete(final String str) {
    if (getExtendedState() == 6)
      this.sp12.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    final JTextField word = new JTextField();
    word.setPreferredSize(new Dimension(300, 50));
    word.setFont(new Font("MS , 1, 20));
    word.setHorizontalAlignment(0);
    JPanel textline = new JPanel();
    textline.setBounds(300, 150, 300, 300);
    textline.add(word);
    this.changeWText = word;
    this.changePanel = textline;
    JButton deleteButton = new JButton(");
    deleteButton.setFont(new Font("MS , 1, 20));
    deleteButton.setBounds(300, 300, 300, 50);
    deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.add[0] = word.getText();
            MainFrame.this.UpdateAction(str);
          }
        });
    this.changeButton = deleteButton;
    this.sp12.add(deleteButton);
    this.sp12.add(textline);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp12.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp12.setLocation(0, 0);
            }
          }
        });
    this.sp12.setVisible(true);
  }

  public void OpenEditUpdata(final String str) {
    if (getExtendedState() == 6)
      this.sp13.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    final JTextField word = new JTextField();
    word.setPreferredSize(new Dimension(300, 50));
    word.setFont(new Font("MS , 1, 20));
    word.setHorizontalAlignment(0);
    JPanel textline = new JPanel();
    textline.setBounds(300, 150, 300, 300);
    textline.add(word);
    this.changeWText = word;
    this.changePanel = textline;
    JButton updateButton = new JButton(");
    updateButton.setFont(new Font("MS , 1, 20));
    updateButton.setBounds(300, 300, 300, 50);
    updateButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.add[0] = word.getText();
            MainFrame.this.UpdateAction(str);
          }
        });
    this.changeButton = updateButton;
    this.sp13.add(updateButton);
    this.sp13.add(textline);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp13.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp13.setLocation(0, 0);
            }
          }
        });
    this.sp13.setVisible(true);
  }

  public void OpenEditAddNewWord(String str) {
    if (getExtendedState() == 6)
      this.sp14.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    final JTextField japanese = new JTextField(null);
    japanese.setPreferredSize(new Dimension(300, 50));
    japanese.setFont(new Font("MS , 1, 20));
    japanese.setHorizontalAlignment(0);
    JPanel japaneseline = new JPanel();
    japaneseline.setBounds(300, 150, 300, 300);
    japaneseline.add(japanese);
    this.changeJText = japanese;
    this.changeJapanese = japaneseline;
    final JTextField meaning = new JTextField(null);
    meaning.setPreferredSize(new Dimension(300, 50));
    meaning.setFont(new Font("MS , 1, 20));
    meaning.setHorizontalAlignment(0);
    JPanel meaningline = new JPanel();
    meaningline.setBounds(300, 250, 300, 300);
    meaningline.add(meaning);
    this.changeMText = meaning;
    this.changeMean = meaningline;
    final JTextField frequency = new JTextField("1");
    frequency.setPreferredSize(new Dimension(300, 50));
    frequency.setFont(new Font("MS , 1, 20));
    frequency.setHorizontalAlignment(0);
    JPanel frequencyline = new JPanel();
    frequencyline.setBounds(300, 350, 300, 300);
    frequencyline.add(frequency);
    this.changeFText = frequency;
    this.changeFreq = frequencyline;
    JButton addButton = new JButton(");
    addButton.setFont(new Font("MS , 1, 20));
    addButton.setBounds(650, 355, 100, 50);
    addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.add[1] = japanese.getText();
            MainFrame.add[2] = meaning.getText();
            if (MainFrame.add[1].isEmpty() || MainFrame.add[2].isEmpty() || frequency.getText().isEmpty()) {
              JLabel Message = new JLabel(");
              Message.setForeground(Color.RED);
              Message.setBounds(0, 0, 200, 200);
              JOptionPane.showMessageDialog(MainFrame.this.sp14, Message);
            } else if (!Pattern.matches("^[0-9]+$", frequency.getText())) {
              JLabel Message = new JLabel(");
              Message.setForeground(Color.RED);
              Message.setBounds(0, 0, 200, 200);
              JOptionPane.showMessageDialog(MainFrame.this.sp14, Message);
            } else {
              MainFrame.setfreq = Integer.parseInt(frequency.getText());
              MainFrame.this.addALL(MainFrame.add);
              JLabel Message = new JLabel(");
              Message.setForeground(Color.GREEN);
              Message.setBounds(0, 0, 200, 200);
              JOptionPane.showMessageDialog(MainFrame.this.sp14, Message);
              MainFrame.this.CloseEditAddNewWord(MainFrame.this.sp14);
              MainFrame.this.OpenEditAdd(MainFrame.this.PanelNames[11]);
            }
          }
        });
    this.changeButton = addButton;
    this.sp14.add(addButton);
    this.sp14.add(japaneseline);
    this.sp14.add(meaningline);
    this.sp14.add(frequencyline);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp14.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp14.setLocation(0, 0);
            }
          }
        });
    this.sp14.setVisible(true);
  }

  public void OpenEditWordDetail(String str) {
    if (getExtendedState() == 6)
      this.sp15.setLocation(((int)this.dim.getWidth() - width) / 2, ((int)this.dim.getHeight() - height) / 2);
    final JTextField word = new JTextField(theWord);
    word.setPreferredSize(new Dimension(300, 50));
    word.setFont(new Font("MS , 1, 20));
    word.setHorizontalAlignment(0);
    JPanel textline = new JPanel();
    textline.setBounds(300, 150, 300, 300);
    textline.add(word);
    final JTextField Japanese = new JTextField(theJapanese);
    Japanese.setPreferredSize(new Dimension(300, 50));
    Japanese.setFont(new Font("MS , 1, 20));
    Japanese.setHorizontalAlignment(0);
    JPanel textlineJ = new JPanel();
    textlineJ.setBounds(300, 230, 300, 300);
    textlineJ.add(Japanese);
    final JTextField Meaning = new JTextField(theMeaning);
    Meaning.setPreferredSize(new Dimension(300, 50));
    Meaning.setFont(new Font("MS , 1, 20));
    Meaning.setHorizontalAlignment(0);
    JPanel textlineM = new JPanel();
    textlineM.setBounds(300, 310, 300, 300);
    textlineM.add(Meaning);
    final JTextField Frequency = new JTextField(Integer.toString(nowfreq));
    Frequency.setPreferredSize(new Dimension(300, 50));
    Frequency.setFont(new Font("MS , 1, 20));
    Frequency.setHorizontalAlignment(0);
    JPanel textlineF = new JPanel();
    textlineF.setBounds(300, 390, 300, 300);
    textlineF.add(Frequency);
    this.changeWText = word;
    this.changeJText = Japanese;
    this.changeMText = Meaning;
    this.changeFText = Frequency;
    this.changePanel = textline;
    this.changeJapanese = textlineJ;
    this.changeMean = textlineM;
    this.changeFreq = textlineF;
    JButton updateButton = new JButton(");
    updateButton.setFont(new Font("MS , 1, 20));
    updateButton.setBounds(650, 450, 100, 50);
    updateButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainFrame.UpdateW = word.getText();
            MainFrame.UpdateJ = Japanese.getText();
            MainFrame.UpdateM = Meaning.getText();
            MainFrame.UpdateF = Integer.parseInt(Frequency.getText());
            if (!MainFrame.add[0].isEmpty() && Pattern.matches("^[0-9a-zA-Z\\s()]+$", MainFrame.UpdateW)) {
              MainFrame.this.UpdateAll();
              JLabel Message = new JLabel(");
              Message.setForeground(Color.GREEN);
              Message.setBounds(0, 0, 200, 200);
              JOptionPane.showMessageDialog(MainFrame.this.sp15, Message);
              MainFrame.this.CloseEditWordDetail(MainFrame.this.sp15);
              MainFrame.this.OpenEditUpdata(MainFrame.this.PanelNames[13]);
            } else {
              JLabel Message = new JLabel(");
              Message.setForeground(Color.RED);
              Message.setBounds(0, 0, 200, 200);
              JOptionPane.showMessageDialog(MainFrame.this.sp15, Message);
            }
          }
        });
    this.changeButton = updateButton;
    this.sp15.add(updateButton);
    this.sp15.add(textline);
    this.sp15.add(textlineJ);
    this.sp15.add(textlineM);
    this.sp15.add(textlineF);
    addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            if (MainFrame.this.getExtendedState() == 6) {
              MainFrame.this.sp15.setLocation(((int)MainFrame.this.dim.getWidth() - MainFrame.width) / 2, ((int)MainFrame.this.dim.getHeight() - MainFrame.height) / 2);
            } else {
              MainFrame.this.sp15.setLocation(0, 0);
            }
          }
        });
    this.sp15.setVisible(true);
  }

  void MRandW() {
    CloseTestMeaning(this.sp7);
    OpenTestNext(this.sp7);
  }

  void JRandW() {
    CloseTestJapanese(this.sp8);
    OpenTestNext(this.sp8);
  }

  int answerJ(String japanese) {
    if (japanese.equals(correctJ.toString())) {
      truth[this.count] = ";
      this.countCorrect++;
      return 1;
    }
    truth[this.count] = ";
    return 0;
  }

  int answerM(String meaning) {
    if (meaning.equals(correctM.toString())) {
      truth[this.count] = ";
      this.countCorrect++;
      return 1;
    }
    truth[this.count] = ";
    return 0;
  }

  public void NextM() {
    CloseTestNext(this.sp9);
    OpenTestMeaning();
  }

  public void NextJ() {
    CloseTestNext(this.sp9);
    OpenTestJapanese();
  }

  public void finish() {
    CloseTestNext(this.sp9);
    OpenTestResult();
  }

  JScrollPane createTable() {
    ArrayList<String> columnNames = new ArrayList();
    ArrayList<ArrayList<Object>> data = new ArrayList();
    selectDatabase();
    try {
      Exception exception2, exception1 = null;
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    Vector<?> columnNamesVector = new Vector();
    Vector<Vector> dataVector = new Vector();
    int i;
    for (i = 0; i < data.size(); i++) {
      ArrayList subArray = data.get(i);
      Vector subVector = new Vector();
      for (int j = 0; j < subArray.size(); j++)
        subVector.add(subArray.get(j));
      dataVector.add(subVector);
    }
    for (i = 0; i < columnNames.size(); i++)
      columnNamesVector.add(columnNames.get(i));
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    model = new DefaultTableModel(dataVector, columnNamesVector);
    table.setModel(model);
    table.setAutoResizeMode(0);
    table.setFont(new Font("MS , 1, 10));
    DefaultTableColumnModel columnModel =
      (DefaultTableColumnModel)table.getColumnModel();
    table.setRowHeight(25);
    TableColumn column = null;
    column = columnModel.getColumn(0);
    column.setPreferredWidth(160);
    column = columnModel.getColumn(1);
    column.setPreferredWidth(160);
    column = columnModel.getColumn(2);
    column.setPreferredWidth(380);
    column = columnModel.getColumn(3);
    column.setPreferredWidth(70);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(40, 100, 790, 300);
    if (getExtendedState() == 6)
      scrollPane.setLocation(((int)this.dim.getWidth() - width) / 9, ((int)this.dim.getHeight() - height) / 4);
    return scrollPane;
  }

  String test() {
    List<Words> WordList = new ArrayList<>();
    WordList = InstallData(WordList);
    String[][] questions = new String[4][4];
    Random random = new Random();
    int num = 0;
    int[] weight = new int[4];
    int[] t = new int[4];
    int qNum = 0;
    int booking = 0;
    int j = 0;
    while (num < 4) {
      int randomValue = random.nextInt(datanum);
      qNum = randomValue;
      booking = 0;
      if (this.count > 0)
        for (j = 0; j < this.count; j++) {
          if (this.solved[j] == qNum) {
            booking = 1;
            break;
          }
        }
      for (int n = 0; n < num; n++) {
        if (t[n] == qNum) {
          booking = 1;
          break;
        }
      }
      if (booking == 0) {
        questions[num][0] = ((Words)WordList.get(qNum)).getWord();
        questions[num][1] = ((Words)WordList.get(qNum)).getJapanese();
        questions[num][2] = ((Words)WordList.get(qNum)).getMean();
        weight[num] = ((Words)WordList.get(qNum)).getFreq();
        t[num] = qNum;
        num++;
      }
    }
    for (j = 0; j < 4; j++) {
      AnswerJapanese[j] = questions[j][1];
      AnswerMeaning[j] = questions[j][2];
    }
    int sumWeight = weight[0] + weight[1] + weight[2] + weight[3];
    int sum = 0;
    String[] qWord = new String[sumWeight];
    String[] qJapanese = new String[sumWeight];
    String[] qMean = new String[sumWeight];
    for (int k = 0; k < 4; k++) {
      for (j = 0; j < weight[k]; j++) {
        qWord[j + sum] = questions[k][0];
        qJapanese[j + sum] = questions[k][1];
        qMean[j + sum] = questions[k][2];
      }
      sum += weight[k];
    }
    int jugde = random.nextInt(sumWeight);
    String Question = qWord[jugde];
    for (j = 0; j < datanum; j++) {
      if (Question.equals(((Words)WordList.get(j)).getWord())) {
        this.solved[this.count] = j;
        break;
      }
    }
    correctJ = ((Words)WordList.get(this.solved[this.count])).getJapanese();
    correctM = ((Words)WordList.get(this.solved[this.count])).getMean();
    return Question;
  }

  void UpdateAction(String str) {
    if (!add[0].isEmpty() && Pattern.matches("^[0-9a-zA-Z\\s()-]+$", add[0])) {
      if (Edit(add) == 1) {
        if (str == this.PanelNames[11]) {
          addFrequency();
          JLabel Message = new JLabel(");
          Message.setForeground(Color.GREEN);
          Message.setBounds(0, 0, 200, 200);
          JOptionPane.showMessageDialog(this.sp11, Message);
          CloseEditAdd(this.sp11);
          OpenEditAdd(this.PanelNames[11]);
        }
        if (str == this.PanelNames[12]) {
          Delete();
          JLabel Message = new JLabel(");
          Message.setForeground(Color.GREEN);
          Message.setBounds(0, 0, 200, 200);
          JOptionPane.showMessageDialog(this.sp12, Message);
          CloseEditAdd(this.sp12);
          OpenEditAdd(this.PanelNames[12]);
        }
        if (str == this.PanelNames[13]) {
          CloseEditUpdata(this.sp13);
          OpenEditWordDetail(this.PanelNames[15]);
        }
      } else if (str == this.PanelNames[11]) {
        CloseEditAdd(this.sp11);
        OpenEditAddNewWord(this.PanelNames[14]);
      } else if (str == this.PanelNames[12] || str == this.PanelNames[13]) {
        JLabel Message = new JLabel(");
        Message.setForeground(Color.RED);
        Message.setBounds(0, 0, 200, 200);
        JOptionPane.showMessageDialog(this.sp12, Message);
      }
    } else {
      JLabel Message = new JLabel(");
      Message.setForeground(Color.RED);
      Message.setBounds(0, 0, 200, 200);
      JOptionPane.showMessageDialog(this.sp11, Message);
    }
  }

  int Edit(String[] add) {
    List<Words> WordList = new ArrayList<>();
    WordList = InstallData(WordList);
    for (int j = 0; j < datanum; j++) {
      if (add[0].toLowerCase().equals(((Words)WordList.get(j)).getWord().toLowerCase())) {
        theWord = ((Words)WordList.get(j)).getWord();
        theJapanese = ((Words)WordList.get(j)).getJapanese();
        theMeaning = ((Words)WordList.get(j)).getMean();
        nowfreq = ((Words)WordList.get(j)).getFreq();
        return 1;
      }
    }
    return 0;
  }

  void addALL(String[] add2) {
    if (i == 1) {
      SQL = "INSERT INTO info_math values(?,?,?,?)";
    } else if (i == 2) {
      SQL = "INSERT INTO algorithm values(?,?,?,?)";
    } else if (i == 3) {
      SQL = "INSERT INTO compiler values(?,?,?,?)";
    }
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void addFrequency() {
    if (i == 1) {
      SQL = "UPDATE info_math SET frequency = ? WHERE word = ?";
    } else if (i == 2) {
      SQL = "UPDATE algorithm SET frequency = ? WHERE word = ?";
    } else if (i == 3) {
      SQL = "UPDATE compiler SET frequency = ? WHERE word = ?";
    }
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void Delete() {
    if (i == 1) {
      SQL = "DELETE FROM info_math WHERE word = ?";
    } else if (i == 2) {
      SQL = "DELETE FROM algorithm WHERE word = ?";
    } else if (i == 3) {
      SQL = "DELETE FROM compiler WHERE word = ?";
    }
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void UpdateAll() {
    if (i == 1) {
      SQL = "UPDATE info_math SET word = ?, japanese = ?, meaning = ?, frequency = ? WHERE word = ?";
    } else if (i == 2) {
      SQL = "UPDATE algorithm SET word = ?, japanese = ?, meaning = ?, frequency = ? WHERE word = ?";
    } else if (i == 3) {
      SQL = "UPDATE compiler SET word = ?, japanese = ?, meaning = ?, frequency = ? WHERE word = ?";
    }
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
