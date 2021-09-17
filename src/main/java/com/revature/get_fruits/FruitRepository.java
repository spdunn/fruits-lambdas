package com.revature.get_fruits;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FruitRepository {

    private final DynamoDBMapper dbReader;

    public FruitRepository() {
        dbReader = new DynamoDBMapper((AmazonDynamoDBClientBuilder.defaultClient()));
    }

    public List<Fruit> getAllFruits() {
        return dbReader.scan(Fruit.class, new DynamoDBScanExpression());
    }

    public Optional<Fruit> getFruitByName(String name) {
        Map<String, AttributeValue> queryInputs = new HashMap<>();
        queryInputs.put(":name", new AttributeValue().withS(name));

        DynamoDBScanExpression query = new DynamoDBScanExpression()
                .withFilterExpression("name = :name")
                .withExpressionAttributeValues(queryInputs);

        List<Fruit> queryResult = dbReader.scan(Fruit.class, query);

        return queryResult.stream().findFirst();
    }
}
