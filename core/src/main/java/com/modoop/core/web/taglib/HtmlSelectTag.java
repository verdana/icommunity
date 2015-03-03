package com.modoop.core.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * @author Genkyo Lee
 */
public class HtmlSelectTag extends HtmlTag
{
    private static final long serialVersionUID = 1466284751065612573L;

    //Properties
    private String[] options;
    private String selected = "";
    private int size = 1;
    private boolean hasBlankOption = true;
    private boolean hasNaOption = true;
    private String naOptionText = "未设置";

    //Constructor
    public HtmlSelectTag()
    {
    }

    //Methods
    public String[] getOptions()
    {
        return options;
    }

    public void setOptions(String[] options)
    {
        this.options = options;
    }

    public String getSelected()
    {
        return selected;
    }

    public void setSelected(String selected)
    {
        this.selected = selected;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public boolean isHasNaOption()
    {
        return hasNaOption;
    }

    public boolean isHasBlankOption()
    {
        return hasBlankOption;
    }

    public void setHasBlankOption(boolean hasBlankOption)
    {
        this.hasBlankOption = hasBlankOption;
    }

    public void setHasNaOption(boolean hasNaOption)
    {
        this.hasNaOption = hasNaOption;
    }

    public String getNaOptionText()
    {
        return naOptionText;
    }

    public void setNaOptionText(String naOptionText)
    {
        this.naOptionText = naOptionText;
    }

    @Override
    public int doStartTag() throws JspException
    {
        JspWriter out = pageContext.getOut();

        StringBuffer html = new StringBuffer("<select name=\"" + this.name + "\"");

        //add attribute 'size'
        if (this.size > 0)
        {
            html.append(" size=\"").append(size).append("\"");
        }

        //add attribute 'class'
        if (this.classname != null && this.classname.length() > 0)
        {
            html.append(" class=\"").append(this.classname).append("\"");
        }

        //add attribute 'style'
        if (this.style != null && this.style.length() > 0)
        {
            html.append(" style=\"").append(this.style).append("\"");
        }

        //add other attributs set by 'decorator'
        if (this.decorate != null && this.decorate.length() > 0)
        {
            html.append(" ").append(this.decorate);
        }

        html.append(">\n");

        //add blank option
        if (this.hasBlankOption)
        {
            html.append("<option value=\"\"></option>\n");
        }

        //add n/a option
        if (this.hasNaOption)
        {
            html.append("<option value=\"-1\">");
            html.append(this.naOptionText);
            html.append("</option>\n");
        }

        //add options
        if (this.options != null && this.options.length > 0)
        {
            for (int i = 0; i < options.length - 1; i++)
            {
                String option = options[i];
                html.append("    ");
                html.append("<option value=\"").append(i).append("\"");
                //check if this is a 'selected' option
                if (this.selected.equals(String.valueOf(i)))
                {
                    html.append(" selected");
                }
                html.append(">");

                html.append(option);
                html.append("</option>\n");
            }
        }

        html.append("</select>\n");

        try
        {
            out.print(html);
        }
        catch (IOException e)
        {
            throw new JspException(e);
        }

        return SKIP_BODY;
    }
}
