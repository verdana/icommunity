package com.modoop.core.web.taglib;

import javax.servlet.jsp.tagext.TagSupport;
import java.util.Locale;

/**
 * @author Genkyo Lee
 */
public class HtmlTag extends TagSupport
{
    private static final long serialVersionUID = 3624864486436296150L;

    //Properties
    protected String id;
    protected String name;
    protected String classname;
    protected String style;
    protected String decorate;
    protected Locale locale;

    //Constructor
    protected HtmlTag()
    {
    }

    //Methods

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getClassname()
    {
        return classname;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getDecorate()
    {
        return decorate;
    }

    public void setDecorate(String decorate)
    {
        this.decorate = decorate;
    }

    public Locale getLocale()
    {
        return locale;
    }

    public void setLocale(Locale locale)
    {
        this.locale = locale;
    }

    protected Locale getCurrentLocale()
    {
        // decide the locale to translate texts
        if (this.locale == null)
        {
            locale = pageContext.getResponse().getLocale();
        }

        return locale;
    }
}