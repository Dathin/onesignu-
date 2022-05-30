package io.github.dathin.onesignup.service;

import io.github.dathin.onesignup.dao.data.SearchData;
import io.github.dathin.onesignup.dao.data.UpsertData;
import io.github.dathin.onesignup.mapper.FoundFieldsMapper;
import io.github.dathin.onesignup.mapper.PatchDataMapper;
import io.github.dathin.onesignup.mapper.SearchFieldsMapper;
import io.github.dathin.onesignup.model.data.DataExplained;
import io.github.dathin.onesignup.model.data.PatchDataRequest;
import io.github.dathin.onesignup.model.exception.FieldNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OneSignupService {

	private final UpsertData upsertData;

	private final SearchData searchData;

	private final PatchDataMapper patchDataMapper;

	private final SearchFieldsMapper searchFieldsMapper;

	private final FoundFieldsMapper foundFieldsMapper;

	public OneSignupService(UpsertData upsertData, SearchData searchData, PatchDataMapper patchDataMapper,
			SearchFieldsMapper searchFieldsMapper, FoundFieldsMapper foundFieldsMapper) {
		this.upsertData = upsertData;
		this.searchData = searchData;
		this.patchDataMapper = patchDataMapper;
		this.searchFieldsMapper = searchFieldsMapper;
		this.foundFieldsMapper = foundFieldsMapper;
	}

	public void patchData(PatchDataRequest patchDataRequest) {
		var data = patchDataMapper.from(patchDataRequest.getData());
		upsertData.query(data);
	}

	public List<DataExplained> getData(String[] fields) {

		var searchFields = searchFieldsMapper.from(fields);

		var iterableMap = searchData.query(new ArrayList<>(searchFields));

		var foundFields = foundFieldsMapper.from(iterableMap, searchFields);

		if (!foundFields.getNotFoundFields().isEmpty()) {
			throw new FieldNotFoundException(searchFields);
		}

		return foundFields.getList();
	}

}
