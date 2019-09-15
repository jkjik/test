package testing;

import com.chenglian.enums.DictionariesEnum;
import com.chenglian.enums.TestEnum;
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
        EnumsUtils.addEnum(TestEnum.class,"PROPERTY"
                ,new Class[]{java.lang.Integer.class,java.lang.String.class}
                ,new Object[]{4,"配置"});
        for (TestEnum enums : TestEnum.values()) {
            System.out.println(enums);
            System.out.println(enums.getCode());
            System.out.println(enums.getDescribe());
        }
        System.out.println(TestEnum.getCodeDescribe(4));
    }
}
