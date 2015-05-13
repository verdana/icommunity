package com.modoop.admin.controller.finance;

import com.modoop.admin.controller.AbstractController;
import com.modoop.admin.service.ContractService;
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
 * @author Roger Lee
 */
@Controller
@RequestMapping(value = "/contract")
public class ContractController extends AbstractController
{
    @Autowired
    private ContractService service;

    /**
     * 交易记录浏览
     */
    @RequiresPermissions("contract:read")
    @RequestMapping(value = {"", "browse"}, method = RequestMethod.GET)
    public String browse(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request)
    {
        Map<String, Object> parameters = ServletUtils.getParametersStartingWith(request, "search_");
        model.addAttribute("params", parameters);
        model.addAttribute("contracts", service.search(parameters, pageNumber, pageSize));
        return "contract/contract_browse";
    }

    @RequiresPermissions("contract:read")
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("contract", service.find(id));
        return "contract/contract_detail";
    }
}
