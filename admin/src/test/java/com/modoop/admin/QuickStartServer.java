package com.modoop.admin;

import com.modoop.core.test.JettyFactory;
import org.eclipse.jetty.server.Server;

/**
 * @author Genkyo Lee
 */
public class QuickStartServer
{
    private static final String WEBAPP_PATH = "admin/src/main/webapp";
    private static final String CLASS_PATH = "admin/target";
    public static final int PORT = 8080;
    public static final String CONTEXT = "/";

    public static void main(String[] args) throws Exception
    {
        // 启动Jetty
        Server server = JettyFactory.createServerInSource(WEBAPP_PATH, PORT, CONTEXT);

        try
        {
            server.start();

            System.out.println("[INFO] Server running at http://localhost:" + PORT + CONTEXT);
            System.out.println("[HINT] Hit Enter to reload the application quickly");

            // 等待用户输入回车重载应用.
            while (true)
            {
                char c = (char) System.in.read();
                if (c == '\n')
                {
                    JettyFactory.reloadContext(server, CLASS_PATH);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
