## 开放平台基础能力


### 获取接口应用授权码接口

**功能描述:** 获取接口应用授权码

**场景价值:** 获取接口应用授权码，访问接口

**适用对象:** 所有应用服务商


**接口地址:** https://openapi.91160.com/app/token

**请求方式:** GET

**请求参数:**

参数 | 参数类型|参数名|是否必须|描述
---|---|---|---|---
appId|int|应用 ID|true|-
appSecret|string|应用密钥|true|-

**请求示例:**

```
curl -X GET -k -i https://openapi.91160.com/app/token?appId=2002222&appSecret=atx5ih

```
**返回参数:**

字段 | 字段类型|字段说明|备注
---|---|---|---
data|object|结果集|-
└─expiresIn|int|过期时长|-
└─appToken|string|授权码|-
code|string|错误码|-
msg|string|错误信息|-


**返回示例:**

```
{
	"data": {
		"appToken": "xdssdfdfssdfdfssdf",
		"expiresIn": 2121
	},
	"msg": "success",
	"code": 147,
}
```

