DROP TABLE IF EXISTS restaurants;


CREATE TABLE restaurants
(
  id               INTEGER PRIMARY KEY ,
  name             VARCHAR                  NOT NULL,
  votes            INTEGER DEFAULT 0        NOT NULL
);



DROP TABLE IF EXISTS dishes;
CREATE TABLE dishes (
  id          INTEGER PRIMARY KEY ,
  restaurant_id     INTEGER   NOT NULL,
  name              VARCHAR                  NOT NULL,
  price             VARCHAR                  NOT NULL,

  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX restaurants_unique_dish_idx ON dishes (id);