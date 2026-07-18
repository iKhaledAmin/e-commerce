# Modular E-Commerce Platform 🚀

## Table of Contents

- [Overview](#overview)
- [Architecture Highlights](#architecture-highlights)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Entity Relationship Diagram](#entity-relationship-diagram)
- [System Design Specification](#system-design-specification)
- [API Documentation](#api-documentation)



## Overview ✨

E-Commerce Platform is a modular commerce system designed to support the complete customer purchasing lifecycle, including product catalog management, shopping carts, and order management.

The platform is built around a separation-of-concerns architecture where commerce functionality and inventory management are treated as independent domains. Rather than managing inventory directly, the platform integrates with a dedicated Inventory Management System (IMS) through a secure integration gateway. This approach enables the e-commerce domain to focus exclusively on customer-facing commerce workflows while delegating inventory availability, stock reservation, allocation, and consistency management to a specialized inventory platform.

The system supports a reservation-based checkout workflow that validates product pricing, verifies inventory availability, reserves stock through the external IMS, and creates orders only when all requested inventory can be successfully allocated. This design helps prevent overselling while maintaining consistency across distributed systems.

In addition to commerce operations, the platform provides comprehensive product and category management capabilities, customer shopping cart functionality, account management, and secure authentication using JWT and Role-Based Access Control (RBAC).

The platform also includes a dedicated image management architecture that abstracts file storage behind domain services, allowing storage implementations to evolve from local file systems to cloud-based providers such as Amazon S3 or Azure Blob Storage without impacting business logic.

Built using a modular monolith architecture and Domain-Driven Design (DDD) principles, the platform emphasizes maintainability, scalability, clear domain boundaries, and integration readiness for modern commerce ecosystems.


---
<a id="architecture-highlights"></a>
## Architecture Highlights 🏗️

- Modular Monolith Architecture
- Domain-Driven Design (DDD)
- Separation of Commerce and Inventory Domains
- External Inventory Management System (IMS) Integration
- Reservation-Based Workflow
- Integration Gateway Pattern
- Anti-Corruption Layer Pattern
- Storage-Agnostic Image Management Architecture
- JWT Authentication & Role-Based Access Control (RBAC)
- Capability-Based Authorization
- Structured Logging & Request Tracing
- Entity Auditing & Business Event Tracking
- Scheduled Background Processing
- Cloud Storage Migration Ready Design
- Distributed Inventory Consistency Strategy


## Features ✨

### Identity & Access Management

Provide secure customer authentication and account lifecycle management.

- Account registration and activation by sending activation code via email
- JWT-based authentication
- Role-Based Access Control (RBAC)
- View account profile
- Update account profile

---

### Product Catalog Management

Manage product and category information for customer-facing commerce experiences.

- Create, update, and soft delete categories
- View and list categories with pagination
- Create, update, and soft delete products
- Product publication and unpublication workflows
- Customer-facing purchasable product catalog
- Product discovery with pagination and sorting
- Product-to-inventory association management

---

### Product Media Management

Manage product imagery through a dedicated image management architecture.

- Product image management
- Image variant support
- Storage abstraction layer
- Business-logic-independent storage providers
- Future cloud storage migration support (Amazon S3, Azure Blob Storage, etc.)

---

### Shopping Cart Management

Provide customers with a persistent shopping experience prior to checkout.

- View active shopping cart
- Add products to cart
- Update item quantities
- Remove cart items
- Clear shopping cart

---

### Reservation-Based Workflow

Ensure inventory consistency during customer purchasing workflows.

- Product price validation before order creation
- Inventory availability verification
- Automatic inventory reservation through external IMS
- Overselling prevention
- Distributed inventory consistency
- Detailed unavailable-product feedback
- Order creation only when all requested inventory is reservable

---

### Order Management

Manage the complete customer order lifecycle.

- Place orders from active carts
- Confirm orders
- Cancel eligible orders
- View complete order details
- List customer orders with pagination and sorting
- Order status tracking

---

### Inventory System Integration

Integrate seamlessly with the external Inventory Management System (IMS).

- Inventory availability validation
- Stock reservation workflows
- Reservation confirmation workflows
- Reservation release workflows
- Gateway-based integration architecture
- Anti-corruption layer protection between domains

---

### Scheduled Processing & Automation

Automate operational workflows and system maintenance tasks.

- Expired order cleanup processing
- Reservation lifecycle coordination
- Background business workflow execution

---

### Architecture & Operational Excellence

Provide maintainability, observability, and long-term scalability.

- Modular Monolith Architecture
- Domain-Driven Design (DDD)
- Clean Architecture principles
- Structured logging
- Request tracing
- Entity auditing
- Business event tracking
- Security event tracking
- Exception monitoring



---
<a id="technologies-used"></a>
## Technologies Used 🛠️

### Backend & Framework

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

---

### Database & Persistence

- MySQL
- JPA / Hibernate ORM

---

### Authentication & Authorization

- JWT Authentication
- Role-Based Access Control (RBAC)
- Capability-Based Authorization

---

### API & Documentation

- REST APIs
- OpenAPI 3
- Swagger UI
- SpringDoc OpenAPI

---

### Architecture & Design

- Modular Monolith Architecture
- Domain-Driven Design (DDD)
- Clean Architecture
- Layered Architecture
- Bounded Context Design
- Integration Gateway Pattern
- Anti-Corruption Layer Pattern
- External Inventory Service Integration
- Image Storage Abstraction Layer

---

### Commerce & Order Processing

- Reservation-Based Workflow
- Distributed Inventory Coordination
- Order Lifecycle Management
- Scheduled Order Cleanup Processing
- Product Publication Workflow
- Inventory-Aware Commerce Operations

---

### Observability & Auditing

- SLF4J
- Logback
- Structured JSON Logging
- Request Correlation & Tracing
- Spring Data JPA Auditing
- Business Event Logging
- Security Event Logging

---

### Integration & Communication

- Machine-to-Machine Service Integration
- JWT-Based Service Authentication
- Inventory Management System (IMS) Integration
- REST-Based Inter-Service Communication

---

### Image Management

- File System Storage
- Storage Provider Abstraction
- Multi-Variant Image Support
- Cloud Storage Ready Architecture
- Amazon S3 Migration Ready Design
- Azure Blob Storage Migration Ready Design

---

### Developer Productivity

- Maven
- Lombok
- MapStruct

---

### Email & Notifications

- Java Mail
- Thymeleaf Email Templates

---

### Infrastructure

- Docker
- Docker Compose



---
<a id="entity-relationship-diagram"></a>
## Entity Relationship Diagram 🗄️

The following Entity Relationship Diagram (ERD) represents the core domain model of the E-Commerce Platform, including identity management, product catalog management, category management, image management, shopping cart operations, order processing, and integration with the external Inventory Management System (IMS).

The model illustrates how customers interact with products and carts, how orders progress through their lifecycle, how products are connected to inventory resources managed by IMS, and how image assets are associated with commerce entities while remaining independent from storage implementation details.

![E-Commerce Platform ERD](docs/diagrams/ecommerce-erd.jpg)

---
<a id="system-design-specification"></a>
## System Design Specification 📘

A detailed architectural specification describing the platform architecture, bounded contexts, domain model,  inventory integration architecture, image management architecture, consistency strategies, order lifecycle management, and operational considerations is available below.

📄 [E-Commerce Platform Specification](docs/specifications/ecommerce-platform-specification.pdf)

---
<a id="api-documentation"></a>
## API Documentation 📑

The E-Commerce Platform exposes a fully documented OpenAPI 3 specification covering authentication, category management, product management, shopping cart operations, order management, and commerce-to-inventory integrations.

### Swagger Documentation Previews

- 📷 [Swagger-UI APIs Overview](docs/api/swagger-overview.jpeg)
- 📷 [Authentication APIs](docs/api/authentication.jpeg)
- 📷 [Category Management APIs](docs/api/category-management.jpeg)
- 📷 [Product Management APIs](docs/api/product-management.jpeg)
- 📷 [Cart Management APIs](docs/api/cart-management.jpeg)
- 📷 [Order Management APIs](docs/api/order-management.jpeg)
