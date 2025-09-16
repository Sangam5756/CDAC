```java


import java.util.HashSet;




 enum Category {
    FOOD, OIL, FRUIT, STATIONARY, SPICES, GRAINS
}

/*
 * 
2. Override the `hashCode()` method in the `Product` class consistent with the `equals()` 
method you wrote in 
Task 1. Verify the `HashSet` behavior by adding multiple products.**


# 3. **Modify the `equals()` method to include the `name` field as part of equality check, 
and override `hashCode()` accordingly. Add products with same `id`
 and `category` but different `name` and observe the effect on `HashSet`.**
*/


 class ProductPrac1 {
    private int id;
    private String name;
    private Category category;
    private int stock;
    private double price;

    public ProductPrac1(int id, String name, Category category, int stock, double price) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", stock=" + stock + ", price="
                + price + "]";
    }


////    same id same category
//    @Override
    public boolean equals(Object obj) {
      
        if (obj instanceof ProductPrac1) {
            ProductPrac1 pd = (ProductPrac1) obj;
            System.out.println("Equals Method is Called on id "+ pd.id);
            return (id == pd.id) && (this.category.equals(pd.category));
        }

        return false;

    }
    
    @Override
    public int hashCode() {
        int code = (id * 29) + category.hashCode();
        System.out.println("Hashed Method is Called on id "+ id);
        return code ;
        
    }

}



public class Test2 {

    public static void main(String[] args) {
        ProductPrac1 product1 = new ProductPrac1(101, "Bread", Category.FOOD, 100, 50);
        ProductPrac1 product2 = new ProductPrac1(10, "Biscuits", Category.FOOD, 100, 50);
        ProductPrac1 product3 = new ProductPrac1(101, "Bread", Category.FOOD, 100, 50);
        ProductPrac1 product4 = new ProductPrac1(10, "Sunflower Oil", Category.OIL, 100, 50);
        ProductPrac1 product5 = new ProductPrac1(101, "Rice", Category.GRAINS, 100, 50);

        
        
        HashSet<ProductPrac1> products = new HashSet<>();
        System.out.println(products.add(product1));
        System.out.println(products.add(product2));
        System.out.println(products.add(product3));
        System.out.println(products.add(product4));
        System.out.println(products.add(product5));
        System.out.println(products.size());

    }
}
```