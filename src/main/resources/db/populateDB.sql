TRUNCATE restaurants CASCADE;
ALTER SEQUENCE restaurants_id_seq RESTART WITH 1;
TRUNCATE users CASCADE;
ALTER SEQUENCE users_id_seq RESTART WITH 1;


INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');


INSERT INTO user_roles (role, user_id) VALUES
  (0, 1),
  (1, 1),
  (0, 2);

INSERT INTO restaurants (  name)
VALUES ('Retaurant1'),
  ('Retaurant2' );

INSERT INTO dishes (restaurant_id, name, price)
VALUES (1, 'Завтрак', 500),
  (1, 'Обед', 1000),
  (2, 'плов', 500),
  (2, 'суп', 500);


