package org.sk.mavenProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id: ");
        int id = sc.nextInt();
        
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Student getStudent = session.get(Student.class, id);
        
        if(getStudent != null){
            session.remove(getStudent);
            System.out.println("Student deleted: " + getStudent);
        } else {
            System.out.println("Student with id " + id + " not found.");
        }
        
        transaction.commit();
        session.close();
        sf.close();
    }
}