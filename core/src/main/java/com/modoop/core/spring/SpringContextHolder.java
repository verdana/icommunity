package com.modoop.core.spring;

import com.modoop.core.util.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring容器配置文件加载管理器。
 *
 * @author Roger Lee
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean
{
    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

    private static ApplicationContext applicationContext = null;

    /**
     * 载入Spring类配置，完成Spring容器的初始化。
     *
     * @return application
     */
    public static ApplicationContext getApplicationContext()
    {
        assertContextInjected();
        return applicationContext;
    }

    /**
     * 通过名称来获取对应的Bean，并强制转型。
     *
     * @return bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
    {
        assertContextInjected();
        return (T) getApplicationContext().getBean(name);
    }

    /**
     * 根据Bean的类型从容器中取出对应的静态Bean。
     *
     * @return bean
     */
    public static <T> T getBean(Class<T> requiredType)
    {
        assertContextInjected();
        return getApplicationContext().getBean(requiredType);
    }

    /**
     * 清除SpringContextHolder内初始化的ApplicationContext。
     */
    public static void clear()
    {
        logger.debug("clean the ApplicationContext of SpringContextHolder: " + applicationContext);
        applicationContext = null;
    }

    /**
     * 实现ApplicationContextAware接口，注入Context静态资源。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
    {
        logger.debug("Inject ApplicationContext into SpringContextHolder:" + applicationContext);

        if (SpringContextHolder.applicationContext != null)
        {
            logger.warn("SpringContextHolder's ApplicationContext is replaced, the original ApplicationContext is: " + SpringContextHolder.applicationContext);
        }

        SpringContextHolder.applicationContext = applicationContext; // NOSONAR
    }

    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy() throws Exception
    {
        SpringContextHolder.clear();
    }

    /**
     * 检查ApplicationContext不为空。
     */
    private static void assertContextInjected()
    {
        AssertUtils.state(applicationContext != null, "applicaitonContext have not injected, please defind the SpringContextHolder application context file");
    }
}
