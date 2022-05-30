package io.github.dathin.onesignup.client;

import feign.QueryMap;
import feign.RequestLine;
import io.github.dathin.onesignup.model.data.DataExplained;
import io.github.dathin.onesignup.model.data.PutDataRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface DataClient {

	@RequestLine("GET /?{parameters}")
	List<DataExplained> getData(@QueryMap Map<String, Object> parameters);

	default List<DataExplained> getData(String[] data) {
		return getData(Collections.singletonMap("data", data));
	}

	@RequestLine("PUT /")
	void put(PutDataRequest putDataRequest);

}
