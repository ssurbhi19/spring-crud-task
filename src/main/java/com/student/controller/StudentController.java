package com.student.controller;

import com.student.config.AppConfig;
import com.student.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentController
{
    public static void main(String args[])
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        JdbcTemplate template = (JdbcTemplate) ac.getBean("template");

        /*String insertSql = "insert into student values(?,?,?,?)";
        int row = template.update(insertSql, 103,"aff","bss", "surbhi1996verma@gmail.com");
        System.out.println(row + " row inserted.");
*/
       String selectSql = "SELECT * FROM student";
       System.out.println(template.query(selectSql,new BeanPropertyRowMapper(Student.class)));

        String updateSql = "update student set first_name = ? where id = ?";
        template.update(updateSql, "Default", 102);
        System.out.println("Updated Record with ID = " + 102);

        String deleteSql = "DELETE FROM student WHERE id = ?";
        int rows = template.update(deleteSql, 101);
        System.out.println(rows + " row(s) deleted.");

    }
}
