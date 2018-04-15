# GEFA API

- [README](../docs/API.md)  

## Structure

### The envelope
Every response is contained by an envelope. That is, each response has a predictable set of keys with which you can expect to interact:

```javascript
{
  "data": {
    ...
   }
}
```

### Errors and Status Codes
If a request fails any validations, expect a 422 and errors in the following format:

```javascript
{
  "error": {
    "code": 404,
    "message": "ID not found"
  }
}
```
#### Other status codes

| Code     | Description|
| :-------:|---------------|
| 400      | The request could not be understood by the server due to malformed syntax |
| 401      | Unauthorized requests, when a request requires authentication but it isn't provided |
| 403      | Forbidden requests, when a request may be valid but the user doesn't have permissions to perform the action      |
| 404	   | Either there is no API method associated with the URL path of the request, or the request refers to one or more resources that were not found |
| 409	   | This code is only allowed in situations where it is expected that the user might be able to resolve the conflict and resubmit the request      |

## Endpoints

### Objects

- [ ] [Status Types](#status_types)
- [ ] [Levels](#levels)
- [ ] [Level Types](#level_types)

### Models

- [ ] [Status Type](#status_type)
- [ ] [Status](#status)
- [ ] [Level](#level)
- [ ] [Level Type](#level_type)


### Status Types 

#### Summary of Status Types endpoints
|Method |URL                  |Description          |Dev Status             |
|-------|---------------------|---------------------|:---------------------:|
|**GET**|**/api/status-types**|Returns list of status types|:white_check_mark: Done|
|**GET**|**/api/status-types/{id}**|Returns detail of status type|:white_check_mark: Done|
|**GET**|**/api/status-types/{id}/status**|Returns list of status belongs to a status type|:white_check_mark: Done|

#### Request

|Method |URL                  |Description          |Dev Status             |
|-------|---------------------|----------------------|:---------------------:|
|**GET**|**/api/status-types**|Returns list of status types|:white_check_mark: Done|

#### Parameters

| Name  | Type |       Description      |
|-------|------|------------------------|
|--|--|--|
*required

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|

##### Model (Response)

{ [Status Type](#status_type) }

##### Example Value (Response)

```javascript
{
    "data":
    [
        {
            "statusTypeId": 1,
            "statusTypeName": "EDO_USUARIO",
        },
        {
            "statusTypeId": 2,
            "statusTypeName": "EDO_MODIFICACION",
        },
        {
            "statusTypeId": 3,
            "statusTypeName": "EDO_TIPIFICACION",
        }
    ]
}
```

#### Request

|Method |URL                  |Description          |Dev Status             |
|-------|---------------------|----------------------|:---------------------:|
|**GET**|**/api/status-types/{id}**|Returns detail of status type|:white_check_mark: Done|

#### Parameters

| Name  | Type |       Description      |
|-------|------|------------------------|
|--|--|--|
*required

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|

##### Model (Response)

{ [Status Type](#status_type) }


##### Example Value (Response)

```javascript
{
    "data":
    {
        "statusTypeId": 1,
        "statusTypeName": "EDO_USUARIO",
    },
}
```

#### Request

|Method |URL                  |Description          |Dev Status             |
|-------|---------------------|----------------------|:---------------------:|
|**GET**|**/api/status-types/{id}/status**|Returns list of status belongs to a status type|:white_check_mark: Done|

#### Parameters

| Name  | Type |       Description      |
|-------|------|------------------------|
|--|--|--|
*required

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|

##### Model (Response)

{ [Status Type](#status_type) }


##### Example Value (Response)

```javascript
{
    "data": [
      {
        "statusId": 1,
        "statusName": "SIN TRAMITAR",
        "statusType": {
          "statusTypeId": 1,
          "statusTypeName": "SIN TRAMITAR",
        }
      },
      {
        "statusId": 2,
        "statusName": "EN TRÁMITE",
        "statusType": {
          "statusTypeId": 1,
          "statusTypeName": "SIN TRAMITAR",
        }
      },
      {
        "statusId": 3,
        "statusName": "ALTA",
        "statusType": {
          "statusTypeId": 1,
          "statusTypeName": "SIN TRAMITAR",
        }
      },
    ]
}
```

### Levels 

#### Summary of Levels endpoints
|Method |URL                  |Description           |Dev Status             |
|-------|---------------------|----------------------|:---------------------:|
|**GET**|**/api/levels**      |Returns list of levels|:white_check_mark: Done|
|**GET**|**/api/levels/{id}** |Returns detail of a level|:white_check_mark: Done|
|**GET**|**/api/levels/{id}/sub-levels**|Returns list of sublevels belongs to a level|:white_check_mark: Done|

#### Request

|Method |URL                  |Description           |Dev Status       |
|-------|---------------------|----------------------|:---------------:|
|**GET**|**/api/levels**      |Returns list of levels|:white_check_mark: Done|

#### Parameters

| Name  | Type |       Description      |
|-------|------|------------------------|
|--|--|--|
*required

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|


##### Example Value (Response)

```javascript
{
    "data":
    [
      {
        "levelId": 1,
        "levelName": "ADQUIRIENTE Y BANCA ELECTRÓNICA",
        "levelType": {
          "levelTypeId": 1,
          "levelTypeName": "DIRECCIÓN"
        },
        "levelSuperior": null,
        "user": {
          "userInternalId": "XMY3070",
          "status": {
            "statusId": 1,
            "statusName": "SIN TRAMITAR",
            "statusType": {
              "statusTypeId": 1,
              "statusTypeName": "EDO_USUARIO"
            }
          },
          "profileType": {
            "profileTypeId": 1,
            "profileTypeName": "GESTORIA FSW"
          }
        }
      },
      {
        "levelId": 2,
        "levelName": "ANS Y FACTORIAS",
        "levelType": {
          "levelTypeId": 1,
          "levelTypeName": "DIRECCIÓN"
        },
        "levelSuperior": null,
        "user": {
          "userInternalId": "XMY3070",
          "status": {
            "statusId": 1,
            "statusName": "SIN TRAMITAR",
            "statusType": {
              "statusTypeId": 1,
              "statusTypeName": "EDO_USUARIO"
            }
          },
          "profileType": {
            "profileTypeId": 1,
            "profileTypeName": "GESTORIA FSW"
          }
        }
      },
    ]
}
```

#### Request

|Method |URL                  |Description           |Dev Status       |
|-------|---------------------|----------------------|:---------------:|
|**GET**|**/api/levels/{id}** |Returns detail of a level|:white_check_mark: Done|

#### Parameters

| Name  | Type |       Description      |
|-------|------|------------------------|
|--|--|--|
*required

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|

##### Example Value (Response)

```javascript
{
  "data": {
    "levelId": 2,
    "levelName": "ANS Y FACTORIAS",
    "levelType": {
      "levelTypeId": 1,
      "levelTypeName": "DIRECCIÓN"
    },
    "levelSuperior": null,
    "user": {
      "userInternalId": "XMY3070",
      "status": {
        "statusId": 1,
        "statusName": "SIN TRAMITAR",
        "statusType": {
          "statusTypeId": 1,
          "statusTypeName": "EDO_USUARIO"
        }
      },
      "profileType": {
        "profileTypeId": 1,
        "profileTypeName": "GESTORIA FSW"
      }
    }
  }
}
```

#### Request

|Method |URL                  |Description           |Dev Status       |
|-------|---------------------|----------------------|:---------------:|
|**GET**|**/api/levels/{id}/sub-levels**|Returns list of sublevels belongs to a level|:white_check_mark: Done|

#### Parameters

| Name  | Type |       Description      |
|-------|------|------------------------|
|--|--|--|
*required

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|

##### Example Value (Response)

```javascript
{
  "data": [
    {
      "levelId": 22,
      "levelName": "COA",
      "levelType": {
        "levelTypeId": 2,
        "levelTypeName": "SUBDIRECCIÓN"
      },
      "levelSuperior": {
        "levelId": 2,
        "levelName": "ANS Y FACTORIAS",
        "levelType": {
          "levelTypeId": 1,
          "levelTypeName": "DIRECCIÓN"
        },
        "levelSuperior": null,
        "user": {
          "userInternalId": "XMY3070",
          "status": {
            "statusId": 1,
            "statusName": "SIN TRAMITAR",
            "statusType": {
              "statusTypeId": 1,
              "statusTypeName": "EDO_USUARIO"
            }
          },
          "profileType": {
            "profileTypeId": 1,
            "profileTypeName": "GESTORIA FSW"
          }
        }
      },
      "user": {
        "userInternalId": "XMY3080",
        "status": {
          "statusId": 1,
          "statusName": "SIN TRAMITAR",
          "statusType": {
            "statusTypeId": 1,
            "statusTypeName": "EDO_USUARIO"
          }
        },
        "profileType": {
          "profileTypeId": 1,
          "profileTypeName": "GESTORIA FSW"
        }
      }
    },
    {
      "levelId": 23,
      "levelName": "ANS FRONTS",
      "levelType": {
        "levelTypeId": 2,
        "levelTypeName": "SUBDIRECCIÓN"
      },
      "levelSuperior": {
        "levelId": 2,
        "levelName": "ANS Y FACTORIAS",
        "levelType": {
          "levelTypeId": 1,
          "levelTypeName": "DIRECCIÓN"
        },
        "levelSuperior": null,
        "user": {
          "userInternalId": "XMY3070",
          "status": {
            "statusId": 1,
            "statusName": "SIN TRAMITAR",
            "statusType": {
              "statusTypeId": 1,
              "statusTypeName": "EDO_USUARIO"
            }
          },
          "profileType": {
            "profileTypeId": 1,
            "profileTypeName": "GESTORIA FSW"
          }
        }
      },
      "user": {
        "userInternalId": "XMY3080",
        "status": {
          "statusId": 1,
          "statusName": "SIN TRAMITAR",
          "statusType": {
            "statusTypeId": 1,
            "statusTypeName": "EDO_USUARIO"
          }
        },
        "profileType": {
          "profileTypeId": 1,
          "profileTypeName": "GESTORIA FSW"
        }
      }
    }
  ]
}
```

### Level Types 

#### Summary of Level Types endpoints

|Method |URL                  |Description           |Dev Status             |
|-------|---------------------|----------------------|:---------------------:|
|**GET**|**/api/level-types**      |Returns list of level types|:white_check_mark: Done|
|**GET**|**/api/level-types/{id}** |Returns detail of a level type|:white_check_mark: Done|
|**GET**|**/api/level-types/{id}/levels**|Returns list of levels belongs to a level type|:white_check_mark: Done|

#### Responses

| Code |   Description     |
|------|-------------------|
| 200  |Successful operation|

##### Example Value (Response)

```javascript
{
  "data": [
    {
      "levelTypeId": 1,
      "levelTypeName": "DIRECCIÓN"
    },
    {
      "levelTypeId": 3,
      "levelTypeName": "GERENCIA"
    },
    {
      "levelTypeId": 2,
      "levelTypeName": "SUBDIRECCIÓN"
    }
  ]
}
```

## Models

### Status Type
```typescript
StatusType {
  "statusTypeId": int,
  "statusTypeName": string
}
```

### Status
```typescript
Status {
  "statusTypeId": int,
  "statusTypeName": string,
  statusType: StatusType
}
```
### Level
```typescript
Level {
  "levelId": int,
  "levelName": string,
  levelType: LevelType,
  "levelSuperior": int,
  user: User
}
```

### Level Type
```typescript
LevelType {
  "levelTypeId": int,
  "levelTypeName": string
}
```
