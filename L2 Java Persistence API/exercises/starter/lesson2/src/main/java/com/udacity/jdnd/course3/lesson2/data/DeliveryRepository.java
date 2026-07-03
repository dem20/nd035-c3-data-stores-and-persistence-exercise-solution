package com.udacity.jdnd.course3.lesson2.data;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class DeliveryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Transactional
    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    @Transactional
    public void delete(Long id) {
        Delivery delivery = find(id);
        if (delivery != null) {
            entityManager.remove(delivery);
        }
    }

    public Delivery findByName(String name) {
        return entityManager.createNamedQuery("Delivery.findByName", Delivery.class)
                            .setParameter("name", name)
                            .getSingleResult();
    }

    public RecipientAndPrice getRecipientAndPrice(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> cq = cb.createQuery(RecipientAndPrice.class);

        Root<Delivery> delivery = cq.from(Delivery.class);
        Join<Delivery, Plant> plants = delivery.join("plants", JoinType.LEFT);

        Expression<BigDecimal> totalPrice =
                cb.coalesce(cb.sum(plants.get("price")), BigDecimal.ZERO);

        cq.select(cb.construct(
                RecipientAndPrice.class,
                delivery.get("name"),
                totalPrice
        ));

        cq.where(cb.equal(delivery.get("id"), deliveryId));
        cq.groupBy(delivery.get("id"), delivery.get("name"));

        return entityManager.createQuery(cq).getSingleResult();
    }
}