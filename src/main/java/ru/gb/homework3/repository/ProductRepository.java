package ru.gb.homework3.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.homework3.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Iterable<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public Product findById(Long id) {
        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.findById", Product.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    public void deleteById(Integer id) {
        Product product = new Product();
        product.setId(id);
        delete(product);
    }

    public void delete(Product product) {
        Product mergedProduct = entityManager.merge(product);
        entityManager.remove(mergedProduct);
    }
}

