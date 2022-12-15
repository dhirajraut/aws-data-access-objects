package com.github.dhirajraut.aws.publishers;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class SNSPublisher {

    static AmazonSNS client = AmazonSNSClientBuilder.defaultClient();
    
    public static PublishResult publish (String topicArn, String message) {

        PublishRequest request = new PublishRequest(topicArn, message);
        return client.publish(request);
    }
}
