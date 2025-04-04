# DTOS/Projections
DTOS - short for Data Transfer Objects. Another naming convention is projections.

Projections can be used to alter default queries made in by a Repository (CrudRepository). A Projection can be considered an abstraction of a Entity, which defines the data you want to to be retured

By using a Projection as the the return type for a query, the query changes -  See ProductRepository:
```
List<ProductSummary> findByCategory(Category category);
```

If the default entity is used as the return type instead, other queries would have been made due to eager loading...

Note: 
DTO/projection interfaces are preferable if possible. Classes should only be used if you need to need to include additional logic to the DTO class