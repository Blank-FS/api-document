## 健康日志 API

### 1.获取健康日志接口

**功能描述:** 获取用户的健康日志列表信息

**场景价值:** 同步健康日志信息至本地数据库

**适用对象:** 线上咨询业务、健康管理

**接口地址:** https://openapi.91160.com/emr/v1/getUserEmrRecord

**请求方式:** POST

**请求参数:**

| 参数     | 参数类型 | 参数名                 | 是否必须 | 描述                   |
| -------- | -------- | ---------------------- | -------- | ---------------------- |
| appToken | string   | 开放平台应用授权 Token | true     | -                      |
| cardNo   | string   | 身份证号               | true     |
| emrId    | string   | 健康日志编号           | false    | 默认为空，表示取之后的 |
| pageNum  | int      | 当前页数               | false    | 默认为 1               |
| pageSize | int      | 每页记录数             | false    | 默认 20                |

**请求示例:**

```
curl -X POST -k -H 'ContentType: application/json; charset=utf-8' -i https://openapi.91160.com/emr/v1/getUserEmrRecord --data '{
    "appToken": "xdssdfdfssdfdfssdf",
	"cardNo": "430624XXXXXX"
}'
```

**返回参数:**

| 字段                                                 | 字段类型 | 字段说明                         | 备注 |
| ---------------------------------------------------- | -------- | -------------------------------- | ---- |
| data                                                 | object   | 结果集                           | -    |
| └─list                                               | array    | 列表数据                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emrId                | int      | 健康日志编码                     | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emrType              | string   | 健康日志类型                     | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─recordTime           | string   | 日志时间，就诊时间               | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitId               | string   | 医院 ID                          | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitName             | string   | 医院名称                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depId                | string   | 科室 ID                          | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depName              | string   | 科室名称                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─doctorId             | string   | 医生 ID                          | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─doctorName           | string   | 医生名称                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resourceType         | int      | 资源类型: 0: 无；1：image;2: pdf | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resourceUrl          | string   | 资源路径                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mainSuit             | string   | 主诉                             | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─eventSummary         | string   | 事件摘要                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─treatment            | string   | 处理                             | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─diagnostic           | string   | 诊断                             | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mattersNeedAttention | string   | 注意事项                         | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark               | string   | 备注                             | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detail               | Json     | 日志详细信息，具体参考           | -    |
| └─total                                              | int      | 总量                             | -    |
| code                                                 | int      | 响应代码                         | -    |
| msg                                                  | string   | 错误信息                         | -    |

**返回示例:**

```
{
	"code": 1,
	"data": {"list":[

		{
			"emrId": "161",
			"status": "EMR_STATUS_OCR_WAIT",
			"emrType": "EMR_ASK",
			"recordTime": "2022-08-24 13:44:56",
			"userId": "222914859",
			"unitId": "200011502",
			"unitName": "1**",
			"doctorId": "200281878",
			"doctorName": "欧洲",
			"orderNo": "20037504",
			"orderType": "GRAPHIC_CONSULTATION"
		}
	],
	"total":20
	},
	"msg": "success"
}
```

### 2.上传用户的健康日志

**功能描述:** 上传用户的健康日志

**场景价值:** 医院将用户的健康日志上传后，方便用户进行查看、管理、跨医院使用。

**适用对象:** 医院系统

**接口地址:** https://openapi.91160.com/emr/v1/syncUserEmrRecord

**请求方式:** POST

**请求参数:**

| 参数                  | 参数类型 | 参数名                          | 是否必须 | 描述    |
| --------------------- | -------- | ------------------------------- | -------- | ------- |
| appToken              | string   | 开放平台应用授权 Token          | true     | -       |
| data                  | list     | 数据集                          |          | -       |
| └─channelEmrId        | string   | 渠道的健康日志编号 ID           | true     |
| └─dataSource          | int      | 数据来源，医院固定为 3          | true     | 默认 20 |
| └─cardNo              | string   | 用户身份证号码                  |          |
| └─resourceType        | string   | 资源类型：1,图片；2,链接；3,PDF |          |
| └─resourceUrl         | string   |                                 |          |
| 同 1 返回接口参数部分 |          |                                 |          |

**请求示例:**

```
curl -X POST -k -H 'ContentType: application/json; charset=utf-8' -i https://openapi.91160.com/emr/v1/getUserEmrRecord --data '{
    "appToken": "xdssdfdfssdfdfssdf",
    "data": [
        {
            "emrType": "EMR_RECORD",
            "dataSource": "3",
            "recordTime": "2022-08-25 14:21:39",
            "userId": "200011502",
            "unitId": "301",
            "unitName": "罗湖医院",
            "depId": "1",
            "depName": "测试科",
            "doctorId": "10000",
            "doctorName": "李医生",
            "resourceType":"1", //资源类型：1，图片；2：链接；3：PDF
            "resourceUrl":"http://xxx.png",
            "detail": {
                "eventSummary": "111111111",
                "diagnostic": "This is test"
            }
        }
    ]
}'
```

**返回参数:**

| 字段                                  | 字段类型 | 字段说明        | 备注 |
| ------------------------------------- | -------- | --------------- | ---- |
| data                                  | object   | 结果集          | -    |
| └─list                                | array    | 列表数据        | -    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emrId | string   | 健康日志编号 ID | -    |
| code                                  | string   | 错误码          | -    |
| msg                                   | string   | 错误信息        | -    |

**返回示例:**

```
{
    "code": 1,
    "data": [
        {
            "emrId": "203",
            "userId": "200011502"
        }
    ],
    "msg": "success"
}
```
