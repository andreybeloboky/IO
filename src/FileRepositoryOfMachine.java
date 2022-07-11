import java.io.*;

public class FileRepositoryOfMachine {
    private final String WASHING_MACHINE_FILE = "washing_machine.csv";

    public BufferedReader workWithFileRead() throws FileNotFoundException {
        FileReader read = new FileReader(WASHING_MACHINE_FILE);
        return new BufferedReader(read);
    }

    public BufferedWriter workWithFileWriteTrue() throws IOException {
        FileWriter write = new FileWriter(WASHING_MACHINE_FILE, true);
        return new BufferedWriter(write);
    }

    public BufferedWriter workWithFileWrite() throws IOException {
        FileWriter write = new FileWriter(WASHING_MACHINE_FILE);
        return new BufferedWriter(write);
    }
}
