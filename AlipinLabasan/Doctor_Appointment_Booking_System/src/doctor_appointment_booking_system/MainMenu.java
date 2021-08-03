/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_appointment_booking_system;


import static doctor_appointment_booking_system.LoginData.accountID;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    boolean menuStatus = false;
    Date currentDate = null;
    int roomNoChoosen;
    String timeNoChoosen;
    int userAccountID;
    String date;
    DBHelper db = new DBHelper();
    
    public MainMenu() {
        initComponents();
        jPanel1.setSize(0, 400);
        AppointmentListPanel.setVisible(false);
        PersonalInfoPanel.setVisible(false);
        sidebar_btnClose.setVisible(false);
        userAccountID = db.getUserAccountID();
        pic("C:/Users/Labasan/Documents/NetBeansProjects/menu.png", sidebar_btnOpen);
        pic("C:/Users/Labasan/Documents/NetBeansProjects/return.png", sidebar_btnClose);
        date();
    }
    
    public void showInfo(){
     //  AccountIDLBL.getAccountID();
        try {
            AccountIDLBL.setText(String.valueOf(userAccountID));
            fnameLBL.setText(db.selectFirstName(userAccountID));
            lnameLBL.setText(db.selectLastName(userAccountID));
            emailLBL.setText(db.selectEmail(userAccountID));
            contactLBL.setText(db.selectContact(userAccountID));
            usernameLBL.setText(db.selectUsername(userAccountID));
            passwordLBL.setText(db.selectPassword(userAccountID));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
    
     public void ShowAppointmentList(){
        ArrayList<ReservationData> list = db.getReservationData(userAccountID);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[4];
        
        for(int i=0; i < list.size(); i++){
            row[0] = list.get(i).getReservationID();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getRoomNo();
            row[3] = list.get(i).getTime();
            
            model.addRow(row);
        }
    }
    
    public void date(){
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String d = sdf.format(date);
            date = sdf.parse(d);
            jDateChooser1.setDate(date);
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void pic(String icon, JLabel label){
        ImageIcon Myimg = new ImageIcon(icon);
        Image img = Myimg.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        label.setIcon(image);
    }
    
    public void sidebarOpen(){
        Thread th = new Thread(){
            @Override
            public void run(){
                try{
                for(int i=50; i<=160; i++){
                    Thread.sleep(0, 10);
                    jPanel1.setSize(i, 400);
                    sidebar_btnOpen.setVisible(false);
                    
                    if(i==60){
                        sidebar_btnClose.setVisible(true);
                    }
                    if(i==155){
                        room1.setVisible(false);
                        room4.setVisible(false);
                        room7.setVisible(false);
                    }
                }
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, e);
            }
            }
        };th.start();
    }
    
    public void sidebarClose(){
        Thread th = new Thread(){
            @Override
            public void run(){
                try {
                    for(int i=160; i>=0; i--){
                    Thread.sleep(0, 10);                        
                            jPanel1.setSize(i, 400);
                            sidebar_btnOpen.setVisible(false);
                        
                        if(i==0){
                            sidebar_btnOpen.setVisible(true);
                            sidebar_btnClose.setVisible(false);
                        }
                        if(i==150){
                            room1.setVisible(true);
                            room4.setVisible(true);
                            room7.setVisible(true);
                        }
                       
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        };th.start();
    }    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        sidebar_btnOpen = new javax.swing.JLabel();
        sidebar_btnClose = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        reservation = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        AppointmentList = new javax.swing.JLabel();
        PersonalInfo = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        reservationPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        room1 = new javax.swing.JButton();
        room2 = new javax.swing.JButton();
        room3 = new javax.swing.JButton();
        room4 = new javax.swing.JButton();
        room5 = new javax.swing.JButton();
        room6 = new javax.swing.JButton();
        room7 = new javax.swing.JButton();
        room8 = new javax.swing.JButton();
        room9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TimeBtn1 = new javax.swing.JButton();
        TimeBtn2 = new javax.swing.JButton();
        TimeBtn3 = new javax.swing.JButton();
        TimeBtn4 = new javax.swing.JButton();
        TimeBtn5 = new javax.swing.JButton();
        SubmitBtn = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        AppointmentListPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CancelBtn = new javax.swing.JButton();
        PersonalInfoPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        AccountIDLBL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fnameTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lnameTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        contactTF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        passwordTF = new javax.swing.JTextField();
        reportBTN2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fnameLBL = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lnameLBL = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        emailLBL = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        contactLBL = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        usernameLBL = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        passwordLBL = new javax.swing.JLabel();

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 77, 125));
        jLabel12.setText("FIRST NAME:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WeCare Medical Center");
        setUndecorated(true);
        getContentPane().setLayout(null);

        sidebar_btnOpen.setBackground(new java.awt.Color(204, 255, 255));
        sidebar_btnOpen.setForeground(new java.awt.Color(204, 255, 255));
        sidebar_btnOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidebar_btnOpen.setOpaque(true);
        sidebar_btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidebar_btnOpenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidebar_btnOpenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidebar_btnOpenMouseExited(evt);
            }
        });
        getContentPane().add(sidebar_btnOpen);
        sidebar_btnOpen.setBounds(10, 10, 30, 30);

        sidebar_btnClose.setBackground(new java.awt.Color(204, 255, 255));
        sidebar_btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidebar_btnClose.setOpaque(true);
        sidebar_btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidebar_btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidebar_btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sidebar_btnCloseMouseExited(evt);
            }
        });
        getContentPane().add(sidebar_btnClose);
        sidebar_btnClose.setBounds(10, 10, 30, 30);

        jPanel1.setBackground(new java.awt.Color(129, 186, 216));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 186, 216)));
        jPanel1.setLayout(null);

        reservation.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        reservation.setForeground(new java.awt.Color(255, 255, 255));
        reservation.setText("Reservation");
        reservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationMouseClicked(evt);
            }
        });
        jPanel1.add(reservation);
        reservation.setBounds(30, 200, 120, 22);

        profile.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("+ Profile");
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jPanel1.add(profile);
        profile.setBounds(27, 110, 90, 22);

        AppointmentList.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        AppointmentList.setForeground(new java.awt.Color(255, 255, 255));
        AppointmentList.setText("- Appointment list");
        AppointmentList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AppointmentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppointmentListMouseClicked(evt);
            }
        });
        jPanel1.add(AppointmentList);
        AppointmentList.setBounds(37, 142, 114, 15);

        PersonalInfo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        PersonalInfo.setForeground(new java.awt.Color(255, 255, 255));
        PersonalInfo.setText("- Personal Info");
        PersonalInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PersonalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonalInfoMouseClicked(evt);
            }
        });
        jPanel1.add(PersonalInfo);
        PersonalInfo.setBounds(37, 167, 105, 15);

        Logout.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Sign out");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        jPanel1.add(Logout);
        Logout.setBounds(30, 240, 100, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 170, 400);

        reservationPanel.setBackground(new java.awt.Color(204, 255, 255));
        reservationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 186, 216), 2));
        reservationPanel.setMinimumSize(new java.awt.Dimension(700, 400));
        reservationPanel.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel3.setText("RESERVATION");
        reservationPanel.add(jLabel3);
        jLabel3.setBounds(270, 30, 200, 20);

        room1.setBackground(new java.awt.Color(129, 186, 216));
        room1.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room1.setForeground(new java.awt.Color(0, 102, 102));
        room1.setText("General Pediatrician");
        room1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room1ActionPerformed(evt);
            }
        });
        reservationPanel.add(room1);
        room1.setBounds(30, 120, 140, 50);

        room2.setBackground(new java.awt.Color(129, 186, 216));
        room2.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room2.setForeground(new java.awt.Color(0, 102, 102));
        room2.setText("Cardiologist");
        room2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room2ActionPerformed(evt);
            }
        });
        reservationPanel.add(room2);
        room2.setBounds(180, 120, 140, 50);

        room3.setBackground(new java.awt.Color(129, 186, 216));
        room3.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room3.setForeground(new java.awt.Color(0, 102, 102));
        room3.setText("ENT Physician");
        room3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room3ActionPerformed(evt);
            }
        });
        reservationPanel.add(room3);
        room3.setBounds(330, 120, 140, 50);

        room4.setBackground(new java.awt.Color(129, 186, 216));
        room4.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room4.setForeground(new java.awt.Color(0, 102, 102));
        room4.setText("Pulmonologist");
        room4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room4ActionPerformed(evt);
            }
        });
        reservationPanel.add(room4);
        room4.setBounds(30, 200, 140, 50);

        room5.setBackground(new java.awt.Color(129, 186, 216));
        room5.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room5.setForeground(new java.awt.Color(0, 102, 102));
        room5.setText("Gynecologist");
        room5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room5ActionPerformed(evt);
            }
        });
        reservationPanel.add(room5);
        room5.setBounds(180, 200, 140, 50);

        room6.setBackground(new java.awt.Color(129, 186, 216));
        room6.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room6.setForeground(new java.awt.Color(0, 102, 102));
        room6.setText("General Medicine");
        room6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room6ActionPerformed(evt);
            }
        });
        reservationPanel.add(room6);
        room6.setBounds(330, 200, 140, 50);

        room7.setBackground(new java.awt.Color(129, 186, 216));
        room7.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room7.setForeground(new java.awt.Color(0, 102, 102));
        room7.setText("Gastroenterologist");
        room7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room7ActionPerformed(evt);
            }
        });
        reservationPanel.add(room7);
        room7.setBounds(30, 280, 140, 50);

        room8.setBackground(new java.awt.Color(129, 186, 216));
        room8.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room8.setForeground(new java.awt.Color(0, 102, 102));
        room8.setText("Dermatologist");
        room8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room8ActionPerformed(evt);
            }
        });
        reservationPanel.add(room8);
        room8.setBounds(180, 280, 140, 50);

        room9.setBackground(new java.awt.Color(129, 186, 216));
        room9.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        room9.setForeground(new java.awt.Color(0, 102, 102));
        room9.setText("Orthopedician");
        room9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        room9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room9ActionPerformed(evt);
            }
        });
        reservationPanel.add(room9);
        room9.setBounds(330, 280, 140, 50);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Select Room:");
        reservationPanel.add(jLabel1);
        jLabel1.setBounds(30, 90, 100, 15);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel2.setText("Select Date:");
        reservationPanel.add(jLabel2);
        jLabel2.setBounds(490, 80, 80, 15);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Select Time:");
        reservationPanel.add(jLabel4);
        jLabel4.setBounds(490, 150, 90, 15);

        TimeBtn1.setBackground(new java.awt.Color(129, 186, 216));
        TimeBtn1.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        TimeBtn1.setForeground(new java.awt.Color(0, 102, 102));
        TimeBtn1.setText("9:00AM - 11:30AM");
        TimeBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeBtn1ActionPerformed(evt);
            }
        });
        reservationPanel.add(TimeBtn1);
        TimeBtn1.setBounds(511, 180, 130, 23);

        TimeBtn2.setBackground(new java.awt.Color(129, 186, 216));
        TimeBtn2.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        TimeBtn2.setForeground(new java.awt.Color(0, 102, 102));
        TimeBtn2.setText("11:30AM - 2:00PM");
        TimeBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeBtn2ActionPerformed(evt);
            }
        });
        reservationPanel.add(TimeBtn2);
        TimeBtn2.setBounds(511, 210, 130, 23);

        TimeBtn3.setBackground(new java.awt.Color(129, 186, 216));
        TimeBtn3.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        TimeBtn3.setForeground(new java.awt.Color(0, 102, 102));
        TimeBtn3.setText("2:00PM - 4:30PM");
        TimeBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeBtn3ActionPerformed(evt);
            }
        });
        reservationPanel.add(TimeBtn3);
        TimeBtn3.setBounds(511, 240, 130, 23);

        TimeBtn4.setBackground(new java.awt.Color(129, 186, 216));
        TimeBtn4.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        TimeBtn4.setForeground(new java.awt.Color(0, 102, 102));
        TimeBtn4.setText("4:30PM - 7:00PM");
        TimeBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeBtn4ActionPerformed(evt);
            }
        });
        reservationPanel.add(TimeBtn4);
        TimeBtn4.setBounds(511, 270, 130, 23);

        TimeBtn5.setBackground(new java.awt.Color(129, 186, 216));
        TimeBtn5.setFont(new java.awt.Font("Gadugi", 1, 10)); // NOI18N
        TimeBtn5.setForeground(new java.awt.Color(0, 102, 102));
        TimeBtn5.setText("7:00PM - 9:30PM");
        TimeBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeBtn5ActionPerformed(evt);
            }
        });
        reservationPanel.add(TimeBtn5);
        TimeBtn5.setBounds(511, 300, 130, 23);

        SubmitBtn.setBackground(new java.awt.Color(129, 186, 216));
        SubmitBtn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SubmitBtn.setForeground(new java.awt.Color(0, 102, 102));
        SubmitBtn.setText("Submit");
        SubmitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBtnActionPerformed(evt);
            }
        });
        reservationPanel.add(SubmitBtn);
        SubmitBtn.setBounds(530, 340, 90, 40);
        reservationPanel.add(jDateChooser1);
        jDateChooser1.setBounds(490, 110, 150, 30);

        getContentPane().add(reservationPanel);
        reservationPanel.setBounds(0, 0, 700, 400);

        AppointmentListPanel.setBackground(new java.awt.Color(255, 255, 255));
        AppointmentListPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 186, 216), 2));
        AppointmentListPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppointmentListPanelMouseClicked(evt);
            }
        });
        AppointmentListPanel.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel5.setText("MY APPOINTMENT LIST");
        AppointmentListPanel.add(jLabel5);
        jLabel5.setBounds(200, 30, 300, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ReservationID", "Date", "Room Number", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        AppointmentListPanel.add(jScrollPane1);
        jScrollPane1.setBounds(90, 100, 530, 180);

        CancelBtn.setBackground(new java.awt.Color(129, 186, 216));
        CancelBtn.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        CancelBtn.setText("Cancel Appointment");
        CancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        AppointmentListPanel.add(CancelBtn);
        CancelBtn.setBounds(270, 320, 160, 30);

        getContentPane().add(AppointmentListPanel);
        AppointmentListPanel.setBounds(0, 0, 700, 400);

        PersonalInfoPanel.setBackground(new java.awt.Color(129, 186, 216));
        PersonalInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 186, 216), 2));
        PersonalInfoPanel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 77, 125));
        jLabel7.setText("UPDATE ACCOUNT INFORMATION");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 20, 307, 22);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(1, 77, 125));
        jLabel17.setText("ACCOUNT ID  :");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(60, 60, 89, 15);

        AccountIDLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AccountIDLBL.setText("AccounIDLbl");
        jPanel2.add(AccountIDLBL);
        AccountIDLBL.setBounds(170, 60, 70, 14);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 77, 125));
        jLabel8.setText("FIRST NAME:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(60, 100, 80, 20);
        jPanel2.add(fnameTF);
        fnameTF.setBounds(160, 90, 200, 30);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 77, 125));
        jLabel9.setText("LAST NAME:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(60, 140, 73, 20);
        jPanel2.add(lnameTF);
        lnameTF.setBounds(160, 130, 200, 30);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 77, 125));
        jLabel10.setText("E-MAIL:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(60, 180, 48, 20);
        jPanel2.add(emailTF);
        emailTF.setBounds(160, 170, 200, 30);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(1, 77, 125));
        jLabel18.setText("CONTACT :");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(60, 220, 64, 20);
        jPanel2.add(contactTF);
        contactTF.setBounds(160, 210, 200, 30);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(1, 77, 125));
        jLabel20.setText("USERNAME:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(60, 260, 72, 20);
        jPanel2.add(usernameTF);
        usernameTF.setBounds(160, 250, 200, 30);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 77, 125));
        jLabel11.setText("PASSWORD:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(60, 300, 75, 20);
        jPanel2.add(passwordTF);
        passwordTF.setBounds(160, 290, 200, 30);

        reportBTN2.setBackground(new java.awt.Color(1, 77, 125));
        reportBTN2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reportBTN2.setForeground(new java.awt.Color(255, 255, 255));
        reportBTN2.setText("CONFIRM");
        reportBTN2.setBorder(null);
        reportBTN2.setBorderPainted(false);
        reportBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBTN2ActionPerformed(evt);
            }
        });
        jPanel2.add(reportBTN2);
        reportBTN2.setBounds(300, 350, 90, 30);

        PersonalInfoPanel.add(jPanel2);
        jPanel2.setBounds(0, 0, 420, 400);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 77, 125));
        jLabel6.setText("PERSONAL INFORMATION");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 77, 125));
        jLabel13.setText("FIRST NAME:");

        fnameLBL.setBackground(new java.awt.Color(255, 255, 255));
        fnameLBL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fnameLBL.setText("FNAME");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 77, 125));
        jLabel14.setText("LAST NAME:");

        lnameLBL.setBackground(new java.awt.Color(255, 255, 255));
        lnameLBL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lnameLBL.setText("LNAME");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(1, 77, 125));
        jLabel15.setText("E-MAIL:");

        emailLBL.setBackground(new java.awt.Color(255, 255, 255));
        emailLBL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLBL.setText("EMAIL");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(1, 77, 125));
        jLabel19.setText("CONTACT NUMBER:");

        contactLBL.setBackground(new java.awt.Color(255, 255, 255));
        contactLBL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contactLBL.setText("CONTACT");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(1, 77, 125));
        jLabel21.setText("USERNAME:");

        usernameLBL.setBackground(new java.awt.Color(255, 255, 255));
        usernameLBL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernameLBL.setText("USERNAME");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 77, 125));
        jLabel16.setText("PASSWORD:");

        passwordLBL.setBackground(new java.awt.Color(255, 255, 255));
        passwordLBL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLBL.setText("PASSWORD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(emailLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fnameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lnameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(contactLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel13)
                .addGap(7, 7, 7)
                .addComponent(fnameLBL)
                .addGap(5, 5, 5)
                .addComponent(jLabel14)
                .addGap(7, 7, 7)
                .addComponent(lnameLBL)
                .addGap(5, 5, 5)
                .addComponent(jLabel15)
                .addGap(7, 7, 7)
                .addComponent(emailLBL)
                .addGap(5, 5, 5)
                .addComponent(jLabel19)
                .addGap(7, 7, 7)
                .addComponent(contactLBL)
                .addGap(5, 5, 5)
                .addComponent(jLabel21)
                .addGap(7, 7, 7)
                .addComponent(usernameLBL)
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addGap(7, 7, 7)
                .addComponent(passwordLBL))
        );

        PersonalInfoPanel.add(jPanel3);
        jPanel3.setBounds(430, 0, 270, 400);

        getContentPane().add(PersonalInfoPanel);
        PersonalInfoPanel.setBounds(0, 0, 700, 400);

        setSize(new java.awt.Dimension(699, 399));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        
        if(profile.getText().equals("+ Profile")){
            profile.setText("- Profile");
        Thread th = new Thread(){
            @Override
            public void run(){
                try {
                    int x= 200;
                    for(int i=160; i<=200; i++){
                    Thread.sleep(1);
                            reservation.setBounds(30, i, 120, 22);
                            Logout.setBounds(30, x, 100, 22);
                        if(i==175){ 
                            AppointmentList.setVisible(true);
                        }
                        if(i==195){
                            PersonalInfo.setVisible(true);
                        }  
                        x++;
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
             }
            };th.start();
        }
        
        else if(profile.getText().equals("- Profile")){
            profile.setText("+ Profile");
        Thread th = new Thread(){
            @Override
            public void run(){
                try {
                    int x = 240;
                    for(int i=200; i>=150; i--){
                    Thread.sleep(1);
                        reservation.setBounds(30, i, 120, 22);
                        Logout.setBounds(30, x, 100, 22);
                        if(i==175){ 
                            PersonalInfo.setVisible(false);
                        }
                        if(i==155){
                            AppointmentList.setVisible(false);
                        } 
                        if(x==190) {
                            x=190;
                        }else{
                            x--;
                        }
                    }
                    
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
             }
            };th.start();
        }
    }//GEN-LAST:event_profileMouseClicked

    private void reservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationMouseClicked
        reservationPanel.setVisible(true);
        AppointmentListPanel.setVisible(false);
        PersonalInfoPanel.setVisible(false);
        room1.setVisible(true);
        room4.setVisible(true);
        room7.setVisible(true);
        date();        
        profile.setText("+ Profile");
        sidebarClose();
    }//GEN-LAST:event_reservationMouseClicked

    private void AppointmentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppointmentListMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        if(model.getRowCount()>0){
            model.setRowCount(0);
        }
        
        ShowAppointmentList();
        
        AppointmentListPanel.setVisible(true);
        reservationPanel.setVisible(false);
        PersonalInfoPanel.setVisible(false);
       // date();
        profile.setText("+ Profile");
        sidebarClose();
    }//GEN-LAST:event_AppointmentListMouseClicked

    private void sidebar_btnOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_btnOpenMouseClicked
        // TODO add your handling code here:
        reservation.setBounds(30, 150, 120, 22);
        Logout.setBounds(30, 190, 100, 22);
        AppointmentList.setVisible(false);
        PersonalInfo.setVisible(false);
        
        sidebarOpen();
    }//GEN-LAST:event_sidebar_btnOpenMouseClicked

    private void sidebar_btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_btnCloseMouseClicked
        // TODO add your handling code here:
        sidebarClose();
    }//GEN-LAST:event_sidebar_btnCloseMouseClicked

    private void sidebar_btnOpenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_btnOpenMouseEntered
        sidebar_btnOpen.setBackground(new java.awt.Color(129,186,216));
    }//GEN-LAST:event_sidebar_btnOpenMouseEntered

    private void sidebar_btnOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_btnOpenMouseExited
        sidebar_btnOpen.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_sidebar_btnOpenMouseExited

    private void sidebar_btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_btnCloseMouseEntered
        sidebar_btnClose.setBackground(new java.awt.Color(150,204,216));
    }//GEN-LAST:event_sidebar_btnCloseMouseEntered

    private void sidebar_btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_btnCloseMouseExited
        sidebar_btnClose.setBackground(new java.awt.Color(129,186,216));
    }//GEN-LAST:event_sidebar_btnCloseMouseExited

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        int yes_no = JOptionPane.showConfirmDialog(this, "Are you sure you want to sign out?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if(yes_no == JOptionPane.YES_OPTION){
            this.dispose();
            try {
                new UserLogin().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("no");
        }
    }//GEN-LAST:event_LogoutMouseClicked

    private void PersonalInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonalInfoMouseClicked
        // TODO add your handling code here:
        //this.dispose();
        showInfo();
        reservationPanel.setVisible(false);
        PersonalInfoPanel.setVisible(true);
        AppointmentListPanel.setVisible(false);
        profile.setText("+ Profile");
        sidebarClose();
    }//GEN-LAST:event_PersonalInfoMouseClicked

    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBtnActionPerformed
        // TODO add your handling code here:
        if(!room1.isEnabled()){
            roomNoChoosen = 1;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }
        else if(!room2.isEnabled()){
            roomNoChoosen = 2;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room3.isEnabled()){
            roomNoChoosen = 3;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room4.isEnabled()){
            roomNoChoosen = 4;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room5.isEnabled()){
            roomNoChoosen = 5;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room6.isEnabled()){
            roomNoChoosen = 6;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room7.isEnabled()){
            roomNoChoosen = 7;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room8.isEnabled()){
            roomNoChoosen = 8;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else if(!room9.isEnabled()){
            roomNoChoosen = 9;
            date = new SimpleDateFormat("dd-MM-yyyy").format(jDateChooser1.getDate());
        }else
            roomNoChoosen = 0;
        
        if(!TimeBtn1.isEnabled())
            timeNoChoosen = TimeBtn1.getText();
        else if(!TimeBtn2.isEnabled())
            timeNoChoosen = TimeBtn2.getText();
        else if(!TimeBtn3.isEnabled())
            timeNoChoosen = TimeBtn3.getText();
        else if(!TimeBtn4.isEnabled())
            timeNoChoosen = TimeBtn4.getText();
        else if(!TimeBtn5.isEnabled())
            timeNoChoosen = TimeBtn5.getText();
         if(!new DBHelper().checkReserved(date, roomNoChoosen, timeNoChoosen)){
            new DBHelper().addReservation(userAccountID, date, roomNoChoosen, timeNoChoosen);
            JOptionPane.showMessageDialog(null, "Reserved Successfully");      
         }
         else
             JOptionPane.showMessageDialog(null, "Schedule Already Reserved! Please choose another.");
      //  db.addReservation(userAccountID, date, roomNoChoosen, timeNoChoosen);
            
    }//GEN-LAST:event_SubmitBtnActionPerformed

    private void room1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room1ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(false);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room1ActionPerformed

    private void room2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room2ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(false);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room2ActionPerformed

    private void room3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room3ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(false);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room3ActionPerformed

    private void room4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room4ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(false);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room4ActionPerformed

    private void room5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room5ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(false);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room5ActionPerformed

    private void room6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room6ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(false);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room6ActionPerformed

    private void room7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room7ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(false);
            room8.setEnabled(true);
            room9.setEnabled(true);
    }//GEN-LAST:event_room7ActionPerformed

    private void room8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room8ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(false);
            room9.setEnabled(true);
    }//GEN-LAST:event_room8ActionPerformed

    private void room9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room9ActionPerformed
        // TODO add your handling code here:
            room1.setEnabled(true);
            room2.setEnabled(true);
            room3.setEnabled(true);
            room4.setEnabled(true);
            room5.setEnabled(true);
            room6.setEnabled(true);
            room7.setEnabled(true);
            room8.setEnabled(true);
            room9.setEnabled(false);
    }//GEN-LAST:event_room9ActionPerformed

    private void TimeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeBtn1ActionPerformed
        // TODO add your handling code here:
        TimeBtn1.setEnabled(false);
        TimeBtn2.setEnabled(true);
        TimeBtn3.setEnabled(true);
        TimeBtn4.setEnabled(true);
        TimeBtn5.setEnabled(true);
    }//GEN-LAST:event_TimeBtn1ActionPerformed

    private void TimeBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeBtn2ActionPerformed
        // TODO add your handling code here:
        TimeBtn1.setEnabled(true);
        TimeBtn2.setEnabled(false);
        TimeBtn3.setEnabled(true);
        TimeBtn4.setEnabled(true);
        TimeBtn5.setEnabled(true);
    }//GEN-LAST:event_TimeBtn2ActionPerformed

    private void TimeBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeBtn3ActionPerformed
        // TODO add your handling code here:
        TimeBtn1.setEnabled(true);
        TimeBtn2.setEnabled(true);
        TimeBtn3.setEnabled(false);
        TimeBtn4.setEnabled(true);
        TimeBtn5.setEnabled(true);
    }//GEN-LAST:event_TimeBtn3ActionPerformed

    private void TimeBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeBtn4ActionPerformed
        // TODO add your handling code here:
        TimeBtn1.setEnabled(true);
        TimeBtn2.setEnabled(true);
        TimeBtn3.setEnabled(true);
        TimeBtn4.setEnabled(false);
        TimeBtn5.setEnabled(true);
    }//GEN-LAST:event_TimeBtn4ActionPerformed

    private void TimeBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeBtn5ActionPerformed
        // TODO add your handling code here:
        TimeBtn1.setEnabled(true);
        TimeBtn2.setEnabled(true);
        TimeBtn3.setEnabled(true);
        TimeBtn4.setEnabled(true);
        TimeBtn5.setEnabled(false);
    }//GEN-LAST:event_TimeBtn5ActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int rows = model.getRowCount();
        int selectedRow = jTable1.getSelectedRow();
        
        try{
            int reservationID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
            int response = JOptionPane.showConfirmDialog(this,"Are you sure you want to cancel reservation?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            switch(response){
                case JOptionPane.YES_OPTION:
                    db.deleteReservation(reservationID);
                    rows-=1;
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
            if(model.getRowCount()>0){
                model.setRowCount(rows);
            }
            
            if(model.getRowCount()>0){
                model.setRowCount(0);
            }
            
            ShowAppointmentList();
            
        }catch(Exception e){
            System.out.println(e);
        }
 
        
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void AppointmentListPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppointmentListPanelMouseClicked
        // TODO add your handling code here:
        
        ArrayList<ReservationData> list = db.getAdminReservationData();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[4];
        
        for(int i=0; i < list.size(); i++){
            row[1] = list.get(i).getReservationID();
            row[2] = list.get(i).getDate();
            row[3] = list.get(i).getRoomNo();
            row[4] = list.get(i).getTime();
            
            model.addRow(row);
        }
    
    }//GEN-LAST:event_AppointmentListPanelMouseClicked

    private void reportBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBTN2ActionPerformed
       //DBHelper db = new DBHelper();

        String fname = fnameTF.getText();
        String lname = lnameTF.getText();
        String email = emailTF.getText();
        String contactNum = contactTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        int response = JOptionPane.showConfirmDialog(this,"Are you sure you want to change personal information?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.YES_OPTION:
                try {
                    if(!new DBHelper().searchUser(username)){
                        db.updateAccount(userAccountID, fname, lname, contactNum, email, username, password);
                        JOptionPane.showMessageDialog(null, "Updated Successfully");
                        fnameTF.setText("");
                        lnameTF.setText("");
                        emailTF.setText("");
                        contactTF.setText("");
                        usernameTF.setText("");
                        passwordTF.setText("");
                        showInfo();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Username Already exist!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_reportBTN2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountIDLBL;
    private javax.swing.JLabel AppointmentList;
    private javax.swing.JPanel AppointmentListPanel;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel PersonalInfo;
    private javax.swing.JPanel PersonalInfoPanel;
    private javax.swing.JButton SubmitBtn;
    private javax.swing.JButton TimeBtn1;
    private javax.swing.JButton TimeBtn2;
    private javax.swing.JButton TimeBtn3;
    private javax.swing.JButton TimeBtn4;
    private javax.swing.JButton TimeBtn5;
    private javax.swing.JLabel contactLBL;
    private javax.swing.JTextField contactTF;
    private javax.swing.JLabel emailLBL;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel fnameLBL;
    private javax.swing.JTextField fnameTF;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lnameLBL;
    private javax.swing.JTextField lnameTF;
    private javax.swing.JLabel passwordLBL;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JLabel profile;
    private javax.swing.JButton reportBTN2;
    private javax.swing.JLabel reservation;
    private javax.swing.JPanel reservationPanel;
    private javax.swing.JButton room1;
    private javax.swing.JButton room2;
    private javax.swing.JButton room3;
    private javax.swing.JButton room4;
    private javax.swing.JButton room5;
    private javax.swing.JButton room6;
    private javax.swing.JButton room7;
    private javax.swing.JButton room8;
    private javax.swing.JButton room9;
    private javax.swing.JLabel sidebar_btnClose;
    private javax.swing.JLabel sidebar_btnOpen;
    private javax.swing.JLabel usernameLBL;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
