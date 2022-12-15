package com.github.dhirajraut.aws.daos;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.lambda.runtime.events.SNSEvent.SNSRecord;

public class SNSHandler implements RequestHandler<SNSEvent, List<String>> {

    @Override
    public List<String> handleRequest(SNSEvent input, Context context) {
        
        List<String> returnObject = new ArrayList<String>();

        final LambdaLogger logger = context.getLogger();
        logger.log("Input: SNSEvent = " + input);

        if (input != null) {
            List<SNSRecord> records = input.getRecords();
            logger.log("Received records = " + records);

            if (records != null) {
                logger.log("Received message count = " + records.size());

                for (SNSRecord record : records) {
                    logger.log("SNSRecord = " + record);
                    if (record != null && record.getSNS() != null) {
                        returnObject.add(record.getSNS().getMessage());
                    }
                }
            }
        }
        return returnObject;
    }
}
