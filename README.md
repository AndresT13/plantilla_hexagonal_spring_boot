# plantilla_hexagonal_spring_boot

Este proyecto es una plantilla básica de un API REST con Spring Boot utilizando Arquitectura Hexagonal. Aquí se incluyen endpoints para crear, actualizar, obtener, eliminar usuarios, y consultar usuarios por número de documento.

Endpoints de la API
1. Crear un nuevo usuario
Método: POST
URL: /api/user
Cuerpo de la solicitud (JSON):

{
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0100",
  "address": "123 Elm Street",
  "city": "Springfield"
}

Respuesta (Código 201):
{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0100",
  "address": "123 Elm Street",
  "city": "Springfield"
}

2. Actualizar un usuario
Método: PUT
URL: /api/user/{id}
Cuerpo de la solicitud (JSON):

{
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}
Respuesta (Código 200):

{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}

Claro, te ayudo a crear un archivo README.md que incluya las peticiones de prueba de Postman para tu API en Spring Boot. Aquí te dejo un ejemplo de cómo podrías estructurarlo:

Plantilla Spring Boot - Arquitectura Hexagonal
Este proyecto es una plantilla básica de un API REST con Spring Boot utilizando Arquitectura Hexagonal. Aquí se incluyen endpoints para crear, actualizar, obtener, eliminar usuarios, y consultar usuarios por número de documento.

Endpoints de la API
1. Crear un nuevo usuario
Método: POST
URL: /api/user
Cuerpo de la solicitud (JSON):

json
Copiar
{
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0100",
  "address": "123 Elm Street",
  "city": "Springfield"
}
Respuesta (Código 201):

json
Copiar
{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0100",
  "address": "123 Elm Street",
  "city": "Springfield"
}
2. Actualizar un usuario
Método: PUT
URL: /api/user/{id}
Cuerpo de la solicitud (JSON):

json
Copiar
{
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}
Respuesta (Código 200):

json
Copiar
{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}
3. Obtener un usuario por ID
Método: GET
URL: /api/user/{id}

Respuesta (Código 200):

{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}

Claro, te ayudo a crear un archivo README.md que incluya las peticiones de prueba de Postman para tu API en Spring Boot. Aquí te dejo un ejemplo de cómo podrías estructurarlo:

Plantilla Spring Boot - Arquitectura Hexagonal
Este proyecto es una plantilla básica de un API REST con Spring Boot utilizando Arquitectura Hexagonal. Aquí se incluyen endpoints para crear, actualizar, obtener, eliminar usuarios, y consultar usuarios por número de documento.

Endpoints de la API
1. Crear un nuevo usuario
Método: POST
URL: /api/user
Cuerpo de la solicitud (JSON):

json
Copiar
{
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0100",
  "address": "123 Elm Street",
  "city": "Springfield"
}
Respuesta (Código 201):

json
Copiar
{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0100",
  "address": "123 Elm Street",
  "city": "Springfield"
}
2. Actualizar un usuario
Método: PUT
URL: /api/user/{id}
Cuerpo de la solicitud (JSON):

json
Copiar
{
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}
Respuesta (Código 200):

json
Copiar
{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}
3. Obtener un usuario por ID
Método: GET
URL: /api/user/{id}

Respuesta (Código 200):

json
Copiar
{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}
4. Obtener todos los usuarios
Método: GET
URL: /api/user

Respuesta (Código 200):

[
  {
    "id": 11,
    "documentType": "ID",
    "numberDocument": 10000011,
    "firstName": "John",
    "secondName": "Doe",
    "numberPhone": "555-0101",
    "address": "456 Oak Street",
    "city": "Shelbyville"
  },
  {
    "id": 12,
    "documentType": "ID",
    "numberDocument": 10000012,
    "firstName": "Jane",
    "secondName": "Doe",
    "numberPhone": "555-0102",
    "address": "789 Pine Street",
    "city": "Springfield"
  }
]

5. Eliminar un usuario
Método: DELETE
URL: /api/user/{id}

Respuesta (Código 204):

No hay cuerpo en la respuesta. Solo el código 204 No Content.

6. Buscar un usuario por número de documento
Método: GET
URL: /api/user/document/{numberDocument}

Respuesta (Código 200):

{
  "id": 11,
  "documentType": "ID",
  "numberDocument": 10000011,
  "firstName": "John",
  "secondName": "Doe",
  "numberPhone": "555-0101",
  "address": "456 Oak Street",
  "city": "Shelbyville"
}


