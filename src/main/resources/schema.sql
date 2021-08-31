drop table up_merchant_categories;
create table up_merchant_categories(
category_id int not null primary key,
category_name varchar2(256) not null,
category_type varchar2(255) not null,
category_desc varchar2(255),
list_order int
);

drop table up_merchants;
create table up_merchants(
merchant_id varchar2(8) not null primary key,
category_id int not null,
merhchant_name varchar2(256) not null,
merchant_desc varchar2(4000),
list_order int
);

