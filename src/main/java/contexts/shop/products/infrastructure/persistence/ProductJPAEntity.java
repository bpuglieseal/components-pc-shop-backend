package contexts.shop.products.infrastructure.persistence;

import contexts.shop.categories.infrastructure.persistence.CategoryJPAEntity;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPAEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private float rating;
    private int stock;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierJPAEntity supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryJPAEntity category;
}
