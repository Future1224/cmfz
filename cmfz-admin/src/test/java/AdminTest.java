import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.Random;


/**
 * 描述:
 *
 * @author 赵文朋
 * @create 2018-07-04 15:09
 */
public class AdminTest {


    @Test
    public void m1(){

        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao ad = (AdminDao)ApplicationContext.getBean("adminDao");
        Admin admin = ad.selectByName("hu");
        System.out.println(admin);
        String s = DigestUtils.md5Hex("666666" + "abcde");
        System.out.println(s);
        String random = RandomStringUtils.random(5, "QWERTYUIOPASDFGHJKLZXCVBNMmnbvcxzasdfghjklpoiuytrewq1234567890");
        System.out.println(random);
        System.out.println(RandomStringUtils.random(5));
        System.out.println(RandomStringUtils.randomAlphanumeric(5));
    }
}
