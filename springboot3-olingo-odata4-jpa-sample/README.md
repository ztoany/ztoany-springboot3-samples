# Spring Boot 3 Olingo OData4 Samples

## install dependency

```shell
git clone https://github.com/SAP/olingo-jpa-processor-v4.git
cd olingo-jpa-processor-v4
git checkout 2.2.0
cd jpa
mvn clean install
```

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