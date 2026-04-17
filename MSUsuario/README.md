# 📦 MSUsuario

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Arquitectura](https://img.shields.io/badge/Arquitectura-Hexagonal-orange)
![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)

---

## 🧠 Descripción

Microservicio encargado de la gestión de **Usuarios** dentro del ecosistema.
Implementa Redis, Kafka y CompletableFuture

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
arakamitech.com.msusuario
│
├── domain
│   ├── model
│   │   └── AllTables.java
│   │   └── Rol.java
│   │   └── Usuario.java
│   │
│   ├── port
│   │   ├── in
│   │   │   └── UsuarioUseCase.java
│   │   │
│   │   └── out
│   │       └── NotificacionProducerPort.java
│   │       └── RolRepositoryPort.java
│   │       └── UsuarioRepositoryPort.java
│   │
│   └── service
│       └── FindAllTables.java
│
├── application
│   ├── usecase
│   │   └── UsuarioUseCaseImpl.java
│   │
│   ├── dto
│   │   ├── request
│   │   │   └── UsuarioRequest.java
│   │   │
│   │   └── response
│   │       └── AllTablesResponse.java
│   │       └── Response.java
│   │       └── RolResponse.java
│   │       └── UsuarioResponse.java
│   │
│   └── mapper
│       └── AllTablesMapper.java
│       └── UsuarioMapper.java
│
├── infrastructure
│   ├── adapters
│   │   ├── in
│   │   │   └── rest
│   │   │       └── controller
│   │   │           └── Controller.java
│   │   │
│   │   └── out
│   │       └── persistence
│   │       │   ├── entity
│   │       │   │   └── UsuarioEntity.java
│   │       │   │
│   │       │   ├── repository
│   │       │   │   └── UsuarioRepository.java
│	│		│	├── mapper
│   │       │   │   └── UsuarioPersistenceMapper.java
│   │       │   │
│   │       │   └── adapter
│   │       │       └── UsuarioRepositoryAdapter.java
│   │   	└── rol
│	│           └── persistence
│	│               ├── entity
│	│               │   └── RolEntity.java
│	│               │
│	│               ├── repository
│	│               │   └── RolRepository.java
│	│				├── mapper
│	│               │   └── RolPersistenceMapper.java
│	│               │
│	│               └── adapter
│	│                   └── RolRepositoryAdapter.java
│   │
│   └── config
│       └── AsyncConfig.java
│       └── NotificacionProperties.java
│       └── RedisConfig.java
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
docker build -t msusuario .
```

### 📌 Ejecutar contenedor

```bash
docker run -p 8080:8080 msusuario
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
