package io.github.dathin.onesignup.config.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class Collections {

    @Bean
    public MongoClient getMongoClient() {
        String uri = "mongodb://one:signup@localhost:27017/";
        return MongoClients.create(uri);
    }

    @Bean
    @Qualifier("data")
    public MongoCollection<Document> getDataCollection(MongoClient mongoClient) {
        return getCollection(mongoClient, "data");
    }

    @Bean
    @Qualifier("users")
    public MongoCollection<Document> getUsersCollection(MongoClient mongoClient) {
        return getCollection(mongoClient, "users");
    }

    private MongoCollection<Document> getCollection(MongoClient mongoClient, String collectionName) {
        CodecRegistry codecRegistry = fromRegistries(getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        return mongoClient.getDatabase("onesignup").withCodecRegistry(codecRegistry).getCollection(collectionName);
    }


}
