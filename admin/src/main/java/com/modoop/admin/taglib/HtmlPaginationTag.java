package com.modoop.admin.taglib;

import com.modoop.core.constant.Constants;
import com.modoop.core.util.ServletUtils;
import com.modoop.core.util.StringUtils;
import com.modoop.core.web.taglib.HtmlTag;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Genkyo Lee
 */
public class HtmlPaginationTag<T> extends HtmlTag
{
    // Properties
    private static final long serialVersionUID = -2747842035854074161L;

    public static final String MSG_KEY_DISPLAY_RANGE = "tag.navigator.list.range";

    public static final String MSG_KEY_BTN_FIRST = "tag.navigator.btn.first";

    public static final String MSG_KEY_BTN_PREV = "tag.navigator.btn.prev";

    public static final String MSG_KEY_BTN_NEXT = "tag.navigator.btn.next";

    public static final String MSG_KEY_BTN_LAST = "tag.navigator.btn.last";

    private Page<T> page;

    private String excludedParams = "";

    private int paginationSize;


    // Constructor
    public HtmlPaginationTag()
    {
    }

    // Methods
    public Page<T> getPage()
    {
        return page;
    }

    public void setPage(Page<T> page)
    {
        this.page = page;
    }

    public void setPaginationSize(int paginationSize)
    {
        this.paginationSize = paginationSize;
    }

    public String getExcludedParams()
    {
        return excludedParams;
    }

    public void setExcludedParams(String excludedParams)
    {
        this.excludedParams = excludedParams;
        this.excludedParams = this.excludedParams.replaceAll("\\*", ".*");
        this.excludedParams = this.excludedParams.replaceAll("\\?", ".");
    }

    @Override
    public int doStartTag() throws JspException
    {
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - paginationSize / 2);
        int end = Math.min(begin + (paginationSize - 1), page.getTotalPages());

        JspWriter out = pageContext.getOut();
        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();

        StringBuilder html = new StringBuilder("<ul");

        // add attribute 'class'
        if (this.classname != null && this.classname.length() > 0)
        {
            html.append(" class=\"").append(this.classname).append('\"');
        }

        if (this.style != null && this.style.length() > 0)
        {
            html.append(" style=\"").append(this.style).append('\"');
        }

        // add other attributs set by 'decorator'
        if (this.decorate != null && this.decorate.length() > 0)
        {
            html.append(' ').append(this.decorate);
        }

        html.append(">\n");

        String queryString = getQueryString(req);

        // Begin
        if (page.hasPrevious())
        {
            html.append("   <li><a href=\"?").append(queryString).append("1").append("\">").append("&laquo;").append("</a></li>\n");
            html.append("   <li><a href=\"?").append(queryString).append(current - 1).append("\">").append("&lsaquo;").append("</a></li>\n");
        }
        else
        {
            html.append("   <li class=\"disabled\"><a href=\"javascript:void(0)\">").append("&laquo;").append("</a></li>\n");
            html.append("   <li class=\"disabled\"><a href=\"javascript:void(0)\">").append("&lsaquo;").append("</a></li>\n");
        }

        // Page
        for (int i = begin; i <= end; i++)
        {
            if (i == current)
            {
                html.append("   <li class=\"active\"><a href=\"?").append(queryString).append(i).append("\">").append(i).append("</a></li>\n");
            }
            else
            {
                html.append("   <li><a href=\"?").append(queryString).append(i).append("\">").append(i).append("</a></li>\n");
            }
        }

        // End
        if (page.hasNext())
        {
            html.append("   <li><a href=\"?").append(queryString).append(current + 1).append("\">").append("&rsaquo;").append("</a></li>\n");
            html.append("   <li><a href=\"?").append(queryString).append(page.getTotalPages()).append("\">").append("&raquo;").append("</a></li>\n");
        }
        else
        {
            html.append("   <li class=\"disabled\"><a href=\"javascript:void(0)\">").append("&rsaquo;").append("</a></li>\n");
            html.append("   <li class=\"disabled\"><a href=\"javascript:void(0)\">").append("&raquo;").append("</a></li>\n");
        }

        html.append("</ul>\n");

        try
        {
            out.println(html.toString());
        }
        catch (IOException e)
        {
            throw new JspException(e);
        }

        return SKIP_BODY;
    }

    protected String getQueryString(HttpServletRequest req)
    {
        // Deal with query string
        StringBuilder newQuery = new StringBuilder();
        String paramValue;

        String[] patterns = this.excludedParams.split(" ");

        Enumeration paramNames = req.getParameterNames();

        while (paramNames != null && paramNames.hasMoreElements())
        {
            String paramName = (String) paramNames.nextElement();

            // Parameter 'page-index' does not need to build.
            if (Constants.QUERY_PAGE_INDEX.equals(paramName))
            {
                continue;
            }

            // paramNames matches excludedParams
            boolean matched = false;
            for (String pattern : patterns)
            {
                if (paramName.matches(pattern))
                {
                    matched = true;
                    break;
                }
            }

            if (matched)
            {
                continue;
            }

            newQuery.append(paramName).append('=');

            paramValue = req.getParameter(paramName);

            if (!StringUtils.isAscii(paramValue))
            {
                newQuery.append(ServletUtils.urlEncode(paramValue));
            }
            else
            {
                newQuery.append(paramValue);
            }

            newQuery.append('&');
        }

        return newQuery.append(Constants.QUERY_PAGE_INDEX).append('=').toString();
    }
}
