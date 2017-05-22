CREATE SEQUENCE public.users_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

CREATE TABLE public.users (
	id BIGINT PRIMARY KEY,
	first_name VARCHAR(255) not null,
	last_name VARCHAR(255) not null,
	age INT not null
);

