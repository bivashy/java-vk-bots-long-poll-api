[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yvasyliev/java-vk-bots-longpoll-api/badge.svg?kill_cache=1)](https://search.maven.org/artifact/com.github.yvasyliev/java-vk-bots-longpoll-api)
[![javadoc](https://javadoc.io/badge2/com.github.yvasyliev/java-vk-bots-longpoll-api/javadoc.svg?kill_cache=1)](https://javadoc.io/doc/com.github.yvasyliev/java-vk-bots-longpoll-api)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/yvasyliev/java-vk-bots-long-poll-api/blob/master/LICENSE)
![Build status](https://github.com/yvasyliev/java-vk-bots-long-poll-api/actions/workflows/build-maven-project.yml/badge.svg?branch=master)
![CodeQL](https://github.com/yvasyliev/java-vk-bots-long-poll-api/workflows/CodeQL/badge.svg)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=bugs)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=yvasyliev_java-vk-bots-long-poll-api&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=yvasyliev_java-vk-bots-long-poll-api)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat)](http://makeapullrequest.com)

# Java VK Bots Long Poll API

A Java library to create VK bots using Bots Long Poll API.

## Description

An easy-to-use and lightweight Java library that implements [Bots Long Poll API](https://vk.com/dev/bots_longpoll). Uses
API version: `5.131`.

## Note

This library keeps on improving. Feel free to create issues or pull requests.

## Third-party dependencies

This library uses the next third-party dependencies:

* `Gson`
* `SLF4J`
* `OkHttp`

## Requirements

1. `Java 8` or higher
2. `Maven` or other build tool

## Quickstart

1. Create VK Community.
2. Go to `Manage` - `API usage` - `Access tokens` and create `access_token`.
3. Add the library to your `Maven` project:
   ```xml
   <dependency>
       <groupId>com.github.yvasyliev</groupId>
       <artifactId>java-vk-bots-longpoll-api</artifactId>
       <version>4.1.0</version>
   </dependency>
   ```
4. Extend `LongPollBot` class and override necessary methods:
   ```java
   import api.longpoll.bots.LongPollBot;
   import api.longpoll.bots.exceptions.VkApiException;
   import api.longpoll.bots.model.events.messages.MessageNew;
   import api.longpoll.bots.model.objects.basic.Message;
   
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
import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import java.io.File;

public class HelloBot extends LongPollBot {
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
}
```

## More Examples

Find more examples of bot usage [here](https://github.com/yvasyliev/java-vk-bots-long-poll-api-examples).

## Async execution

Each API method can be executed asynchronously:

```java
import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.messages.Send;import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import java.io.File;import java.util.concurrent.CompletableFuture;

public class HelloBot extends LongPollBot {
   @Override
   public void onMessageNew(MessageNew messageNew) {
      CompletableFuture<Send.ResponseBody> future = vk.messages.send()
               .setPeerId(message.getPeerId())
               .setMessage("Sending message asynchronously...")
               .executeAsync();
   }
}
```

## Bot events

`LongPollBot` can handle the next events:

|                 VK event | Handler method                                                               |
|-------------------------:|:-----------------------------------------------------------------------------|
|            `app_payload` | `public void onAppPayload(AppPayload appPayload)`                            |
|              `audio_new` | `public void onAudioNew(Audio audio)`                                        |
|      `board_post_delete` | `public void onBoardPostDelete(BoardPostDelete boardPostDelete)`             |
|        `board_post_edit` | `public void onBoardPostEdit(BoardPost boardPost)`                           |
|         `board_post_new` | `public void onBoardPostNew(BoardPost boardPost)`                            |
|     `board_post_restore` | `public void onBoardPostRestore(BoardPost boardPost)`                        |
|     `group_change_photo` | `public void onGroupChangePhoto(GroupChangePhoto groupChangePhoto)`          |
|  `group_change_settings` | `public void onGroupChangeSettings(GroupChangeSettings groupChangeSettings)` |
|             `group_join` | `public void onGroupJoin(GroupJoin groupJoin)`                               |
|            `group_leave` | `public void onGroupLeave(GroupLeave groupLeave)`                            |
|               `like_add` | `public void onLikeAdd(Like like)`                                           |
|            `like_remove` | `public void onLikeRemove(Like like)`                                        |
|  `market_comment_delete` | `public void onMarketCommentDelete(MarketCommentDelete marketCommentDelete)` |
|    `market_comment_edit` | `public void onMarketCommentEdit(MarketComment marketComment)`               |
|     `market_comment_new` | `public void onMarketCommentNew(MarketComment marketComment)`                |
| `market_comment_restore` | `public void onMarketCommentRestore(MarketComment marketComment)`            |
|      `market_order_edit` | `public void onMarketOrderEdit(MarketOrder marketOrder)`                     |
|       `market_order_new` | `public void onMarketOrderNew(MarketOrder marketOrder)`                      |
|          `message_allow` | `public void onMessageAllow(MessageAllow messageAllow)`                      |
|           `message_deny` | `public void onMessageDeny(MessageDeny messageDeny)`                         |
|           `message_edit` | `public void onMessageEdit(Message message)`                                 |
|          `message_event` | `public void onMessageEvent(MessageEvent messageEvent)`                      |
|            `message_new` | `public void onMessageNew(MessageNew messageNew)`                            |
|          `message_reply` | `public void onMessageReply(Message message)`                                |
|   `message_typing_state` | `public void onMessageTypingState(MessageTypingState messageTypingState)`    |
|   `photo_comment_delete` | `public void onPhotoCommentDelete(PhotoCommentDelete photoCommentDelete)`    |
|     `photo_comment_edit` | `public void onPhotoCommentEdit(PhotoComment photoComment)`                  |
|      `photo_comment_new` | `public void onPhotoCommentNew(PhotoComment photoComment)`                   |
|  `photo_comment_restore` | `public void onPhotoCommentRestore(PhotoComment photoComment)`               |
|      `photo_comment_new` | `public void onPhotoNew(Photo photo)`                                        |
|          `poll_vote_new` | `public void onPollVoteNew(PollVoteNew pollVoteNew)`                         |
|             `user_block` | `public void onUserBlock(UserBlock userBlock)`                               |
|           `user_unblock` | `public void onUserUnblock(UserUnblock userUnblock)`                         |
|   `video_comment_delete` | `public void onVideoCommentDelete(VideoCommentDelete videoCommentDelete)`    |
|     `video_comment_edit` | `public void onVideoCommentEdit(VideoComment videoComment)`                  |
|      `video_comment_new` | `public void onVideoCommentNew(VideoComment videoComment)`                   |
|  `video_comment_restore` | `public void onVideoCommentRestore(VideoComment videoComment)`               |
|              `video_new` | `public void onVideoNew(Video video)`                                        |
|      `vkpay_transaction` | `public void onVkpayTransaction(VkpayTransaction vkpayTransaction)`          |
|          `wall_post_new` | `public void onWallPostNew(WallPost wallPost)`                               |
|      `wall_reply_delete` | `public void onWallReplyDelete(WallReplyDelete wallReplyDelete)`             |
|        `wall_reply_edit` | `public void onWallReplyEdit(WallReply wallReply)`                           |
|         `wall_reply_new` | `public void onWallReplyNew(WallReply wallReply)`                            |
|     `wall_reply_restore` | `public void onWallReplyRestore(WallReply wallReply)`                        |
|            `wall_repost` | `public void onWallRepost(WallPost wallPost)`                                |

## Logging

This library uses `SLF4J` API to log all events. You can add any `SLF4J` binding to your project to register events the
way you want.

It is highly recommended enabling `DEBUG` log level to see sent and received data.
