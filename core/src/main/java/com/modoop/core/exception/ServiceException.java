package com.modoop.core.exception;

import java.text.MessageFormat;

/**
 * @author Roger Lee
 */
public class ServiceException extends RuntimeException
{
    private static final long serialVersionUID = -2261250682350287730L;

    private Object[] params;

//Properties
    /**
     * 出现NullPointerException时，报告给用户的消息. 如：
     * <pre>
     * catch (NullPointerException e) {
     *     throw new WebException(WebException.NULL);
     * }
     * </pre>
     */
    public static final String NULL = "网络正忙，请稍候再试！(NP)";

    /**
     * 出现RuntimeException时，报告给用户的消息. 如：
     * <pre>
     * catch (RuntimeException e) {
     *     throw new WebException(EWWebException.RUNTIME, e);
     * }
     * </pre>
     */
    public static final String RUNTIME = "网络正忙，请稍候再试！(RT)";

    /**
     * 一个字典的key，该 key 没有内容，只有一个参数{0}.
     */
    public static final String BLANK = "{0}";

    /**
     * URL不存在时，报告给用户的消息.
     */
    public static final String URL_NOT_FOUND = "您访问的页面不存在，或者正在维护中，请您稍候再试！(UNF)";

    /**
     * 出现敏感词汇时，报告给用户的消息.
     */
    public static final String SENSITIVE_WORDS = "网络正忙，请稍候再试！(SW)";

    /**
     * 网络连接不通时，报告给用户的消息.
     */
    public static final String NETWORK = "网络正忙，请稍候再试！(NW)";

    /**
     * 验证错误时，报告给用户的消息.
     */
    public static final String VALIDATION = "参数内容不合法，请修改后重试！(CV)";

    /**
     * 权限不足错误时，报告给用户的消息.
     */
    public static final String UNAUTHORIZED = "用户权限不足，请联系管理员！(UA)";


    public ServiceException() {
        super();
    }

    /**
     * 用异常的HTTP状态和消息<code>msg</code>构造一个Exception.
     * <p/>
     *
     * @param message 错误消息
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * 用一个cause构在一个Exception.
     *
     * @param cause 造成本Exception的原因.
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * 用一个消息<code>msg</code>及产生本异常的原因root构造一个Exception.
     * 对于原因<code>root</code>,
     * <Ul>
     * </Ul>
     *
     * @param message  错误消息
     * @param cause 异常的原因
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String msg, Object[] params)
    {
        super(msg);
        this.params = params;
    }

    public Object[] getParams()
    {
        return params;
    }

    /**
     * 从本ServiceException中抽象出Message对象实例, 用于翻译和传递等.
     * <p/>
     * 本方法用 ServiceException 的 msg, params 构造一个 ServiceException 实例, 如果本 Exception 没有参数, 且其
     * cause 是 ServiceException 的实例, 则将该 cause 的 getMessage() 对象将作为参数构造.
     *
     * @return 异常消息
     */
    public String getMessage()
    {
        if (this.params != null && this.params.length > 0)
        {
            return MessageFormat.format(super.getMessage(), this.params);
        }
        else if (this.getCause() != null)
        {
            if (this.getCause() instanceof ServiceException)
            {
                ServiceException cause = (ServiceException) this.getCause();
                return MessageFormat.format(super.getMessage(), cause.getMessage());
            }
            else
            {
                return MessageFormat.format(super.getMessage(), this.getCause().getMessage());
            }
        }
        else
        {
            return super.getMessage();
        }
    }
}
