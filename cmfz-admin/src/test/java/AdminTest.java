import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;


/**
 * 描述:
 *
 * @author 赵文朋
 * @create 2018-07-04 15:09
 */
public class AdminTest {




//
//    @Test
//    public  void  m2(){
//        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AdminService as = (AdminService)ApplicationContext.getBean("adminServiceImpl");
//        Admin admin = new Admin();
//        admin.setAdminPassword("666666");
//        admin.setAdminName("张三");
//        admin.setAdminRank(1);
//        //Boolean aBoolean = as.addAdmin(admin);
//       // System.out.println(aBoolean);
//
//    }


//    @Test
//    public  void m3(){
//        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        MenuDao md = (MenuDao)ApplicationContext.getBean("menuDao");
//        List<Menu> menus = md.selectAll();
//        for (Menu menu : menus) {
//            System.out.println(menu);
//        }
//    }

//    @Test
////    public void m4(){
////        Md5Hash abcde = new Md5Hash("666666", "abcde", 520);
////        System.out.println(abcde);
////    }
}
