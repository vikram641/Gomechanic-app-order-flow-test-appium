package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Updates.set;

public class mongoOps {
    public static void main(String[] args){

    }
//    public static Document Update(String order_id){
//        String uri = "mongodb://localhost:27017";
//        try (MongoClient mongoClient = MongoClients.create(uri)) {
//            MongoDatabase database = mongoClient.getDatabase("prod");
//            MongoCollection<Document> collection = database.getCollection("orders");
//            com.mongodb.client.result.UpdateResult result = collection.updateOne(
//                    eq("order_id", order_id),     // filter
//                    set("status_id", 21)             // update
//            );
//            System.out.println("Matched documents: " + result.getMatchedCount());
//            System.out.println("Modified documents: " + result.getModifiedCount());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
public static String getOtpByPhone(String phone) {
    String otp = null;

    try (MongoClient mongoClient = MongoClients.create("mongodb+srv://ro:readonly@prod.wwz39.mongodb.net/?")) {
        MongoDatabase database = mongoClient.getDatabase("prod");
        MongoCollection<Document> collection = database.getCollection("mongo_sessions");

        Document result = collection.find(eq("mobile", phone))
                .projection(fields(include("otp"), excludeId()))
                .first();

        if (result != null) {
            otp = result.getString("otp");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return otp;
}




    public static Integer findNumber(String mobile) {
        String uri = "mongodb://localhost:27017";
        Document foundDoc = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("prod");
            MongoCollection<Document> collection = database.getCollection("users");

            // Find the first document that matches the filter
            foundDoc = collection.find(eq("mobile", mobile)).first();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(foundDoc ==null){
            return 0;
        }
        else {
            return 1;

        }
        // return the found document (or null if not found)
    }



}
