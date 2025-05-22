package contexts.shop.suppliers.domain;

import com.github.javafaker.Faker;

public class SupplierMother {
    public static Supplier withRandomSupplier() {
        Faker faker = new Faker();
        return new Supplier(faker.number().numberBetween(1, 1000), faker.company().name(), faker.address().country());
    }

}
