package io.github.dathin.onesignup;

import io.github.dathin.dathinsession.client.UserClient;
import io.github.dathin.dathinsession.model.user.UserRequest;
import io.github.dathin.onesignup.client.DataClient;
import io.github.dathin.onesignup.model.data.Data;
import io.github.dathin.onesignup.model.data.DataExplained;
import io.github.dathin.onesignup.model.data.PutDataRequest;
import io.github.dathin.onesignup.utils.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class DataTest {

	DataClient dataClient;

	static UserClient userClient;

	@BeforeAll
	static void beforeAll() {
		userClient = Client.getUserClient();
	}

	@BeforeEach
	void setUp() {
		var userRequest = new UserRequest();
		userRequest.setEmail(UUID.randomUUID() + "@dathinlabs.com");
		userRequest.setPassword(UUID.randomUUID().toString());
		userClient.createUser(userRequest);
		var login = userClient.login(userRequest);
		var authorization = login.getToken();
		dataClient = Client.getDataClient(authorization);
	}

	@Test
	void newDefaultProperty() {
		var putDataRequest = new PutDataRequest();
		var data = new Data();
		var key = "cpf";
		var tag = "default";
		var value = "any";
		data.setKey(key);
		data.setTag(tag);
		data.setValue(value);
		putDataRequest.setData(Collections.singletonList(data));

		dataClient.put(putDataRequest);
		var dataExplainedList = dataClient.getData(new String[] { key + "." + tag });

		var expectedDataExplained = new DataExplained();
		expectedDataExplained.setKeyExplained(StringUtils.capitalize(key));
		expectedDataExplained.setKey(key);
		expectedDataExplained.setTagExplained(StringUtils.capitalize(tag));
		expectedDataExplained.setTag(tag);
		expectedDataExplained.setValue(value);

		Assertions.assertTrue(new ReflectionEquals(expectedDataExplained).matches(dataExplainedList.get(0)));
		Assertions.assertEquals(1, dataExplainedList.size());
	}

	@Test
	void newDefaultPropertyWithoutTag() {
		var putDataRequest = new PutDataRequest();
		var data = new Data();
		var key = "cpf";
		var tag = "default";
		var value = "any";
		data.setKey(key);
		data.setValue(value);
		putDataRequest.setData(Collections.singletonList(data));

		dataClient.put(putDataRequest);
		var dataExplainedList = dataClient.getData(new String[] { key + "." + tag });

		var expectedDataExplained = new DataExplained();
		expectedDataExplained.setKeyExplained(StringUtils.capitalize(key));
		expectedDataExplained.setKey(key);
		expectedDataExplained.setTagExplained(StringUtils.capitalize(tag));
		expectedDataExplained.setTag(tag);
		expectedDataExplained.setValue(value);

		Assertions.assertTrue(new ReflectionEquals(expectedDataExplained).matches(dataExplainedList.get(0)));
		Assertions.assertEquals(1, dataExplainedList.size());
	}

	@Test
	void newProperty() {
		var putDataRequest = new PutDataRequest();
		var data = new Data();
		var key = "cpf";
		var tag = "tag";
		var value = "any";
		data.setKey(key);
		data.setTag(tag);
		data.setValue(value);
		putDataRequest.setData(Collections.singletonList(data));

		dataClient.put(putDataRequest);
		var dataExplainedList = dataClient.getData(new String[] { key + "." + tag });

		var expectedDataExplained = new DataExplained();
		expectedDataExplained.setKeyExplained(StringUtils.capitalize(key));
		expectedDataExplained.setKey(key);
		expectedDataExplained.setTagExplained(StringUtils.capitalize(tag));
		expectedDataExplained.setTag(tag);
		expectedDataExplained.setValue(value);

		Assertions.assertEquals(expectedDataExplained, dataExplainedList.get(0));
		Assertions.assertEquals(1, dataExplainedList.size());
	}

	@Test
	void replaceProperty() {
		var putDataRequest = new PutDataRequest();
		var data = new Data();
		var key = "cpf";
		var tag = "tag";
		var value = "any";
		var replaceValue = "anyV2";
		data.setKey(key);
		data.setTag(tag);
		data.setValue(value);
		putDataRequest.setData(Collections.singletonList(data));

		dataClient.put(putDataRequest);
		data.setValue(replaceValue);
		dataClient.put(putDataRequest);
		var dataExplainedList = dataClient.getData(new String[] { key + "." + tag });

		var expectedDataExplained = new DataExplained();
		expectedDataExplained.setKeyExplained(StringUtils.capitalize(key));
		expectedDataExplained.setKey(key);
		expectedDataExplained.setTagExplained(StringUtils.capitalize(tag));
		expectedDataExplained.setTag(tag);
		expectedDataExplained.setValue(replaceValue);

		Assertions.assertEquals(expectedDataExplained, dataExplainedList.get(0));
		Assertions.assertEquals(1, dataExplainedList.size());
	}

	// private boolean matcher(DataExplained expected, DataExplained actual) {
	// if (!Objects.equals(expected.getKeyExplained(), actual.getKeyExplained())) return
	// false;
	// if (!Objects.equals(expected.getTagExplained(), actual.getTagExplained())) return
	// false;
	// if (!Objects.equals(expected.getKey(), actual.getKey())) return false;
	// if (!Objects.equals(expected.getTag(), actual.getTag())) return false;
	// if (!Objects.equals(expected.getValue(), actual.getValue())) return false;
	// return true;
	// }

}
