import com.chenglian.dao.AccountDao;
import com.chenglian.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by lenovo on 2019/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MysqlConnectTest {
    @Autowired
    private AccountDao accountDaoImpl;

    @Test
    public void connectTest(){
        //Account account = new Account(1,"123","123",1,new Date());
        //accountDaoImpl.add(account);
    }
}
