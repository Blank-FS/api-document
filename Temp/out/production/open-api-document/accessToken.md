## 接入须知

```
测试环境域名：wsapitest2.91160.com
正式环境域名：wsapi.91160.com
```

### 获取access_token
**接口说明**
```
服务电商接口，都需要此接口生成的access_token，access_token有效期一个小时。
你可以将access_token放在get参数中、request header中(header中请使用access-token作为HeaderKey)，或者放在post form-data中。
```
**请求方式及地址**

```
【POST】https://wsapi.91160.com/index.php?c=openhealth&a=oauthToken
```

**请求参数【放在form-data里】**

| 字段      | 名称     | 类型   | 必填 | 备注 |
| --------- | -------- | ------ | ---- |---------------|
| operation | 操作类型 | string | 是   | grant(获取)     |
| client_id | 客户端ID | string | 是   | 160分配         |
| secret_id | 秘钥ID   | string | 是   | 160分配         |

**响应参数**

| 字段          | 名称      | 类型   | 备注             |
| ------------- | --------- | ------ | ---------------- |
| status        | 返回码    | int    | 1成功、0失败     |
| msg           | 返回信息  | string |                  |
| data          | 返回对象  | array  |                  |
| refresh_token | 刷新token | string |                  |
| access_token  | token凭证 | string | 请求其他接口必传 |
| chnID         | 渠道ID    | string |                  |
| supplier_id   | 商户ID    | String |                  |



**响应示例**

```json
{
    "status":1,
    "msg":"",
    "data":{
        "chnId":"123160",
        "access_token":"d87e224183910818h95af3b6a5de110d70bc3caa",
        "refresh_token":"5bc17f2d4ajk70dc4789ae087aed106d5a2f62a1",
        "supplier_id":"200023"
    }
}
```

