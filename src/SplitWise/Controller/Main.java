package SplitWise.Controller;

import SplitWise.Enums.ExpenseType;
import SplitWise.Model.User;
import SplitWise.Repository.SplitWiseRepo;
import SplitWise.Service.SplitWiseService;
import SplitWise.Service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SplitWiseRepo splitWiseRepo = new SplitWiseRepo();
        UserService userService = new UserService(splitWiseRepo);
        SplitWiseService splitWiseService = new SplitWiseService(splitWiseRepo, userService);
        User user1 = new User("u1", "userName1", "abc1@gmail.com", "1234567890");
        User user2 = new User("u2", "userName2", "abc2@gmail.com", "1234567891");
        User user3 = new User("u3", "userName3", "abc3@gmail.com", "1234567892");
        User user4 = new User("u4", "userName4", "abc4@gmail.com", "1234567893");
        userService.addUserToMap(user1);
        userService.addUserToMap(user2);
        userService.addUserToMap(user3);
        userService.addUserToMap(user4);
        while (true) {
            String expression = sc.next();
            switch(expression) {
                case "EXPENSE":
                    String user = sc.next();
                    Double amount = sc.nextDouble();
                    Integer noOfUser = sc.nextInt();
                    List<String> userList = new ArrayList<>();
                    for(int i=0; i<noOfUser; i++) {
                        String owedUser = sc.next();
                        userList.add(owedUser);
                    }
                    String userExpenseType = sc.next();
                    ExpenseType expenseType = ExpenseType.valueOf(userExpenseType);

                    switch (expenseType) {
                        case EQUAL:
                            splitWiseService.caseOfEqual(user, amount, userList);
                            break;
                        case EXACT:
                            List<Double> totalPaymentList = new ArrayList<>();
                            for (int i=0; i<noOfUser; i++) {
                                totalPaymentList.add(sc.nextDouble());
                            }
                            splitWiseService.caseOfExact(user, amount, userList, totalPaymentList);
                            break;
                        case PERCENT:
                            List<Double> totalPercentList = new ArrayList<>();
                            for (int i=0; i<noOfUser; i++) {
                                totalPercentList.add(sc.nextDouble());
                            }
                            splitWiseService.caseOfPercentage(user, amount, userList, totalPercentList);
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                    break;
                case "SHOW":
                    String userId = sc.nextLine();
                    splitWiseService.show(userId);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
