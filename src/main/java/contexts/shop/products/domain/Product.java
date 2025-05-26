package contexts.shop.products.domain;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private ProductStock stock;
    private ProductRating rating;
    private String image;
    private int supplierId;
    private int categoryId;

    public Product(int id, String name, String description, double price, ProductStock stock, ProductRating rating, String image, int supplierId, int categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
        this.image = image;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStock getStock() {
        return stock;
    }

    public void setStock(ProductStock stock) {
        this.stock = stock;
    }

    public ProductRating getRating() {
        return rating;
    }

    public void setRating(ProductRating rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public static Product fromPrimitivesToDomain(int id, String name, String description, double price, int stock, float rating, String image, int supplierId, int categoryId) {
        return new Product(id, name, description, price, new ProductStock(stock), new ProductRating(rating), image, supplierId, categoryId);
    }

}