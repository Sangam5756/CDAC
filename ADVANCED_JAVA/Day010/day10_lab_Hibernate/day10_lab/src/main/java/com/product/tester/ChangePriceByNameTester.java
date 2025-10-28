package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;

public class ChangePriceByNameTester {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             SessionFactory sf = getFactory()) {

            ProductDao dao = new ProductDaoImpl();

            System.out.println("Enter product name and new price:");
            String name = sc.next();
            double price = sc.nextDouble();

            System.out.println(dao.changePriceByName(name, price));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
