-- create databse
CREATE DATABASE IF NOT EXISTS modoop;
USE modoop;

/*==============================================================*/
/* Table: admin         									    */
/*==============================================================*/
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
/* Table: role										            */
/*==============================================================*/
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
/* Table: permission								            */
/*==============================================================*/
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
/* Table: admin_x_role										    */
/*==============================================================*/
CREATE TABLE admin_x_role
(
    admin_id bigint NOT NULL,
    role_id bigint NOT NULL,
    PRIMARY KEY (admin_id,role_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE admin_x_role ADD CONSTRAINT fk_admin_id FOREIGN KEY (admin_id) REFERENCES admin (id) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE admin_x_role ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

