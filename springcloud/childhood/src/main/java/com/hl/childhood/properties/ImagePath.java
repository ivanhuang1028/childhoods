package com.hl.childhood.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "image-path")
@Data
public class ImagePath {
    private String localPicPath;
}
