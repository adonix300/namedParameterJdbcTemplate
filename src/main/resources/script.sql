SELECT homework.orders.product_name
FROM homework.orders
JOIN homework.customers ON orders.customer_id = customers.id
WHERE customers.name =