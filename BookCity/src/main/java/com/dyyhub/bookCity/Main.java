package com.dyyhub.bookCity;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);
        tomcat.getConnector();

        //创建webAPP
        Context ctx = tomcat.addWebapp("",new File("src/main/webapp").getAbsolutePath());
        WebResourceRoot resourceRoot = new StandardRoot(ctx);
        resourceRoot.addPreResources(
                new DirResourceSet(resourceRoot, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
        ctx.setResources(resourceRoot);
        tomcat.start();
        tomcat.getServer().await();
    }
}
