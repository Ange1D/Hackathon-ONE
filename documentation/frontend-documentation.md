
# Documentación Frontend

1. [Maquetación del proyecto](#1-maquetación-del-proyecto)  
2. [Requisitos del proyecto](#2-requisitos-del-proyecto)  
3. [Creación del proyecto](#3-creación-del-proyecto) 
4. [Dependencias del proyecto](#4-dependencias-del-proyecto) 
5. [Estructura del proyecto](#5-estructura-del-proyecto) 

## 1. Maquetación del proyecto

La maquetación del proyecto fue creada usando [Figma](https://www.figma.com).

![Imagen de la maquetación del proyecto en móvil](./images/frontend/figma/mobile.jpg)

![Imagen de la maquetación del proyecto en escritorio](./images/frontend/figma/desktop.jpg)

## 1. Requisitos del proyecto

[Node.js](https://nodejs.org/en/download/package-manager)  

## 3. Creación del proyecto

El proyecto fue creado usando [Vite](https://vitejs.dev/) con el siguiente comando:

```sh
npm create vite@latest frontend -- --template react
```
## 4. Dependencias del proyecto

El proyecto se crea con las siguientes dependencias:

- **react**: Es una biblioteca de JavaScript utilizada para construir interfaces de usuario interactivas y reutilizables. React permite crear componentes reutilizables que se actualizan de manera eficiente cuando cambia el estado de la aplicación.
- **react-dom**: Es una biblioteca específica de React que se utiliza para renderizar componentes de React en el navegador. React DOM proporciona métodos para montar y actualizar componentes de React en el DOM (Document Object Model). Es una dependencia necesaria cuando se trabaja con React en aplicaciones web.

Adicionalmente se agregaron:

- **axios**: Es una biblioteca basada en promesas que se utiliza para realizar solicitudes HTTP en aplicaciones web. Se utiliza comúnmente para realizar solicitudes a una API o para interactuar con un servidor. Proporciona una interfaz fácil de usar para realizar solicitudes HTTP y manejar las respuestas de manera eficiente.
- **react-router-dom**: Es una biblioteca que se utiliza para manejar la navegación en aplicaciones de React. Proporciona componentes y utilidades para definir rutas y enlaces en una aplicación de React.


## 5. Estructura del proyecto

- **\public\images**: Esta carpeta se encuentra en la raíz del proyecto y se utiliza para almacenar imágenes que se utilizarán en la aplicación. Los archivos colocados en esta carpeta estarán disponibles públicamente y se pueden acceder a ellos directamente desde la URL de la aplicación.
- **\src**: Esta carpeta también se encuentra en la raíz del proyecto y es donde se encuentra la mayor parte del código fuente de la aplicación. Aquí es donde se desarrollan los componentes, servicios y otros archivos relacionados con la lógica de la aplicación.
- **\src\components**: Esta carpeta se utiliza para almacenar los componentes de React reutilizables que se utilizan en la aplicación. Al organizar los componentes en esta carpeta, se facilita su búsqueda y mantenimiento.
- **\src\services**: Esta carpeta se utiliza para almacenar servicios o utilidades que se utilizan en la aplicación. Los servicios pueden incluir funciones o clases que se utilizan para realizar tareas específicas, como realizar solicitudes HTTP, manejar el estado global de la aplicación, autenticación, etc. Al organizar los servicios en esta carpeta, se facilita su reutilización y mantenimiento.

3. **Dependencias del proyecto:**
    - `axios`
    - `react` y `react-dom`
    - `react-router-dom`

4. **Dependencias de desarrollo:**
    - `@types/react` y `@types/react-dom`
    - `@vitejs/plugin-react`
    - `eslint`, `eslint-plugin-react`, `eslint-plugin-react-hooks` y `eslint-plugin-react-refresh`
    - `vite`


5. **`frontend/public/images`:** Esta carpeta almacena las imágenes de fondo y otros recursos visuales utilizados en la aplicación.

6. **`frontend/src/components`:** Aquí se encuentran los componentes principales de tu aplicación. Cada carpeta contiene un archivo `index.jsx` (que define el componente) y su respectivo archivo CSS.

    - `footer`
    - `home`
    - `login`
    - `myProfile`
    - `nav`
    - `newTeam`
    - `notFound`
    - `register`
    - `teamCreated`
    - `teamDetails`
    - `teamFinder`

### Script de autenticacion `{frontend\src\services\authService.js}`

7. **`register(username, password)`**:
   - Esta función realiza una solicitud HTTP POST al endpoint `${API_URL}/user` para registrar un nuevo usuario.
   - Toma dos parámetros: `username` (nombre de usuario) y `password` (contraseña).
   - Devuelve una promesa que se resuelve con la respuesta del servidor.

8. **`login(username, password)`**:
   - Realiza una solicitud HTTP POST al endpoint `${API_URL}/login` para iniciar sesión.
   - También toma dos parámetros: `username` y `password`.
   - Después de recibir la respuesta del servidor, verifica si contiene un token de acceso.
   - Si hay un token, lo almacena en el almacenamiento local (`localStorage`) y devuelve los datos de la respuesta.

9. **`logout()`**:
   - Elimina el token de acceso almacenado en el almacenamiento local, lo que equivale a cerrar la sesión del usuario.

10. **`getCurrentUser()`**:
   - Obtiene el token de acceso del almacenamiento local.
   - Si no hay un token, devuelve `null`.
   - Si hay un token, intenta decodificarlo para obtener información sobre el usuario (como el nombre de usuario y la contraseña).
   - Si la decodificación tiene éxito, devuelve un objeto con el token, el nombre de usuario y la contraseña. De lo contrario, también devuelve `null`.

11. **`getAuthHeader()`**:
   - Devuelve un objeto que contiene el encabezado de autorización (`Authorization`) con el token de acceso.
   - Si no hay un token, devuelve un objeto vacío.

