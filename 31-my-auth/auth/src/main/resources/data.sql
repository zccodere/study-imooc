BEGIN;
INSERT INTO auth_function(id, name, parent_id, url, serial_num, accordion)
VALUES 
  (0, '菜单树', '-1', '', 1, 0),
  (1, '安全权限', 0, '', 1, 1),
  (2, '用户管理', 1, '/user/index', 2, 0),
  (3, '角色管理', 1, '/role/index', 3, 0),
  (4, '菜单管理', 1, '/function/index', 4, 0),
  (5, '用户授权', 1, '/authorize/index', 5, 0),
  (6, '用户角色', 1, '/authorize/userRole', 6, 0);
COMMIT;



