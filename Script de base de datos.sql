-- Creacion de tablas

create table generes (
	id NUMERIC(10) primary key,
	name VARCHAR(30)
);

create table users (
	id NUMERIC(10) primary key,
	full_name VARCHAR(30),
	username VARCHAR(20),
	passwd VARCHAR(200),
	state VARCHAR(3)
);

create table books (
	id NUMERIC(10) primary key,
	name VARCHAR(50),
	summary VARCHAR(500),
	price NUMERIC(6, 2),
	state VARCHAR(3),
	image VARCHAR(500),
	gen_id NUMERIC(10),
	usr_id NUMERIC(10),
	constraint fk_gen foreign key(gen_id) references generes(id),
	constraint fk_usr foreign key(usr_id) references users(id)
);

-- Insercion de datos

insert into generes(id, name) values (1, 'Terror'), (2, 'Historia'), (3, 'Aventuras');

INSERT INTO books (id, name, summary, price, state, image, gen_id, usr_id) VALUES
(1, 'Shadows of the Abyss', 'A group of explorers uncover an ancient evil lurking beneath the ocean floor.', 19.99, 'DIS', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1506502069i/36312075.jpg', 1, NULL),

(2, 'Whispers in the Dark', 'A detective investigates a series of mysterious disappearances tied to a haunted mansion.', 15.50, 'NOD', 'https://m.media-amazon.com/images/I/61OtLOBQjvL._SL1500_.jpg', 1, NULL),

(3, 'Empire of Ashes', 'A deep dive into the rise and fall of a forgotten ancient civilization.', 22.75, 'DIS', 'https://i1.wp.com/anthonyryan.net/wp-content/uploads/2018/04/empire-of-ashes-final.jpg?ssl=1', 2, NULL),

(4, 'Chronicles of the Forgotten War', 'A historian uncovers lost documents that change the narrative of a major war.', 18.40, 'DIS', 'https://m.media-amazon.com/images/I/51UgSjwI59L._SY445_SX342_.jpg', 2, NULL),

(5, 'Jungle of Secrets', 'An adventurer ventures into an uncharted jungle filled with dangers and hidden treasures.', 17.99, 'DIS', 'https://m.media-amazon.com/images/I/419VRUDILnL._SY445_SX342_.jpg', 3, NULL),

(6, 'The Lost Expedition', 'A team sets out to find a missing expedition and encounters unexpected perils.', 16.25, 'DIS', 'https://smithwriter.com/sites/default/files/lostexpedition_ebook_large.jpg', 3, NULL),

(7, 'Nightmare Carnival', 'A traveling carnival hides terrifying secrets that come alive at night.', 14.99, 'NOD', 'https://m.media-amazon.com/images/I/81EK6jxHuIL._SL1500_.jpg', 1, NULL),

(8, 'Voyage Beyond the Horizon', 'Sailors embark on a journey to discover lands beyond the known world.', 20.00, 'NOD', 'https://media.bribooks.com/public/AuthorCoverImages/user_cover_68e3f98e70883_b0_v1489526.png?width=500', 3, NULL);

-- Drop de tablas

drop table books;
drop table generes;
drop table users;