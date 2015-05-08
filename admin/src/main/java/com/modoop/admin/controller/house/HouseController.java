package com.modoop.admin.controller.house;

import com.modoop.admin.controller.AbstractController;
import com.modoop.admin.service.HouseService;
import com.modoop.core.util.ServletUtils;
import com.modoop.core.validator.BeanValidators;
import com.modoop.data.entity.House;
import com.modoop.data.entity.Role;
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
 * @author James
 */
@Controller
@RequestMapping(value = "/house")
public class HouseController extends AbstractController
{
    @Autowired
    private HouseService houseService;

    /**
     * 管理员浏览
     */
    @RequiresPermissions("house:read")
    @RequestMapping(value = {"", "browse"}, method = RequestMethod.GET)
    public String browse(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request)
    {
        Map<String, Object> parameters = ServletUtils.getParametersStartingWith(request, "search_");
        model.addAttribute("params", parameters);
        model.addAttribute("houses", houseService.search(parameters, pageNumber, pageSize));
        return "house/house_browse";
    }


    @RequiresPermissions("house:change")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model)
    {
//        model.addAttribute("roles", houseService.());
        return "house/house_create";
    }

    @RequiresPermissions("house:change")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute House house, RedirectAttributes redirectAttributes)
    {
        houseService.create(house);

        redirectAttributes.addFlashAttribute("message", "户型 " + house.getName() + " 创建成功！");
        return "redirect:/house/browse";
    }

    /**
     * 管理员详细信息
     */
    @RequiresPermissions("house:read")
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("house", houseService.find(id));
        return "house/house_detail";
    }

    @RequiresPermissions("house:change")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("house", houseService.find(id));
        return "house/house_update";
    }

    @RequiresPermissions("house:change")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute House house, RedirectAttributes redirectAttributes)
    {
        houseService.update(house);

        redirectAttributes.addFlashAttribute("message", "户型 " + house.getName() + " 更新成功！");
        return "redirect:/house/browse";
    }

    @RequiresPermissions("house:change")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") List<Long> ids, RedirectAttributes redirectAttributes)
    {
        for (Long id : ids)
        {
            houseService.delete(id);
        }
        redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "个户型成功！");
        return "redirect:/house/browse";
    }

    @RequestMapping(value = "selfupdate", method = RequestMethod.GET)
    public String selfupdate(Model model, Principal principal)
    {
        model.addAttribute("house", houseService.findByName(principal.getName()));
        return "house/house_selfupdate";
    }

}
