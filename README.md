[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yvasyliev/java-vk-bots-longpoll-api/badge.svg?&kill_cache=1)](https://search.maven.org/artifact/com.github.yvasyliev/java-vk-bots-longpoll-api)
![Build status](https://github.com/yvasyliev/java-vk-bots-long-poll-api/actions/workflows/build-maven-project.yml/badge.svg?branch=master)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/yvasyliev/java-vk-bots-long-poll-api/blob/master/LICENSE)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/yvasyliev/java-vk-bots-long-poll-api.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/yvasyliev/java-vk-bots-long-poll-api/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/yvasyliev/java-vk-bots-long-poll-api.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/yvasyliev/java-vk-bots-long-poll-api/context:java)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat)](http://makeapullrequest.com)
# Java VK Bots Long Poll API
A Java library to create VK bots using Bots Long Poll API.

## Description
An easy-to-use and lightweight Java library that implements [Bots Long Poll API](https://vk.com/dev/bots_longpoll).
This library does not promise to implement all possible public VK APIs. Used API version: `5.118`.

## Note
This library keeps on improving. Feel free to create issues or pull requests.

## Third-party dependencies
This library uses the next third-party dependencies:
* Gson
* SLF4J
* Jsoup

## Requirements
1. Java 8+
2. Maven (or other build tool)

## Quickstart
1. Create VK Community and get `group_id` (from browser URL).
2. Go to `Manage` - `API usage` - `Access tokens` and create `access_token`.
3. Add the library to your project using Maven:
```xml
<dependency>
  <groupId>com.github.yvasyliev</groupId>
  <artifactId>java-vk-bots-longpoll-api</artifactId>
  <version>1.3.0</version>
</dependency>
```
4. Extend `LongPollBot` class and override necessary methods:
```java
public class HelloBot extends LongPollBot {
    @Override
    public void onMessageNew(MessageNewEvent messageNewEvent) {
        try {
            Message message = messageNewEvent.getMessage();
            if (message.hasText()) {
                String response = "Hello! Received your message: " + message.getText();
                new MessagesSend(this)
                        .setPeerId(message.getPeerId())
                        .setMessage(response)
                        .execute();
            }
        } catch (BotsLongPollAPIException | BotsLongPollException e) {
            e.printStackTrace();
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

    public static void main(String[] args) throws BotsLongPollAPIException, BotsLongPollException {
        new BotsLongPoll(new HelloBot()).run();
    }
}
```
## Async execution
Each API method can be executed asynchronously:
```java
new MessagesSend(this)
        .setPeerId(peerId)
        .setMessage("Sending message asynchronously...")
        .executeAsync();
```
`executeAsync()` method returns `CompletableFuture<T>` result.
## Bot capabilities
`LongPollBot` supports next event handlers:
* `onAppPayload(AppPayload appPayload)`
* `onAudioNew(Audio audio)`
* `onBoardPostDelete(BoardPostDeleteEvent boardPostDeleteEvent)`
* `onBoardPostEdit(BoardPostEvent boardPostEvent)`
* `onBoardPostNew(BoardPostEvent boardPostEvent)`
* `onBoardPostRestore(BoardPostEvent boardPostEvent)`
* `onGroupChangePhoto(GroupChangePhotoEvent groupChangePhotoEvent)`
* `onGroupChangeSettings(GroupChangeSettingsEvent groupChangeSettingsEvent)`
* `onGroupJoin(GroupJoinEvent groupJoinEvent)`
* `onGroupLeave(GroupLeaveEvent groupLeaveEvent)`
* `onLikeAdd(LikeEvent likeEvent)`
* `onLikeRemove(LikeEvent likeEvent)`
* `onMarketCommentDelete(MarketCommentDeleteEvent marketCommentDeleteEvent)`
* `onMarketCommentEdit(MarketCommentEvent marketCommentEvent)`
* `onMarketCommentNew(MarketCommentEvent marketCommentEvent)`
* `onMarketCommentRestore(MarketCommentEvent marketCommentEvent)`
* `onMarketOrderEdit(MarketOrder marketOrder)`
* `onMarketOrderNew(MarketOrder marketOrder)`
* `onMessageAllow(MessageAllowEvent messageAllowEvent)`
* `onMessageDeny(MessageDenyEvent messageDenyEvent)`
* `onMessageEdit(Message message)`
* `onMessageEvent(MessageEvent messageEvent)`
* `onMessageNew(MessageNewEvent messageNewEvent)`
* `onMessageReply(Message message)`
* `onMessageTypingState(MessageTypingStateEvent messageTypingStateEvent)`
* `onPhotoCommentDelete(PhotoCommentDeleteEvent photoCommentDeleteEvent)`
* `onPhotoCommentEdit(PhotoCommentEvent photoCommentEvent)`
* `onPhotoCommentNew(PhotoCommentEvent photoCommentEvent)`
* `onPhotoCommentRestore(PhotoCommentEvent photoCommentEvent)`
* `onPhotoNew(Photo photo)`
* `onUserBlock(UserBlockEvent userBlockEvent)`
* `onUserUnblock(UserUnblockEvent userUnblockEvent)`
* `onVideoCommentDelete(VideoCommentDeleteEvent videoCommentDeleteEvent)`
* `onVideoCommentEdit(VideoCommentEvent videoCommentEvent)`
* `onVideoCommentNew(VideoCommentEvent videoCommentEvent)`
* `onVideoCommentRestore(VideoCommentEvent videoCommentEvent)`
* `onVideoNew(Video video)`
* `onVkpayTransaction(VkpayTransaction vkpayTransaction)`
* `onWallPostNew(WallPost wallPost)`
* `onWallReplyDelete(WallReplyDeleteEvent wallReplyDeleteEvent)`
* `onWallReplyEdit(WallReplyEvent wallReplyEvent)`
* `onWallReplyNew(WallReplyEvent wallReplyEvent)`
* `onWallReplyRestore(WallReplyEvent wallReplyEvent)`
* `onWallRepost(WallPost wallPost)`

## Logging
This library uses SLF4J API to log all events. You can add any SLF4J binding to your project to register events the way you want.
