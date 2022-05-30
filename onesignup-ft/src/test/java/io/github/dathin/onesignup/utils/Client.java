package io.github.dathin.onesignup.utils;

import io.github.dathin.boot.dathinstarterclient.client.InternalClientBuilder;
import io.github.dathin.boot.dathinstarterclient.client.InternalClientBuilderConfig;
import io.github.dathin.boot.dathinstarterclient.client.InternalClientBuilderFactory;
import io.github.dathin.dathinsession.client.DathinSessionClients;
import io.github.dathin.dathinsession.client.UserClient;
import io.github.dathin.dathinsession.client.UserClientConfig;
import io.github.dathin.onesignup.client.DataClient;
import io.github.dathin.onesignup.client.DataClientConfig;
import io.github.dathin.onesignup.client.OnesignupClients;

public class Client {

	public static DataClient getDataClient() {
		return getDataClient(null);
	}

	public static DataClient getDataClient(String authorization) {
		var internalClientBuilderFactory = new InternalClientBuilderFactory();
		var onesignupClients = new OnesignupClients();
		var internalClientBuilderConfig = new InternalClientBuilderConfig();
		internalClientBuilderConfig.setHeaderPropagation(false);
		InternalClientBuilder internalClientBuilder = internalClientBuilderFactory
				.getNewInstance(internalClientBuilderConfig);
		internalClientBuilder.setAuthorization(authorization);
		var dataClientConfig = new DataClientConfig();
		dataClientConfig.setUrl("http://localhost:8080");
		return onesignupClients.dataClient(internalClientBuilder, dataClientConfig);
	}

	public static UserClient getUserClient() {
		return getUserClient(null);
	}

	public static UserClient getUserClient(String authorization) {
		var internalClientBuilderFactory = new InternalClientBuilderFactory();
		var dathinSessionClients = new DathinSessionClients();
		var internalClientBuilderConfig = new InternalClientBuilderConfig();
		internalClientBuilderConfig.setHeaderPropagation(false);
		InternalClientBuilder internalClientBuilder = internalClientBuilderFactory
				.getNewInstance(internalClientBuilderConfig);
		internalClientBuilder.setAuthorization(authorization);
		var userClientConfig = new UserClientConfig();
		userClientConfig.setUrl("http://localhost:9000");
		return dathinSessionClients.userClient(internalClientBuilder, userClientConfig);
	}

}
