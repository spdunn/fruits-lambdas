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

    public void deleteFruitByName(String name) {

    }
}
