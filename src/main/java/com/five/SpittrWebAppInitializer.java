package com.five;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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

}
