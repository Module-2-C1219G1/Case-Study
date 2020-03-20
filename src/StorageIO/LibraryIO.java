package StorageIO;

import java.io.*;
import java.util.ArrayList;

public class LibraryIO {
    private static final String LIBRARY_PATH_NAME = "C:\\Users\\Yuki Douji\\Desktop\\Case Study\\src\\StorageIO\\Library.text";
    private static final String USER_PATH_NAME = "C:\\Users\\Yuki Douji\\Desktop\\Case Study\\src\\StorageIO\\user.text";
    File fileLibrary = new File(LIBRARY_PATH_NAME);
    File fileUser = new File(USER_PATH_NAME);

    public <E> void writeBook(ArrayList<E> arrayList) throws IOException {
        fileLibrary.delete();
        if (!fileLibrary.exists() || !fileLibrary.isDirectory() || fileLibrary.canWrite()) {
            fileLibrary.createNewFile();
        }
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileWriter fileWrite = null;
        fileOutputStream = new FileOutputStream(fileLibrary);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        closeStream(fileOutputStream);
        closeStream(objectOutputStream);
    }

    public <E> void writeUser(ArrayList<E> arrayList) throws IOException {
        fileUser.delete();
        if (!fileUser.exists() || !fileUser.isDirectory() || fileUser.canWrite()) {
            fileUser.createNewFile();
        }
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileWriter fileWrite = null;
        fileOutputStream = new FileOutputStream(fileUser);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        closeStream(fileOutputStream);
        closeStream(objectOutputStream);
    }

    public <E> ArrayList<E> readBook() throws IOException, ClassNotFoundException {
        ArrayList<E> arrayList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        fileInputStream = new FileInputStream(fileLibrary);
        objectInputStream = new ObjectInputStream(fileInputStream);
        arrayList = (ArrayList<E>) objectInputStream.readObject();
        closeStream(fileInputStream);
        closeStream(objectInputStream);
        return arrayList;
    }

    public <E> ArrayList<E> readUser() throws IOException, ClassNotFoundException {
        ArrayList<E> arrayList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        fileInputStream = new FileInputStream(fileUser);
        objectInputStream = new ObjectInputStream(fileInputStream);
        arrayList = (ArrayList<E>) objectInputStream.readObject();
        closeStream(fileInputStream);
        closeStream(objectInputStream);
        return arrayList;
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
