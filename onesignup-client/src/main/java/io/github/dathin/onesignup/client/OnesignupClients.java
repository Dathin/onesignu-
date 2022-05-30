package io.github.dathin.onesignup.client;

import io.github.dathin.boot.dathinstarterclient.client.InternalClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DataClientConfig.class)
public class OnesignupClients {

	@Bean
	public DataClient dataClient(InternalClientBuilder internalClientBuilder, DataClientConfig dataClientConfig) {
		return internalClientBuilder.buildClient(DataClient.class, dataClientConfig.getUrl());
	}

}
