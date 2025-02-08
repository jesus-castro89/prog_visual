# Los botones en SWING

Los botones son componentes gráficos fundamentales en las interfaces de usuario, ya que permiten a los usuarios
interactuar con el programa mediante la realización de acciones al hacer clic en ellos. En Java, los botones se pueden
crear y personalizar utilizando la biblioteca SWING, que proporciona clases y métodos para trabajar con componentes
gráficos.

## Agregando botones a una ventana

Para crear botónes en nuestra interfaz desde IntelliJ IDEA, primero debemos crear un nuevo proyecto de Java y una nueva
ventana desde el editor de diseño. Luego, podemos arrastrar y soltar un botón desde la paleta de componentes a la
ventana, lo que creará un nuevo botón en la interfaz.

![button_1.png](button_1.png)

Como puedes notar, en nuestra paleta de componentes tenemos un botón que podemos arrastrar y soltar en nuestra ventana.

## Personalizando un botón

Una vez que hemos agregado un botón a nuestra ventana, podemos personalizarlo cambiando su texto, tamaño, color y
otros atributos. Para ello, podemos seleccionar el botón en el editor de diseño y modificar sus propiedades en la
ventana de propiedades.

![button_2](button_2.png)

> **Nota:** Si cambiamos el texto del botón, es posible que se actualize automáticamente el nombre del componente en la
> clase. Por lo que si esto sucede, deberemos cambiar el nombre del componente en la clase y la vista de diseño para
> mantener la consistencia.

## Manejando eventos de botón

Una vez que hemos agregado y personalizado un botón, podemos manejar eventos de clic en el botón para realizar acciones
específicas.

Para ellos seguiremos los siguientes pasos:

1. Seleccionamos el botón en el editor de diseño.
2. Hacemos clic derecho sobre el botón y seleccionamos `Create Listener`
    - ![button_3.png](button_3.png)
3. Seleccionamos el evento que queremos manejar, por ejemplo `ActionListener`.
    - ![button_4.png](button_4.png)
    - Esto abrirá la siguiente ventana en la que deberemos de seleccionar el método que se ejecutará al hacer clic en el
      botón. Por defecto, se selecciona `actionPerformed`. Hacemos clic en `OK`.
    - ![button_5.png](button_5.png)
4. Se creará un nuevo método en la clase que manejará el evento del botón. Podemos agregar el código necesario para
   realizar la acción deseada dentro de este método.
    - El código generado por IntelliJ IDEA será similar al siguiente:
      ```java
         button1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 
             }
         });
      ```
5. Ahora puedes que deseas ejecutar al hacer clic en el botón dentro del método `actionPerformed`.
6. Finalmente, ejecutamos la aplicación y verificamos que la acción se realice correctamente al hacer clic en el botón.
7. ¡Listo! Has creado un botón y has manejado un evento de clic en Java.

## Conclusión

Los botones son componentes esenciales en las interfaces de usuario, ya que permiten a los usuarios interactuar con el
programa de manera sencilla y directa. Al aprender a crear y personalizar botones en Java, podrás mejorar la
interactividad de tus aplicaciones y proporcionar a los usuarios una experiencia más intuitiva y agradable.