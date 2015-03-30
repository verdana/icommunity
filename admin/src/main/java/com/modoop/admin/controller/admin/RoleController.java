package com.modoop.admin.controller.admin;

import com.google.common.base.Joiner;
import com.modoop.admin.controller.AbstractController;
import com.modoop.admin.service.RoleService;
import com.modoop.core.util.ServletUtils;
import com.modoop.core.validator.BeanValidators;
import com.modoop.data.entity.Role;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Validator;
import java.util.List;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends AbstractController
{
    @Autowired
    private RoleService roleService;

    @Autowired
    private Validator validator;

    @RequiresPermissions("role:read")
    @RequestMapping(value = {"", "browse"}, method = RequestMethod.GET)
    public String browse(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request)
    {
        Map<String, Object> parameters = ServletUtils.getParametersStartingWith(request, "search_");
        model.addAttribute("params", parameters);
        model.addAttribute("roles", roleService.search(parameters, pageNumber, pageSize));
        return "role/role_browse";
    }

    @RequiresPermissions("role:read")
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("permissions", roleService.findPermissions());
        model.addAttribute("role", roleService.find(id));
        return "role/role_detail";
    }

    @RequiresPermissions("role:change")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model)
    {
        model.addAttribute("permissions", roleService.findPermissions());
        return "role/role_create";
    }

    @RequiresPermissions("role:change")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute Role role, @RequestParam(value = "permissions") List<String> permissions, RedirectAttributes redirectAttributes)
    {
        role.setPermissions(Joiner.on(",").join(permissions));
        BeanValidators.validateWithException(validator, role);

        roleService.create(role);
        redirectAttributes.addFlashAttribute("message", "管理员权限 " + role.getName() + " 创建成功！");
        return "redirect:/role/browse";
    }

    @RequiresPermissions("role:change")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("permissions", roleService.findPermissions());
        model.addAttribute("role", roleService.find(id));
        return "role/role_update";
    }

    @RequiresPermissions("role:change")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute Role role, @RequestParam(value = "permissions") List<String> permissions, RedirectAttributes redirectAttributes)
    {
        role.setPermissions(Joiner.on(",").join(permissions));
        BeanValidators.validateWithException(validator, role);

        roleService.update(role);
        redirectAttributes.addFlashAttribute("message", "管理员权限 " + role.getName() + " 修改成功！");
        return "redirect:/role/browse";
    }

    @RequiresPermissions("role:change")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") List<Long> ids, RedirectAttributes redirectAttributes)
    {
        for (Long id : ids)
        {
            roleService.delete(id);
        }
        redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "个管理员权限成功！");
        return "redirect:/role/browse";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("permissions");
    }
}
