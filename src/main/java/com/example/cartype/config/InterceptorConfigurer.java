package com.example.cartype.config;

import com.example.cartype.interceptor.TokenInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(InterceptorConfigurer.class);
//    @Value("${spring.profiles.active}")
    private String env;//当前激活的配置文件
    private TokenInterceptor tokenInterceptor;




    public InterceptorConfigurer(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePaths=new ArrayList<>();
        //需要排除拦截的url
        excludePaths.add("/login");
        excludePaths.add("/brand");
        excludePaths.add("/brandSeries");
        excludePaths.add("/seriesCar");
        excludePaths.add("/img/**");

        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);
        WebMvcConfigurer.super.addInterceptors(registry);

    }

    /**
     * 解决跨域问题
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*addMapping：允许所以映射
      allowedHeaders：允许所以请求头
      allowedMethods:允许所以请求方式，get、post、put、delete
      allowedOrigins：允许所以域名访问
      allowCredentials：允许携带cookie参数*/
        registry.addMapping("/**").allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,//保留空的字段
//                SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
//                SerializerFeature.WriteNullNumberAsZero);//Number null -> 0
//        converter.setFastJsonConfig(config);
//        converter.setDefaultCharset(Charset.forName("UTF-8"));
//        converters.add(converter);
        converters.add(new ByteArrayHttpMessageConverter());

    }
}
