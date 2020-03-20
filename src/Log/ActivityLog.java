package Log;

import BookInfo.*;
import Manager.*;
import java.io.*;
import java.util.Date;


public class ActivityLog {
    private Date timeActive = new Date(System.currentTimeMillis());
    private static final String PATH_OF_FILE = "C:\\Users\\Yuki Douji\\Desktop\\Case Study\\src\\Log\\ActivityLog.text";
    public final File fileActiveLog = new File(PATH_OF_FILE);


    public ActivityLog() throws IOException {
        timeActive = new Date(System.currentTimeMillis());
    }

    public void WriteActivityLog(Book book, String status) throws IOException {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        BufferedReader br = null;
        String data = status + " " + book.getNameBook() + " " + timeActive.toString() + "\n";

        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fileWriter = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
        fileWriter.close();
    }

    public void WriteActivityLog(User user, String status) throws IOException {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        String data = status + " " + user.getName() + " Code: " + " " + timeActive.toString() + "\n";
        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fileWriter = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
        fileWriter.close();
    }

    public void WriteActivityLog(Publisher publisher, String status) throws IOException {
        BufferedWriter bw = null;
        FileWriter fw = null;
        String data = status + " " + publisher.getName() + " " + timeActive.toString() + "\n";
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
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        String data = status + " " + category.getName() + " Code: " + " " + timeActive.toString() + "\n";
        if (!fileActiveLog.exists()) {
            fileActiveLog.createNewFile();
        }
        fileWriter = new FileWriter(fileActiveLog.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
        fileWriter.close();
    }
}
