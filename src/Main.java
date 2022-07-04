import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String login = null;
        String password = null;
        System.out.println("Are you a new user? Y - yes, N - no");
        char value = scanner.next().charAt(0);
        if (value == 'Y') {
            System.out.println("Enter your login: ");
            login = scanner.next();
            EmailValidator validator = new EmailValidator();
            boolean checkEmail = validator.validate(login);
            if (checkEmail) {
                System.out.println("Enter your password: ");
                password = scanner.next();
                boolean isUser = DataProccesing.isUserValidationMatch(login);
                if (isUser) {
                    DataProccesing.dataSaving(login, password);
                    System.out.println("Congrats.You are registered");
                }
            }
        } else {
            if (value == 'N') {
                System.out.println("Enter your login: ");
                login = scanner.next();
                System.out.println("Enter your password: ");
                password = scanner.next();
                boolean isUser = DataProccesing.isUserExist(login, password);
                if (isUser) {
                    System.out.println("Congrats. You logged in as " + login);
                }
            } else {
                throw new UserIncorrectException("Incorrect input. You can use only Y or N");
            }
        }
        System.out.println("Would you like to buy?");
        int operation = 0;
        while (operation != 1) {
            System.out.println("You can 1- add information about machine, 2- delete information about one, 3 - get information on ID, 4 - update information");
            int various = scanner.nextInt();
            if (various == 1) {
                int switchNumber = 1;
                while (switchNumber == 1) {
                    System.out.println("add at the first - name, age, price, color");
                    System.out.println("Input name");
                    String name = scanner.next();
                    System.out.println("Input age");
                    int age = scanner.nextInt();
                    System.out.println("Input price");
                    int price = scanner.nextInt();
                    System.out.println("Input color");
                    String color = scanner.next();
                    WashingMachine machine = new WashingMachine(0, name, age, price, color);
                    DataProccesing.writeMachine(machine);
                    System.out.println("Do you want to repeat? 1 - yes, any other number - no");
                    switchNumber = scanner.nextInt();
                }
            } else {
                if (various == 2) {
                    System.out.println("Input ID which you need to delete");
                    String needID = scanner.next();
                    DataSavingFunctionOfUser.delete(needID);
                } else {
                    if (various == 3) {
                        System.out.println("Enter the ID who you need to");
                        String needID = scanner.next();
                        String value1 = DataSavingFunctionOfUser.getOnID(needID);
                        System.out.println(value1);
                    } else {
                        if (various == 4) {
                            System.out.println("How ID do you want to edit?");
                            String needID = scanner.next();
                            System.out.println("What name do you want to change to");
                            String newName = scanner.next();
                            DataSavingFunctionOfUser.update(needID,newName);
                        } else {
                            throw new UserIncorrectException("You can choose only 1 - 3 various");
                        }
                    }
                }
            }
            System.out.println("Input - 1 if you want to finish operation, 2 - continue");
            operation = scanner.nextInt();
        }
    }
}