/* 
# E-commerce Platform Search Function

## Introduction
-> In an e-commerce platform, customers search for products every day. As the number of products increases, finding a product quickly becomes more important. If the search process is slow, it can affect the user experience. Therefore, efficient searching algorithms are required to improve performance.

-> In this project, I implemented two searching techniques: **Linear Search** and **Binary Search**. These algorithms help in finding products based on their Product ID.

## Big O Notation
-> Big O Notation is used to measure the efficiency of an algorithm. It tells us how the running time of an algorithm changes when the amount of data increases.

Some common time complexities are:

* O(1) – Constant Time
* O(log n) – Logarithmic Time
* O(n) – Linear Time
* O(n²) – Quadratic Time

Using Big O Notation helps us compare different algorithms and choose the better one for a specific problem.

### Best Case
-> The product is found on the first attempt.
### Average Case
-> The product is found somewhere in the middle of the list.
### Worst Case
-> The product is found at the last position or is not present in the list.

---

## Implementation

A Product class is created with the following attributes:

* Product ID
* Product Name
* Category

Two search algorithms are implemented:

# Linear Search
-> Linear Search checks each product one by one until the required product is found.

# Binary Search
-> Binary Search works only on a sorted array. It repeatedly divides the search space into two halves, making the search much faster.

## Time Complexity Comparison

 * Algorithm      Best Case  Average Case  Worst Case 
 * Linear Search  O(1)       O(n)          O(n)       
 * Binary Search  O(1)       O(log n)      O(log n)   
## Which Search is Better?

* Linear Search is easy to understand and implement, but it becomes slower when the number of products increases.
* Binary Search is much faster because it reduces the search area by half in every step. However, it requires the products to be stored in sorted order.
* For a large e-commerce platform with thousands of products, Binary Search is generally a better choice because it provides faster search results.

*/
class Product {

    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("Product_ID: " + productId +
                ", Product_Name: " + productName +
                ", Category: " + category);
    }
}

public class EcommercePlatformSearch {

    // Linear Search
    static Product linear(Product[] products, int key) {

        for (Product product : products) {
            if (product.productId == key) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    static Product binary(Product[] products, int key) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == key) {
                return products[mid];
            }

            if (products[mid].productId < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Sorted array for Binary Search
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };

        int searchId = 104;

        System.out.println("Linear Search Result:");
        Product result1 = linear(products, searchId);

        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Product Not Found");
        }

        System.out.println("\nBinary Search Result:");
        Product result2 = binary(products, searchId);

        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Product Not Found");
        }
    }
}