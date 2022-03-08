[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yvasyliev/java-vk-bots-longpoll-api/badge.svg?&kill_cache=1)](https://search.maven.org/artifact/com.github.yvasyliev/java-vk-bots-longpoll-api)
![Build status](https://github.com/yvasyliev/java-vk-bots-long-poll-api/actions/workflows/build-maven-project.yml/badge.svg?branch=master)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/yvasyliev/java-vk-bots-long-poll-api/blob/master/LICENSE)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/yvasyliev/java-vk-bots-long-poll-api.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/yvasyliev/java-vk-bots-long-poll-api/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/yvasyliev/java-vk-bots-long-poll-api.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/yvasyliev/java-vk-bots-long-poll-api/context:java)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat)](http://makeapullrequest.com)
[![javadoc](https://javadoc.io/badge2/com.github.yvasyliev/java-vk-bots-longpoll-api/javadoc.svg)](https://javadoc.io/doc/com.github.yvasyliev/java-vk-bots-longpoll-api)
# Java VK Bots Long Poll API
A Java library to create VK bots using Bots Long Poll API.

## Description
An easy-to-use and lightweight Java library that implements [Bots Long Poll API](https://vk.com/dev/bots_longpoll). Uses API version: `5.131`.

## Note
This library keeps on improving. Feel free to create issues or pull requests.

## Third-party dependencies
This library uses the next third-party dependencies:
* Gson
* SLF4J

## Requirements
1. Java 8+
2. Maven (or other build tool)

## Quickstart
1. Create VK Community.
2. Go to `Manage` - `API usage` - `Access tokens` and create `access_token`.
3. Add the library to your Maven project:
```xml
<dependency>
  <groupId>com.github.yvasyliev</groupId>
  <artifactId>java-vk-bots-longpoll-api</artifactId>
  <version>3.2.8</version>
</dependency>
```
4. Extend `LongPollBot` class and override necessary methods:
```java
public class HelloBot extends LongPollBot {
    @Override
    public void onMessageNew(MessageNew messageNew) {
        try {
            Message message = messageNew.getMessage();
            if (message.hasText()) {
                String response = "Hello! Received your message: " + message.getText();
                vk.messages.send()
                        .setPeerId(message.getPeerId())
                        .setMessage(response)
                        .execute();
            }
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAccessToken() {
        return "your_access_token";
    }

    public static void main(String[] args) throws VkApiException {
        new HelloBot().startPolling();
    }
}
```
## How to send photos or documents?
Easy:
```java
@Override
public void onMessageNew(MessageNew messageNew) {
    try {
        Message message = messageNew.getMessage();
        vk.messages.send()
            .setPeerId(message.getPeerId())
            .setMessage("Sending some files to you...")
            .addPhoto(new File("your_photo.png")) // to send photo as photo
            .addDoc(new File("your_photo.png")) // to send photo as document
            .execute();
    } catch (VkApiException e) {
        e.printStackTrace();
    }
}
```
## More Examples
Find more examples of bot usage [here](https://github.com/yvasyliev/java-vk-bots-long-poll-api-examples)
## Async execution
Each API method can be executed asynchronously:
```java
CompletableFuture<Send.Response> future = vk.messages.send()
        .setPeerId(peerId)
        .setMessage("Sending message asynchronously...")
        .executeAsync();
```
## Bot capabilities
`LongPollBot` supports the next event handlers:
* `onAppPayload(AppPayload appPayload)`
* `onAudioNew(Audio audio)`
* `onBoardPostDelete(BoardPostDelete boardPostDelete)`
* `onBoardPostEdit(BoardPost boardPost)`
* `onBoardPostNew(BoardPost boardPost)`
* `onBoardPostRestore(BoardPost boardPost)`
* `onGroupChangePhoto(GroupChangePhoto groupChangePhoto)`
* `onGroupChangeSettings(GroupChangeSettings groupChangeSettings)`
* `onGroupJoin(GroupJoin groupJoin)`
* `onGroupLeave(GroupLeave groupLeave)`
* `onLikeAdd(Like like)`
* `onLikeRemove(Like like)`
* `onMarketCommentDelete(MarketCommentDelete marketCommentDelete)`
* `onMarketCommentEdit(MarketComment marketComment)`
* `onMarketCommentNew(MarketComment marketComment)`
* `onMarketCommentRestore(MarketComment marketComment)`
* `onMarketOrderEdit(MarketOrder marketOrder)`
* `onMarketOrderNew(MarketOrder marketOrder)`
* `onMessageAllow(MessageAllow messageAllow)`
* `onMessageDeny(MessageDeny messageDeny)`
* `onMessageEdit(Message message)`
* `onMessageEvent(MessageEvent messageEvent)`
* `onMessageNew(MessageNew messageNew)`
* `onMessageReply(Message message)`
* `onMessageTypingState(MessageTypingState messageTypingState)`
* `onPhotoCommentDelete(PhotoCommentDelete photoCommentDelete)`
* `onPhotoCommentEdit(PhotoComment photoComment)`
* `onPhotoCommentNew(PhotoComment photoComment)`
* `onPhotoCommentRestore(PhotoComment photoComment)`
* `onPhotoNew(Photo photo)`
* `onUserBlock(UserBlock userBlock)`
* `onUserUnblock(UserUnblock userUnblock)`
* `onVideoCommentDelete(VideoCommentDelete videoCommentDelete)`
* `onVideoCommentEdit(VideoComment videoComment)`
* `onVideoCommentNew(VideoComment videoComment)`
* `onVideoCommentRestore(VideoComment videoComment)`
* `onVideoNew(Video video)`
* `onVkpayTransaction(VkpayTransaction vkpayTransaction)`
* `onWallPostNew(WallPost wallPost)`
* `onWallReplyDelete(WallReplyDelete wallReplyDelete)`
* `onWallReplyEdit(WallReply wallReply)`
* `onWallReplyNew(WallReply wallReply)`
* `onWallReplyRestore(WallReply wallReply)`
* `onWallRepost(WallPost wallPost)`

## Logging
This library uses SLF4J API to log all events. You can add any SLF4J binding to your project to register events the way you want.

It is highly recommended enabling `DEBUG` log level to see sent and received data.
