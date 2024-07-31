## 预约挂号API

### 1.机构列表接口

**功能描述:** 批量获取开放的机构信息

**场景价值:** 同步医院或其他机构信息至本地数据库

**适用对象:** 挂号服务功能或平台

**接口地址:** GET https://openapi.91160.com/basicInfo/unitList

**请求方式:** GET

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|开放平台应用授权Token|true|-
pageNum|int|页数.|true|默认为1
pageSize|int|每页记录数|true|默认20

**请求示例:**

```
curl -X GET -k -i https://openapi.91160.com/basicInfo/unitList?appToken=75fd1d311fdeef6bcc07a14f381c11f2vDUzpmEL&pageNum=1&pageSize=10

```

**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
data|object|结果集|-
└─list|array|列表数据|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitId|int|医院id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─masterUnitId|int|主医院ID,如果没有医院集团，则为医院ID身|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitName|string|医院名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitLevel|string|医院等级，如特等，三甲|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitType|string|医院性质：1-公立，2-民营|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitOrg|int|机构类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─image|string|医院logo图片完整路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|区域编码（国标码）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─address|string|医院地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mapPoint|string|地图经纬度位置|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitIntro|string|医院简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─payType|string|医院支付类型: 0-现场支付，1-强制在线支付|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─provinceName|string|省名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─provinceCode|string|省份编码（国标码）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cityName|string|市名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cityCode|string|城市编码（国标码）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─districtName|string|区域名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appointmentOpenTime|string|预约放号时间 HH:mm 14:20|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appointmentCycleDays|string|预约周期天数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─busRoute|string|乘车路线|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─telephone|string|医院总机号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─specialDeps|string|特色科室|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitOrgName|string|医院类型名称|-
└─total|int|总量.|-
code|string|响应代码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"data": {
		"list": [
			{
				"unitId": 100,
				"masterUnitId": 801,
				"unitName": "深圳市人民医院",
				"unitLevel": "re7bqy",
				"unitType": "n49hj7",
				"unitOrg": 181,
				"image": "of1uxv",
				"areaCode": "97955",
				"address": "Suite 609 贾街30号， 云浮， 新 359155",
				"mapPoint": "3i7c50",
				"unitIntro": "yqc9lm",
				"payType": "0bep04",
				"provinceName": "锦程.袁",
				"provinceCode": "97955",
				"cityName": "锦程.袁",
				"cityCode": "97955",
				"districtName": "锦程.袁",
				"appointmentOpenTime": "2023-04-24 17:03:28",
				"appointmentCycleDays": "gyjq45",
				"busRoute": "bzapid",
				"telephone": "17087246424",
				"specialDeps": "o5d2tc",
				"unitOrgName": "锦程.袁"
			}
		],
		"total": 468
	},
	"code": "0",
	"msg": "j3faxz"
}
```

### 2.机构科室列表

**功能描述:** 批量获取机构下的科室信息

**场景价值:** 同步机构下科室信息至本地数据库

**适用对象:** 挂号服务功能或平台

**接口地址:** https://openapi.91160.com/basicInfo/depList

**请求方式:** GET

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|开放平台应用授权Token|true|-
unitId|int|医院id|true|-
pageNum|int|页数.|true|默认为1
pageSize|int|每页记录数|true|默认20

**请求示例:**

```
curl -X GET -k -i https://openapi.91160.com/basicInfo/depList?pageSize=10&unitId=710&appToken= 75fd1d311fdeef6bcc07a14f381c11f2vDUzpmEL834&pageNum=242
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
data|object|结果集|-
└─list|array|列表数据|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depId|int|科室 ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depName|string|科室名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depIntro|string|科室介绍|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─telephone|string|联系电话|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitId|int|医院id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depClassName|string|科室分类名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depClassId|string|科室分类ID|-
└─total|int|总记录数|-
code|string|错误码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"data": {
		"list": [
			{
				"depId": 120,
				"depName": "锦程.袁",
				"depIntro": "ai2wx6",
				"telephone": "17087246424",
				"unitId": 273,
				"image": "435o47",
				"unitInnerPosition": "yqhsfn",
				"depClassName": "锦程.袁",
				"depClassId": "106",
				"hisDepId": "106"
			}
		],
		"total": 32
	},
	"code": "0",
	"msg": "u7z307",
}
```

### 3.机构医生列表接口

**功能描述:** 批量获取机构及科室下的医生信息

**场景价值:** 同步机构下的医生信息至本地数据库

**适用对象:** 挂号服务功能或平台

**接口地址:** https://openapi.91160.com/basicInfo/doctorList

**请求方式:** GET

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|开放平台应用授权Token|true|-
unitId|int|医院id|true|-
depId|int|科室id|true|-
pageNum|int|页数.|true|默认为1
pageSize|int|每页记录数|true|默认20

**请求示例:**

```
curl -X GET -k -i https://openapi.91160.com/basicInfo/doctorList?pageNum=502&unitId=508&appToken= 75fd1d311fdeef6bcc07a14f381c11f2vDUzpmEL721&doctorId=256&depId=234&pageSize=10&doctorName=锦程.袁
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
data|object|结果集|-
└─list|array|列表数据|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitId|int|医院id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depId|string|科室id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─doctorId|int|医生id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─doctorName|string|医生姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─image|string|医生头像|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─doctorTitle|string|医生职称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detail|string|医生简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─gender|int|医生性别: 1-男，0-女|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─expertise|string|擅长|-
└─total|int|总量.|-
code|string|错误码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"data": {
		"list": [
			{
				"unitId": 804,
				"depId": "106",
				"doctorId": 252,
				"doctorName": "王元",
				"image": "b5ka4e",
				"doctorTitle": "vd0stt",
				"moreVisits": 175,
				"detail": "vqgxdv",
				"gender": 0,
				"expertise": "54j6g7",
			
			}
		],
		"total": 160
	},
	"code": "0",
	"msg": "o6j8vy",
}
```


### 4.排班列表接口

**功能描述:** 批量查询医生的排班数据

**场景价值:** 查询或同步排班数据至本地服务

**适用对象:** 挂号服务功能或平台

**接口地址:** https://openapi.91160.com/appointment/scheduleList

**请求方式:** GET

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|开放平台应用授权Token|true|-
unitId|int|医院id|true|-
depId|int|科室id| true |-
doctorId|int|科室id| true |-
beginDate|string|开始日期|true|-
endDate|string|结束日期|true|-

**请求示例:**
```
curl -X GET -k -i https://openapi.91160.com/appointment/scheduleList?internalChannel=vgf120&depId=346&appToken= 75fd1d311fdeef6bcc07a14f381c11f2vDUzpmEL630&doctorId=409&beginDate=2023-04-24&endDate=2023-04-24&unitId=292
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
status|int|No comments found.|-
data|array|No comments found.|-
└─scheduleId|string|No comments found.|-
└─unitId|int|No comments found.|-
└─depId|int|科室 ID|-
└─doctorId|int|No comments found.|-
└─scheduleDate|string|No comments found.|-
└─unitName|string|No comments found.|-
└─timeType|string|班别 am pm em|-
└─timeTypeDesc|string|No comments found.|-
└─levelCode|string|预约挂号级别|-
└─levelName|string|挂号级别|-
└─resourceMax|int|最大号源数|-
└─appointedNum|int|已预约数|-
└─resourceFee|double|诊金+挂号费+服务费等|-
code|string|错误码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"data": [
		{
			"scheduleId": "106",
			"unitId": 520,
			"depId": 300,
			"doctorId": 731,
			"scheduleDate": "2023-04-24",
			"timeType": "am",
			"timeTypeDesc": "qz9hv5",
			"levelCode": "97955",
			"levelName": "锦程.袁",
			"resourceMax": 737,
			"appointedNum": 120,
			"resourceFee": 86.93,
		}
	],
	"code": "0",
	"msg": "mj81q0",
}
```

### 5.号源列表接口

**功能描述:** 实时查询某一个排班的号源明细数据

**场景价值:** 查询号源数据用于预约挂号

**适用对象:** 挂号服务功能或平台

**接口地址:** https://openapi.91160.com/appointment/resourceList

**请求方式:** GET

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|应用授权码|true|-
unitId|int|医院 ID|true|-
scheduleId|string|排班 ID|true|-

**请求示例:**

```
curl -X GET -k -i https://openapi.91160.com/appointment/resourceList?appToken= 75fd1d311fdeef6bcc07a14f381c11f2vDUzpmEL516&unitId=667&scheduleId=106
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
data|array|No comments found.|-
└─resourceId|string|No comments found.|-
└─beginTime|string|No comments found.|-
└─endTime|string|No comments found.|-
└─scheduleId|string|No comments found.|-
└─resourceMax|int|No comments found.|-
└─appointedNum|int|No comments found.|-
└─resourceFee|double|No comments found.|-
code|string|错误码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"data": [
		{
			"resourceId": "106",
			"beginTime": "2023-04-24 17:03:28",
			"endTime": "2023-04-24 17:03:28",
			"scheduleId": "106",
			"resourceMax": 107,
			"appointedNum": 641,
			"resourceFee": 6.62
		}
	],
	"code": "97955",
	"msg": "29unlf",
}
```

### 6.预约下单接口

**功能描述:** 提交号源下单

**场景价值:** 预约挂号下单

**适用对象:** 挂号服务功能或平台

**接口地址:** https://openapi.91160.com/appointment/order

**请求方式:** POST

**报文类型:** application/json; charset=utf-8

**请求报文参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|app接口授权码|true|-
unitId|int|医院单位 ID|true|-
depId|int|科室ID| false |-
doctorId|int|医生ID| false |-
detlId |string|号源ID|true|-
mobile|string|手机号码|true|-
trueName|string|患者姓名|true|-
sex|int|0 男 1 女|true|-
birthday|string|String[yyyy-mm-dd]	Y	出生日期|true|-
cardType|int|证件类型|true|-
cardNo|string|证件号|true|-
clinicNo|string|门诊卡号|true|-
address|string|地址|true|-
guardian|object|监护人信息|false|-
└─guardianTrueName|string|监护人姓名|true|-
└─guardianMobile|string|监护人手机号|true|-
└─guardianCardType|string|证件人证件类型|true|-
└─guardianCardNo|string|监护人证件号|true|-
└─guardianSex|string|监护人姓名|true|-
└─guardianRelation|string|监护人关系|true|-
└─guardianBirthday|string|监护人生日|true|-


**请求示例:**

```
curl -X POST -k -H '报文类型: application/json; charset=utf-8' -i https://openapi.91160.com/appointment/order --data '{
   "appToken": "xdssdfdfssdfdfssdf",
	"unitId": 395,
	"mobile": "17628427637",
	"trueName": "锦程.袁",
	"sex": 0,
	"birthday": "2023-04-24",
	"cardType": 323,
	"cardNo": "0975vj",
	"clinicNo": "epfghp",
	"address": "Suite 609 贾街30号， 云浮， 新 359155",
	"detlId": "106",
	"guardian": {
		"guardianTrueName": "锦程.袁",
		"guardianMobile": "17628427637",
		"guardianCardType": "7hmmja",
		"guardianCardNo": "oelelg",
		"guardianSex": "0pj934",
		"guardianRelation": "mpnqm0",
		"guardianMemberId": "106",
		"guardianBirthday": "2023-04-24"
	}
}'
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
data|object|结果集|-
└─orderId|int|No comments found.|-
└─hisTakeNo|string|HIS系统取号号码|-
code|string|错误码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"data": {
		"orderId": 974,
		"hisTakeNo": "取号密码"
	},
	"code": "97955",
	"msg": "w44u4d"
}
```

### 7.预约取消接口

**功能描述:** 取消预约挂号订单

**场景价值:** 用于用户挂号订单的取消

**适用对象:** 挂号服务功能或平台

**接口地址:** https://openapi.91160.com/appointment/cancel

**请求方式:** POST

**报文类型:** application/json; charset=utf-8

**请求报文参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appToken|string|app接口授权码|true|-
orderId|int|预约订单号|true|-
cancelReason|string|取消原因|true|-

**请求示例:**

```
curl -X POST -k -H '报文类型: application/json; charset=utf-8' -i https://openapi.91160.com/appointment/cancel --data '{
   "appToken": "xdssdfdfssdfdfssdf",
	"orderId": 488,
	"cancelReason": "取消原因"
}'
```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
code|string|错误码|-
msg|string|错误信息|-

**返回示例:**

```
{
	"code": "97955",
	"msg": "nfiuxp"
}
```