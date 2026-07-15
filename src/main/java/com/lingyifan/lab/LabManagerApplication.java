package com.lingyifan.lab;
import org.mybatis.spring.annotation.MapperScan; import org.springframework.boot.*; import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication @MapperScan("com.lingyifan.lab.mapper") public class LabManagerApplication { public static void main(String[] args){SpringApplication.run(LabManagerApplication.class,args);} }
