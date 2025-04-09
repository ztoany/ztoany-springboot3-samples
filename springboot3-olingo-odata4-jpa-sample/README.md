# Spring Boot 3 Olingo OData4 Samples

## endpoint

odata base url

```shell
http://localhost:8080/api/odata
```

metadata

```shell
http://localhost:8080/api/odata/$metadata
```

## operation

create entity

```shell
curl -X POST \
  http://localhost:8080/api/odata/Customers \
  -H "Content-Type: application/json" \
  -d '{
        "Name": "cc",
        "Id":"113"
      }'
```

get all entity

```shell
curl http://localhost:8080/api/odata/Customers
```

filter

```shell
curl http://localhost:8080/api/odata/Customers?$filter=Name eq 'cc11'
```