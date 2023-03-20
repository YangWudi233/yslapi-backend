package com.yzh.yslapiclientsdk;

import com.yzh.yslapiclientsdk.client.YslApiClient;
import com.yzh.yslapiclientsdk.modal.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties("yslapi.client")
@ComponentScan
public class YslApiClientConfig {
    private String accessKey;
    private String secretKey;
    @Bean
    public YslApiClient yslApiClient(){
        return new YslApiClient(accessKey,secretKey);
    }

}
