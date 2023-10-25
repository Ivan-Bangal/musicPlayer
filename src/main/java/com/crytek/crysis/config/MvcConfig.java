package com.crytek.crysis.config;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static java.nio.file.FileSystems.getDefault;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class MvcConfig implements WebMvcConfigurer{

    private final String HOME_DIRECTORY;

    /**
     * @param hOME_DIRECTORY
     */
    public MvcConfig(@Value("${upload.path}") String hOME_DIRECTORY) {
        
        HOME_DIRECTORY = hOME_DIRECTORY;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("uploads", registry);
    }
   
    public void exposeDirectory(String uploadDirectory,ResourceHandlerRegistry registry) {
      
        Path root =getDefault().getPath(HOME_DIRECTORY, "uploads");

        
        String path = root.toFile().getAbsolutePath();
        
        if (path.startsWith("../"))
            path = path.replace("../", "");


        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            registry.addResourceHandler("/"+uploadDirectory+"/**").addResourceLocations("file:///"+path.replace("\\", "/"));
        }else{
            registry.addResourceHandler("/"+uploadDirectory+"/**").addResourceLocations("file:/"+path.replace("\\", "/"));
        }


    }

}
