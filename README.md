# Hibernate CriteriaBuilder

## Overview

This project demonstrates the use of the `CriteriaBuilder` interface in Hibernate, which is part of the `javax.persistence.criteria` package. The `CriteriaBuilder` was introduced to overcome the drawbacks of the Criteria API. It allows us to create different types of criteria to perform specific operations without hardcoding queries as strings.

## Key Components

### CriteriaBuilder

- **Purpose**: Acts as a builder to generate objects for different types of criteria.
- **Usage**: Create an instance using the `getCriteriaBuilder()` method from the session object.
- **Functionality**: Helps construct queries using inbuilt methods, but does not execute them.

### Criteria Types

1. **CriteriaQuery**
   - **Purpose**: Used for data retrieval from the database.
   - **Creation**: Use `createQuery()` method from `CriteriaBuilder`.
   - **Methods**: 
     - `from()`: Fetches all records from the respective table and stores them in a root element.
   - **Execution**: Use the `Query` interface to execute the constructed query.

   ```java
   // Example of CriteriaQuery
   Session session = sessionFactory.openSession();
   CriteriaBuilder cb = session.getCriteriaBuilder();
   CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
   Root<Employee> root = cq.from(Employee.class);
   cq.select(root);
   Query<Employee> query = session.createQuery(cq);
   List<Employee> employees = query.getResultList();
   ```

2. **CriteriaUpdate**
   - **Purpose**: Used for updating data in the database.
   - **Creation**: Use `createCriteriaUpdate()` method from `CriteriaBuilder`.
   - **Methods**: 
     - `from()`: Fetches all records from the respective table and stores them in a root element.
     - `set()`: Sets the values for columns to be updated.
   - **Execution**: Use the `Query` interface to execute the constructed query using `executeUpdate()` method.

   ```java
   // Example of CriteriaUpdate
   Session session = sessionFactory.openSession();
   CriteriaBuilder cb = session.getCriteriaBuilder();
   CriteriaUpdate<Employee> cu = cb.createCriteriaUpdate(Employee.class);
   Root<Employee> root = cu.from(Employee.class);
   cu.set("salary", 50000);
   cu.where(cb.equal(root.get("id"), 1));
   Query query = session.createQuery(cu);
   int rowsUpdated = query.executeUpdate();
   ```

3. **CriteriaDelete**
   - **Purpose**: Used for deleting data from the database.
   - **Creation**: Use `createCriteriaDelete()` method from `CriteriaBuilder`.
   - **Methods**: 
     - `from()`: Fetches all records from the respective table and stores them in a root element.
   - **Execution**: Use the `Query` interface to execute the constructed query using `executeUpdate()` method.

   ```java
   // Example of CriteriaDelete
   Session session = sessionFactory.openSession();
   CriteriaBuilder cb = session.getCriteriaBuilder();
   CriteriaDelete<Employee> cd = cb.createCriteriaDelete(Employee.class);
   Root<Employee> root = cd.from(Employee.class);
   cd.where(cb.equal(root.get("id"), 1));
   Query query = session.createQuery(cd);
   int rowsDeleted = query.executeUpdate();
   ```

## Notes

### CriteriaBuilder

- It is an interface present in `javax.persistence.criteria` package.
- It was introduced to overcome the drawbacks of Criteria API.
- Using `CriteriaBuilder` we can create different types of criteria to perform specific operations.
- `CriteriaBuilder` acts as a builder responsible for generating objects for different types of criteria.
- We can create an object of `CriteriaBuilder` by invoking the `getCriteriaBuilder()` method using the session object.
- Using `CriteriaBuilder`, we don't need to hardcode the query as a string; instead, we use inbuilt methods to construct the query.
- It is only used to construct the query and not responsible for executing it.
- To execute the query, we need to create an instance of the `Query` interface.

### CriteriaQuery

- It is an interface present in `javax.persistence.criteria` package.
- It is used specifically for data retrieval from the database.
- We can create an object of `CriteriaQuery` by invoking the `createQuery()` method using the `CriteriaBuilder` object.
- The `createQuery()` method accepts the entity class name as the parameter to construct the query.
- It has a method called `from()` which accepts the entity class name as the parameter to fetch all records from the respective table and store them inside a root element.
- The user is provided with several methods to represent the `where` clause and various other expressions needed for the query.
- To execute the query after it is constructed, we need to use the `Query` interface.

### CriteriaUpdate

- It is an interface present in `javax.persistence.criteria` package.
- It is used specifically for updating data in the database.
- We can create an object of `CriteriaUpdate` by invoking the `createCriteriaUpdate()` method using the `CriteriaBuilder` object.
- The `createCriteriaUpdate()` method accepts the entity class name as the parameter to construct the query.
- It has a method called `from()` which accepts the entity class name as the parameter to fetch all records from the respective table and store them inside a root element.
- We use the `set` method from `CriteriaUpdate` to set the values for columns to be updated.
- The user is provided with several methods to represent the `where` clause and various other expressions needed for the query.
- To execute the query after it is constructed, we need to use the `Query` interface and the `executeUpdate()` method.

### CriteriaDelete

- It is an interface present in `javax.persistence.criteria` package.
- It is used specifically for deleting data from the database.
- We can create an object of `CriteriaDelete` by invoking the `createCriteriaDelete()` method using the `CriteriaBuilder` object.
- The `createCriteriaDelete()` method accepts the entity class name as the parameter to construct the query.
- It has a method called `from()` which accepts the entity class name as the parameter to fetch all records from the respective table and store them inside a root element.
- The user is provided with several methods to represent the `where` clause and various other expressions needed for the query.
- To execute the query after it is constructed, we need to use the `Query` interface and the `executeUpdate()` method.
