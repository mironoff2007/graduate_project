DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS restaurants;


CREATE TABLE restaurants
(
  id               serial PRIMARY KEY ,
  name             VARCHAR                  NOT NULL
);
ALTER TABLE public.restaurants
  OWNER TO "user";



CREATE TABLE dishes (
  id          serial PRIMARY KEY ,
  restaurant_id	    integer	             DEFAULT NULL,
  name              VARCHAR                  NOT NULL,
  price             VARCHAR                  NOT NULL,

  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX restaurants_unique_dish_idx ON dishes (id);
ALTER TABLE public.dishes
  OWNER TO "user";



CREATE TABLE votes (
  id               serial PRIMARY KEY ,
  user_id          integer	              NOT NULL,
  restaurant_id    integer                  DEFAULT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
ALTER TABLE public.votes
  OWNER TO "user";


DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id          serial PRIMARY KEY ,
  name        VARCHAR  NOT NULL
);
ALTER TABLE public.users
  OWNER TO "user";



CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
ALTER TABLE public.user_roles
  OWNER TO "user";