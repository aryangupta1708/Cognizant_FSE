
/* 
# Inventory Management System

# Problem Understanding

-> In a warehouse, a large number of products need to be stored, updated, and managed efficiently. If the inventory grows to thousands of products, performing operations manually or using inefficient methods can become slow and difficult.
Data structures and algorithms help organize data in a way that makes operations such as adding, updating, searching, and deleting products faster and more efficient. Choosing the right data structure improves the overall performance of the inventory management system.

### Suitable Data Structures

-> Some commonly used data structures for inventory management are:

* Array Simple but has a fixed size.
* ArrayList Dynamic in size and easy to use.
* HashMap Provides fast access to products using a unique key such as Product ID.

For this project, **HashMap** is used because it allows quick insertion, retrieval, updating, and deletion of products.

## Implementation

-> A `Product` class is created with the following attributes:

* Product ID
* Product Name
* Quantity
* Price

** The products are stored in a `HashMap<Integer, Product>`, where the Product ID acts as the key.

-> The system supports the following operations:

1. Add a new product.
2. Update an existing product.
3. Delete a product from inventory.
4. Display all available products.

-> This Inventory Management System demonstrates how data structures and algorithms can be used to manage warehouse products efficiently. By using a HashMap, product operations such as adding, updating, and deleting can be performed quickly, making the system suitable for handling large inventories.

# Time Complexity Analysis
-> Operation	Time Complexity
1. Add Product	O(1)
2. Update Product	O(1)
3. Delete Product	O(1)
4. Search Product	O(1)
Since HashMap uses hashing, most operations can be performed in constant time on average.

#Optimization
-> The performance of the system can be improved further by:
* Using proper hashing techniques.
* Applying database indexing for very large inventories.
* Using caching for frequently accessed products.
* Using ConcurrentHashMap in multi-user environments.
*/

//Code 

import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(productId + " " + productName +
                " " + quantity + " " + price);
    }
}

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    static void updateProduct(int id, int quantity) {
        if (inventory.containsKey(id)) {
            inventory.get(id).quantity = quantity;
        }
    }

    static void deleteProduct(int id) {
        inventory.remove(id);
    }

    static void displayProducts() {
        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {

        addProduct(new Product(101, "Laptop", 10, 50000));
        addProduct(new Product(102, "Mobile", 20, 25000));
        addProduct(new Product(103, "Keyboard", 30, 1000));

        updateProduct(102, 25);
        deleteProduct(103);

        displayProducts();
    }
}