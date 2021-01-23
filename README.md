# Algoritmo_Criptografico
¿Qué es el cifrado?
El cifrado es un proceso que transforma la información original en una forma irreconocible. Esta nueva forma del mensaje es completamente diferente del mensaje original. Es por eso que un pirata informático no puede leer los datos, ya que los remitentes utilizan un algoritmo de cifrado. El cifrado generalmente se realiza mediante algoritmos clave.
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/procesocifrado.png
Los datos están encriptados para evitar robos. Sin embargo, muchas empresas conocidas también cifran datos para mantener su secreto comercial frente a sus competidores.
¿Qué es el descifrado?
El descifrado i es un proceso de conversión de datos codificados / encriptados en una forma que es fácil de leer y entendido por un humano o un ordenador. Este método se realiza descifrando el texto manualmente o utilizando claves que se utilizan para cifrar los datos originales.
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/procesodesifrado.png
¿Y qué es el método de criptografía Blowfish?
Blowfish es un método de cifrado que es un arma muy potente contra los piratas informáticos y los ciberdelincuentes. Se utiliza en una amplia gama de productos, incluidas algunas herramientas seguras de cifrado de correo electrónico, software de respaldo, herramientas de administración de contraseñas y TiVo.
Blowfish fue desarrollado en 1993 por Bruce Schneier. Es un cifrado de bloque simétrico . Qué significa eso? Bueno, es simétrico porque se usa la misma clave tanto para el cifrado como para el descifrado; la clave debe mantenerse en secreto para todos los demás, excepto el remitente y el receptor.
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/simetrico.png
Un cifrado en bloque es básicamente una rutina de computadora que toma cualquier cantidad de texto sin formato y lo convierte en texto codificado o texto cifrado . Realiza esta rutina en fragmentos de texto llamados bloques . Y para que el texto se decodifique en el otro lado de la transmisión, la función también debe generar una clave para desbloquear el texto cifrado.
¡¡Empecemos!!
Lo primero que debe hacer es importar la biblioteca de acuerdo con la imagen a continuación:
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/bibliotecas.png
así que a continuación, haga una cadena de "clave" para el proceso de cifrado y descifrado, asegúrese de que cuando haga esta "clave" nadie lo sepa 🤫:
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/key.png
después de crear una clave y luego crear un proceso de clase de cifrado para cifrar los datos:
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/encrypt.png
y crear un proceso de clase de descifrado también:
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/decrypt.png
Finalmente, puede probar su proceso de cifrado y descifrado:
https://raw.githubusercontent.com/CarlosFranTorresMartinez/Algoritmo_Criptografico/blowfish/asset/main.png
