package io.github.mxyz.SimpleNote.service.impl;


import io.github.mxyz.SimpleNote.entity.TblUser;
import io.github.mxyz.SimpleNote.mapper.TblUserMapper;
import io.github.mxyz.SimpleNote.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TblUserMapper userMapper;
    // 从属性文件中读取发件人地址
    @Value("${spring.mail.username}")
    private String from;
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);          // 设置发件人邮箱地址
        message.setTo(to);              // 设置收件人地址
        message.setSubject(subject);    // 设置邮件主题
        message.setText(content);       // 设置邮件内容

        try {
            mailSender.send(message);
            TblUser user = new TblUser();
            user.setUsername(to);
            user.setPassword(content);
            userMapper.insert(user);
            System.out.println("邮件发送成功！");
        } catch (Exception e) {
            System.out.println("邮件发送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    @Async
    @Override
    public void loginByMail(String mail) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println("开始发送邮件:" + time.toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            Thread.sleep(5000);
            Random randObj = new Random();
            sendMail(mail,"登录验证码", Integer.toString(100000 + randObj.nextInt(900000)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            time = new Timestamp(System.currentTimeMillis());
            System.out.println("邮件发送完毕" + time.toLocalDateTime()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }
}
