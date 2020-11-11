create table if not exists service.region (
    id bigserial primary key ,
    name varchar(100) not null,
    create_date timestamp without time zone not null default current_timestamp,
    update_date timestamp without time zone not null default current_timestamp
);

SELECT *  from region
where update_date between '2020-11-01 00:00:00.0'::timestamp
and '2020-11-30 23:59:59.0'::timestamp;
select "fasdfas"

select (extract(epoch from create_date at TIME ZONE 'UTC') * 1000) from region;
SELECT to_number(create_date) from region;
select * from region where name = 'Одесса'
create table if not exists area (
                        id bigserial primary key ,
                        name varchar(100) not null,
                        region_id bigint not null ,
                        create_date timestamp without time zone not null default current_timestamp,
                        update_date timestamp without time zone not null default current_timestamp
);

create table if not exists district (
                          id bigserial primary key ,
                          name varchar(100) not null,
                          area_id bigint not null ,
                          create_date timestamp without time zone zone not null default current_timestamp,
                          update_date timestamp without time zone not null default current_timestamp
);
create table if not exists city (
                        id bigserial primary key ,
                        name varchar(100) not null,
                        district_id bigint not null ,
                        create_date timestamp without time zone zone not null default current_timestamp,
                        update_date timestamp without time zone not null default current_timestamp
);
create table if not exists estate_agency (
                      id bigserial primary key ,
                      name varchar(100) not null,
                      district_id bigint not null ,
                      create_date timestamp without time zone not null default current_timestamp,
                      update_date timestamp without time zone not null default current_timestamp
);
create table if not exists realtor (
                               id bigserial primary key ,
                               name varchar(100) not null,
                               surname varchar(100) not null,
                               experience_in_years int not null,
                               create_date timestamp without time zone not null default current_timestamp,
                               update_date timestamp without time zone not null default current_timestamp
);
create table if not exists real_property(
                              id bigserial primary key ,
                              name varchar(100) not null,
                              create_date timestamp without time zone not null default current_timestamp,
                              update_date timestamp without time zone not null default current_timestamp
);
create table if not exists real_property_realtor
(
    realtor_id bigint not null
            references real_property(id),
    real_property_id bigint not null
            references realtor(id)
);
create table if not exists estate_agency_realtor
(
    estate_agency_id bigint not null
        constraint FK_ear_ea
            references estate_agency,
    realtor_id bigint not null
        constraint FK_ear_r
            references realtor
);
create table if not exists description
(

)


DELETE FROM service.region;
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