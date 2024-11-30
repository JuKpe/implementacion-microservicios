
# Sistema de Gestión de Pedidos y Clientes

## Descripción del Proyecto
Un sistema compuesto por dos microservicios:

1. Servicio de Clientes (Customer Service):
* Gestiona la información de los clientes.
* Usa MySQL como base de datos relacional para almacenar los datos estructurados de los clientes.
* Exponerá endpoints RESTful para:
    * Crear y listar clientes.

2. Servicio de Pedidos (Order Service):
* Gestiona los pedidos de los clientes.
* Usa MongoDB como base de datos NoSQL para almacenar los pedidos, ya que estos pueden tener estructuras más dinámicas.
* Exponerá endpoints para:
    * Crear, listar y buscar pedidos por cliente.
* Comunicarse con el Customer Service para validar la existencia de clientes antes de crear un pedido.


## Arquitectura

- Spring Boot para cada microservicio.
- Base de datos MySQL para el microservicio de clientes.
- Base de datos MongoDB para el microservicio de pedidos.
- Eureka Server para registro de servicios.
- Eureka Dicovery client
- Spring Cloud Config para gestionar propiedades externas 
- Config client
- Cloud bootstrap
- Spring boot actuator
- HashiCorp Vault para almacene información sensible.
- Spring Cloud OpenFeign para comunicación entre microservicios.
- Spring Cloud Gateway para crear un API Gateway para centralizar las peticiones.
- Spring Cloud Bus para enlaza los microservicios  con un Broker de mensajes
- Broker de mensajes: RabbitMQ 
- Spring Cloud Circuit Breaker para el manejo de errores implementado con Resilience4J


