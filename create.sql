create table category (
	categoryid int primary key auto_increment,
    categoryname varchar(15) not null,
    description tinytext
);

create table supplier (
	supplierid int primary key auto_increment,
    suppliername varchar(40) not null,
    contactname varchar(40) ,
    address varchar(50) not null,
    city varchar(20) not null,
    postalcode varchar (20) not null,
    country varchar (25)not null,
    phone varchar(20)
);

create table products (
	idproduct int primary key auto_increment,
    productname varchar(20) not null,
    supplierid int,
    categoryid int,
    unit varchar(50) not null,
    price float(5,2) not null
);

alter table products add constraint FK_PRODUCTS_SUPPLIERID
FOREIGN KEY(SUPPLIERID) REFERENCES SUPPLIER(SUPPLIERID);

alter table products add constraint FK_PRODUCTS_CATEGORY
FOREIGN KEY(categoryid) REFERENCES category(categoryid);

