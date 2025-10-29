package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.entities.Product;

public class DisplayProductByIdTester {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             SessionFactory sf = getFactory()) {

            ProductDao dao = new ProductDaoImpl();

            System.out.println("Enter product ID:");
            int id = sc.nextInt();

            Product product = dao.displayProductById(id);
            if (product != null)
                System.out.println("Product details: " + product);
            else
                System.out.println("No product found with ID " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
