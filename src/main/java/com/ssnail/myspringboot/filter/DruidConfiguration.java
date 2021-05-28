package com.ssnail.myspringboot.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author pengdengwang
 * @since 2020/4/19
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 添加初始化参数
        // 白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // IP 黑名单 （存在共同时，deny 优先于 allow）
        // 如果满足deny，就提示：sorry， you are not permitted to view this page.servletRegistrationBean.addInitParamer("deny", "192.168.1.73")
        // 登录查看信息的账号和密码
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");

        // 是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        // 添加需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gig,*.jpg,*.png,*.ico,/druid/*");

        return filterRegistrationBean;
    }
}
