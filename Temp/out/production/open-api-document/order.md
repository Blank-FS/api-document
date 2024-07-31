## 订单API
### 1.取消预约异步回调

**接口说明**
```
取消预约的时候，需异步回调此接口
```

**请求方式及地址**
```
【POST】https://wsapi.91160.com/index.php?c=openhealth&a=changeYuyueState
```

**请求参数【放在form-data里】**

| 字段          | 名称      | 类型   | 必填 | 备注                    |
| ------------- | --------- | ------ | ---- | ------------------------ |
| access_token  | token凭证 | string | 是   |                          |
| order_id      | 订单id    | int    | 是   | 健康160订单id            |
| cancel_status | 取消状态  | int    | 是   | 1：取消成功，0：取消失败 |



**响应参数**

| 字段   | 名称     | 类型   | 备注         |
| ------ | -------- | ------ | ------------ |
| status | 返回码   | int    | 1成功、0失败 |
| msg    | 返回信息 | string |              |
| data   | 返回对象 | array  |              |



**响应示例**

```json
{
    "status":1,
    "msg":"",
    "data":[]
}
```



### 2.体检完成异步通知
**接口说明**
```
体检完成后，需异步调用此接口进行通知
```
**请求方式及地址**
```
【POST】https://wsapi.91160.com/index.php?c=openhealth&a=lockListSync
```

**请求参数【放在form-data里】**

| 字段         | 名称      | 类型   | 必填 | 备注          |
| ------------ | --------- | ------ | ---- | ------------- |
| access_token | token凭证 | string | 是   |               |
| order_id     | 订单id    | int    | 是   | 健康160订单id |

**响应参数**

| 字段   | 名称     | 类型   | 备注         |
| ------ | -------- | ------ | ------------ |
| status | 返回码   | int    | 1成功、0失败 |
| msg    | 返回信息 | string |              |
| data   | 返回对象 | array  |              |

**响应示例**

```json
{
    "status":1,
    "msg":"",
    "data":[]
}
```

