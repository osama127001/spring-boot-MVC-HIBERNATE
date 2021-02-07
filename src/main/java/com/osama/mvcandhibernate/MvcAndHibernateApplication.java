package com.osama.mvcandhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class MvcAndHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcAndHibernateApplication.class, args);

		/*
		* Testing database Connection
		* */
		System.out.println("Connecting to the database ...");
		String dbUrl = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con = DriverManager.getConnection(dbUrl, "root", "admin");
			System.out.println("Connection Successful !");
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}

	}

}
