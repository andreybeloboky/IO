import java.io.*;
import java.util.ArrayList;

public class WashingMachineService {

    FileRepositoryOfMachine machine = new FileRepositoryOfMachine();

    /**
     * @param needID - ID which should be removed;
     */
    public void delete(String needID) throws IOException {
        ArrayList<String> string = new ArrayList<>();
        String line;
        int compare;
        int number = 0;
        BufferedReader read = machine.workWithFileRead();
        while ((line = read.readLine()) != null) {
            String[] findID = line.split(";");
            compare = findID[0].compareTo(needID);
            if (compare != 0) {
                number++;
                findID[0] = String.valueOf(number);
                String str = String.join(";", findID);
                string.add(str);
            }
        }
        read.close();
        BufferedWriter write = machine.workWithFileWrite();
        for (String value : string) {
            write.write(value + "\n");
        }
        write.close();
    }

    /**
     * @param needID  which should be found;
     * @param newName which should be set instead of previous name;
     */
    public void update(String needID, String newName) throws IOException {
        ArrayList<String> string = new ArrayList<>();
        String line;
        int compare;
        BufferedReader read = machine.workWithFileRead();
        while ((line = read.readLine()) != null) {
            String[] findID = line.split(";");
            compare = findID[0].compareTo(needID);
            if (compare == 0) {
                findID[1] = newName;
                String str = String.join(";", findID);
                string.add(str);
            } else {
                string.add(line);
            }
        }
        read.close();
        BufferedWriter writer = machine.workWithFileWrite();
        for (String value : string) {
            writer.write(value + "\n");
        }
        writer.close();
    }

    /**
     * @param needID - ID which the user's needs and getting information about it;
     * @return information about ID;
     */
    public String getOnID(String needID) throws IOException {
        String line;
        int compare;
        BufferedReader reader = machine.workWithFileRead();
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(";");
            compare = array[0].compareTo(needID);
            if (compare == 0) {
                return line;
            }
        }
        reader.close();
        return "This ID doesn't exist";
    }

    /**
     * @param machines - list of the machines;
     */
    public void writeMachine(WashingMachine machines) throws IOException {
        int i = 1;
        BufferedReader read = machine.workWithFileRead();
        while ((read.readLine()) != null) {
            i++;
        }
        machines.setId(i);
        BufferedWriter writer = machine.workWithFileWriteTrue();
        writer.write(machines.getId() + ";" + machines.getCreator() + ";" + machines.getDataOfCreate() + ";" + machines.getPrice() + ";" + machines.getColor() + "\n");
        writer.close();
    }
}
