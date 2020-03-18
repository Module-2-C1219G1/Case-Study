package Log;

import BookInfo.*;
import Manager.*;
import java.io.*;
import java.util.Date;


public class ActivityLog {
    private Date timeActive = new Date(System.currentTimeMillis());
    public final File fileActiveLog = new File("C:\\Users\\Yuki Douji\\Desktop\\Case Study\\src\\ActivityLog.text");
    public static int countLog = 0;


    public ActivityLog() throws IOException {
        timeActive = new Date(System.currentTimeMillis());
    }

    public void WriteActivityLog(Book book, String status) throws IOException {
        countLog++;
        BufferedWriter bw = null;
        FileWriter fw = null;
        BufferedReader br = null;
        String data = countLog + ". " + status + " " + book.getNameBook() + " Code: " + book.getBookCode() + " " + timeActive.toString()+"\n";

        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fw = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.close();
        fw.close();
    }

    public void WriteActivityLog(User user, String status) throws IOException {
        countLog++;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String data = countLog + ". " + status + " " + user.getName() + " Code: " + user.getUserCode() + " " + timeActive.toString()+"\n";
        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fw = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.close();
        fw.close();
    }

    public void WriteActivityLog(Publisher publisher, String status) throws IOException {
        countLog++;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String data = countLog + ". " + status + " " + publisher.getName() + " Code: " + publisher.getPublisherCode() + " " + timeActive.toString()+"\n";
        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fw = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.close();
        fw.close();
    }

    public void WriteActivityLog(Category category, String status) throws IOException {
        countLog++;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String data = countLog + ". " + status + " " +category.getName() + " Code: " + category.getCategoryCode() + " " + timeActive.toString()+"\n";
        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fw = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.close();
        fw.close();
    }
}
