package kata5p2.view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;


public class MailListReaderDDBB {
    public static List<Mail> read(String filename) throws ClassNotFoundException, SQLException{
        ArrayList<Mail> mailList= new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:"
                                                            +filename);
        
        Statement statement = (Statement) connection.createStatement();
        
        String query= "SELECT * FROM MAIL;";
        ResultSet rs=statement.executeQuery(query);
        
        while(rs.next()){
            String mail=rs.getString("mail");
            if(!mail.contains("@")){
                continue;
            }
            Mail correo= new Mail(rs.getString("mail"));
            mailList.add(correo);
        }
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }catch(SQLException e){
                e.printStackTrace();
                }
        
        return mailList;
        }
}
