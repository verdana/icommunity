package com.modoop.admin.controller.admin;

import com.modoop.admin.controller.AbstractController;
import com.modoop.admin.entity.Admin;
import com.modoop.admin.entity.Role;
import com.modoop.admin.service.AdminService;
import com.modoop.core.util.ServletUtils;
import com.modoop.core.validator.BeanValidators;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends AbstractController
{
    @Autowired
    private AdminService adminService;

    @Autowired
    private Validator validator;

    /**
     * 管理员浏览
     */
    @RequiresPermissions("admin:read")
    @RequestMapping(value = {"", "browse"}, method = RequestMethod.GET)
    public String browse(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request)
    {
        Map<String, Object> parameters = ServletUtils.getParametersStartingWith(request, "search_");
        model.addAttribute("params", parameters);
        model.addAttribute("admins", adminService.search(parameters, pageNumber, pageSize));
        return "admin/admin_browse";
    }


    @RequiresPermissions("admin:change")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model)
    {
        model.addAttribute("roles", adminService.findRoles());
        return "admin/admin_create";
    }

    @RequiresPermissions("admin:change")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Admin admin, @RequestParam(value = "roleId") Long roleId, RedirectAttributes redirectAttributes)
    {
        admin.setRole(new Role(roleId));
        adminService.create(admin);

        redirectAttributes.addFlashAttribute("message", "管理员 " + admin.getName() + " 创建成功！");
        return "redirect:/admin/browse";
    }

    /**
     * 管理员详细信息
     */
    @RequiresPermissions("admin:read")
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("admin", adminService.find(id));
        return "admin/admin_detail";
    }

    @RequiresPermissions("admin:change")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("roles", adminService.findRoles());
        model.addAttribute("admin", adminService.find(id));
        return "admin/admin_update";
    }

    @RequiresPermissions("admin:change")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute Admin admin, @RequestParam(value = "roleId") Long roleId, RedirectAttributes redirectAttributes)
    {
        admin.setRole(new Role(roleId));
        adminService.update(admin);

        redirectAttributes.addFlashAttribute("message", "管理员 " + admin.getName() + " 更新成功！");
        return "redirect:/admin/browse";
    }

    @RequiresPermissions("admin:change")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") List<Long> ids, RedirectAttributes redirectAttributes)
    {
        for (Long id : ids)
        {
            adminService.delete(id);
        }
        redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "个管理员成功！");
        return "redirect:/admin/browse";
    }

    @RequestMapping(value = "selfupdate", method = RequestMethod.GET)
    public String selfupdate(Model model, Principal principal)
    {
        model.addAttribute("admin", adminService.findByName(principal.getName()));
        return "admin/admin_selfupdate";
    }

    @RequestMapping(value = "selfupdate", method = RequestMethod.POST)
    public String selfupdate(@ModelAttribute Admin admin, @RequestParam(value = "roleId") Long roleId, RedirectAttributes redirectAttributes)
    {
        if ("".equals(admin.getPassword())) admin.setPassword(null); // avoid validator.
        BeanValidators.validateWithException(validator, admin);
        admin.setRole(new Role(roleId));
        adminService.update(admin);

        redirectAttributes.addFlashAttribute("message", "管理员 " + admin.getName() + " 更新成功！");
        return "redirect:/admin/selfupdate";
    }
}
