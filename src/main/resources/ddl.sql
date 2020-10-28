create table if not exists region (
    id serial primary key ,
    name varchar(100) not null,
    create_data timestamp with time zone not null default current_timestamp,
    update_data timestamp without time zone not null default current_timestamp
);
create table if not exists area (
                        id serial primary key ,
                        name varchar(100) not null,
                        region_id integer not null ,
                        create_data timestamp with time zone not null default current_timestamp,
                        update_data timestamp without time zone not null default current_timestamp
);

create table if not exists district (
                          id serial primary key ,
                          name varchar(100) not null,
                          area_id integer not null ,
                          create_data timestamp with time zone not null default current_timestamp,
                          update_data timestamp without time zone not null default current_timestamp
);
create table if not exists city (
                        id serial primary key ,
                        name varchar(100) not null,
                        district_id integer not null ,
                        create_data timestamp with time zone not null default current_timestamp,
                        update_data timestamp without time zone not null default current_timestamp
);
create table if not exists estate_agency (
                      id serial primary key ,
                      name varchar(100) not null,
                      district_id integer not null ,
                      create_data timestamp with time zone not null default current_timestamp,
                      update_data timestamp without time zone not null default current_timestamp
);
create table if not exists realtor (
                               id serial primary key ,
                               name varchar(100) not null,
                               create_data timestamp with time zone not null default current_timestamp,
                               update_data timestamp without time zone not null default current_timestamp
);
create table if not exists real_property(
                              id serial primary key ,
                              name varchar(100) not null,
                              create_data timestamp with time zone not null default current_timestamp,
                              update_data timestamp without time zone not null default current_timestamp
);
create table if not exists real_property_realtor
(
    realtor_id       integer not null
            references real_property(id),
    real_property_id integer not null
            references realtor(id)
);
create table if not exists estate_agency_realtor
(
    estate_agency_id integer not null
        constraint FK_ear_ea
            references estate_agency,
    realtor_id integer not null
        constraint FK_ear_r
            references realtor
);


DELETE FROM region;
DELETE FROM city;
DELETE FROM area;
DELETE FROM district;
DELETE FROM estate_agency;
DELETE FROM estate_agency_realtor;
DELETE FROM real_property_realtor;
DELETE from realtor;
DELETE FROM real_property;
alter sequence city_id_seq restart 1;
alter sequence district_id_seq restart 1;
alter sequence area_id_seq restart 1;
alter sequence region_id_seq restart 1;