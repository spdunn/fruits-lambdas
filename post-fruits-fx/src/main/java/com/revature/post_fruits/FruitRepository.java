package com.revature.post_fruits;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FruitRepository {

    private final DynamoDBMapper dbReader;

    public FruitRepository() {
        dbReader = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());
    }

    public void postFruit(Fruit newFruit) {
//        Map<String, AttributeValue> queryInputs = new HashMap<>();
//        queryInputs.put(":name", new AttributeValue().withS(newFruit.getName()));
//        queryInputs.put(":name", new AttributeValue().withS(newFruit.getName()));

//        DynamoDBSaveExpression query = new DynamoDBSaveExpression()
//                .withExpectedEntry("name", new ExpectedAttributeValue().withValue(new AttributeValue().withS(newFruit.getName())))
//                .withExpectedEntry("color", new ExpectedAttributeValue().withValue(new AttributeValue().withS(newFruit.getColor())))
//                .withExpectedEntry("weight", new ExpectedAttributeValue().withValue(new AttributeValue()))
//                .withExpectedEntry("cost", new ExpectedAttributeValue().withValue(new AttributeValue()))
//                .withExpectedEntry("juiceLevel", new ExpectedAttributeValue().withValue(new AttributeValue()));
        dbReader.save(newFruit);
    }

}
