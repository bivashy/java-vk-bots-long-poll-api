[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yvasyliev/java-vk-bots-longpoll-api/badge.svg)](https://search.maven.org/artifact/com.github.yvasyliev/java-vk-bots-longpoll-api)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/yvasyliev/java-vk-bots-long-poll-api/blob/master/LICENSE)

# Java VK Bots Long Poll API
A Java library to create VK bots using Bots Long Poll API.

## Description
An easy to use and lightweight Java library that implements [Bots Long Poll API](https://vk.com/dev/bots_longpoll).
This library does not promise to implement all possible public VK APIs.

## Note
This library is in beta release. Feel free to create issues or pull requests.

## Third-party dependecies
This library uses the next third-party dependecies:
* Gson
* SLF4J
* Jsoup

## Quickstart
1. Add the library to your project using Maven:
```xml
<dependency>
  <groupId>com.github.yvasyliev</groupId>
  <artifactId>java-vk-bots-longpoll-api</artifactId>
  <version>1.0.27-beta</version>
</dependency>
```
2. Create a class that extends `LongPollBot` and overrides necessary methods:
```java
public class MyBot extends LongPollBot {
    @Override
    public void onMessageNew(MessageEvent messageEvent) {
        Message message = messageEvent.getMessage();
        if (message.hasText()) {
            String format = String.format("Hello! Received your message: %s", message.getText());
            try {
                new MessagesSend(this)
                        .setPeerId(message.getPeerId())
                        .setMessage(format)
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
