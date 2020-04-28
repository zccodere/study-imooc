package com.myimooc.spring.auth.service;

import com.myimooc.spring.auth.dao.RoleDao;
import com.myimooc.spring.auth.dao.RoleFunctionDao;
import com.myimooc.spring.auth.entity.Role;
import com.myimooc.spring.auth.entity.RoleFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 角色服务
 *
 * @author zc 2017-08-19
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleFunctionDao roleFunctionDao;

    public void addRole(Role role, Collection<RoleFunction> roleFunctions) {
        roleDao.save(role);
        roleFunctions.forEach((rf) -> {
            rf.setRoleId(role.getId());
        });
        roleFunctionDao.saveAll(roleFunctions);
    }

    public void editRole(Role role, Collection<RoleFunction> roleFunctions) {
        roleDao.update(role);
        roleFunctionDao.deleteByRoleId(role.getId());
        roleFunctions.forEach((rf) -> {
            rf.setRoleId(role.getId());
        });
        roleFunctionDao.saveAll(roleFunctions);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteById(roleId);
        roleFunctionDao.deleteByRoleId(roleId);
    }

    public List<Role> getRoles(int page, int size) {
        List<Role> roles = roleDao.findByPage(page, size);
        roles.forEach((role) -> {
            List<RoleFunction> roleFunctions = roleFunctionDao.findByRoleId(role.getId());
            StringBuilder functionIds = new StringBuilder();
            roleFunctions.forEach((rf) -> {
                functionIds.append(rf.getFunctionId()).append(",");
            });

            if (functionIds.length() > 1) {
                role.setFunctionIds(functionIds.deleteCharAt(functionIds.length() - 1).toString());
            }
        });
        return roles;
    }

    public List<Role> getRoles(Collection<Long> ids) {
        return roleDao.findByIds(ids);
    }

    public List<RoleFunction> getRoleFunctions(Long roleId) {
        return roleFunctionDao.findByRoleId(roleId);
    }
}
