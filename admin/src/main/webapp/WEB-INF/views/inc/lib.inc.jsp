<%@ page import="com.modoop.admin.entity.Stateful" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    static final String htmlHeaderCheck = "<INPUT TYPE=\"checkbox\" NAME=\"checkAll\" onClick=\"check_all(this.form)\">";
    static final String DEFAULT_CHARSET = "UTF-8";

    String urlEncode(String str)
    {
        try
        {
            return URLEncoder.encode(str, DEFAULT_CHARSET);
        }
        catch (UnsupportedEncodingException e)
        {
            return str;
        }
    }

    String urlDecode(String str)
    {
        try
        {
            if (str.indexOf("%") >= 0)
            {
                return URLDecoder.decode(str, DEFAULT_CHARSET);
            }
            else
            {
                return str;
            }
        }
        catch (UnsupportedEncodingException e)
        {
            return str;
        }
    }

    String getStateText(int stateIndex)
    {
        String textColor = "";

        switch (stateIndex)
        {
            case 0:
                textColor = "green";
                break;
            case 1:
                textColor = "orange";
                break;
            case 2:
                textColor = "red";
                break;
            case 3:
                textColor = "darkgray";
                break;
            case 4:
                textColor = "black";
                break;
            case 5:
                textColor = "gray";
                break;
        }

        return "<span class=\"" + textColor + "\">" + Stateful.TEXT[stateIndex] + "</span>";
    }

    String getVisibilityColor(int visibility)
    {
        String textColor = "";

        switch (visibility)
        {
            case 0:
                textColor = "blue";
                break;
            case 1:
                textColor = "darkgray";
                break;
            case 2:
                textColor = "gray";
                break;
        }

        return textColor;
    }
%>