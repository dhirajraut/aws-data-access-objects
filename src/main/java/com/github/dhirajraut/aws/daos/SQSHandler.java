package com.github.dhirajraut.aws.daos;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class SQSHandler implements RequestHandler<SQSEvent, List<String>> {

    @Override
    public List<String> handleRequest(SQSEvent input, Context context) {
        
        List<String> returnObject = new ArrayList<String>();

        final LambdaLogger logger = context.getLogger();
        logger.log("Input: SNSEvent = " + input);

        if (input != null) {
            List<SQSMessage> records = input.getRecords();
            logger.log("Received records = " + records);

            if (records != null) {
                logger.log("Received message count = " + records.size());

                for (SQSMessage record : records) {
                    logger.log("SQSMessage = " + record);
                    if (record != null && record.getBody() != null) {
                        returnObject.add(record.getBody());
                    }
                }
            }
        }
        return returnObject;
    }
}
