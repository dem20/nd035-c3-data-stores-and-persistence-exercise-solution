package com.udacity.jdnd.course3.lesson2.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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
}