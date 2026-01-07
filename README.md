# Order Pricing Engine (Vanilla Java)

This project is a **domain-first order pricing engine** implemented in **plain Java**, with a focus on **immutability**, **financial correctness**, and **clean object-oriented design**.

The goal of this project is not UI or persistence, but to demonstrate how to design a **robust core domain** that can later be reused in frameworks like Spring Boot.

---

## Problem Statement

A system is required to create customer orders where:

- An order contains one or more order items
- Item price is captured at order time and must never change
- Discounts are applied using extensible business rules
- Invalid states (negative price, zero quantity, invalid discount) must never exist
- Total and payable amounts are always **derived**, never stored

---

## Key Design Principles

- **Immutability by default**  
  All domain objects are fully initialized at construction time and cannot be modified afterward.

- **Fail-fast validation**  
  Invalid domain states are rejected immediately via domain-specific exceptions.

- **Derived data is not stored**  
  Subtotals, discounts, and payable amounts are calculated on demand to avoid inconsistency.

- **Polymorphism over conditionals**  
  Discount logic is implemented using polymorphism instead of `if/else` branching.

- **Financial correctness**  
  All monetary calculations use `BigDecimal` to avoid precision errors.

---

## Core Domain Model

### OrderItem
- Immutable snapshot of a product at order time
- Owns price and quantity
- Calculates its own line total
- Enforces quantity and price invariants

### Discount
- Behavioral abstraction representing a discount rule
- Stateless with respect to orders
- Answers one question:  
  **“Given a subtotal, how much should be reduced?”**

Implemented discounts:
- `NoDiscount` (Null Object)
- `PercentageDiscount`
- `FlatDiscount`

### Order
- Aggregate root
- Owns order metadata, items, and discount
- Delegates line total calculation to `OrderItem`
- Delegates discount logic to `Discount`
- Calculates payable amount on demand

---

## Example Usage

A simple console runner demonstrates how the domain is used:

- Create order items
- Choose a discount strategy
- Create an order
- Calculate payable amount

The console runner contains **no business logic** and acts purely as a client.

---

## Project Scope

This project intentionally focuses on:

- Domain modeling
- Object-oriented design
- Business rule enforcement

It intentionally excludes:

- Persistence
- Frameworks (Spring, Hibernate)
- REST APIs or UI layers

These can be added later without changing the core domain.

---

## Status

✅ Core domain complete  
🚧 Possible next steps:
- Unit tests
- Spring Boot wrapper
- Tax calculation rules
