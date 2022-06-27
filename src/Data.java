import com.company.IncorrectException;

import java.io.*;

public class Data {

    /**
     * @param login    - written by user;
     * @param password - written by user;
     */
    public static void dataSaving(String login, String password) {
        File file = new File("data_users.csv");
        try (FileWriter write = new FileWriter(file, true);
             BufferedWriter fast = new BufferedWriter(write)) {
            fast.write(login + ";" + password + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param login - written by user;
     * @return true - if email is correctly, false - not;
     */
    public static boolean isUserValidationMatch(String login) {
        File file = new File("data_users.csv");
        String line;
        try (FileReader read = new FileReader(file);
             BufferedReader readText = new BufferedReader(read)) {
            while ((line = readText.readLine()) != null) {
                char[] email = line.toCharArray();
                int i = 0;
                while (email[i] != ';') {
                    i++;
                }
                String emailResult = line.substring(0, i);
                int result = emailResult.compareTo(login);
                if (result == 0) {
                    throw new IncorrectException("This user already exists");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * @param login    - written by user;
     * @param password - written by user;
     * @return true - if email is found, false - not;
     */
    public static boolean isUserExist(String login, String password) {
        File file = new File("data_users.csv");
        String line;
        int numbers = 0;
        try (FileReader read = new FileReader(file);
             BufferedReader readText = new BufferedReader(read)) {
            while ((line = readText.readLine()) != null) {
                int result = line.compareTo(login + "+" + password);
                if (result == 0) {
                    numbers++;
                }
            }
            if (numbers == 0) {
                throw new IncorrectException("This user doesn't exist");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * @param machines - list of the machines;
     */
    public static void writeMachine(WashingMachine machines) {
        File file = new File("washing_machine.csv");
        int i = 1;
        try (FileReader read = new FileReader(file);
             BufferedReader reader = new BufferedReader(read)) {
            while ((reader.readLine()) != null) {
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter write = new FileWriter(file, true);
             BufferedWriter fast = new BufferedWriter(write)) {
            machines.ID = i;
            fast.write(machines.ID + ";" + machines.creator + ";" + machines.dataOfCreate + ";" + machines.price + ";" + machines.color + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
