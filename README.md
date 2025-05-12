# Examen_Final
Examen Final De Estructura De Datos EDD
# Proyecto AVL Tree en Java
## 📌 Descripcion del Problema
Los arboles AVL son una estructura de datos de tipo arbol binario de busqueda, el cual mantiene un balanceo automaticamente mediante rotaciones.
Este proyecto implementa un **Arbol AVL Dinamico**, permitiendo insertar y eliminar numeros desde la consola, visualizarlos jerarquicamente y garantizar el balanceo en cada operacion.
## 📌 Caracteristicas Del Programa
**La inserccion dinamica de numeros** desde la terminal
**Balanceo Automatico** del árbol AVL después de cada inserción o eliminación.
**Visualizacion de Jerarquias** del arbol en la consola
**Eliminacion de Nodos** ingresados por error
**Opciones interactivas** para mostrar el arbol, reiniciar o continuar la edicion.
## ️️️️️💬 *Explicacion Paso a Paso*
### *Estructura del Codigo*
el proyecto esta dividido en las siguientes clases:
**Node** Representa un nodo del arbol con su valor, hijos y alturas.
**AVL Tree** Define el arbol AVL con las funciones de inserccion, eliminacion, balanceo y visualizacion.
**AVL Main** Contiene la logica de interaccion del usuario.
### *Inserccion de Nodos**
Al momento que el usuario introduce un numero al sistema.
**Buscar la Posicion** Adecuada en el arbol.
**Inserccion de Nodos** Como en un BST normal.
**Calcular el Factor** De balance y de ser necesario aplicar rotaciones.
**Actualizacion de la Altura** Y poscion del nodo.
**Impresion** Del arbol completo en la consola
### **Eliminacion de Nodos**
Si el usuario ingreso un nodo mal, y desea eliminar el numero.
**Buscar el Nodo** Que se desea eliminar.
**Nodo sin Hijos** Su eliminacion en directa.
**Nodo con un Hijo** Se entrelaza y se conecta con el unico hijo con el que contaba el nodo.
**Nodo con dos Hijos** Se realiza un reemplazo del sucesor en orden, es decir, el menor del sub-arbol  al derecho.
**Actualizacion de Altura y Balanceo** Aplicando las rotaciones necesarias, actulizando el nuevo arbol.
**Impresion del Nuevo Arbol**
### **Visualizacion del Arbol**
**Forma Jerrargica** El arbol se presenta de esta forma con ramas y sangrias, permitiendo una presentacion de la estructura.
permitiendo visualizar el arbol completo con la opcion *Presentacion*
### *Operaciones Interactivas**
El usuario puede utilizar diversos comandos como:
**Exit o -1** Esto permitira salir del programa.
**Presentacion** Permite la visualizacion completa del arbol.
**Nuevo** Reinicia el arbol desde cero.
**Eliminar** Permite borrar un nodo especifico que se halla ingresado mal.
**Continuar** Permite seguir editando el arbol sin reiniciarlo.
## 📋 *Ejecucion del Programa*
**Descargar del codigo** El cual cuenta con el nombre *AVLMain*
**Ejecucion del Codigo** En la consola lectora de Java.
**Inicio del Codigo** Donde iniciamos la interaccion con el codigo y el ingreso de nodos.
