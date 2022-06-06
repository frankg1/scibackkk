package com.fdu.sciback.tool;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebCfg implements WebMvcConfigurer {

    private final String localIp = "localhost";
    private final String remoteIp = "10.176.34.127";

    private final String useIp = this.remoteIp;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://" + this.useIp + ":8008")
                .allowedMethods("POST", "PUT", "OPTIONS", "DELETE", "GET")
                .allowedHeaders("*")
                .maxAge(3600);
    }

}
