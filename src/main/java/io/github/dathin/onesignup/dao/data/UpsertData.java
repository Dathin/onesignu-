package io.github.dathin.onesignup.dao.data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import io.github.dathin.boot.dathinstarterauthorizer.service.AuthenticationService;
import io.github.dathin.onesignup.dao.Query;
import io.github.dathin.onesignup.model.data.PatchData;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UpsertData implements Query<List<PatchData>, Void> {

    private final MongoCollection<Document> mongoCollection;

    private final AuthenticationService authenticationService;


    public UpsertData(@Qualifier("data") MongoCollection<Document> mongoCollection, AuthenticationService authenticationService) {
        this.mongoCollection = mongoCollection;
        this.authenticationService = authenticationService;
    }

    @Override
    public Void query(List<PatchData> patchData) {
        var updateList = patchData.stream().map(data -> Updates.set(data.getKeyTag(), data.getValue()))
                .collect(Collectors.toList());
        var filter = Filters.eq("userId", authenticationService.getAuthenticatedUserOrThrow().getId());
        var update = Updates.combine(updateList);
        var updateOptions = new UpdateOptions().upsert(true);
        mongoCollection.updateOne(filter, update, updateOptions);
        return null;
    }
}
