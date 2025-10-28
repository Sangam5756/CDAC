package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.entities.Category;
import com.product.entities.Product;

public class DisplayProductByFieldTester {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             SessionFactory sf = getFactory()) {

            ProductDao dao = new ProductDaoImpl();

            System.out.println("Enter date(yyyy-MM-dd) and category:");
            LocalDate date = LocalDate.parse(sc.next());
            Category category = Category.valueOf(sc.next().toUpperCase());

            List<Product> products = dao.displayProductByField(date, category);

            if (products != null && !products.isEmpty())
                products.forEach(System.out::println);
            else
                System.out.println("No products found for the given date and category.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
