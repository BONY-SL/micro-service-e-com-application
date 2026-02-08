INSERT INTO category (id, name, description ) VALUES (nextval('category_seq'), 'Keyboards','Computer Keyboards');
INSERT INTO category (id, name, description ) VALUES (nextval('category_seq'), 'Mice','Computer Mice');
INSERT INTO category (id, name, description ) VALUES (nextval('category_seq'), 'Monitors','Computer Monitors');
INSERT INTO category (id, name, description ) VALUES (nextval('category_seq'), 'Laptops','Portable Computers');
INSERT INTO category (id, name, description ) VALUES (nextval('category_seq'), 'Desktops','Desktop Computers');


-- Assuming you already have a sequence named 'product_seq'

-- Insert products for the 'Keyboards' category
INSERT INTO public.product (id,name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'),'Mechanical Keyboard 1', 'Mechanical keyboard with RGB lighting',10 , 99.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'),'Mechanical Keyboard 2', 'Compact mechanical keyboard',15 , 79.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'),'Mechanical Keyboard 3', 'Wireless mechanical keyboard',8 , 129.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'),'Mechanical Keyboard 4', 'Ergonomic mechanical keyboard',12 , 109.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'),'Mechanical Keyboard 5', 'Gaming mechanical keyboard',20 , 89.99, (SELECT id FROM category WHERE name = 'Keyboards'));

-- Insert products for the 'Mice' category
INSERT INTO public.product (id,name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'),'Gaming Mouse 1', 'High-precision gaming mouse',25 , 49.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'),'Gaming Mouse 2', 'Wireless gaming mouse',30 , 59.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'),'Gaming Mouse 3', 'Ergonomic gaming mouse',18 , 39.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'),'Gaming Mouse 4', 'RGB gaming mouse',22 , 44.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'),'Gaming Mouse 5', 'Budget gaming mouse',40 , 29.99, (SELECT id FROM category WHERE name = 'Mice'));

-- Insert products for the 'Monitors' category
INSERT INTO public.product (id,name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'),'4K Monitor 1', '27-inch 4K UHD monitor',5 , 399.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'),'4K Monitor 2', '32-inch 4K UHD monitor',7 , 499.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'),'4K Monitor 3', 'Curved 4K UHD monitor',4 , 599.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'),'4K Monitor 4', 'Gaming 4K UHD monitor',6 , 449.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'),'4K Monitor 5', 'Budget 4K UHD monitor',10 , 299.99, (SELECT id FROM category WHERE name = 'Monitors'));

-- Insert products for the 'Laptops' category
INSERT INTO public.product (id,name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'),'Laptop 1', '15-inch laptop with Intel i7',10 , 899.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'),'Laptop 2', '13-inch laptop with M1 chip',8 , 1199.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'),'Laptop 3', '17-inch gaming laptop',5 , 1499.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'),'Laptop 4', '14-inch business laptop',12 , 999.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'),'Laptop 5', 'Convertible 2-in-1 laptop',7 , 1099.99, (SELECT id FROM category WHERE name = 'Laptops'));

-- Insert products for the 'Desktops' category
INSERT INTO public.product (id,name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'),'Desktop 1', 'Gaming desktop with RTX 3080',6 , 1999.99, (SELECT id FROM category WHERE name = 'Desktops')),
    (nextval('product_seq'),'Desktop 2', 'All-in-one desktop',10 , 1299.99, (SELECT id FROM category WHERE name = 'Desktops')),
    (nextval('product_seq'),'Desktop 3', 'Compact desktop PC',15 , 799.99, (SELECT id FROM category WHERE name = 'Desktops')),
    (nextval('product_seq'),'Desktop 4', 'Workstation desktop',4 , 2499.99, (SELECT id FROM category WHERE name = 'Desktops')),
    (nextval('product_seq'),'Desktop 5', 'Budget desktop PC',20 , 599.99, (SELECT id FROM category WHERE name = 'Desktops'));


