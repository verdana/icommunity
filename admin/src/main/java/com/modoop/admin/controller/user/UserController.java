package com.modoop.admin.controller.user;

import com.modoop.admin.controller.AbstractController;
import com.modoop.admin.service.AdminService;
import com.modoop.admin.service.UserService;
import com.modoop.core.util.ServletUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractController
{
    @Autowired
    private UserService userService;

    /**
     * 用户浏览
     */
    @RequiresPermissions("user:read")
    @RequestMapping(value = {"", "browse"}, method = RequestMethod.GET)
    public String browse(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request)
    {
        Map<String, Object> parameters = ServletUtils.getParametersStartingWith(request, "search_");
        model.addAttribute("params", parameters);
        model.addAttribute("users", userService.search(parameters, pageNumber, pageSize));
        return "user/user_browse";
    }

    @RequiresPermissions("user:read")
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("user", userService.find(id));
        return "user/user_detail";
    }
}
