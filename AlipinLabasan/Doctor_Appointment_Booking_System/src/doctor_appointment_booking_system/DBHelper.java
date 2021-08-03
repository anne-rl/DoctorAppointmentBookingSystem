/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_appointment_booking_system;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; //executing parametric queries
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Labasan
 */
public class DBHelper {

    public PreparedStatement ps, ps2;
    public ResultSet rs;
    public Statement stmt;
    Connection connect;
    static int accountID;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
      
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            System.out.println("Connection is up");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed");
        }
        return con;
    }
    public int getUserAccountID(){
        return accountID;
    }
    
    //UserLogin
    public boolean addAccount(String fname,String lname, String contactNum, String email,String username,String password){
         boolean ok = false;
         if (!searchUser(username)) {   
            try {
                   System.out.println("Add Account");
                   String query = "INSERT INTO `account`(`FirstName`, `LastName`,`ContactNumber`,`Email`) VALUES (?,?,?,?)";
                   connect= getConnection();

                   ps = connect.prepareStatement(query);

                   ps.setString(1, fname);
                   ps.setString(2, lname);
                   ps.setString(3, contactNum);
                   ps.setString(4, email);
                
                   
                   String query2 = "INSERT INTO `useraccount`(`Username`, `Password`) VALUES (?,?)";
                   ps2 = connect.prepareStatement(query2);
                   ps2.setString(1, username);
                   ps2.setString(2, password);
                   
                   if(ps.executeUpdate()>0 && ps2.executeUpdate()>0){
                         JOptionPane.showMessageDialog(null,"User Added");
                         new UserLogin().setVisible(true);
                         ok = true;
                   }
                   
               } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                   JOptionPane.showMessageDialog(null,e);
               }
        }
         else
                   {
                         ok=false;
                   }
        return ok;  
     }
    public boolean searchAccount(String username,String password){
          try{
                String query = "SELECT  `Username`=?, `Password`=? FROM `useraccount` ";
                connect= getConnection();
                ps = connect.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                rs =ps.executeQuery();
                if(rs.next())
                {
                      JOptionPane.showMessageDialog(null,"Logging In!!");
                      MainMenu mm = new MainMenu();
                      mm.setVisible(true);
                      
                }
      
      }catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null,e);
      }
          return false;
      }
    public boolean searchUser(String username){
                boolean result = false;
                System.out.println("Search Account ");
                try{
                    String query = "SELECT * FROM `useraccount`";
                    connect= getConnection();

                    ps = connect.prepareStatement(query);

                    rs = ps.executeQuery();
                    while(rs.next()){
                        if(rs.getString("Username").equalsIgnoreCase(username)){
                            System.out.println("Account Already Exists! " + rs.getString("Username"));
                            result = true;
                            break;
                        }
                    }
                    System.out.println("Search Done!");
                } catch(ClassNotFoundException | SQLException ex){
                    ex.printStackTrace();
                }
                return result;
    }
    public boolean login(String username, String password){
            boolean result = false;

            System.out.println("Search Account ");
            try{
                //String query = "SELECT * FROM `account`";
                String query = "SELECT * FROM `useraccount`";
                connect= getConnection();

                ps = connect.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                    //System.out.println(rs.getString("username") + rs.getInt("roomNo") + rs.getDate("date") + rs.getString("time"));
                    if(rs.getString("Username").equals(username) && rs.getString("Password").equals(password)){
                        System.out.println("Account Exists, Logging in! " + rs.getString("Username"));
                        accountID = rs.getInt("accountID");
                        result = true;
                    }
                }
                System.out.println("Search Done!");
            } catch(Exception ex){
                ex.printStackTrace();
            }
            return result;

          }

    public ArrayList<AdminData> getAdminList(){
          ArrayList<AdminData> adminList = new ArrayList<AdminData>();
          
          try{
              String query = "SELECT * FROM `account`";
              connect = getConnection();
              stmt = connect.createStatement();
              rs = stmt.executeQuery(query);
              AdminData adminData;
              while(rs.next()){
                  adminData =new AdminData(rs.getInt("accountID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("ContactNumber"), rs.getString("Email"));
                  adminList.add(adminData);
              }
              
          }catch(Exception ex){
              ex.printStackTrace();
          }
          return adminList;
      }
      
    //ReservationData
    public boolean addReservation(int accountID, String date, int roomNo, String time){
        boolean result = false;
        System.out.println("------------");
            try {
                System.out.println("Add Account ");
               
                String query = "INSERT INTO `reservation`(`accountID`,`Date`, `RoomNo`, `Time`) VALUES (?,?,?,?)";
                connect = getConnection();
                
                ps = connect.prepareStatement(query);
                ps.setInt(1, accountID);
                ps.setString(2, date);
                ps.setInt(3, roomNo);
                ps.setString(4, time);
                ps.executeUpdate();
                System.out.println("Reservation added Successfully");
                result = true;
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        return result;
    }
    public boolean checkReserved(String date, int roomNo, String time){
        boolean result = false;
        System.out.println("Search Reservation ");
        try{
            String query = "SELECT * FROM `reservation`";
            connect = getConnection();
            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               System.out.println("Input " + date + roomNo + time);
               if(rs.getString("Date").equals(date) && rs.getInt("RoomNo") == (roomNo) && rs.getString("Time").equals(time)){
                   System.out.println("Time already reserved");
                   result = true;
                   break;
               }
            }
            System.out.println("Search Done!");
        } catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }  
    public ArrayList<ReservationData> getReservationData(int accID){
          ArrayList<ReservationData> reservationData = new ArrayList<ReservationData>();
          
          try{
              String query = "SELECT * FROM `reservation` WHERE `accountID` ="+accID;
              connect = getConnection();
              stmt = connect.createStatement();
              rs = stmt.executeQuery(query);
              ReservationData reserveData;
              while(rs.next()){
                  reserveData = new ReservationData(rs.getInt("reservationID"), rs.getString("Date"), rs.getInt("RoomNo"), rs.getString("Time"));
                  reservationData.add(reserveData);
              }
              
          }catch(Exception ex){
              ex.printStackTrace();
          }
          return reservationData;
      }
    
    public ArrayList<ReservationData> getAdminReservationData(){
          ArrayList<ReservationData> reservationData = new ArrayList<ReservationData>();
          
          try{
              String query = "SELECT * FROM `reservation`";
              connect = getConnection();
              stmt = connect.createStatement();
              rs = stmt.executeQuery(query);
              ReservationData reserveData;
              while(rs.next()){
                  reserveData = new ReservationData(rs.getInt("accountID"), rs.getInt("reservationID"), rs.getString("Date"), rs.getInt("RoomNo"), rs.getString("Time"));
                  reservationData.add(reserveData);
              }
              
          }catch(Exception ex){
              ex.printStackTrace();
          }
          return reservationData;
      }
    
     public void deleteReservationAdmin(int reservationID){
            try{
                System.out.println("Delete Reservation ");
                String query = "DELETE FROM `reservation` WHERE `reservationID` = "+ reservationID;
                connect= getConnection();
                ps = connect.prepareStatement(query);
                ps.execute();
                System.out.println("Reservation Deleted!");
                
            }catch(Exception e){
                e.printStackTrace();
            }
     }
     
     public void deleteReservation(int reservationID){
            try{
                System.out.println("Delete Reservation ");
                String query = "DELETE FROM `reservation` WHERE `reservationID` = "+ reservationID;
                connect= getConnection();
                ps = connect.prepareStatement(query);
                ps.execute();
                System.out.println("Reservation Deleted!");
                
            }catch(Exception e){
                e.printStackTrace();
            }
     }

      public String selectPassword(int accountID){
         String res = null;
         try{
            String query= "SELECT * FROM `useraccount` WHERE `accountID` = " + accountID;
            connect = getConnection();

            ps = connect.prepareStatement(query);
            //ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()){
               res = rs.getString("Password");
            }
            
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return res;
    }
     public String selectUsername(int accountID) throws SQLException, ClassNotFoundException{
         String res = null;
         String query= "SELECT * FROM `useraccount` WHERE `accountID` = " + accountID;
         connect = getConnection();
       
         ps = connect.prepareStatement(query);
         //ps.setInt(1, accountID);
         rs = ps.executeQuery();
         while(rs.next()){
            res = rs.getString("Username");
         }
         return res;
    }
    public String selectFirstName(int accountID){
         String res = null;
         try{
            String query= "SELECT * FROM `account` WHERE `accountID` = "+ accountID;
            connect = getConnection();
            ps = connect.prepareStatement(query);
            //ps.setInt(1,accountID);
            rs = ps.executeQuery();
            while(rs.next()){
               res = rs.getString("FirstName");
            }
         }catch(Exception e){
             e.printStackTrace();
         }
         return res;
    }
    public String selectLastName(int accountID){
         String res = null;
         try{
            String query= "SELECT * FROM `account` WHERE `accountID` = "+ accountID;
            connect = getConnection();

            ps = connect.prepareStatement(query);
            //ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()){
               res = rs.getString("LastName");
            }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return res;
    }
    public String selectContact(int accountID){
         String res = null;
         try{
            String query= "SELECT * FROM `account` WHERE `accountID` = "+ accountID;
            connect = getConnection();

            ps = connect.prepareStatement(query);
           // ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()){
               res = rs.getString("ContactNumber");
            }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return res;
    }
    public String selectEmail(int accountID){
         String res = null;
         try{
            String query= "SELECT * FROM `account` WHERE `accountID` = " + accountID;
            connect = getConnection();
            ps = connect.prepareStatement(query);
            //ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()){
               res = rs.getString("Email");
            }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return res;
    }

    public void updateAccount(int accountID, String fname, String lname, String contactNum, String email, String username, String password) throws SQLException, ClassNotFoundException{
        String query = "UPDATE `useraccount` SET `Username` = ?, `Password` = ? WHERE `accountID` = "+accountID;
         connect = getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password); 
           // ps.setInt(3, accountID);
            ps.execute();
        String query2 = "UPDATE `account` SET `FirstName` = ? , `LastName` = ? , `ContactNumber` = ? , `Email` = ? WHERE `accountID` = " +accountID;
         connect = getConnection();
            ps2 = connect.prepareStatement(query2);
            ps2.setString(1, fname);    
            ps2.setString(2, lname);
            ps2.setString(3, contactNum);
            ps2.setString(4, email);
           // ps2.setInt(5, accountID);
            ps2.execute();
    }
    
}//end of DBHelper
