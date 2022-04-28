package io.github.dathin.onesignup.mapper;

import com.mongodb.client.FindIterable;
import io.github.dathin.onesignup.model.data.DataExplained;
import io.github.dathin.onesignup.model.data.FoundFields;
import io.github.dathin.onesignup.util.CaseFormatter;
import org.bson.Document;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface FoundFieldsMapper {

    default FoundFields from(FindIterable<Map<String, Document>> maps, Set<String> notFoundFields) {
        var foundFields = new FoundFields();
        var list = new ArrayList<DataExplained>();
        maps.forEach(map -> map.forEach((key, document) -> document.forEach((tag, value) -> {
            var data = new DataExplained();
            data.setKey(key);
            data.setTag(tag);
            data.setValue((String) value);
            data.setKeyExplained(CaseFormatter.fromCamelCaseToText(key));
            data.setTagExplained(CaseFormatter.fromCamelCaseToText(tag));
            list.add(data);
            notFoundFields.remove(key + "." + tag);
        })));
        foundFields.setNotFoundFields(notFoundFields);
        foundFields.setList(list);
        return foundFields;
    }

}
