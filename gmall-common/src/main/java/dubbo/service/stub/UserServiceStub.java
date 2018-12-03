package dubbo.service.stub;

import dubbo.bean.UserAddress;
import dubbo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkk
 * @version V1.0
 * @Description: userService本地存根类
 * @date 2018/11/22/9:57
 */
public class UserServiceStub implements UserService{

    private final UserService userService;

    //在构造器中dubbo会传入userService远程的代理对象
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        if (userId != null) {
            return userService.getUserAddressList(userId);
        }
        UserAddress address1 = new UserAddress(null, "暂无数据", "", "暂无数据", "暂无数据", "暂无数据");
        List<UserAddress> list = new ArrayList<UserAddress>();
        list.add(address1);
        return list;
    }
}
