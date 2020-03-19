package StorageIO;

import BookInfo.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryIO {
    private static final String LIBRARY_FILE_NAME = "Library.txt";

    public void write(HashMap<Integer, Book> library) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        fileOutputStream = new FileOutputStream(new File(LIBRARY_FILE_NAME));
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(library);
        closeStream(fileOutputStream);
        closeStream(objectOutputStream);
    }

    public HashMap<Integer, Book> read() throws IOException, ClassNotFoundException {
        HashMap<Integer, Book> library = new HashMap<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        fileInputStream = new FileInputStream(new File(LIBRARY_FILE_NAME));
        objectInputStream = new ObjectInputStream(fileInputStream);
        library = (HashMap<Integer, Book>) objectInputStream.readObject();
        closeStream(fileInputStream);
        closeStream(objectInputStream);

        return library;
    }


    private void closeStream(InputStream is) throws IOException {
        if (is != null) {
            is.close();
        }
    }

    private void closeStream(OutputStream os) throws IOException {
        if (os != null) {
            os.close();
        }
    }
}


}
