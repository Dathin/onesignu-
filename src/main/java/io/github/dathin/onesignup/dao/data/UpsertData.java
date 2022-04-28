package io.github.dathin.onesignup.dao.data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import io.github.dathin.onesignup.dao.Query;
import io.github.dathin.onesignup.model.data.PatchData;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpsertData implements Query<List<PatchData>, Void> {

    private final MongoCollection<Document> mongoCollection;


    public UpsertData(@Qualifier("data") MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }


    public Void get(String userId, List<PatchData> patchData) {
        var updateList = patchData.stream().map(data -> Updates.set(data.getKeyTag(), data.getValue()))
                .collect(Collectors.toList());
        var filter = Filters.eq("userId", userId);
        var update = Updates.combine(updateList);
        var updateOptions = new UpdateOptions();
        mongoCollection.updateOne(filter, update, updateOptions);
        return null;
    }

    @Override
    public Void query(List<PatchData> patchData) {
        get("625e15dd3f99da226dd54ef3", patchData);
        return null;
    }
}
