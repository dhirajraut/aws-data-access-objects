package com.github.dhirajraut.aws;

import com.github.dhirajraut.aws.publishers.SNSPublisher;

public class Runner {
    public static void main(String args[]) {
        SNSPublisher.publish(null, null);
    }
}
