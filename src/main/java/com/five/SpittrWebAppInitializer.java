package com.five;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.File;

/**
 * Created by 陈祥 on 2016/8/23.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**ContextLoaderListener要加载的应用中的bean**/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**DispatcherServlet要加载的包含Web组件的bean，如控制器、视图解析器以及处理器映射**/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**将DispatcherServlet映射到"/"**/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**使用Servlet3.0解析multipart请求
     * 限制文件的大小不超过2MB，整个请求不超过4MB，且所有文件都要写到磁盘中
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp", 2097152, 4194304, 0)
        );
    }
}
