package com.modoop.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Genkyo Lee
 */
public abstract class AbstractController
{
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected static final String PAGE_SIZE = "20";

//    /**
//     * 将异常消息取出来后发送到显示错误提示的页面显示。
//     *
//     * @param t   需要处理的异常对象
//     */
//    @ExceptionHandler({ConstraintViolationException.class, ServiceException.class})
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    protected String handleException(HttpServletRequest req, Throwable t)
//    {
//        req.setAttribute(Constants.THROWABLE, t);
//        return "error/error";
//    }
}
