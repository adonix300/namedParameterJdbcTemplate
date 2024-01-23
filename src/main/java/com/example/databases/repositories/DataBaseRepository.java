package com.example.databases.repositories;

import com.example.databases.models.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DataBaseRepository {
    @PersistenceContext
    EntityManager entityManager;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        TypedQuery<Order> query = entityManager.createQuery("FROM Order where customer.name = :name", Order.class);
        query.setParameter("name", name);
        List<String> productNames = new ArrayList<>();
        for (Order order : query.getResultList()) {
            productNames.add(order.getProductName());
        }
        return productNames;
    }
}
