package assign2;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineShoppingSystem {
    Scanner sc = new Scanner(System.in);

    class Product {
        int id;
        String name;
        String description;
        float price;
        int quantity;

        Product(int id, String name, String description, float price, int quantity) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.quantity = quantity;
        }
    }

    class Customer {
        int id;
        String name;
        String email;
        String shipping_add;

        Customer(int id, String name, String email, String shipping_add) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.shipping_add = shipping_add;
        }

        void display() {
            System.out.println("User ID:" + id);
            System.out.println("Name:" + name);
            System.out.println("Email address:" + email);
            System.out.println("Shipping Address:" + shipping_add);
        }
    }

    static ArrayList<Product> ProductList = new ArrayList<>();

    class ShoppingCart {
        void add_product(Product pro) {
            if (!ProductList.contains(pro)) {
                ProductList.add(pro);
            } else {
                System.out.println("already contains the product in the cart");
            }
        }

        void seach_product(Product pro) {
            if (ProductList.contains(pro)) {
                display_product(pro);
            } else {
                System.out.println("product does not exist in the cart");
            }
        }

        void delete_product(Product pro) {
            ProductList.remove(pro);
        }

        void display_product(Product p) {
            System.out.println("Product ID:" + p.id);
            System.out.println("Product Name:" + p.name);
            System.out.println("Product Description:" + p.description);
            System.out.println("Product Price:" + p.price);
            System.out.println("Product quantity:" + p.quantity);

        }
    }

    class OnlineStore {
        int pro_id;
        String pro_name;
        String pro_des;
        float pro_price;
        int pro_quan;
        int cus_id;
        String cus_name;
        String cus_email;
        String cus_shipping_add;

        Customer User_Details() {
            System.out.println("enter your id");
            cus_id = sc.nextInt();
            sc.nextLine(); 
            System.out.println("enter your name");
            cus_name = sc.nextLine();
            System.out.println("enter your email");
            cus_email = sc.nextLine();
            System.out.println("enter your shipping address");
            cus_shipping_add = sc.nextLine();
            Customer user = new Customer(cus_id, cus_name, cus_email, cus_shipping_add);
            // System.out.println("product name = "+ cus_name);
            return user;
        }
        Product Product_Details() {
            System.out.println("enter product id");
            pro_id = sc.nextInt();
            sc.nextLine(); 
            System.out.println("enter product name");
            pro_name = sc.nextLine();
            System.out.println("enter product description");
            pro_des = sc.nextLine();
            System.out.println("enter product price");
            pro_price = sc.nextFloat();
            System.out.println("enter product quantity");
            pro_quan = sc.nextInt();
            Product product = new Product(pro_id, pro_name, pro_des, pro_price, pro_quan);
            // System.out.println("product name = "+ pro_name);
            return product;
        }

        void place_order(ArrayList<Product> cart, Customer user) {
            if (cart.isEmpty()) {
                System.out.println("cart is empty");
            } else {
                System.out.println("ORDER PLACED SUCCESSFULLY...!");
                System.out.println("ORDER DETAILS:-");
                System.out.println("Customer Details:");
                user.display();
                ShoppingCart obj = new ShoppingCart();
                for (Product product : cart) {
                    obj.display_product(product);
                    System.out.println();
                }
                ;
            }
        }
    }

    class TestMain {
        void TestCase() {
            OnlineShoppingSystem obj = new OnlineShoppingSystem();
            Product p;
            OnlineStore order = obj.new OnlineStore();
            ShoppingCart cart = obj.new ShoppingCart();
            Customer user = order.User_Details();
            int choice = 0;
            while (choice != 5) {
                System.out.println(
                        "Choose any option:\n 1- add a product to cart\n 2- search a product in the cart\n 3- delete a product from the cart\n 4- place order\n 5- EXIT");
                choice = sc.nextInt();
                if (choice == 1) {
                    p = order.Product_Details();
                    cart.add_product(p);
                } else if (choice == 2) {
                    System.out.println("enter id to search");
                    int id = sc.nextInt();
                    int i;
                    for (i = 0; i < ProductList.size(); i++) {
                        if (ProductList.get(i).id == id) {
                            break;
                        }
                    }
                    cart.seach_product(ProductList.get(i));
                } else if (choice == 3) {
                    System.out.println("enter id to search");
                    int id = sc.nextInt();
                    int i;
                    for (i = 0; i < ProductList.size(); i++) {
                        if (ProductList.get(i).id == id) {
                            break;
                        }
                    }
                    if (ProductList.get(i).id == id) {
                        cart.delete_product(ProductList.get(i));
                    } else {
                        System.out.println("product does not exist in the cart");
                    }
                } else if (choice == 4) {
                    order.place_order(ProductList, user);
                } 
                else if(choice== 5){
                    System.out.println("EXITING...!");
                }
                else {
                    System.out.println("wrong choice...!");
                }
            }
        }
    }

    public static void main(String[] args) {
        OnlineShoppingSystem object = new OnlineShoppingSystem();
        TestMain test = object.new TestMain();
        test.TestCase();
    }
}