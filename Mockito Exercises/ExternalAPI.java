package com.example;

public interface ExternalApi {

    String getData();

    String getUser(String name);

    void sendNotification(String message);

}