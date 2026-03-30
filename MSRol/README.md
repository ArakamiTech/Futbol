# 📦 MSRol

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Arquitectura](https://img.shields.io/badge/Arquitectura-Hexagonal-orange)
![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)

---

## 🧠 Descripción

Microservicio encargado de la gestión de **Roles** dentro del ecosistema.

Implementado bajo **Arquitectura Hexagonal (Ports & Adapters)** para garantizar:

* Bajo acoplamiento
* Alta mantenibilidad
* Escalabilidad
* Facilidad de pruebas

---

## 🚀 Ejecución

Ejecuta el proyecto como aplicación de Spring Boot:

```bash
./mvnw spring-boot:run
```

o desde tu IDE como **Spring Boot App**

---

## 🧱 Arquitectura Hexagonal

```text
arakamitech.com.msrol
│
├── domain
│   ├── model
│   │   └── Rol.java
│   │
│   ├── port
│   │   ├── in
│   │   │   └── RolUseCase.java
│   │   │
│   │   └── out
│   │       └── RolRepositoryPort.java
│   │
│   └── service
│       └── RolDomainService.java
│
├── application
│   ├── usecase
│   │   └── RolUseCaseImpl.java
│   │
│   ├── dto
│   │   ├── request
│   │   │   └── RolRequest.java
│   │   │
│   │   └── response
│   │       └── RolResponse.java
│   │
│   └── mapper
│       └── RolMapper.java
│
├── infrastructure
│   ├── adapters
│   │   ├── in
│   │   │   └── rest
│   │   │       └── controller
│   │   │           └── RolController.java
│   │   │
│   │   └── out
│   │       └── persistence
│   │           ├── entity
│   │           │   └── RolEntity.java
│   │           │
│   │           ├── repository
│   │           │   └── RolJpaRepository.java
│	│			├── mapper
│   │           │   └── RolPersistenceMapper.java
│   │           │
│   │           └── adapter
│   │               └── RolRepositoryAdapter.java
│   │
│   └── config
│       └── BeanConfiguration.java
│
└── shared
    ├── exception
    ├── util
    └── constants
```

---

## 🔄 Flujo de la aplicación

```text
Controller → UseCase → Domain → Port → Adapter → DB
```

---

## 📡 API (Swagger)

Una vez ejecutado el proyecto, puedes acceder a la documentación:

```
http://localhost:8080/swagger-ui.html
```

o

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🐳 Docker

### 📌 Construir imagen

```bash
docker build -t msrol .
```

### 📌 Ejecutar contenedor

```bash
docker run -p 8080:8080 msrol
```

---

## 🧪 Buenas prácticas implementadas

* Separación de capas (Hexagonal)
* Dominio independiente de frameworks
* Uso de DTOs para entrada/salida
* Mapeo entre capas
* Uso de puertos y adaptadores

---

## 👨‍💻 Autor

Cristhian Torres - ArakamiTech

---

## 🎥 Twitch

https://www.twitch.tv/arakamitech

---

## 📄 Licencia

Software libre. Úsalo como quieras.
