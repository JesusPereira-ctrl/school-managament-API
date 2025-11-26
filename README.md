# 📘 Gestión de Clases – Backend Spring Boot

## 🏛️ Arquitectura del Proyecto

Este proyecto sigue una **Arquitectura en Capas (Layered Architecture)** para garantizar mantenibilidad, escalabilidad y claridad en la separación de responsabilidades.

```
[ Controller ] → [ Service ] → [ Repository ] → [ Entity ] → [ DB ]
                         ↑
                    [ DTOs ]
```

### ✔ Capa de Presentación — Controllers  
- Manejan las solicitudes HTTP.  
- Validan Request DTOs.  
- Retornan Response DTOs.  
- No contienen lógica de negocio.

### ✔ Capa de Aplicación — Services  
- Contienen la lógica de negocio.  
- Coordinan repositorios y reglas del dominio.  
- Transforman entidades ↔ DTOs.

### ✔ Capa de Persistencia — Repositories  
- Interactúan directamente con la base de datos.  
- Exponen operaciones CRUD.  
- No contienen reglas de negocio.

### ✔ Capa de Dominio — Entities  
- Definen el modelo del sistema.  
- Contienen relaciones JPA (OneToMany, ManyToOne, JoinColumn, etc).  
- Incluyen auditoría mediante una clase embebida (`Audit`).

### ✔ DTOs — Request & Response  
- Request DTOs validan datos de entrada.  
- Response DTOs definen datos expuestos en la API.  
- Evitan exponer entidades directamente.

### ✔ Gestión de Excepciones  
- Manejada mediante `@RestControllerAdvice`.  
- Respuestas homogéneas para errores 404, 400, etc.

### ✔ Configuración  
- OpenAPI/Swagger para documentación automática.  
- Configuración de CORS y perfiles.

---

## ▶️ Cómo correr la aplicación

### **1. Instalar PostgreSQL**
Asegúrate de tener instalado **PostgreSQL 16+**.

- Crea un usuario con permisos (o usa el predeterminado `postgres`).
- Recuerda tu contraseña para configurarla en el proyecto.

---

### **2. Crear la base de datos**

```sql
CREATE DATABASE school_management;
```

> ⚠️ Debe coincidir con el nombre configurado en `application-dev.properties`.

---

### **3. Configurar `application-dev.properties`**

Archivo ubicado en:

```
src/main/resources/application-dev.properties
```

Configura:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/school_management
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.sql.init.mode=always
spring.sql.init.encoding=UTF-8
```

- `ddl-auto=create` creará automáticamente todas las tablas.  
- `data.sql` insertará datos iniciales en cada arranque del proyecto.

---

### **4. Ejecutar la aplicación**

#### ✔ Desde el IDE (VSCode / IntelliJ)
Ejecuta:

```
GestionClasesApplication.java
```

#### ✔ Desde consola

```bash
mvn spring-boot:run
```

---

### **5. Acceder a Swagger**

Una vez levantada la aplicación:

👉 **Swagger UI:**  
```
http://localhost:8080/api/v1/swagger-ui/index.html
```

---

## 📁 Estructura del Proyecto

```
gestion-clases/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/colegio/gestion_clases/
│   │   │       ├── GestionClasesApplication.java
│   │   │       │
│   │   │       ├── config/
│   │   │       │   ├── SchemasSwaggerConfig.java
│   │   │       │   └── WebConfig.java
│   │   │       │
│   │   │       ├── controllers/
│   │   │       │   ├── StudentController.java
│   │   │       │   ├── TeacherController.java
│   │   │       │   ├── SubjectController.java
│   │   │       │   ├── NoteController.java
│   │   │       │   └── SchoolClassController.java
│   │   │       │
│   │   │       ├── exceptions/
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       │
│   │   │       ├── models/
│   │   │       │   ├── entities/
│   │   │       │   │   ├── Student.java
│   │   │       │   │   ├── Teacher.java
│   │   │       │   │   ├── Subject.java
│   │   │       │   │   ├── Note.java
│   │   │       │   │   ├── SchoolClass.java
│   │   │       │   │   └── embeddable/
│   │   │       │   │       └── Audit.java
│   │   │       │   │
│   │   │       │   ├── dtos/
│   │   │       │   │   ├── request/
│   │   │       │   │   └── response/
│   │   │       │
│   │   │       ├── repositories/
│   │   │       │   ├── StudentRepository.java
│   │   │       │   ├── TeacherRepository.java
│   │   │       │   ├── SubjectRepository.java
│   │   │       │   ├── NoteRepository.java
│   │   │       │   └── SchoolClassRepository.java
│   │   │       │
│   │   │       ├── services/
│   │   │       │   └── (interfaces e implementaciones)
│   │   │       │
│   │   │       └── services/impl/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   │
│   └── test/
│
└── pom.xml
```

---

## 🚀 Tecnologías Utilizadas

### **Backend**
- Java 21  
- Spring Boot 4  
- Spring Web (REST API)  
- Spring Data JPA / Hibernate  
- Jakarta Bean Validation  

### **Base de Datos**
- PostgreSQL 16+  
- HikariCP  

### **Documentación**
- Springdoc OpenAPI 2  
- Swagger UI  

### **Herramientas**
- Maven  
- Git / GitHub  
- VSCode / IntelliJ IDEA  
