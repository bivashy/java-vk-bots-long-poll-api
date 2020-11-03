[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yvasyliev/java-vk-bots-longpoll-api/badge.svg?&kill_cache=1)](https://search.maven.org/artifact/com.github.yvasyliev/java-vk-bots-longpoll-api)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/yvasyliev/java-vk-bots-long-poll-api/blob/master/LICENSE)

# Java VK Bots Long Poll API
A Java library to create VK bots using Bots Long Poll API.

## Description
An easy to use and lightweight Java library that implements [Bots Long Poll API](https://vk.com/dev/bots_longpoll).
This library does not promise to implement all possible public VK APIs. Uses API version: 5.110.

## Note
This library is in beta release. Feel free to create issues or pull requests.

## Third-party dependencies
This library uses the next third-party dependecies:
* Gson
* SLF4J
* Jsoup

## Requirements
1. Java 8+
2. Maven (or other build tool)
3. VK community to retrieve `group_id` and `access_token`. The details can be found [here](https://vk.com/dev/access_token).

## Quickstart
1. Add the library to your project using Maven:
```xml
<dependency>
  <groupId>com.github.yvasyliev</groupId>
  <artifactId>java-vk-bots-longpoll-api</artifactId>
  <version>1.0.28-beta</version>
</dependency>
```
2. Create a class that extends `LongPollBot` and overrides necessary methods:
```java
public class MyBot extends LongPollBot {
    @Override
    public void onMessageNew(MessageEvent messageNewEvent) {
        Message message = messageNewEvent.getMessage();
        if (message.hasText()) {
            String response = "Hello! Received your message: " + message.getText();
            try {
                new MessagesSend(this)
                        .setPeerId(message.getPeerId())
                        .setMessage(response)
                        .execute();
            } catch (ApiHttpException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getAccessToken() {
        return "your_access_token";
    }

    @Override
    public int getGroupId() {
        return 999999999;
    }
}
```
3. In `main` method create instance of `BotsLongPoll` class, pass instance of `LongPollBot` class as constructor parameter and call `run()` method:
```java
public static void main(String[] args) {
    new BotsLongPoll(new MyBot()).run();
}
```

## Logging
This library uses SLF4J API to log all events. You can add any SLF4J binding to your project to register events the way you want.
