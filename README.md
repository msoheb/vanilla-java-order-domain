# Order Pricing Engine (Vanilla Java)

This project is a **domain-first order pricing engine** implemented in **plain Java**, with a focus on **correct domain modeling**, **immutability**, and **business rule enforcement**.

The goal of this project is not UI or persistence, but to demonstrate how to design a **financially correct core domain** that can later evolve into a Spring Boot or enterprise application.

---

## Problem Statement

A small business needs to create customer orders where:
- An order contains one or more order items
- Item prices are captured at the time of ordering and never change
- Discounts are applied using clear, extensible rules
- Invalid states (zero quantity, invalid discounts, negative prices) must never exist
- Total amounts are always **derived**, never stored

---

## Design Principles Applied

- **Immutability by default**  
  All domain objects are fully initialized at construction time and cannot be mutated afterward.

- **Fail-fast validation**  
  Invalid domain states are rejected immediately via domain-specific exceptions.

- **Derived data is not stored**  
  Totals and calculated values are always derived from source data to avoid inconsistency.

- **Polymorphism over conditionals**  
  Discount logic is implemented using polymorphism instead of `if/else` branching.

- **BigDecimal for monetary values**  
  Floating-point types are avoided to ensure financial precision.

---

## Core Domain Model

### OrderItem
- Immutable snapshot of a product at order time
- Owns price, quantity, and optional variants
- Enforces its own invariants
- Calculates its own line total

### Discount
- Behavioral abstraction representing a discount rule
- Stateless with respect to orders
- Answers one question:  
  *“Given a subtotal, how much should be reduced?”*

Implemented discounts:
- `NoDiscount` (Null Object)
- `PercentageDiscount`

---

## Project Scope

This project intentionally focuses on:
- Domain correctness
- Object-oriented design
- Business rule modeling

It intentionally excludes:
- Persistence
- Frameworks (Spring, Hibernate, etc.)
- UI or API layers

These can be added later without changing the core domain.

---

## Tech Stack

- Java (Vanilla)
- `BigDecimal` for monetary calculations
- No external frameworks or libraries

---

## Status

🚧 **In Progress**

Upcoming:
- FlatDiscount
- Order aggregate
- Console runner
- Extended README with examples
