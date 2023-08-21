package SplitWise.Service;

import SplitWise.Model.User;
import SplitWise.Repository.SplitWiseRepo;

public class UserService {
    SplitWiseRepo splitWiseRepo;

    public UserService(SplitWiseRepo splitWiseRepo) {
        this.splitWiseRepo = splitWiseRepo;
    }

    public void addUserToMap(User user) {
        splitWiseRepo.getUserMap().put(user.getUserId(), user);
    }

    public User getUserByUserId(String userId) {
        return splitWiseRepo.getUserMap().get(userId);
    }
}
