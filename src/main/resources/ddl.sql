create table if not exists region (
    id bigserial primary key ,
    name varchar(100) not null,
    create_date timestamp without time zone not null default current_timestamp,
    update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX region_id ON region (id);
create table if not exists area (
                        id bigserial primary key ,
                        name varchar(100) not null,
                        region_id bigint not null ,
                        FOREIGN KEY (region_id) references region(id),
                        create_date timestamp without time zone not null default current_timestamp,
                        update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX area_id ON area (id);
create table if not exists district (
                          id bigserial primary key ,
                          name varchar(100) not null,
                          area_id bigint not null ,
                          FOREIGN KEY (area_id) references area(id),
                          create_date timestamp without time zone not null default current_timestamp,
                          update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX district_id ON district (id);
CREATE UNIQUE INDEX district_area_id ON district (area_id);
create table if not exists city (
                        id bigserial primary key ,
                        name varchar(100) not null,
                        district_id bigint not null ,
                        FOREIGN KEY (district_id) references district(id),
                        create_date timestamp without time zone not null default current_timestamp,
                        update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX city_id ON city (id);
create table if not exists estate_agency (
                      id bigserial primary key ,
                      name varchar(100) not null,
                      district_id bigint not null ,
                      FOREIGN KEY (district_id) references district(id),
                      create_date timestamp without time zone not null default current_timestamp,
                      update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX ea_id ON estate_agency (id);
create table if not exists realtor (
                               id bigserial primary key ,
                               name varchar(100) not null,
                               surname varchar(100) not null,
                               experience_in_years int not null,
                               create_date timestamp without time zone not null default current_timestamp,
                               update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX r_id ON realtor (id);
create table if not exists real_property(
                              id bigserial primary key ,
                              name varchar(100) not null,
                              create_date timestamp without time zone not null default current_timestamp,
                              update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX rp_id ON real_property (id);
create table if not exists real_property_realtor
(
    realtor_id bigint not null,
    FOREIGN KEY (realtor_id) references realtor(id),
    real_property_id bigint not null,
    FOREIGN KEY (real_property_id) references real_property(id)
);
create table if not exists estate_agency_realtor
(
    estate_agency_id bigint not null,
        constraint FK_ear_ea
        FOREIGN KEY (estate_agency_id)
            references estate_agency ON DELETE CASCADE,
    realtor_id bigint not null,
        constraint FK_ear_r
        FOREIGN KEY (realtor_id)
            references realtor ON DELETE CASCADE
);
create table if not exists client
(
    id bigserial primary key,
    name varchar(100),
    surname varchar(100),
    login varchar(100),
    password varchar(100),
    create_date timestamp without time zone not null default current_timestamp,
    update_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX c_id ON client (id);
create table if not exists history
(
    id bigserial primary key,
    name varchar(100),
    history_level varchar(100),
    history_type varchar(100),
    client_id bigint not null,
    FOREIGN KEY (client_id) references client(id),
    create_date timestamp without time zone not null default current_timestamp
);
CREATE UNIQUE INDEX history_id ON history (id);
create table if not exists history_detail (
    id bigserial primary key,
    name varchar(100),
    value varchar(100),
    history_id bigint not null,
    FOREIGN KEY (history_id) references history(id)
);
CREATE UNIQUE INDEX history_detail_id ON history_detail (id);
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

create function delete_all_by_date(given_date timestamp without time zone) returns boolean
    language plpgsql
as
$$
DECLARE
    passed BOOLEAN;
begin
    DELETE
    FROM history_detail
    where history_id in (
        SELECT history.id
        FROM HISTORY
        WHERE history.create_date < given_date
    );
    DELETE from history where create_date < given_date;
    return passed;
end
$$;
drop function  delete_all_by_date(given_date history.create_date%type);
call delete_all_by_date('2020-11-19 14:38:01.603000'::timestamp without time zone);

select * from delete_all_by_date('2020-11-19 14:38:01.603000'::timestamp without time zone);