create table customers_detail(
user_name  VARCHAR2(20) PRIMARY KEY,
address VARCHAR2(50) NOT NULL,
 first_name VARCHAR(20) NOT NULL,
 last_name VARCHAR2(20) NOT NULL,
 email VARCHAR2(20)NOT NULL,
 phone NUMBER(10) unique  not null
 ); 

 alter table customers_detail add password varchar2(20);
 alter table customers_detail add  email varchar2(30) unique  ;
desc customers_detail;

create table cart(
user_name varchar2(20) not null,
products_id number(4) not null,
product_name varchar(20) not null,
standard_cost number(10) not null,
 foreign key (user_name)REFERENCES customers_detail(user_name), 
  foreign key (products_id)REFERENCES product_items(products_id)
  );
 
 CREATE table orders_detail (
 order_id NUMBER(4) not null,
 user_name varchar2(20) NOT NULL,
 status VARCHAR2(20) NOT NULL,
 order_date date NOT NULL,
 foreign key (user_name)REFERENCES customers_detail(user_name),
 foreign key (order_id)REFERENCES cart(order_id));
 alter table orders_detail add category varchar2(30);
 alter table orders_detail add order_date DATE default sysdate ;
 
 
  CREATE table product_items(
 products_name VARCHAR(20) NOT NULL,
 products_id NUMBER(4) primary key,
 standard_cost number(10) NOT NULL);
 alter table product_items add category varchar2(30);
 
desc product_items;
desc orders_detail;
desc customers_detail;
desc cart;
drop table cart cascade constraints;

select * from customers_detail;
select * from product_items;
select * from orders_detail;
select * from cart;



