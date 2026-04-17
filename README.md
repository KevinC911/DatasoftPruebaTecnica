# Prueba técnica de Datasoft



Hola, esta es mi solución para la prueba que me entregaron.



## Tecnologías

- SpringBoot (Java 25)

- Vite con Reactjs (Typescript)

- PostgreSQL



## Anotaciones

- La contraseña **está encriptada** por lo que en el caso de ingresar los datos del usuario, tiene que hacerse por medio de la API, los datos que yo usé fueron estos:
`{
	"id": 1,
	"full_name": "Angel Martinez",
	"username": "angelmar999",
	"passwd": "angelmartinez@",
	"state": "ACT"
}

{
	"id": 2,
	"full_name": "Maria Teresa",
	"username": "maresa101",
	"passwd": "mariateresa@",
	"state": "ACT"
}

{
	"id": 3,
	"full_name": "Mario Antonio",
	"username": "marian404",
	"passwd": "marioantonio@",
	"state": "ACT"
}`

- Los cambios a la conexión de la base se pueden hacer a través de application.properties del Spring Boot.

- Hay añadir un .env al Frontend de React.js, tiene una variable con `VITE_API_URL`para la URL de la API, por ejemplo en mi caso yo puse: `VITE_API_URL=http://localhost:8080/api`

