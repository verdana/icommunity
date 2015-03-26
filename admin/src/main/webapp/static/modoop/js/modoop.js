// basic methods.
$(document).ready(function()
{
    init_selete_style();
    init_popovers();
    update_button_status();
});

redirect = function(url)
{
    window.location.href = encodeURI(url);
};

back = function()
{
    window.history.back();
};

home = function()
{
    window.location.href = "/";
};

confirm_submit = function (form, uri)
{
    if (window.confirm("您确定继续执行操作吗？"))
    {
        form.attr('action', uri);
        form.attr('method', 'post');
        form.submit();
    }
};


update_navigation_css = function()
{
    var path = window.location.pathname;
    var lis = $('ul[class="nav navbar-nav"] > li');

    if (lis.size() > 0)
    {
        lis.each(function()
        {
            if (path.indexOf($(this).find('a').attr('href')) >= 0)
            {
                $(this).attr('class', 'active');
            }
            else
            {
                $(this).attr('class', '');
            }
        });
    }
};

init_selete_style = function()
{
    var selects = $('select').not('.input-lg').not('.input-sm');
    if (selects.length > 0)
    {
        selects.each(function()
        {
            $(this).select2(
                {
                    minimumResultsForSearch: 20
                });
        })
    }
};

init_popovers = function()
{
    var popovers = $('input[rel="popover"]');
    if (popovers.length > 0)
    {
        popovers.each(function()
        {
           $(this).popover(
               {
                   title: 'Tips',
                   trigger: 'focus'
               });
        });
    }
};

get_checked_value = function(id)
{
    var checks = $('#' + id + ' input:checkbox:checked');
    if (checks.length == 1) return checks.val();
};

fix_checked_style = function()
{
    var rows = $('TABLE.data tbody > tr:has(td)');

    if (rows.length > 0)
    {
        rows.each(function()
        {
            var row = $(this);
            var checkbox = row.find('input[type="checkbox"]');

            if (checkbox.prop('checked') == true)
            {
                row.addClass('warning');
            }
            else
            {
                row.removeClass('warning');
            }
        });
    }

    update_button_status();
};


update_button_status = function()
{
    if ($('table.data :checkbox').length > 0)
    {
        var i = $('table.data :checked').length;

        if (i > 0)
        {
            $('.mbtn').each(function()
            {
                $(this).removeAttr('disabled');
            });
        }
        else
        {
            $('.mbtn').each(function()
            {
                $(this).attr('disabled', 'disabled');
            });
        }

        if (i == 1)
        {
            $('.sbtn').each(function()
            {
                $(this).removeAttr('disabled');
            });
        }
        else
        {
            $('.sbtn').each(function()
            {
                $(this).attr('disabled', 'disabled');
            });
        }
    }
};

// validator methods.
jQuery.validator.addMethod("pattern", function(value, element, param)
{
    if (this.optional(element))
    {
        return true;
    }
    if (typeof param === 'string')
    {
        param = new RegExp('^(?:' + param + ')$');
    }
    return param.test(value);
}, 'Invalid format.');