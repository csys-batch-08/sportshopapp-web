create table customers_detail(
user_name  VARCHAR2(20) PRIMARY KEY,
address VARCHAR2(50) NOT NULL,
 first_name VARCHAR(20) NOT NULL,
 last_name VARCHAR2(20) NOT NULL,
 email VARCHAR2(20)NOT NULL,
 phone NUMBER(10) unique  not null
 ); 

 CREATE table orders_detail (
 order_id NUMBER(4) PRIMARY KEY,
 user_name varchar2(20) NOT NULL,
 status VARCHAR2(20) NOT NULL,
 order_date date NOT NULL,
 foreign key (user_name)REFERENCES customers_detail(user_name));
 
  CREATE table product_items(
 products_name VARCHAR(20) NOT NULL,
 products_id NUMBER(4) primary key,
 standard_cost number(10) NOT NULL);
 
 create table ordered_items(
 order_id NUMBER(4) NOT NULL,
 product_id number(5)not null,
 quantity NUMBER(5) NOT NULL,
 FOREIGN key (product_id)REFERENCES product_items(products_id),
 foreign key (order_id)REFERENCES orders_detail(order_id));



