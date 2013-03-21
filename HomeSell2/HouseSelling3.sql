DROP table IF EXISTS ResidenceMap;
DROP table IF EXISTS Picture;
DROP table IF EXISTS Room;
DROP table IF EXISTS Mail;
DROP table IF EXISTS House;
DROP table IF EXISTS RealEstate;
DROP table IF EXISTS Visitor;
DROP table IF EXISTS Owner;
DROP table IF EXISTS Person;

create table Person(id bigint, version integer, email_address varchar(255), first_name varchar(255), last_name varchar(255), date_of_birth date not null, phone_number bigint, primary key(id), unique(email_address))ENGINE=InnoDB;

create table Owner(version integer, email_address varchar(255), password varchar(255) not null, primary key(email_address), foreign key(email_address) references Person(email_address) on delete cascade)ENGINE=InnoDB;

create table Visitor(version integer, email_address varchar(255), primary key(email_address), foreign key(email_address) references Person(email_address) on delete cascade)ENGINE=InnoDB;

create table Mail(mes_id bigint, version integer, message varchar(255) not null, sent date, sender varchar(255) not null, receiver varchar(255), primary key(mes_id), unique(sent, sender, receiver), foreign key(sender) references Person(email_address), foreign key(receiver) references Person(email_address))ENGINE=InnoDB;

create table RealEstate(ree_id bigint, version integer, email_address varchar(255), civic_number int, street varchar(255), city varchar(255), province varchar(255), postal_code varchar(6), date_of_construction date, total_area int, primary key(ree_id), unique(civic_number, postal_code), foreign key(email_address) references Owner(email_address)on delete cascade)ENGINE=InnoDB;

create table House(house_id bigint, version integer, backyard_size int, primary key(house_id), foreign key(house_id) references RealEstate(ree_id) on delete cascade)ENGINE=InnoDB;

create table Room(room_id bigint, version integer, ree_id bigint, room_type varchar(255), size int, primary key(room_id), foreign key(ree_id) references RealEstate(ree_id) on delete cascade)ENGINE=InnoDB;

create table Picture(pic_id bigint, version integer, ree_id bigint, name varchar(255), format varchar(10), description varchar(255), size int, width int, height int, dir_location varchar(255), primary key(pic_id), foreign key(ree_id) references RealEstate(ree_id) on delete cascade)ENGINE=InnoDB;

create table ResidenceMap(email_address varchar(255), ree_id bigint, primary key(ree_id), unique(email_address), foreign key(ree_id) references RealEstate(ree_id), foreign key(email_address) references Owner(email_address) on delete cascade)ENGINE=InnoDB;
