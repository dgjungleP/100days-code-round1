package com.jungle.challenge;

import com.jungle.challenge.entity.User;
import com.jungle.challenge.mapper.UserMapper;
import com.jungle.challenge.plugins.desensitization.DataDesensitizationPlugin;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@Slf4j
@MapperScan("com.jungle.challenge.mapper")
public class Application implements ApplicationRunner {
    @Resource
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
//
//    @Bean
//    public UsedTimeAnalysePlugin usedTimeAnalysePlugin() {
//        return new UsedTimeAnalysePlugin();
//    }

    @Bean
    public DataDesensitizationPlugin dataDesensitizationPlugin() {
        return new DataDesensitizationPlugin();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始运行");
        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);
    }
}
