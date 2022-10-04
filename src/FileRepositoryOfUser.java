import java.io.*;

public class FileRepositoryOfUser {
    private final String USERS_DATA_FILE = "data_users.csv";

    public BufferedReader workWithFileRead() throws FileNotFoundException {
        FileReader read = new FileReader(USERS_DATA_FILE);
        return new BufferedReader(read);
    }

    public BufferedWriter workWithFileWrite() throws IOException {
        FileWriter write = new FileWriter(USERS_DATA_FILE, true);
        return new BufferedWriter(write);
    }
}
