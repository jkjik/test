package testing;

import com.chenglian.enums.DictionariesEnum;
import com.chenglian.util.EnumsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2019/9/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class EnumsTest {
    @Test
    public void enumTest(){
        System.out.println(DictionariesEnum.getCodeDescribe(2));
    }
    @Test
    public void add(){
        EnumsUtils.addEnum(DictionariesEnum.class,"PROPERTY"
                ,new Class[]{java.lang.Integer.class,java.lang.String.class}
                ,new Object[]{4,"配置"});
    }
}
