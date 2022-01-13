---
name: Receiving VK API Exeption
about: Create a report to help us improve the library
title: Receiving VK API Exeption
labels: ''
assignees: ''

---

I'm executing the request by this URL (replace with URL from your logs): `https://api.vk.com/method/messages.send`

with parameters (replace with params from your logs): `{access_token=*************************************************************************************, random_id=1413328727, message=Sending you message, v=5.131}`

and I'm receiving (replace with response from your logs): 
```json
{"error":{"error_code":100,"error_msg":"One of the parameters specified was missing or invalid: you should specify peer_id, user_id, domain, chat_id or user_ids param","request_params":[{"key":"method","value":"messages.send"},{"key":"oauth","value":"1"},{"key":"v","value":"5.131"},{"key":"random_id","value":"1413460573"}]}}
```

Here is the code example (replace with your code example):
```java
public void sendMessage() throws VkApiException {
    Send.Response response = vk.messages.send()
            .setMessage("Sending you message")
            .execute();

    System.out.println("Response: " + response);
}
```

I'm using `java-vk-bots-longpoll-api` version (replace with version you are using): `3.1.1`

Could you please help me to understand what is wrong here?
