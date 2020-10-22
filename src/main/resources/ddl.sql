create sequence seq_name;
create table region (
    id serial primary key ,
    name varchar(100) not null,
    create_data timestamp with time zone not null default current_timestamp,
    update_data timestamp without time zone not null default current_timestamp
);
create table oblast (
                        id serial primary key ,
                        name varchar(100) not null,
                        region_id integer not null ,
                        create_data timestamp with time zone not null default current_timestamp,
                        update_data timestamp without time zone not null default current_timestamp
);
create table district (
                          id serial primary key ,
                          name varchar(100) not null,
                          oblast_id integer not null ,
                          create_data timestamp with time zone not null default current_timestamp,
                          update_data timestamp without time zone not null default current_timestamp
);
create table city (
                        id serial primary key ,
                        name varchar(100) not null,
                        district_id integer not null ,
                        create_data timestamp with time zone not null default current_timestamp,
                        update_data timestamp without time zone not null default current_timestamp
);
create table estate_agency (
                      id serial primary key ,
                      name varchar(100) not null,
                      district_id integer not null ,
                      create_data timestamp with time zone not null default current_timestamp,
                      update_data timestamp without time zone not null default current_timestamp
);
create table realtor (
                               id serial primary key ,
                               name varchar(100) not null,
                               create_data timestamp with time zone not null default current_timestamp,
                               update_data timestamp without time zone not null default current_timestamp
);
create table real_property(
                              id serial primary key ,
                              name varchar(100) not null,
                              create_data timestamp with time zone not null default current_timestamp,
                              update_data timestamp without time zone not null default current_timestamp
);
create table EstateAgency_Realtor(
                              id serial primary key ,
                              estateAgency_id integer not null,
                              realtor_id integer not null ,
                              create_data timestamp with time zone not null default current_timestamp,
                              update_data timestamp without time zone not null default current_timestamp
);
create table realProperty_Realtor(
                                     id serial primary key ,
                                     real_property_id integer not null,
                                     realtor_id integer not null ,
                                     create_data timestamp with time zone not null default current_timestamp,
                                     update_data timestamp without time zone not null default current_timestamp
);
DELETE FROM region;
DELETE FROM city;
DELETE FROM oblast;
DELETE FROM district;
DELETE FROM estate_agency;
DELETE FROM real_property;
ALTER table real_property drop realtor_id
alter sequence city_id_seq restart 1;
alter sequence district_id_seq restart 1;
alter sequence oblast_id_seq restart 1;
alter sequence region_id_seq restart 1;
alter sequence seq_name restart 1;