package mcqs;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
class question implements Serializable{
    private int qno,ans;
    private boolean hasMarked;
    private boolean hasAttempted;
    public question(int q,boolean m,boolean a,int an)
    {
        qno=q;
        hasMarked=m;
        hasAttempted=a;
        ans=an;
    }
    public int AnswerGiven() { return ans; }
    public boolean Marked() { return hasMarked; }
    public boolean Attempted() { return hasAttempted; }
    public void setMarked(boolean b){ hasMarked=b; }
    public void setAttempted(boolean b){ hasAttempted=b; }
    public void setAnswer(int an) { ans=an; }
}

class student implements Serializable{
    private String name;
    private String roll;
    private int marks;
    public ArrayList <question> q=new ArrayList();
    public student(String n,String r)
    {
        name=n;
        roll=r;
        marks=0;
    }
    public String getName() { return name; }
    public String getRoll() { return roll; }
    public void setMarks(int m)  { marks=m;  }
    public int getMarks() { return marks; }
    //public void setQMarkedAttempted(boolean m,boolean a,int i,int ans) { q.add(new question(i,m,a,ans)); }
    }

class questions implements Serializable{
    private String q;
    private String option[];
    private int ans;
    public questions(String que,int a,String o[])
    {
        q=que;
        ans=a;
        option=new String[4];
        for(int i=0;i<4;i++)
            option[i]=o[i];
    }
    public void setQ(String s){ q=s; }
    public void setA(int a){ ans=a; }
    public void setOptions(String op[]){ option=Arrays.copyOf(op,op.length);}
    public String getQ() { return q;}
    public int getA() { return ans;}
    public String[] getOption() { return option; }
}

public class StartGUI extends javax.swing.JFrame {

    /**
     * Creates new form StartGUI
     */
    private int time,count;
    private Timer timer=null;
    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {        
            time--;
            TimeLabel.setText("Time Left:"+time+" secs");
            if(time==0)
            {
                JOptionPane.showMessageDialog(null,"Time's up!");
                JOptionPane.showMessageDialog(null,"Thank You for taking the test.\nYour Score is "+stud.get(stud.size()-1).getMarks());
                StudentPanel.setVisible(false);
                WelcomePanel.setVisible(true);
                timer.stop();
                TimeLabel.setText("");
            }
        }
    }
    private int currentQ;
    private ArrayList <questions> mcq=new ArrayList();
    private ArrayList <student> stud=new ArrayList();
    private boolean hasUploaded=false,hasClicked=false;
    public StartGUI() {
        initComponents();
        TeacherPanel.setVisible(false);
        TeacherSignInPanel.setVisible(false);
        StudentPanel.setVisible(false);
        StudentSignInPanel.setVisible(false);
        ViewIndividualPanel.setVisible(false);
        ViewOverallPanel.setVisible(false);
        QuestionSetPanel.setVisible(false);
        File file=null;
        file= new File("E:\\students.ser");
        ObjectInput ois=null;
        InputStream isr =null;
        InputStream buffer=null;
        try {
             if(!file.exists())
                 file.createNewFile();
             isr= new FileInputStream("E:\\students.ser");
             buffer = new BufferedInputStream(isr);
             ois = new ObjectInputStream(buffer);
             stud=(ArrayList)ois.readObject();
             ois.close();
             isr.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        file= new File("E:\\mcq.ser");
        try {
             if(!file.exists())
                 file.createNewFile();   
             isr= new FileInputStream("E:\\mcq.ser");
             buffer = new BufferedInputStream(isr);
             ois = new ObjectInputStream(buffer);
             mcq=(ArrayList)ois.readObject();
             ois.close();
             isr.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomePanel = new javax.swing.JPanel();
        TeacherButton = new javax.swing.JButton();
        WelcomeLabel = new javax.swing.JLabel();
        StudentButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        WelcomeBg = new javax.swing.JLabel();
        TeacherSignInPanel = new javax.swing.JPanel();
        LoginButton1 = new javax.swing.JButton();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField1 = new javax.swing.JPasswordField();
        BackButton1 = new javax.swing.JButton();
        WelcomeLabel3 = new javax.swing.JLabel();
        WelcomeBg4 = new javax.swing.JLabel();
        TeacherPanel = new javax.swing.JPanel();
        WelcomeLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        TeacherButton1 = new javax.swing.JButton();
        WelcomeLabel2 = new javax.swing.JLabel();
        StudentButton1 = new javax.swing.JButton();
        StudentButton2 = new javax.swing.JButton();
        BackButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        WelcomeBg3 = new javax.swing.JLabel();
        QuestionSetPanel = new javax.swing.JPanel();
        DoneButton = new javax.swing.JButton();
        QuestionNumberLabel1 = new javax.swing.JLabel();
        ChoiceButton1 = new javax.swing.JRadioButton();
        ChoiceButton2 = new javax.swing.JRadioButton();
        ChoiceButton3 = new javax.swing.JRadioButton();
        ChoiceButton4 = new javax.swing.JRadioButton();
        Submit1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        QuestionNoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        WelcomeBg1 = new javax.swing.JLabel();
        ViewOverallPanel = new javax.swing.JPanel();
        PasswordLabel1 = new javax.swing.JLabel();
        PasswordLabel2 = new javax.swing.JLabel();
        PasswordLabel3 = new javax.swing.JLabel();
        PasswordLabel4 = new javax.swing.JLabel();
        PasswordLabel5 = new javax.swing.JLabel();
        Above80Field = new javax.swing.JTextField();
        Above70Field = new javax.swing.JTextField();
        Above60Field = new javax.swing.JTextField();
        Below40Field = new javax.swing.JTextField();
        Above90Field = new javax.swing.JTextField();
        BackButton3 = new javax.swing.JButton();
        WelcomeLabel4 = new javax.swing.JLabel();
        WelcomeBg5 = new javax.swing.JLabel();
        ViewIndividualPanel = new javax.swing.JPanel();
        PasswordLabel8 = new javax.swing.JLabel();
        PasswordLabel9 = new javax.swing.JLabel();
        PasswordLabel10 = new javax.swing.JLabel();
        EnterButton = new javax.swing.JButton();
        TNameField = new javax.swing.JTextField();
        TPercentageField = new javax.swing.JTextField();
        TRollField = new javax.swing.JTextField();
        BackButton4 = new javax.swing.JButton();
        WelcomeLabel5 = new javax.swing.JLabel();
        WelcomeBg6 = new javax.swing.JLabel();
        StudentSignInPanel = new javax.swing.JPanel();
        LoginButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        NameField = new javax.swing.JTextField();
        RollNumberField = new javax.swing.JTextField();
        NameLabel = new javax.swing.JLabel();
        RollNumberLabel = new javax.swing.JLabel();
        WelcomeLabel1 = new javax.swing.JLabel();
        WelcomeBg2 = new javax.swing.JLabel();
        StudentPanel = new javax.swing.JPanel();
        TimeLabel = new javax.swing.JLabel();
        EndTestButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Submit = new javax.swing.JLabel();
        AnswerButton1 = new javax.swing.JRadioButton();
        AnswerButton2 = new javax.swing.JRadioButton();
        AnswerButton3 = new javax.swing.JRadioButton();
        AnswerButton4 = new javax.swing.JRadioButton();
        OptionLabel1 = new javax.swing.JLabel();
        OptionLabel2 = new javax.swing.JLabel();
        OptionLabel3 = new javax.swing.JLabel();
        OptionLabel4 = new javax.swing.JLabel();
        WelNameLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        QuestionNumberLabel = new javax.swing.JLabel();
        PreviousLabel = new javax.swing.JLabel();
        NextLabel = new javax.swing.JLabel();
        ReviewButton = new javax.swing.JRadioButton();
        QuestionReview = new javax.swing.JLabel();
        QnoLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        QuestionBg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AttemptedArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        ReviewArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 540));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WelcomePanel.setAlignmentX(0.0F);
        WelcomePanel.setAlignmentY(0.0F);
        WelcomePanel.setPreferredSize(new java.awt.Dimension(820, 540));
        WelcomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TeacherButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        TeacherButton.setForeground(new java.awt.Color(0, 51, 51));
        TeacherButton.setText("Teacher");
        TeacherButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        TeacherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TeacherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherButtonMouseClicked(evt);
            }
        });
        TeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherButtonActionPerformed(evt);
            }
        });
        WelcomePanel.add(TeacherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 260, -1));

        WelcomeLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText("MultiPle Choice test evaluator");
        WelcomePanel.add(WelcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 820, 60));

        StudentButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        StudentButton.setForeground(new java.awt.Color(0, 51, 51));
        StudentButton.setText("Student");
        StudentButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        StudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentButtonMouseClicked(evt);
            }
        });
        WelcomePanel.add(StudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 260, -1));

        ExitButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(0, 51, 51));
        ExitButton.setText("Exit");
        ExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        ExitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        WelcomePanel.add(ExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, -1));

        WelcomeBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        WelcomePanel.add(WelcomeBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(WelcomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TeacherSignInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginButton1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        LoginButton1.setForeground(new java.awt.Color(0, 51, 51));
        LoginButton1.setText("LOGIn");
        LoginButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        LoginButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButton1MouseClicked(evt);
            }
        });
        LoginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButton1ActionPerformed(evt);
            }
        });
        TeacherSignInPanel.add(LoginButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 160, -1));

        PasswordLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel.setText("Enter password");
        TeacherSignInPanel.add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 280, -1));

        PasswordField1.setBackground(new java.awt.Color(204, 204, 204));
        PasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordField1ActionPerformed(evt);
            }
        });
        TeacherSignInPanel.add(PasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 280, 30));

        BackButton1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        BackButton1.setForeground(new java.awt.Color(0, 51, 51));
        BackButton1.setText("Back");
        BackButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        BackButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButton1MouseClicked(evt);
            }
        });
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });
        TeacherSignInPanel.add(BackButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, -1));

        WelcomeLabel3.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        WelcomeLabel3.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel3.setText("MultiPle Choice test evaluator");
        TeacherSignInPanel.add(WelcomeLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 820, 60));

        WelcomeBg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        TeacherSignInPanel.add(WelcomeBg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(TeacherSignInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TeacherPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WelcomeLabel6.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        WelcomeLabel6.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel6.setText("timer");
        TeacherPanel.add(WelcomeLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 376, 60, -1));

        jButton2.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 51));
        jButton2.setText("OK");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        TeacherPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 50, 30));

        TeacherButton1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        TeacherButton1.setForeground(new java.awt.Color(0, 51, 51));
        TeacherButton1.setText("Set Question Paper");
        TeacherButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        TeacherButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TeacherButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherButton1MouseClicked(evt);
            }
        });
        TeacherButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherButton1ActionPerformed(evt);
            }
        });
        TeacherPanel.add(TeacherButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 290, -1));

        WelcomeLabel2.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        WelcomeLabel2.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel2.setText("MultiPle Choice test evaluator");
        TeacherPanel.add(WelcomeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 820, 60));

        StudentButton1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        StudentButton1.setForeground(new java.awt.Color(0, 51, 51));
        StudentButton1.setText("View Individual performance");
        StudentButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        StudentButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentButton1MouseClicked(evt);
            }
        });
        TeacherPanel.add(StudentButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 410, -1));

        StudentButton2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        StudentButton2.setForeground(new java.awt.Color(0, 51, 51));
        StudentButton2.setText("view overall performance");
        StudentButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        StudentButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentButton2MouseClicked(evt);
            }
        });
        TeacherPanel.add(StudentButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 370, -1));

        BackButton2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        BackButton2.setForeground(new java.awt.Color(0, 51, 51));
        BackButton2.setText("Back");
        BackButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        BackButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButton2MouseClicked(evt);
            }
        });
        BackButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton2ActionPerformed(evt);
            }
        });
        TeacherPanel.add(BackButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, -1));

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("(in seconds)");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        TeacherPanel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 90, 30));

        WelcomeBg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        TeacherPanel.add(WelcomeBg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(TeacherPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        QuestionSetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DoneButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        DoneButton.setForeground(new java.awt.Color(0, 51, 51));
        DoneButton.setText("Done !");
        DoneButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        DoneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DoneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoneButtonMouseClicked(evt);
            }
        });
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(DoneButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 160, -1));

        QuestionNumberLabel1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        QuestionNumberLabel1.setForeground(new java.awt.Color(0, 51, 51));
        QuestionNumberLabel1.setText("Question                                                     (tick the Correct answer)");
        QuestionSetPanel.add(QuestionNumberLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 610, -1));

        ChoiceButton1.setBackground(new java.awt.Color(0, 102, 153));
        ChoiceButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ChoiceButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChoiceButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChoiceButton1MouseClicked(evt);
            }
        });
        ChoiceButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoiceButton1ActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(ChoiceButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        ChoiceButton2.setBackground(new java.awt.Color(0, 102, 153));
        ChoiceButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ChoiceButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChoiceButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChoiceButton2MouseClicked(evt);
            }
        });
        ChoiceButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoiceButton2ActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(ChoiceButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        ChoiceButton3.setBackground(new java.awt.Color(0, 102, 153));
        ChoiceButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ChoiceButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChoiceButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChoiceButton3MouseClicked(evt);
            }
        });
        ChoiceButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoiceButton3ActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(ChoiceButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        ChoiceButton4.setBackground(new java.awt.Color(0, 102, 153));
        ChoiceButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ChoiceButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChoiceButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChoiceButton4MouseClicked(evt);
            }
        });
        ChoiceButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoiceButton4ActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(ChoiceButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        Submit1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        Submit1.setForeground(new java.awt.Color(0, 51, 51));
        Submit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Submit1.setText("SUBMIT");
        Submit1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        Submit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Submit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Submit1MouseClicked(evt);
            }
        });
        QuestionSetPanel.add(Submit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 90, 30));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 280, 30));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        QuestionSetPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 280, 30));

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        QuestionSetPanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 280, 30));

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        QuestionSetPanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 280, 30));

        QuestionNoLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        QuestionNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuestionSetPanel.add(QuestionNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 30, 30));

        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        QuestionSetPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 600, -1));

        WelcomeBg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        QuestionSetPanel.add(WelcomeBg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(QuestionSetPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ViewOverallPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PasswordLabel1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel1.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel1.setText("Above 80 %");
        ViewOverallPanel.add(PasswordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 120, -1));

        PasswordLabel2.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel2.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel2.setText("Above 70 %");
        ViewOverallPanel.add(PasswordLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 120, -1));

        PasswordLabel3.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel3.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel3.setText("Above 60 %");
        ViewOverallPanel.add(PasswordLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 120, -1));

        PasswordLabel4.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel4.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel4.setText("Below 40 %");
        ViewOverallPanel.add(PasswordLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 120, -1));

        PasswordLabel5.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel5.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel5.setText("Above 90 %");
        ViewOverallPanel.add(PasswordLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        Above80Field.setEditable(false);
        Above80Field.setBackground(new java.awt.Color(204, 204, 204));
        Above80Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Above80Field.setBorder(new javax.swing.border.MatteBorder(null));
        Above80Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Above80FieldActionPerformed(evt);
            }
        });
        ViewOverallPanel.add(Above80Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 140, 30));

        Above70Field.setEditable(false);
        Above70Field.setBackground(new java.awt.Color(204, 204, 204));
        Above70Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Above70Field.setBorder(new javax.swing.border.MatteBorder(null));
        Above70Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Above70FieldActionPerformed(evt);
            }
        });
        ViewOverallPanel.add(Above70Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 140, 30));

        Above60Field.setEditable(false);
        Above60Field.setBackground(new java.awt.Color(204, 204, 204));
        Above60Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Above60Field.setBorder(new javax.swing.border.MatteBorder(null));
        Above60Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Above60FieldActionPerformed(evt);
            }
        });
        ViewOverallPanel.add(Above60Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 140, 30));

        Below40Field.setEditable(false);
        Below40Field.setBackground(new java.awt.Color(204, 204, 204));
        Below40Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Below40Field.setBorder(new javax.swing.border.MatteBorder(null));
        Below40Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Below40FieldActionPerformed(evt);
            }
        });
        ViewOverallPanel.add(Below40Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 140, 30));

        Above90Field.setEditable(false);
        Above90Field.setBackground(new java.awt.Color(204, 204, 204));
        Above90Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Above90Field.setBorder(new javax.swing.border.MatteBorder(null));
        Above90Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Above90FieldActionPerformed(evt);
            }
        });
        ViewOverallPanel.add(Above90Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 140, 30));

        BackButton3.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        BackButton3.setForeground(new java.awt.Color(0, 51, 51));
        BackButton3.setText("Back");
        BackButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        BackButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButton3MouseClicked(evt);
            }
        });
        BackButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton3ActionPerformed(evt);
            }
        });
        ViewOverallPanel.add(BackButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, -1));

        WelcomeLabel4.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        WelcomeLabel4.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel4.setText("MultiPle Choice test evaluator");
        ViewOverallPanel.add(WelcomeLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 820, 60));

        WelcomeBg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        ViewOverallPanel.add(WelcomeBg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(ViewOverallPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ViewIndividualPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PasswordLabel8.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel8.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel8.setText("Name");
        ViewIndividualPanel.add(PasswordLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 160, -1));

        PasswordLabel9.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel9.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel9.setText("Percentage(%)");
        ViewIndividualPanel.add(PasswordLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 160, -1));

        PasswordLabel10.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PasswordLabel10.setForeground(new java.awt.Color(0, 51, 51));
        PasswordLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel10.setText("Enter Roll Number");
        ViewIndividualPanel.add(PasswordLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 190, -1));

        EnterButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        EnterButton.setForeground(new java.awt.Color(0, 51, 51));
        EnterButton.setText("Enter");
        EnterButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        EnterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EnterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnterButtonMouseClicked(evt);
            }
        });
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });
        ViewIndividualPanel.add(EnterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 100, 30));

        TNameField.setEditable(false);
        TNameField.setBackground(new java.awt.Color(204, 204, 204));
        TNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TNameField.setBorder(new javax.swing.border.MatteBorder(null));
        TNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNameFieldActionPerformed(evt);
            }
        });
        ViewIndividualPanel.add(TNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 140, 30));

        TPercentageField.setEditable(false);
        TPercentageField.setBackground(new java.awt.Color(204, 204, 204));
        TPercentageField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TPercentageField.setBorder(new javax.swing.border.MatteBorder(null));
        TPercentageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TPercentageFieldActionPerformed(evt);
            }
        });
        ViewIndividualPanel.add(TPercentageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 140, 30));

        TRollField.setBackground(new java.awt.Color(204, 204, 204));
        TRollField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRollField.setBorder(new javax.swing.border.MatteBorder(null));
        TRollField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRollFieldActionPerformed(evt);
            }
        });
        ViewIndividualPanel.add(TRollField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 140, 30));

        BackButton4.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        BackButton4.setForeground(new java.awt.Color(0, 51, 51));
        BackButton4.setText("Back");
        BackButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        BackButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButton4MouseClicked(evt);
            }
        });
        BackButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton4ActionPerformed(evt);
            }
        });
        ViewIndividualPanel.add(BackButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, -1));

        WelcomeLabel5.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        WelcomeLabel5.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel5.setText("MultiPle Choice test evaluator");
        ViewIndividualPanel.add(WelcomeLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 820, 60));

        WelcomeBg6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        ViewIndividualPanel.add(WelcomeBg6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(ViewIndividualPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        StudentSignInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(0, 51, 51));
        LoginButton.setText("LOGIn");
        LoginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
        });
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        StudentSignInPanel.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 160, -1));

        BackButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        BackButton.setForeground(new java.awt.Color(0, 51, 51));
        BackButton.setText("Back");
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        StudentSignInPanel.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, -1));

        NameField.setBackground(new java.awt.Color(204, 204, 204));
        NameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        StudentSignInPanel.add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 280, 30));

        RollNumberField.setBackground(new java.awt.Color(204, 204, 204));
        RollNumberField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RollNumberField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RollNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollNumberFieldActionPerformed(evt);
            }
        });
        StudentSignInPanel.add(RollNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 280, 30));

        NameLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(0, 51, 51));
        NameLabel.setText("Enter Name");
        StudentSignInPanel.add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 280, -1));

        RollNumberLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        RollNumberLabel.setForeground(new java.awt.Color(0, 51, 51));
        RollNumberLabel.setText("Enter roll number");
        StudentSignInPanel.add(RollNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 280, -1));

        WelcomeLabel1.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        WelcomeLabel1.setForeground(new java.awt.Color(0, 51, 51));
        WelcomeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel1.setText("MultiPle Choice test evaluator");
        StudentSignInPanel.add(WelcomeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 820, 60));

        WelcomeBg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        StudentSignInPanel.add(WelcomeBg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        getContentPane().add(StudentSignInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        StudentPanel.setPreferredSize(new java.awt.Dimension(820, 540));
        StudentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TimeLabel.setBackground(new java.awt.Color(204, 204, 204));
        TimeLabel.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(0, 51, 51));
        StudentPanel.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 40));

        EndTestButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        EndTestButton.setForeground(new java.awt.Color(0, 51, 51));
        EndTestButton.setText("END TEST");
        EndTestButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        EndTestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EndTestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EndTestButtonMouseClicked(evt);
            }
        });
        StudentPanel.add(EndTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 504, 260, -1));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        StudentPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 20, 20));

        jLabel3.setBackground(new java.awt.Color(0, 204, 0));
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        StudentPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 20, 20));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        StudentPanel.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 30, -1));

        jLabel4.setFont(new java.awt.Font("Batang", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 240, 30));

        jLabel6.setFont(new java.awt.Font("Batang", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Review");
        StudentPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 60, 20));

        Submit.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        Submit.setForeground(new java.awt.Color(0, 51, 51));
        Submit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Submit.setText("SUBMIT");
        Submit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitMouseClicked(evt);
            }
        });
        StudentPanel.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 90, 30));

        AnswerButton1.setBackground(new java.awt.Color(0, 102, 153));
        AnswerButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AnswerButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnswerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnswerButton1MouseClicked(evt);
            }
        });
        AnswerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnswerButton1ActionPerformed(evt);
            }
        });
        StudentPanel.add(AnswerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        AnswerButton2.setBackground(new java.awt.Color(0, 102, 153));
        AnswerButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AnswerButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnswerButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnswerButton2MouseClicked(evt);
            }
        });
        AnswerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnswerButton2ActionPerformed(evt);
            }
        });
        StudentPanel.add(AnswerButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, -1, -1));

        AnswerButton3.setBackground(new java.awt.Color(0, 102, 153));
        AnswerButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AnswerButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnswerButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnswerButton3MouseClicked(evt);
            }
        });
        AnswerButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnswerButton3ActionPerformed(evt);
            }
        });
        StudentPanel.add(AnswerButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        AnswerButton4.setBackground(new java.awt.Color(0, 102, 153));
        AnswerButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AnswerButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnswerButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnswerButton4MouseClicked(evt);
            }
        });
        AnswerButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnswerButton4ActionPerformed(evt);
            }
        });
        StudentPanel.add(AnswerButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        OptionLabel1.setBackground(new java.awt.Color(204, 204, 204));
        StudentPanel.add(OptionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, 30));

        OptionLabel2.setBackground(new java.awt.Color(204, 204, 204));
        StudentPanel.add(OptionLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 250, 30));

        OptionLabel3.setBackground(new java.awt.Color(204, 204, 204));
        StudentPanel.add(OptionLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 274, 250, 30));

        OptionLabel4.setBackground(new java.awt.Color(204, 204, 204));
        StudentPanel.add(OptionLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 324, 250, 30));

        WelNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        WelNameLabel.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        WelNameLabel.setForeground(new java.awt.Color(0, 51, 51));
        StudentPanel.add(WelNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 220, 30));

        jLabel8.setFont(new java.awt.Font("Batang", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Attempted");
        StudentPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 80, 20));

        QuestionNumberLabel.setBackground(new java.awt.Color(204, 204, 204));
        QuestionNumberLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        QuestionNumberLabel.setText("Question ");
        StudentPanel.add(QuestionNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, -1));

        PreviousLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PreviousLabel.setForeground(new java.awt.Color(0, 51, 51));
        PreviousLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PreviousLabel.setText("Previous");
        PreviousLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        PreviousLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PreviousLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreviousLabelMouseClicked(evt);
            }
        });
        StudentPanel.add(PreviousLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 30));

        NextLabel.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        NextLabel.setForeground(new java.awt.Color(0, 51, 51));
        NextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NextLabel.setText("NEXT");
        NextLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 102, 102)));
        NextLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NextLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NextLabelMouseClicked(evt);
            }
        });
        StudentPanel.add(NextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 80, 30));

        ReviewButton.setBackground(new java.awt.Color(0, 102, 153));
        ReviewButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ReviewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReviewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReviewButtonMouseClicked(evt);
            }
        });
        ReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewButtonActionPerformed(evt);
            }
        });
        StudentPanel.add(ReviewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        QuestionReview.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        QuestionReview.setForeground(new java.awt.Color(0, 51, 51));
        QuestionReview.setText("Mark this Question for Review.");
        StudentPanel.add(QuestionReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 180, -1));

        QnoLabel.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        QnoLabel.setForeground(new java.awt.Color(0, 51, 51));
        StudentPanel.add(QnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 30, 20));
        StudentPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 510, 110));

        QuestionBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcqs/MCQ1.png"))); // NOI18N
        QuestionBg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        StudentPanel.add(QuestionBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 540));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GO TO");
        StudentPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 70, -1));

        jButton1.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        StudentPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 50, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        AttemptedArea.setEditable(false);
        AttemptedArea.setColumns(20);
        AttemptedArea.setForeground(new java.awt.Color(51, 204, 0));
        AttemptedArea.setRows(5);
        AttemptedArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jScrollPane2.setViewportView(AttemptedArea);

        StudentPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 90, 380));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ReviewArea.setEditable(false);
        ReviewArea.setColumns(20);
        ReviewArea.setForeground(new java.awt.Color(255, 0, 0));
        ReviewArea.setRows(5);
        ReviewArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jScrollPane5.setViewportView(ReviewArea);

        StudentPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 90, 380));

        getContentPane().add(StudentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReviewButtonActionPerformed

    private void AnswerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnswerButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnswerButton1ActionPerformed

    private void AnswerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnswerButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnswerButton2ActionPerformed

    private void AnswerButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnswerButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnswerButton3ActionPerformed

    private void TeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoneButtonActionPerformed

    private void ChoiceButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoiceButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoiceButton1ActionPerformed

    private void ChoiceButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoiceButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoiceButton2ActionPerformed

    private void ChoiceButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoiceButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoiceButton3ActionPerformed

    private void ChoiceButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoiceButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoiceButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void TeacherButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherButton1ActionPerformed

    private void LoginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButton1ActionPerformed

    private void PasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordField1ActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void RollNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RollNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RollNumberFieldActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonActionPerformed

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void BackButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButton2ActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void BackButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButton3ActionPerformed

    private void Above80FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Above80FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Above80FieldActionPerformed

    private void Above70FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Above70FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Above70FieldActionPerformed

    private void Above60FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Above60FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Above60FieldActionPerformed

    private void Below40FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Below40FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Below40FieldActionPerformed

    private void Above90FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Above90FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Above90FieldActionPerformed

    private void TNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNameFieldActionPerformed

    private void TPercentageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TPercentageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TPercentageFieldActionPerformed

    private void TRollFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRollFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRollFieldActionPerformed

    private void BackButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButton4ActionPerformed

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterButtonActionPerformed

    private void TeacherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherButtonMouseClicked
        WelcomePanel.setVisible(false);
        TeacherSignInPanel.setVisible(true);
        PasswordField1.setText(null);
    }//GEN-LAST:event_TeacherButtonMouseClicked

    private void StudentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButtonMouseClicked
        WelcomePanel.setVisible(false);
        StudentSignInPanel.setVisible(true);
        NameField.setText(null);
        RollNumberField.setText(null);
    }//GEN-LAST:event_StudentButtonMouseClicked

    private void LoginButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButton1MouseClicked
        char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };
        if(Arrays.equals(PasswordField1.getPassword(),correctPassword))
        {
            TeacherSignInPanel.setVisible(false);
            TeacherPanel.setVisible(true);
            jTextField6.setText("(in seconds)");
        }
        else
            JOptionPane.showMessageDialog(null,"Incorrect Password!");
        PasswordField1.setText("");
    }//GEN-LAST:event_LoginButton1MouseClicked

    private void TeacherButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherButton1MouseClicked
        int k = JOptionPane.showConfirmDialog(null,"Would you like to upload a file?\n(You can also create question paper over here.)","Confirm",JOptionPane.YES_NO_OPTION);
        if(k==JOptionPane.NO_OPTION)
        {
            int n = JOptionPane.showConfirmDialog(null,"Would you like create new set of questions?","Confirm",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
                while(mcq.size()!=0)
                    mcq.remove(0);
                QuestionSetPanel.setVisible(true);
                TeacherPanel.setVisible(false);
            }
            else
            {
                QuestionSetPanel.setVisible(true);
                TeacherPanel.setVisible(false);
            }
            QuestionNoLabel.setText(""+(mcq.size()+1));
        }
        else
        {
            while(mcq.size()!=0)
                    mcq.remove(0);
            int cnt=0;
            hasUploaded=true;
            JFileChooser UploadFile=new JFileChooser();
            UploadFile.showOpenDialog(null);
            File f=UploadFile.getSelectedFile();
            if(f==null)
                JOptionPane.showMessageDialog(null,"No file chosen.");
            else
            {
                FileReader fr=null;
                BufferedReader br=null;
                String s="",q,op[];
                int a;
                op=new String[4];
                try {
                    fr=new FileReader(f.getAbsolutePath());
                    br=new BufferedReader(fr);
                    while(br.readLine()!=null)
                    {
                      q=br.readLine();
                      op[0]=br.readLine();
                      op[1]=br.readLine();
                      op[2]=br.readLine();
                      op[3]=br.readLine();
                      a=Integer.parseInt(br.readLine());
                      mcq.add(new questions(q,a,op));
                      s=br.readLine();
                    }
                    fr.close();
                } catch (Exception ex) {
                    Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_TeacherButton1MouseClicked

    private void Submit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Submit1MouseClicked
        if(jTextArea1.getText().equals("") || jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("") || jTextField4.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please fill the questions and answers correctly!");
        }
        else if(ChoiceButton1.isSelected()==false && ChoiceButton2.isSelected()==false && ChoiceButton3.isSelected()==false && ChoiceButton4.isSelected()==false)
            JOptionPane.showMessageDialog(null,"Please Select atleast one correct answer!");
        else
        {
            int i;
            if(ChoiceButton1.isSelected()==true)
                i=1;
            else if(ChoiceButton2.isSelected()==true)
                i=2;
            else if(ChoiceButton3.isSelected()==true)
                i=3;
            else
                i=4;
            String op[]=new String[4];
            op[0]=jTextField1.getText()+"";
            op[1]=jTextField2.getText()+"";
            op[2]=jTextField3.getText()+"";
            op[3]=jTextField4.getText()+"";
            mcq.add(new questions(jTextArea1.getText(),i,op));
            jTextArea1.setText("");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            ChoiceButton1.setSelected(false);
            ChoiceButton2.setSelected(false);
            ChoiceButton3.setSelected(false);
            ChoiceButton4.setSelected(false);
            QuestionNoLabel.setText(""+(mcq.size()+1));
        }
    }//GEN-LAST:event_Submit1MouseClicked

    private void DoneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoneButtonMouseClicked
        
        TeacherPanel.setVisible(true);
        QuestionSetPanel.setVisible(false);
    }//GEN-LAST:event_DoneButtonMouseClicked

    private void EnterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnterButtonMouseClicked
        int i;
        boolean found=false;
        for(i=0;i<stud.size();i++)
            if(stud.get(i).getRoll().equalsIgnoreCase(TRollField.getText()+""))
            {
                found=true;
                TNameField.setText(""+stud.get(i).getName());
                TPercentageField.setText(((stud.get(i).getMarks()*100.0)/mcq.size())+" %");
                break;
            }
        if(found==false)
            JOptionPane.showMessageDialog(null,"No such roll number found.");
        TRollField.setText("");
    }//GEN-LAST:event_EnterButtonMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void BackButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton2MouseClicked
        if(jTextField6.getText().equalsIgnoreCase("(in seconds)") || jTextField6.getText().equalsIgnoreCase("") || hasClicked==false)
             JOptionPane.showMessageDialog(null,"Time not entered. Please enter.");
        else{
        TeacherSignInPanel.setVisible(true);
        TeacherPanel.setVisible(false);
        }
    }//GEN-LAST:event_BackButton2MouseClicked

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        File file=null;
        OutputStream os=null;
        ObjectOutput oo=null;
        if(hasUploaded==true)
            while(mcq.size()!=0)
                mcq.remove(0);
        file=new File("E:\\students.ser");
        try {
            file.createNewFile();
            oo=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\students.ser")));
            oo.writeObject(stud);
            oo.close();
        } catch (Exception e) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        file=new File("E:\\mcq.ser");
        try {
            file.createNewFile();
            oo=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\mcq.ser")));
            oo.writeObject(mcq);
            oo.close();
        } catch (Exception e) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void BackButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton1MouseClicked
        TeacherSignInPanel.setVisible(false);
        WelcomePanel.setVisible(true);
    }//GEN-LAST:event_BackButton1MouseClicked

    private void StudentButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButton1MouseClicked
        TeacherPanel.setVisible(false);
        ViewIndividualPanel.setVisible(true);
        TRollField.setText("");
        TNameField.setText("");
        TPercentageField.setText("");
    }//GEN-LAST:event_StudentButton1MouseClicked

    private void StudentButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButton2MouseClicked
        TeacherPanel.setVisible(false);
        ViewOverallPanel.setVisible(true);
        int i,c9=0,c8=0,c7=0,c6=0,c4=0;
        for(i=0;i<stud.size();i++)
        {
            if((stud.get(i).getMarks()*100.0/mcq.size())>90)
                c9++;
            else if((stud.get(i).getMarks()*100.0/mcq.size())>80)
                c8++;
            else if((stud.get(i).getMarks()*100.0/mcq.size())>70)
                c7++;
            else if((stud.get(i).getMarks()*100.0/mcq.size())>60)
                c6++;
            else if((stud.get(i).getMarks()*100.0/mcq.size())<40)
                c4++;
        }
        Above90Field.setText(c9+"");
        Above80Field.setText(c8+"");
        Above70Field.setText(c7+"");
        Above60Field.setText(c6+"");
        Below40Field.setText(c4+"");
    }//GEN-LAST:event_StudentButton2MouseClicked

    private void BackButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton3MouseClicked
        TeacherPanel.setVisible(true);
        ViewOverallPanel.setVisible(false);
    }//GEN-LAST:event_BackButton3MouseClicked

    private void BackButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton4MouseClicked
        TeacherPanel.setVisible(true);
        ViewIndividualPanel.setVisible(false);
    }//GEN-LAST:event_BackButton4MouseClicked

    private void setAllQuestions()
    {
        int i=0;
        for(i=1;i<=mcq.size();i++)
            stud.get(stud.size()-1).q.add(new question(i,false,false,-1));
    }
    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        if(mcq.size()==0 || hasClicked==false)
            JOptionPane.showMessageDialog(null,"Question Paper not set.");
        else
        {
            int i=0,flag;
            if(NameField.getText().equalsIgnoreCase("") || RollNumberField.getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null,"Please fill the form properly.");
            else
            {
                flag=0;
                for(i=0;i<stud.size();i++)
                {
                    if((stud.get(i).getName().equalsIgnoreCase(NameField.getText()+"") && stud.get(i).getRoll().equalsIgnoreCase(RollNumberField.getText()+"")) || stud.get(i).getRoll().equalsIgnoreCase(RollNumberField.getText()+""))
                        flag=1;
                }
                if (flag==0)
                {
                    time=count;
                    TimeLabel.setText("Time Left: "+time+" sec");
                    stud.add(new student(NameField.getText(),RollNumberField.getText()));
                    StudentSignInPanel.setVisible(false);
                    StudentPanel.setVisible(true);
                    QnoLabel.setText("1");
                    WelNameLabel.setText("Welcome, "+NameField.getText());
                    setAllQuestions();
                    QnoLabel.setText("1");
                    String s="<html>"+mcq.get(0).getQ()+"</html>";
                    String op[]=mcq.get(0).getOption();
                    jLabel7.setText(s);
                    OptionLabel1.setText(op[0]);
                    OptionLabel2.setText(op[1]);
                    OptionLabel3.setText(op[2]);
                    OptionLabel4.setText(op[3]);
                    currentQ=1;
                    jLabel4.setText("Total Questions : " + mcq.size());
                    timer.start();
                }
                else
                    JOptionPane.showMessageDialog(null,"You have already taken the test!");
            }
        }
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void EndTestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EndTestButtonMouseClicked
        int n = JOptionPane.showConfirmDialog(null,"Would you like end your test?","Confirm",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null,"Thank You for taking the test.\nYour Score is "+stud.get(stud.size()-1).getMarks());
            StudentPanel.setVisible(false);
            WelcomePanel.setVisible(true);
            timer.stop();
            TimeLabel.setText("");
        }
    }//GEN-LAST:event_EndTestButtonMouseClicked

    private void PreviousLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviousLabelMouseClicked
        if(AnswerButton1.isSelected()==false && AnswerButton2.isSelected()==false && AnswerButton3.isSelected()==false && AnswerButton4.isSelected()==false)
        {
            if(stud.get(stud.size()-1).q.get(currentQ-1).Attempted()==true)
            {
                String s=AttemptedArea.getText()+"",s1="",s2="";
                s=s.trim();
                int i=0,flag=0;
                for(int k=7;k<=10&&(flag==0);k++)
                {
                    s2="";
                    for(i=0;(i<s.length())&&(i+k<=s.length())&&(flag==0);i++)
                    {
                        s1=s.substring(i,i+k);
                        if(s1.equalsIgnoreCase("Q No. "+currentQ))
                        {
                            i+=k;
                            flag=1;
                        }
                        else
                            s2+=s.charAt(i);
                    }
                }
                while(i<s.length())
                        s2+=s.charAt(i++);
                AttemptedArea.setText("");
                AttemptedArea.setText(s2);
            }
            stud.get(stud.size()-1).q.get(currentQ-1).setAttempted(false);
            if(mcq.get(currentQ-1).getA()==stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven())
                stud.get(stud.size()-1).setMarks(stud.get(stud.size()-1).getMarks()-1);
            stud.get(stud.size()-1).q.get(currentQ-1).setAnswer(-1);
            
        }
        if(currentQ>1)
        {
            currentQ--;
            QnoLabel.setText(""+(currentQ));
            String s="<html>"+mcq.get(currentQ-1).getQ()+"</html>";
            String op[]=mcq.get(currentQ-1).getOption();
            jLabel7.setText(s);
            OptionLabel1.setText(op[0]);
            OptionLabel2.setText(op[1]);
            OptionLabel3.setText(op[2]);
            OptionLabel4.setText(op[3]);
            AnswerButton1.setSelected(false);
            AnswerButton2.setSelected(false);
            AnswerButton3.setSelected(false);
            AnswerButton4.setSelected(false);
            ReviewButton.setSelected(false);
            if(stud.get(stud.size()-1).q.get(currentQ-1).Marked()==true)
                ReviewButton.setSelected(true);
            int an=stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven();
            if(an==1)
                AnswerButton1.setSelected(true);
            else if(an==2)
                AnswerButton2.setSelected(true);
            else if(an==3)
                AnswerButton3.setSelected(true);
            else if(an==4)
                AnswerButton4.setSelected(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No further Questions!");
        }
    }//GEN-LAST:event_PreviousLabelMouseClicked

    private void NextLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextLabelMouseClicked
        if(AnswerButton1.isSelected()==false && AnswerButton2.isSelected()==false && AnswerButton3.isSelected()==false && AnswerButton4.isSelected()==false)
        {
            if(stud.get(stud.size()-1).q.get(currentQ-1).Attempted()==true)
            {
                String s=AttemptedArea.getText()+"",s1="",s2="";
                s=s.trim();
                int i=0,flag=0;
                for(int k=7;k<=10&&(flag==0);k++)
                {
                    s2="";
                    for(i=0;(i<s.length())&&(i+k<=s.length())&&(flag==0);i++)
                    {
                        s1=s.substring(i,i+k);
                        if(s1.equalsIgnoreCase("Q No. "+currentQ))
                        {
                            i+=k;
                            flag=1;
                        }
                        else
                            s2+=s.charAt(i);
                    }
                }
                while(i<s.length())
                        s2+=s.charAt(i++);
                AttemptedArea.setText("");
                AttemptedArea.setText(s2);
            }
            stud.get(stud.size()-1).q.get(currentQ-1).setAttempted(false);
            if(mcq.get(currentQ-1).getA()==stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven())
                stud.get(stud.size()-1).setMarks(stud.get(stud.size()-1).getMarks()-1);
            stud.get(stud.size()-1).q.get(currentQ-1).setAnswer(-1);
            
        }
        currentQ++;
        if(currentQ>mcq.size())
        {
            JOptionPane.showMessageDialog(null,"No further Questions!");
            currentQ--;
        }
        else
        {
                AnswerButton1.setSelected(false);
                AnswerButton2.setSelected(false);
                AnswerButton3.setSelected(false);
                AnswerButton4.setSelected(false);
                ReviewButton.setSelected(false);
                if(stud.get(stud.size()-1).q.get(currentQ-1).Marked()==true)
                     ReviewButton.setSelected(true);
                int an=stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven();
                if(an==1)
                    AnswerButton1.setSelected(true);
                else if(an==2)
                    AnswerButton2.setSelected(true);
                else if(an==3)
                    AnswerButton3.setSelected(true);
                else if(an==4)
                    AnswerButton4.setSelected(true);
            //}
            QnoLabel.setText(""+(currentQ));
            String s="<html>"+mcq.get(currentQ-1).getQ()+"</html>";
            String op[]=mcq.get(currentQ-1).getOption();
            jLabel7.setText(s);
            OptionLabel1.setText(op[0]);
            OptionLabel2.setText(op[1]);
            OptionLabel3.setText(op[2]);
            OptionLabel4.setText(op[3]);
        }
    }//GEN-LAST:event_NextLabelMouseClicked

    private void SubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMouseClicked
        int flag=0;
        if(AnswerButton1.isSelected()==false && AnswerButton2.isSelected()==false && AnswerButton3.isSelected()==false && AnswerButton4.isSelected()==false)
            JOptionPane.showMessageDialog(null,"No Option Selected!");
        else
        {
            if(stud.get(stud.size()-1).q.get(currentQ-1).Attempted()==true)
            {
                flag=1;
                if(mcq.get(currentQ-1).getA()==stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven())
                    stud.get(stud.size()-1).setMarks(stud.get(stud.size()-1).getMarks()-1);
            }
            if(stud.get(stud.size()-1).q.get(currentQ-1).Marked()==true)
                ReviewButton.setSelected(true);
            int i=0;
            if(AnswerButton1.isSelected()==true)
                i=1;
            else if(AnswerButton2.isSelected()==true)
                i=2;
            else if(AnswerButton3.isSelected()==true)
                i=3;
            else if(AnswerButton4.isSelected()==true)
                i=4;
            stud.get(stud.size()-1).q.get(currentQ-1).setAttempted(true);
            stud.get(stud.size()-1).q.get(currentQ-1).setAnswer(i);
            if(mcq.get(currentQ-1).getA()==i)
            {
                stud.get(stud.size()-1).setMarks(stud.get(stud.size()-1).getMarks()+1);
            }
            if(flag==0)
            {
                String s=AttemptedArea.getText();
                s+="\nQ No. "+currentQ;
                AttemptedArea.setText(s);
            }
            currentQ++;
            if(currentQ>mcq.size())
            {
                JOptionPane.showMessageDialog(null,"No further Questions!");
                currentQ--;
            }
            else
            {
                QnoLabel.setText(""+(currentQ));
                String s="<html>"+mcq.get(currentQ-1).getQ()+"</html>";
                String op[]=mcq.get(currentQ-1).getOption();
                jLabel7.setText(s);
                OptionLabel1.setText(op[0]);
                OptionLabel2.setText(op[1]);
                OptionLabel3.setText(op[2]);
                OptionLabel4.setText(op[3]);
                AnswerButton1.setSelected(false);
                AnswerButton2.setSelected(false);
                AnswerButton3.setSelected(false);
                AnswerButton4.setSelected(false);
                ReviewButton.setSelected(false);
                int an=stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven();
                if(an==1)
                    AnswerButton1.setSelected(true);
                else if(an==2)
                    AnswerButton2.setSelected(true);
                else if(an==3)
                    AnswerButton3.setSelected(true);
                else if(an==4)
                    AnswerButton4.setSelected(true);
                if(stud.get(stud.size()-1).q.get(currentQ-1).Marked()==true)
                    ReviewButton.setSelected(true);
            }
            
        }
    }//GEN-LAST:event_SubmitMouseClicked

    private void ReviewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReviewButtonMouseClicked
        if(ReviewButton.isSelected()==true)
        {
            String s=ReviewArea.getText();
            s+="\nQ No. "+currentQ;
            ReviewArea.setText("");
            ReviewArea.setText(s);
            stud.get(stud.size()-1).q.get(currentQ-1).setMarked(true);
        }
        else
        {
            int i=0,flag=0;
            String s=ReviewArea.getText()+"",s1="",s2="";
            s=s.trim();
            for(int k=7;k<=10&&(flag==0);k++)
            {
                s2="";
                for(i=0;(i<s.length())&&(i+k<=s.length())&&(flag==0);i++)
                {
                    s1=s.substring(i,i+k);
                    if(s1.equalsIgnoreCase("Q No. "+currentQ))
                    {
                        i+=k;
                        flag=1;
                    }
                    else
                        s2+=s.charAt(i);
                }
            }
            while(i<s.length())
                    s2+=s.charAt(i++);
            ReviewArea.setText("");
            ReviewArea.setText(s2);
            stud.get(stud.size()-1).q.get(currentQ-1).setMarked(false);
        }
    }//GEN-LAST:event_ReviewButtonMouseClicked

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        StudentSignInPanel.setVisible(false);
        WelcomePanel.setVisible(true);
    }//GEN-LAST:event_BackButtonMouseClicked

    private void AnswerButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnswerButton1MouseClicked
        AnswerButton2.setSelected(false);
        AnswerButton3.setSelected(false);
        AnswerButton4.setSelected(false);
    }//GEN-LAST:event_AnswerButton1MouseClicked

    private void AnswerButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnswerButton2MouseClicked
        AnswerButton1.setSelected(false);
        AnswerButton3.setSelected(false);
        AnswerButton4.setSelected(false);
    }//GEN-LAST:event_AnswerButton2MouseClicked

    private void AnswerButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnswerButton3MouseClicked
        AnswerButton1.setSelected(false);
        AnswerButton2.setSelected(false);
        AnswerButton4.setSelected(false);
    }//GEN-LAST:event_AnswerButton3MouseClicked

    private void ChoiceButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChoiceButton1MouseClicked
        ChoiceButton2.setSelected(false);
        ChoiceButton3.setSelected(false);
        ChoiceButton4.setSelected(false);
    }//GEN-LAST:event_ChoiceButton1MouseClicked

    private void ChoiceButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChoiceButton2MouseClicked
        ChoiceButton1.setSelected(false);
        ChoiceButton3.setSelected(false);
        ChoiceButton4.setSelected(false);
    }//GEN-LAST:event_ChoiceButton2MouseClicked

    private void ChoiceButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChoiceButton3MouseClicked
        ChoiceButton1.setSelected(false);
        ChoiceButton2.setSelected(false);
        ChoiceButton4.setSelected(false);
    }//GEN-LAST:event_ChoiceButton3MouseClicked

    private void ChoiceButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChoiceButton4MouseClicked
        ChoiceButton1.setSelected(false);
        ChoiceButton2.setSelected(false);
        ChoiceButton3.setSelected(false);
    }//GEN-LAST:event_ChoiceButton4MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int flag=0;
        int n=0;
        try {
             n=Integer.parseInt(jTextField5.getText()+"");
        } catch(Exception e)
        {
            flag=1;
            JOptionPane.showMessageDialog(null,"Inavlid String.");
        }
        if(flag==0)
        {
            if(n>mcq.size() || n<1)
                JOptionPane.showMessageDialog(null,"Inavlid input.");
            else
            {
            currentQ=n;
            AnswerButton1.setSelected(false);
            AnswerButton2.setSelected(false);
            AnswerButton3.setSelected(false);
            AnswerButton4.setSelected(false);
            ReviewButton.setSelected(false);
            if(stud.get(stud.size()-1).q.get(currentQ-1).Marked()==true)
                 ReviewButton.setSelected(true);
            int an=stud.get(stud.size()-1).q.get(currentQ-1).AnswerGiven();
            if(an==1)
                AnswerButton1.setSelected(true);
            else if(an==2)
                AnswerButton2.setSelected(true);
            else if(an==3)
                AnswerButton3.setSelected(true);
            else if(an==4)
                AnswerButton4.setSelected(true);
            QnoLabel.setText(""+(currentQ));
            String s="<html>"+mcq.get(currentQ-1).getQ()+"</html>";
            String op[]=mcq.get(currentQ-1).getOption();
            jLabel7.setText(s);
            OptionLabel1.setText(op[0]);
            OptionLabel2.setText(op[1]);
            OptionLabel3.setText(op[2]);
            OptionLabel4.setText(op[3]);
            }
        }
        jTextField5.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private void AnswerButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnswerButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AnswerButton4MouseClicked

    private void AnswerButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnswerButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnswerButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
           count=Integer.parseInt(jTextField6.getText()+"");
           hasClicked=true;
           timer=new Timer(1000,new TimerListener());
       }
       catch(Exception e)
       {
           hasClicked=false;
           JOptionPane.showMessageDialog(null,"Invalid time!");
           jTextField6.setText("(in seconds)");
       }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Above60Field;
    private javax.swing.JTextField Above70Field;
    private javax.swing.JTextField Above80Field;
    private javax.swing.JTextField Above90Field;
    private javax.swing.JRadioButton AnswerButton1;
    private javax.swing.JRadioButton AnswerButton2;
    private javax.swing.JRadioButton AnswerButton3;
    private javax.swing.JRadioButton AnswerButton4;
    private javax.swing.JTextArea AttemptedArea;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton BackButton1;
    private javax.swing.JButton BackButton2;
    private javax.swing.JButton BackButton3;
    private javax.swing.JButton BackButton4;
    private javax.swing.JTextField Below40Field;
    private javax.swing.JRadioButton ChoiceButton1;
    private javax.swing.JRadioButton ChoiceButton2;
    private javax.swing.JRadioButton ChoiceButton3;
    private javax.swing.JRadioButton ChoiceButton4;
    private javax.swing.JButton DoneButton;
    private javax.swing.JButton EndTestButton;
    private javax.swing.JButton EnterButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton LoginButton1;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel NextLabel;
    private javax.swing.JLabel OptionLabel1;
    private javax.swing.JLabel OptionLabel2;
    private javax.swing.JLabel OptionLabel3;
    private javax.swing.JLabel OptionLabel4;
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel PasswordLabel1;
    private javax.swing.JLabel PasswordLabel10;
    private javax.swing.JLabel PasswordLabel2;
    private javax.swing.JLabel PasswordLabel3;
    private javax.swing.JLabel PasswordLabel4;
    private javax.swing.JLabel PasswordLabel5;
    private javax.swing.JLabel PasswordLabel8;
    private javax.swing.JLabel PasswordLabel9;
    private javax.swing.JLabel PreviousLabel;
    private javax.swing.JLabel QnoLabel;
    private javax.swing.JLabel QuestionBg;
    private javax.swing.JLabel QuestionNoLabel;
    private javax.swing.JLabel QuestionNumberLabel;
    private javax.swing.JLabel QuestionNumberLabel1;
    private javax.swing.JLabel QuestionReview;
    private javax.swing.JPanel QuestionSetPanel;
    private javax.swing.JTextArea ReviewArea;
    private javax.swing.JRadioButton ReviewButton;
    private javax.swing.JTextField RollNumberField;
    private javax.swing.JLabel RollNumberLabel;
    private javax.swing.JButton StudentButton;
    private javax.swing.JButton StudentButton1;
    private javax.swing.JButton StudentButton2;
    private javax.swing.JPanel StudentPanel;
    private javax.swing.JPanel StudentSignInPanel;
    private javax.swing.JLabel Submit;
    private javax.swing.JLabel Submit1;
    private javax.swing.JTextField TNameField;
    private javax.swing.JTextField TPercentageField;
    private javax.swing.JTextField TRollField;
    private javax.swing.JButton TeacherButton;
    private javax.swing.JButton TeacherButton1;
    private javax.swing.JPanel TeacherPanel;
    private javax.swing.JPanel TeacherSignInPanel;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JPanel ViewIndividualPanel;
    private javax.swing.JPanel ViewOverallPanel;
    private javax.swing.JLabel WelNameLabel;
    private javax.swing.JLabel WelcomeBg;
    private javax.swing.JLabel WelcomeBg1;
    private javax.swing.JLabel WelcomeBg2;
    private javax.swing.JLabel WelcomeBg3;
    private javax.swing.JLabel WelcomeBg4;
    private javax.swing.JLabel WelcomeBg5;
    private javax.swing.JLabel WelcomeBg6;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel WelcomeLabel1;
    private javax.swing.JLabel WelcomeLabel2;
    private javax.swing.JLabel WelcomeLabel3;
    private javax.swing.JLabel WelcomeLabel4;
    private javax.swing.JLabel WelcomeLabel5;
    private javax.swing.JLabel WelcomeLabel6;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
