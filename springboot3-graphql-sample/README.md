# Spring Boot 3 Graphql Samples

## graphiql

http://localhost:8080/graphiql

```graphql
query {
  listAllCustomers {
    id
    name
    createdAt
  }
}
```

```graphql
query {
  getCustomerById(id: "7b2d4623-2a0d-46da-90c8-20a854ad5db6") {
    id
    name
    createdAt
  }
}
```