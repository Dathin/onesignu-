package io.github.dathin.onesignup.mapper;

import io.github.dathin.onesignup.model.data.Data;
import io.github.dathin.onesignup.model.data.PatchData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatchDataMapper {

	@Mapping(source = "data", target = "keyTag", qualifiedByName = "keyTagFromKeyAndTag")
	PatchData from(Data data);

	List<PatchData> from(List<Data> patchDataRequests);

	@Named("keyTagFromKeyAndTag")
	default String keyTagFromKeyAndTag(Data data) {
		String tag = data.getTag() == null ? "default" : data.getTag();
		return data.getKey() + "." + tag;
	}

}
