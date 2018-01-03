package kata5p2.main;

import java.io.IOException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;


public class KATA5P2 {
    public static void main(String[] args) throws IOException{
        KATA5P2 histo= new KATA5P2();
        histo.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    
    private void execute() throws IOException{
        input();
        process();
        output();
        
    }
    
    private void input() throws IOException{
        filename="C:\\Users\\DaniCerv\\Desktop\\KATA4\\emails.txt";
        mailList= MailListReader.read(filename);
    }
    
    private void process(){
        histogram=MailHistogramBuilder.build(mailList);
    }
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
