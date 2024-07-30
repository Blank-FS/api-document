## 预约挂号（医院接入）

### 停、改、替诊通知

**功能描述:** 院内排班状态发生变更时，通知160平台

**场景价值:** 医生停诊、替诊、改诊时，及时通知患者

**适用对象:** HIS开发商、号源池平台

**接口地址:** https://api.open.91160.com/guahao/v1/changeSch

**请求方式:** POST

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|开放平台应用授权Token|true|-
unitId|int|医院id|true|-
opType|int|业务类型|true|1：停诊；2：改诊；3：替诊
hisDepId|String|his内部科室编码|false|opType 为 1 且 stopSchType 为 1，2，3 可为空，其他情况必填
hisDocId|String|his内部医生工号|false|opType 为 1 且 stopSchType 为 1，2，3 可为空，其他情况必填
targetHisDepId|String|替诊科室编码|false|opType 为3 有效 不传或者为空时，值默认与deptCode相等（即同科室）
targetHisDocId|String|替诊医生工号|false|opType 为3 不能为空
schDate|String|出诊日期|false|opType 为 1 且 stopSchType 为 1，2，3 可为空，其他情况必填，格式：yyyy-MM-dd
schDateAfter|String|改诊后出诊日期|false|opType 为 2 必填，格式：yyyy-MM-dd
timeType|String|午别|false|opType 为 1 且 stopSchType 为 1，2，3 可为空，其他情况必填，0：全天 1：上午 2：下午 3：晚上
beginTime|String|号源时段开始时间|false|若传开始时间，结束时间必传；认为停诊排班下对应开始时间与结束时间的单个时段（若开始时间与结束时间中存在为空，则停诊整个排班）opType为1时 且 stopSchType 为 0 时有效，格式hh:mm
endTime|String|号源时段结束时间|false|opType为1时且stopSchType 为 0时有效，格式hh:mm
hisSrcId|String|医院号源Id|false|当stopSchType为2时，不为空
hisSchId|String|医院排班ID|false|当stopSchType为2时， 不为空
hisOrdNum|String|医院预约流水号|false|当stopSchType为1时 ，不为空
stopType|int|停诊类型|false|0：停排班停订单1：停排班不停订单2：不停排班停订单
changeType|int|改诊类型|false|0：改诊排班与订单1：只改诊订单
targetHisSchId|String|改诊或替诊后的HIS排班ID|false|opType为2、3时不为空
replaceType|int|替诊类型|false|0：替诊排班与订单1：只替诊订单
stopSchType|int|停排班方式|false|0：根据科室、医生、排班日期、午别停诊1：根据hisOrdNum停诊(不停排班，只停对应订单，此时stopOrderType不管传或不传均固定为2)2：根据hisSchId停诊3：根据hisSrcId停诊 opType为1时，有效

**请求示例:**

```
curl -X POST -k -H '报文类型: application/json; charset=utf-8' -i https://api.open.91160.com/guahao/v1/changeSch --data '{
    "appToken":"eilliidppeior",
    "unitId":"21",
    "hisDepId":"25",
    "hisDocId":"136",
    "schDate":"2023-04-22",
    "timeType":"1",
    "schDateAfter":"",
    "targetHisDepId":"",
    "targetHisDocId":"",
    "beginTime":"",
    "endTime":"",
    "hisSrcId":"",
    "hisSchId":"",
    "hisOrdNum":"",
    "realTime":"0",
    "stopType":"0",
    "changeType":"0",
    "replaceType":"0",
    "StopSchType":"0"
}'
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
code|string|错误码|1 表示成功 其他失败
msg|string|错误信息|-

**返回示例:**

```
{
	"code": 1,
	"msg": "成功",
}
```

