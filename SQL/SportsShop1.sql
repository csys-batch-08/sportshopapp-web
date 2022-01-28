create table customers_detail(
user_name  VARCHAR2(20) PRIMARY KEY,
address VARCHAR2(50) NOT NULL,
 first_name VARCHAR(20) NOT NULL,
 last_name VARCHAR2(20) NOT NULL,
 email VARCHAR2(20)NOT NULL,
 phone NUMBER(10) unique  not null
 ); 
alter table customers_detail modify my_wallet number(20);

 alter table customers_detail add password varchar2(20);
 alter table customers_detail add  email varchar2(30) unique  ;
desc customers_detail;

create table cart(
items int generated always as identity start with 1,
user_name varchar2(20) not null,
products_id number(4) not null,
product_name varchar(20) not null,
standard_cost number(10,2),
quantity int not null,
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
 order_id number(4) generated always as identity start with 101 increment by 1 ,
 user_name varchar2(20) NOT NULL,
 products_id NUMBER(4) not null,
 price number(10,2) not null,
 status VARCHAR2(20) default 'Order placed',
 order_date DATE default sysdate,
 foreign key (user_name)REFERENCES customers_detail(user_name),
 foreign key (products_id)REFERENCES product_items(products_id),
primary key (order_id));
 commit;
 alter table order_detail modify order_id number(4) generated always as identity start with 101 increment by 1 ;
desc order_detail;
drop table order_detail cascade constraints;
commit;
create table orders_item(
item_id number(5) generated always as identity start with 1 increment by 1  ,
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
drop table orders_item cascade constraints;
alter table orders_item modify item_id number(4) generated always as identity start with 1 increment by 1 ;
insert into order_detail (user_name,products_id, price) values(?,?,?)commit;
 desc orders_item;
desc product_items;
desc order_detail;
desc customers_detail;
desc cart;
drop table cart cascade constraints;
select * from orders_item;
select * from customers_detail;
commit;
select * from product_items;
select * from admin;
select * from order_detail;
insert into order_detail (user_name,products_id, price) values('lokesh',345,798);
select * from cart;     
select * from admin;
drop table order_detail cascade constraints;
insert into cart values('lokesh', 399);
insert into order_detail(user_name, products_id,  price) values('lokesh',78,36000);

delete from order_detail where order_id = 101;  

delete from customers_detail where user_name = 'Damodaran';
UPDATE customers_detail
SET my_wallet=200000
WHERE user_name='lokesh';

    commit;
    update order_detail set status='canceled' where order_id =183;
    
   select p.products_name,oi.quantity,oi.standard_cost,oi.total_price,oi.order_id,p.products_id   from orders_item oi   inner join order_detail o on oi.order_id=o.order_id inner join product_items p on oi.products_id=p.products_id where oi.user_name= 'lokesh';
                 
                 select * from orders_item;
