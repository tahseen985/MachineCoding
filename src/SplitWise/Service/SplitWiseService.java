package SplitWise.Service;

import SplitWise.Model.User;
import SplitWise.Repository.SplitWiseRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseService {
    SplitWiseRepo splitWiseRepo;
    UserService userService;
    public SplitWiseService(SplitWiseRepo splitWiseRepo, UserService userService) {
        this.splitWiseRepo = splitWiseRepo;
        this.userService = userService;
    }
    public void caseOfExact(String user, Double amount, List<String> userList, List<Double> totalAmountList) {
        if(!validate(totalAmountList, amount)) {
            System.out.println("Invalid Input");
            return;
        }

    }
    public void caseOfEqual(String userId, Double amount, List<String> userList) {
        int numberOfUser = userList.size();
        Double share = amount/numberOfUser;
        Map<String, Map<String, Double>> expenseData = splitWiseRepo.getExpenseData();
        if(!expenseData.containsKey(userId)) {
            for(String user : userList) {
                Map<String, Double> doubleMap = new HashMap<>();
                if(!expenseData.containsKey(user)) {
                    doubleMap.put(userId, share);
                } else {
                    doubleMap = expenseData.get(user);
                    if(!doubleMap.containsKey(userId)) {
                        doubleMap.put(userId, share);
                    } else {
                        doubleMap.put(userId, doubleMap.get(userId) + share);
                    }
                }
                expenseData.put(user, doubleMap);
            }
        } else {
            Map<String, Double> doubleMap = expenseData.get(userId);
            for (String user : userList) {
                Map<String, Double> userMap = new HashMap<>();
                if(!doubleMap.containsKey(user)) {
                    if(!expenseData.containsKey(user)) {
                        userMap.put(userId, share);
                    } else {
                        userMap = expenseData.get(user);
                        if(!userMap.containsKey(userId)) {
                            userMap.put(userId, share);
                        } else {
                            userMap.put(userId, doubleMap.get(userId) + share);
                        }
                    }
                    expenseData.put(user, userMap);
                } else {
                    Double remaining = share - doubleMap.get(user);
                    if(remaining > 0.0) {
                        if(!expenseData.containsKey(user)) {
                            userMap.put(userId, remaining);
                        } else {
                            userMap = expenseData.get(user);
                            if(!userMap.containsKey(userId)) {
                                userMap.put(userId, remaining);
                            } else {
                                userMap.put(userId, doubleMap.get(userId) + remaining);
                            }
                        }
                        expenseData.put(user, userMap);
                    } else {
                        remaining = doubleMap.get(user) - share;

                    }
                }
            }
        }
    }
    public void caseOfPercentage(String user, Double amount, List<String> userList, List<Double> totalPercentList) {
        if(!validate(totalPercentList, 100.0)) {
            System.out.println("Invalid Input");
            return;
        }

    }
    public void show(String userId) {
        if(userId.isEmpty() && splitWiseRepo.getExpenseData().isEmpty()) {
            System.out.println("No Balance");
        } else if(userId.isEmpty()) {

        }
    }
    public Boolean validate(List<Double> totalAmountList, Double amount) {
        Double sum = 0.0;
        for(int i=0; i<totalAmountList.size(); i++) {
            sum += totalAmountList.get(i);
        }
        if(sum == amount) return true;
        return false;
    }
}
