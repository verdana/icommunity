-- create databse
CREATE DATABASE IF NOT EXISTS modoop;
USE modoop;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
DROP TABLE IF EXISTS `admin`;
CREATE TABLE admin
(
    id bigint AUTO_INCREMENT NOT NULL,
    name varchar(63) NOT NULL,
    password varchar(100) NOT NULL,
    true_name varchar(63) NULL,
    phone varchar(20)  NULL,
    mobile varchar(20) NULL,
    email varchar(127) NULL,
    state tinyint(1) DEFAULT 0 NOT NULL,
    description varchar(255) DEFAULT NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: role										                              */
/*==============================================================*/
DROP TABLE IF EXISTS `role`;
CREATE TABLE role
(
    id bigint AUTO_INCREMENT NOT NULL,
    name varchar(63) NOT NULL,
    permissions varchar(255) NOT NULL,
    description varchar(255) DEFAULT NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: permission								                            */
/*==============================================================*/
DROP TABLE IF EXISTS `permission`;
CREATE TABLE permission
(
    id bigint AUTO_INCREMENT NOT NULL,
    name varchar(63) NOT NULL,
    permit varchar(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: admin_x_role										                      */
/*==============================================================*/
DROP TABLE IF EXISTS `admin_x_role`;
CREATE TABLE admin_x_role
(
    admin_id bigint NOT NULL,
    role_id bigint NOT NULL,
    PRIMARY KEY (admin_id,role_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: saler                                                 */
/*==============================================================*/
DROP TABLE IF EXISTS `saler`;
CREATE TABLE saler
(
    id bigint AUTO_INCREMENT NOT NULL,
    mobile varchar(63) NOT NULL,
    true_name varchar(63) NOT NULL,
    nick_name varchar(63) NULL,
    id_card varchar(15) NULL,
    gender tinyint(1) DEFAULT -1 NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(127) NULL,
    phone varchar(20) NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (mobile)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: broker                                                */
/*==============================================================*/
DROP TABLE IF EXISTS `broker`;
CREATE TABLE broker
(
    id bigint AUTO_INCREMENT NOT NULL,
    mobile varchar(20) NOT NULL,
    true_name varchar(63) NOT NULL,
    id_card varchar(15) NULL,
    gender tinyint(1) DEFAULT -1 NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(127) NULL,
    phone varchar(20) NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (mobile)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE user
(
    id bigint AUTO_INCREMENT NOT NULL,
    mobile varchar(20) NOT NULL,
    name varchar(63) NULL,
    true_name varchar(63) NOT NULL,
    nick_name varchar(63) NULL,
    id_card varchar(15) NULL,
    gender tinyint(1) NOT NULL DEFAULT -1,
    age int NULL,
    password varchar(100) NULL,
    email varchar(127) NULL,
    phone varchar(20) NULL,
    description varchar(255) DEFAULT NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (mobile)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: residential                                           */
/*==============================================================*/
DROP TABLE IF EXISTS `residential`;
CREATE TABLE residential
(
    id bigint AUTO_INCREMENT NOT NULL,
    name varchar(63) NOT NULL,
    address varchar(100) NULL,
    description varchar(255) DEFAULT NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: house                                                 */
/*==============================================================*/
DROP TABLE IF EXISTS `house`;
CREATE TABLE house
(
    id bigint AUTO_INCREMENT NOT NULL,
    name varchar(63) NOT NULL,
    type tinyint(1) DEFAULT 0 NULL,
    area float NULL,
    price decimal(8,2) NULL,
    total_price decimal(11,2) NULL,
    discount float NULL,
    description varchar(255) DEFAULT NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: contract                                              */
/*==============================================================*/
CREATE TABLE contract
(
    id bigint AUTO_INCREMENT NOT NULL,
    number varchar(63) NOT NULL,
    price decimal(11,2) NULL,
    contract_time timestamp NOT NULL,
    description varchar(255) DEFAULT NULL,
    create_time timestamp NOT NULL,
    version bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (number)
)
ENGINE = InnoDB ROW_FORMAT = DEFAULT CHARSET=utf8;


ALTER TABLE admin_x_role ADD CONSTRAINT fk_admin_id FOREIGN KEY (admin_id) REFERENCES admin (id) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE admin_x_role ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

