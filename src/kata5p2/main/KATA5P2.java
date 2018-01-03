package kata5p2.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderDDBB;


public class KATA5P2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
        KATA5P2 histo= new KATA5P2();
        histo.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
    
    private void execute() throws IOException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
        
    }
    
    private void input() throws IOException, ClassNotFoundException, SQLException{
        filename="C:\\Users\\DaniCerv\\Desktop"
        + "\\Ficheros para la práctica en laboratorio 5 -20171227\\KATA.sDB";
        mailList= MailListReaderDDBB.read(filename);
    }
    
    private void process(){
        histogram=MailHistogramBuilder.build(mailList);
    }
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
