# 📦 MSNotificaciones

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Arquitectura](https://img.shields.io/badge/Arquitectura-Hexagonal-orange)
![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)

---

## 🧠 Descripción

Microservicio encargado del envio por email de las notificaciones cuando se crea y actualiza un usuario

Implementado con:

* Kafka Consumer
* JavaMailSender

---

## 🚀 Ejecución

Ejecuta el proyecto como aplicación de Spring Boot:

```bash
./mvnw spring-boot:run
```

o desde tu IDE como **Spring Boot App**

---

## 🧱 Arquitectura

```text
arakamitech.com.msnotificaciones
│
├── domain
│   ├── model
│   │   └── Notificacion.java
│   │
│   ├── port
│       ├── in
│       │   └── NotificationUsecase.java
│       │
│       └── out
│           └── EmailSender.java
│
├── application
│   ├── usecase
│       └── NotificationUseCaseImpl.java
│
├── infrastructure
    ├── email
    │   ├── EmailSenderImpl.java
    │
    └── messaging
        └── NotificacionConsumer.java
```

---

## 🔄 Flujo de la aplicación

```text
NotificacionConsumer → NotificationUsecase → NotificationUseCaseImpl → EmailSender → EmailSenderImpl
```

---

## 🐳 Docker

### 📌 Construir imagen

```bash
docker build -t msnotificaciones .
```

### 📌 Ejecutar contenedor

```bash
docker run -p 8080:8080 msnotificaciones
```

---

## 🧪 Buenas prácticas implementadas

* Separación de capas (Hexagonal Simple)
* Dominio independiente de frameworks
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
