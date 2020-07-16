-- User
CREATE TABLE users(
	users_no		 INT AUTO_INCREMENT,
	users_name 	 VARCHAR(40) NOT NULL,
	email 	 VARCHAR(80) NOT NULL,
	password VARCHAR(20) NOT NULL,
	gender 	 VARCHAR(10),
	reg_date TIMESTAMP,
	usersType VARCHAR(40),
	PRIMARY KEY(users_no)
);


-- Board
CREATE TABLE board(
	no		 INT AUTO_INCREMENT,
	title 	 VARCHAR(200),
	content	 VARCHAR(4000),
	reg_date TIMESTAMP, 
	hit		 INT, 
	group_no INT,
	order_no INT,
	depth 	 INT,
	users_no INT,
	board_public int,
	users_type VARCHAR(40),
	PRIMARY KEY(no)
);

-- Gallery
CREATE TABLE gallery(
	no INT AUTO_INCREMENT,
	org_file_name VARCHAR(200),
	save_file_name VARCHAR(200),
	gallery_comment VARCHAR(4000),
	file_size INT,
	file_ext_name VARCHAR(50),
	reg_date TIMESTAMP,
	product_no int,
	PRIMARY KEY(no)
);
	
-- OrderStatus  주문상ㅌ
CREATE TABLE order_status(
	no	 INT AUTO_INCREMENT,
	product_no INT,
	product_name VARCHAR(200),
	order_product_count INT,
	order_date TIMESTAMP,
	users_no VARCHAR(10),
	order_product_price INT,
	PRIMARY KEY(no)
);

-- Product 제품
CREATE TABLE product(
	product_no INT AUTO_INCREMENT,
	product_name VARCHAR(200), 
	product_price INT, 
	product_count INT, 
	product_comment VARCHAR(4000), 
	reg_date TIMESTAMP,
	PRIMARY KEY(product_no)
);























