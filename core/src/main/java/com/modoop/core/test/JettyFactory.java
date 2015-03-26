package com.modoop.core.test;

import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Genkyo Lee
 */
public class JettyFactory
{
    /**
     * 创建用于开发运行调试的Jetty Server。
     */
    public static Server createServerInSource(String webappPath, int port, String contextPath)
    {
        Server server = new Server();
        //设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        //解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.addConnector(connector);

        WebAppContext webContext = new WebAppContext(webappPath, contextPath);
        server.setHandler(webContext);

        return server;
    }

    public static Server createSSLEmbeddedServer(String webappPath, int port, String contextPath)
    {
        Server server = new Server();
        //设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        SslContextFactory contextFactory = new SslContextFactory();
        contextFactory.setKeyStorePath("rest/src/main/resources/keystore/key.store");
        contextFactory.setKeyStorePassword("password");
        SslConnectionFactory sslConnectionFactory = new SslConnectionFactory(contextFactory, HttpVersion.HTTP_1_1.toString());

        HttpConfiguration config = new HttpConfiguration();
        config.setSecureScheme("https");
        config.setSecurePort(port);
        config.setOutputBufferSize(32786);
        config.setRequestHeaderSize(8192);
        config.setResponseHeaderSize(8192);
        HttpConfiguration sslConfiguration = new HttpConfiguration(config);
        sslConfiguration.addCustomizer(new SecureRequestCustomizer());
        HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(sslConfiguration);

        ServerConnector connector = new ServerConnector(server, sslConnectionFactory, httpConnectionFactory);
        connector.setPort(port);
        server.addConnector(connector);

        WebAppContext webContext = new WebAppContext(webappPath, contextPath);
        server.setHandler(webContext);

        return server;
    }

    /**
     * 快速重新启动application，重载target/classes与target/test-classes.
     */
    public static void reloadContext(Server server, String path) throws Exception
    {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("[INFO] Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        classLoader.addClassPath(path + "/classes");
        classLoader.addClassPath(path + "/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("[INFO] Application reloaded");
    }
}
