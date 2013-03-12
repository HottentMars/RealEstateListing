DROP table IF EXISTS ResidenceMap;
DROP table IF EXISTS Picture;
DROP table IF EXISTS Room;
DROP table IF EXISTS Mail;
DROP table IF EXISTS House;
DROP table IF EXISTS RealEstate;
DROP table IF EXISTS Visitor;
DROP table IF EXISTS Owner;
DROP table IF EXISTS Person;

create table Person(email_address varchar(255), first_name varchar(255), last_name varchar(255), date_of_birth date not null, phone_number bigint, primary key(email_address))ENGINE=InnoDB;

create table Owner(email_address varchar(255), password varchar(255) not null, primary key(email_address), foreign key(email_address) references Person(email_address) on delete cascade)ENGINE=InnoDB;

create table Visitor(email_address varchar(255), primary key(email_address), foreign key(email_address) references Person(email_address) on delete cascade)ENGINE=InnoDB;

create table Mail(mes_id bigint, message varchar(255) not null, sent date not null, sender bigint not null, receiver bigint not null, primary key(mes_id), unique(sent, sender, receiver), foreign key(sender) references Person(per_id), foreign key(receiver) references Person(per_id) on delete cascade)ENGINE=InnoDB;

create table RealEstate(ree_id bigint, own_id bigint, civic_number int, street varchar(255), city varchar(255), province varchar(255), postal_code varchar(6), date_of_construction date, total_area int, primary key(ree_id), unique(civic_number, postal_code), foreign key(own_id) references Owner(own_id) on delete cascade)ENGINE=InnoDB;

create table House(hse_id bigint, primary key(hse_id), backyard_size int, foreign key(hse_id) references RealEstate(ree_id) on delete cascade)ENGINE=InnoDB;

create table Room(roo_id bigint, ree_id bigint, room_type varchar(255), size int, primary key(roo_id), foreign key(ree_id) references RealEstate(ree_id) on delete cascade)ENGINE=InnoDB;

create table Picture(pic_id bigint, ree_id bigint, name varchar(255), format varchar(10), description varchar(255), size int, width int, height int, dir_location varchar(255) not null, primary key(pic_id), foreign key(ree_id) references RealEstate(ree_id) on delete cascade)ENGINE=InnoDB;

create table ResidenceMap(ree_id bigint, own_id bigint, primary key(ree_id), unique(own_id), foreign key(ree_id) references RealEstate(ree_id), foreign key(own_id) references Owner(own_id) on delete cascade)ENGINE=InnoDB;
