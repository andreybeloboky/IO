
import java.io.*;
import java.util.ArrayList;

public class DataSavingFunctionOfUser {
    /**
     * @param needID - ID which should be removed;
     */
    public static void delete(String needID) {
        ArrayList<String> string = new ArrayList<>();
        String line;
        int compare;
        int number = 0;
        File file = new File("washing_machine.csv");
        try (FileReader read = new FileReader(file);
             BufferedReader reader = new BufferedReader(read)) {
            while ((line = reader.readLine()) != null) {
                String[] findID = line.split(";");
                compare = findID[0].compareTo(needID);
                if (compare != 0) {
                    number++;
                    findID[0] = String.valueOf(number);
                    String str = String.join(";", findID);
                    string.add(str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter write = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(write)) {
            for (String value : string) {
                writer.write(value + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param needID which should be found;
     * @param newName which should be set instead of previous name;
     */
    public static void update(String needID, String newName) {
        ArrayList<String> string = new ArrayList<>();
        String line;
        int compare;
        File file = new File("washing_machine.csv");
        try (FileReader read = new FileReader(file);
             BufferedReader reader = new BufferedReader(read)) {
            while ((line = reader.readLine()) != null) {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter write = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(write)) {
            for (String value : string) {
                writer.write(value + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param needID - ID which the user's needs and getting information about it;
     * @return information about ID;
     */
    public static String getOnID(String needID) {
        File file = new File("washing_machine.csv");
        String line;
        int compare;
        try (FileReader reader = new FileReader(file);
             BufferedReader read = new BufferedReader(reader)) {
            while ((line = read.readLine()) != null) {
                String[] array = line.split(";");
                compare = array[0].compareTo(needID);
                if (compare == 0) {
                    return line;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "This ID doesn't exist";
    }
}
