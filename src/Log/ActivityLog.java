package Log;

import BookInfo.*;
import Manager.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class ActivityLog {
    private Date timeActive = new Date(System.currentTimeMillis());
    public final File fileActiveLog = new File("C:\\Users\\Yuki Douji\\Desktop\\Case Study\\src\\ActivityLog.text");
    FileWriter fileWriter = new FileWriter(fileActiveLog);
    public static int countLog = 0;


    public ActivityLog() throws IOException {

    }

    public void WriteActivityLog(Book book, String status) throws IOException {
        countLog++;
        fileWriter.write(countLog + ". " + status + " " + book.getNameBook() + " Code: " + book.getBookCode() + " " + timeActive.toString());

    }

    public void WriteActivityLog(User user, String status) throws IOException {
        countLog++;
        fileWriter.write(countLog + ". " + status + " " + user.getName() + " Code: " + user.getUserCode() + " " + timeActive.toString());
    }

    public void WriteActivityLog(Publisher publisher, String status) throws IOException {
        countLog++;
        fileWriter.write(countLog + ". " + status + " " + publisher.getName() + " Code: " + publisher.getPublisherCode() + " " + timeActive.toString());
    }
}
