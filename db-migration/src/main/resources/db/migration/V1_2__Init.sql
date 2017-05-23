CREATE SEQUENCE public.recommendations_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

CREATE TABLE public.recommendations (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) not null,
  description VARCHAR(512) not null,
  user_id BIGINT not null,
  constraint fk_recommendations_users
  foreign key (user_id)
  REFERENCES users (id)
);
