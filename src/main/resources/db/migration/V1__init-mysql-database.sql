
drop table if exists beer;

drop table if exists customer;

create table beer (
    id varchar(36) not null,
    beer_style smallint not null,
    beer_name varchar(50) not null,
    created_date datetime(6),
    price decimal(38,2) not null,
    quantity_on_hand integer,
    version integer,
    update_date datetime(6),
    upc varchar(255) not null,
    primary key (id)
) ENGINE=InnoDB;

create table customer (
    version integer,
    email varchar(255),
    created_date datetime(6),
    update_date datetime(6),
    id varchar(36) not null,
    customer_name varchar(255),
    primary key (id)
) ENGINE=InnoDB;
