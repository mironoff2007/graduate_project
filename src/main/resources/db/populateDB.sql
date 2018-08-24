DELETE FROM user_roles;
DELETE
FROM restaurants;
DELETE FROM users;


INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 1),
  ('ROLE_USER', 2);

INSERT INTO dishes (restaurant_id, name, price)
VALUES (1, 'Завтрак', 500),
       (1, 'Обед', 1000),
       (2, 'плов', 500),
       (2, 'суп', 500);


INSERT INTO restaurants ( name)
VALUES ('Retaurant1'),
        ('Retaurant2' );