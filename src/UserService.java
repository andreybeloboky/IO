import java.io.*;

public class UserService {
    FileRepositoryOfUser user = new FileRepositoryOfUser();

    /**
     * @param login    - written by user;
     * @param password - written by user;
     */
    public void dataSaving(String login, String password) throws IOException {
        BufferedWriter writer = user.workWithFileWrite();
        writer.write(login + ";" + password + "\n");
        writer.close();
    }

    /**
     * @param login - written by user;
     * @return true - if email is correctly, false - not;
     */
    public boolean isUserValidationMatch(String login) throws IOException {
        BufferedReader read = user.workWithFileRead();
        String line;
        while ((line = read.readLine()) != null) {
            char[] email = line.toCharArray();
            int i = 0;
            while (email[i] != ';') {
                i++;
            }
            String emailResult = line.substring(0, i);
            int result = emailResult.compareTo(login);
            if (result == 0) {
                throw new UserIncorrectException("This user already exists");
            }
        }
        read.close();
        return true;
    }

    /**
     * @param login    - written by user;
     * @param password - written by user;
     * @return true - if email is found, false - not;
     */
    public boolean isUserExist(String login, String password) throws IOException {
        String line;
        int numbers = 0;
        BufferedReader read = user.workWithFileRead();
        while ((line = read.readLine()) != null) {
            int result = line.compareTo(login + "+" + password);
            if (result == 0) {
                numbers++;
            }
        }
        read.close();
        if (numbers == 0) {
            throw new UserIncorrectException("This user doesn't exist");
        }
        return true;
    }
}
