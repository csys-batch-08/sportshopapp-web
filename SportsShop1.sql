create table customers_detail(
user_name  VARCHAR2(20) PRIMARY KEY,
address VARCHAR2(50) NOT NULL,
 first_name VARCHAR(20) NOT NULL,
 last_name VARCHAR2(20) NOT NULL,
 email VARCHAR2(20)NOT NULL,
 phone NUMBER(10) unique  not null
 ); 
alter table customers_detail add my_wallet varchar2(20);
 alter table customers_detail add password varchar2(20);
 alter table customers_detail add  email varchar2(30) unique  ;
desc customers_detail;

create table cart(
items int generated always as identity start with 1,
user_name varchar2(20) not null,
products_id number(4) not null,
product_name varchar(20) not null,
quantity int not null,
standard_cost number(10,2) not null,
total_prize number (10,2)not null,
 foreign key (user_name)REFERENCES customers_detail(user_name), 
  foreign key (products_id)REFERENCES product_items(products_id)
  );
 
  drop table cart;
 desc cart;

 desc order_detail;
 commit;
 
 create table admin (
 user_name varchar2(30) not null,
 password varchar2(20)not null,
 email varchar2 (50)unique not null,
 mobile number(10)unique not null
 );
 insert into admin values ('adminolympus','damo1515','admin@olympus.com',9863456412);

 

 
  CREATE table product_items(
 products_name VARCHAR(20) NOT NULL,
 products_id NUMBER(4) primary key,
 standard_cost number(10) NOT NULL);
 alter table product_items add category varchar2(30);
 alter table product_items add quantity int;
 
  CREATE table order_detail (
 order_id NUMBER(4) primary key,
 user_name varchar2(20) NOT NULL,
 product_name varchar(20) not null,
 category varchar2(30) not null,
 status VARCHAR2(20) NOT NULL,
 order_date DATE default sysdate,
 foreign key (user_name)REFERENCES customers_detail(user_name));
 drop table order_detail;
 alter table order_detail modify order_id number(4) generated always as identity start with 101 increment by 1 ;
desc order_detail;
drop table order_detail cascade constraints;

create table orders_item(
item_id number(5)primary key ,
user_name varchar2(20)not null,

order_id number(4) not null,
products_id number(5) not null,
quantity number(5) not null,
 standard_cost number(10) not null,
total_price number(20) not null,
foreign key (user_name)REFERENCES customers_detail(user_name),
foreign key (products_id)REFERENCES product_items(products_id),
foreign key (order_id)REFERENCES order_detail(order_id)
);
commit;
 drop table orders_item;
desc product_items;
desc orders_detail;
desc customers_detail;
desc cart;
drop table cart cascade constraints;

select * from customers_detail;
commit;
select * from product_items;
select * from orders_detail;
select * from cart;
select * from admin;

    commit;
