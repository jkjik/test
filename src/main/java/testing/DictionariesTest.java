package testing;

import com.chenglian.dao.DictionariesDao;
import com.chenglian.entity.CommodityDictionaries;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2019/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DictionariesTest {
    @Autowired
    private DictionariesDao dictionariesDaoImpl;
    @Test
    public void addTest(){
//        CommodityDictionaries dictionaries0 = new CommodityDictionaries(-1,1,001,"联想");
       CommodityDictionaries dictionaries1 = new CommodityDictionaries(-1,1,001,"小米");
       CommodityDictionaries dictionaries2 = new CommodityDictionaries(-1,1,001,"苹果");
//        CommodityDictionaries dictionaries3 = new CommodityDictionaries(-1,2,002,"苹果");
        CommodityDictionaries dictionaries4 = new CommodityDictionaries(-1,2,002,"华为");
        CommodityDictionaries dictionaries5 = new CommodityDictionaries(-1,2,002,"魅族");
//        dictionariesDaoImpl.add(dictionaries0);
        dictionariesDaoImpl.add(dictionaries1);
        dictionariesDaoImpl.add(dictionaries2);
//        dictionariesDaoImpl.add(dictionaries3);
        dictionariesDaoImpl.add(dictionaries4);
        dictionariesDaoImpl.add(dictionaries5);
    }
}
