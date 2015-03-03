DROP PROCEDURE IF EXISTS admin_find;
DROP PROCEDURE IF EXISTS admin_find_byname;
DROP PROCEDURE IF EXISTS admin_delete;

DELIMITER //

CREATE PROCEDURE admin_find(IN admin_id BIGINT)
BEGIN

	SELECT a.id, a.name, a.password, a.phone, a.mobile, a.email, a.state, a.description, a.true_name, a.create_time, a.last_modify,
        r.id AS role_id, r.name AS role_name, r.permissions AS role_permissions, r.description AS role_description
        FROM admin a
        LEFT JOIN x_admin_role x ON a.id = x.admin_id LEFT JOIN role r ON x.role_id = r.id
        WHERE a.id = admin_id;

END //

CREATE PROCEDURE admin_find_byname(IN admin_name VARCHAR(63))
BEGIN

	SELECT a.id, a.name, a.password, a.phone, a.mobile, a.email, a.state, a.description, a.true_name, a.create_time, a.last_modify,
        r.id AS role_id, r.name AS role_name, r.permissions AS role_permissions, r.description AS role_description
        FROM admin a
        LEFT JOIN x_admin_role x on a.id = x.admin_id LEFT JOIN role r ON x.role_id = r.id
        WHERE a.name = admin_name;

END //

CREATE PROCEDURE admin_delete(IN admin_id BIGINT)
BEGIN

	DELETE FROM admin WHERE id = admin_id;

END //

DELIMITER ;