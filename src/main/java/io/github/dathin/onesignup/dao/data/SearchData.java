package io.github.dathin.onesignup.dao.data;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import io.github.dathin.onesignup.dao.Query;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class SearchData implements Query<ArrayList<String>, FindIterable<Map<String, Document>>> {

    private final MongoCollection<Document> mongoCollection;


    public SearchData(@Qualifier("data") MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public FindIterable<Map<String, Document>> query(ArrayList<String> searchFields) {
        var filter = Filters.eq("userId", "625e15dd3f99da226dd54ef3");
        var mapClass = (Class<Map<String, Document>>) (Class<?>) Map.class;
        Bson projectionFields = Projections.fields(Projections.include(searchFields), Projections.excludeId());
        return mongoCollection.find(filter, mapClass).projection(projectionFields);
    }

}
