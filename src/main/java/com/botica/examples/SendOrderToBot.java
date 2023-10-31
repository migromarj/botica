package com.botica.examples;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.botica.RabbitMQManager;
import com.botica.utils.Utils;

public class SendOrderToBot {

    private static final Logger logger = LogManager.getLogger(SendOrderToBot.class);
    private static final String KEY_TO_PUBLISH = "testCaseGenerator.gen_4";
    private static final String MESSAGE = "{\"order\": \"generateTestCases\"}";

    public static void main(String[] argv) throws Exception {

        RabbitMQManager messageSender = new RabbitMQManager();

        try{
            List<Boolean> queueOptions = Arrays.asList(true, false, true);
            messageSender.connect("", null, queueOptions);
            messageSender.sendMessageToExchange(KEY_TO_PUBLISH, MESSAGE);
            logger.info("Message sent to RabbitMQ: {}", MESSAGE);
            messageSender.close();
        } catch (Exception e) {
            Utils.handleException(logger, "Error sending message to RabbitMQ", e);
        }
    }
}