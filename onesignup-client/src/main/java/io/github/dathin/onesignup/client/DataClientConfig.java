package io.github.dathin.onesignup.client;

import io.github.dathin.boot.dathinstarterclient.client.BaseClientConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "client.data")
public class DataClientConfig extends BaseClientConfig {

}
