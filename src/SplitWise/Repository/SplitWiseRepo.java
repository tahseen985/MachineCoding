package SplitWise.Repository;

import SplitWise.Model.User;

import java.util.HashMap;
import java.util.Map;

public class SplitWiseRepo {
    Map<String, User> userMap = new HashMap<>();
    Map<String, Map<String, Double>> expenseData = new HashMap<>();

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Map<String, Double>> getExpenseData() {
        return expenseData;
    }

    public void setExpenseData(Map<String, Map<String, Double>> expenseData) {
        this.expenseData = expenseData;
    }

}
