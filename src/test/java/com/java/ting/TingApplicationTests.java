package com.java.ting;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TingApplicationTests {

    //    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private CompanyDao companyDao;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Value(value = "${spring.mail.username}")
    private String name;
    @Value(value = "${spring.mail.password}")
    private String password;
    @Value(value = "${spring.mail.host}")
    private String host;

//    @Test
//    @Rollback
//    public void findByName() throws Exception {
//        userMapper.insert("AAA", 20);
//        User u = userMapper.findByName("AAA");
//        Assert.assertEquals(20, u.getAge().intValue());
//    }

    //    @Test
//    public void company() {
//        List<Company> list = companyDao.selectList(null);
//        list.forEach(System.out::println);
//    }


}
