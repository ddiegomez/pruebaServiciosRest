# Ejemplo de servicios REST con Spring 4
Los requisitos eran crear dos llamadas HTTP (POST y GET)
<ul>
  <li>Listado de facturas de un cliente</li>
  <li>Insertar facturas</li>
</ul>

<h3>Tecnologías y framework usados</h3>
<ul>
  <li>Spring 4</li>
  <li>Maven</li>
  <li>Hibernate 4</li>
  <li>MySQL 5</li>
  <li>Java 8</li>
  <li>IDE Spring Tool Suite</li>
  <li>WizzTools.org REST Client 3.5</li>
</ul>

<h3>Despliege</h3>
Dentro del proyecto se encuentra el fichero <b>create-tables.sql</b> con el script de creación de las tablas.<br/>
En el fichero <b>application.properties</b> se encuentra la configuración de la conexión con la BBDD.<br/>

<h3>Funcionamiento</h3>

<h4>Insertar factura</h4>
<ul>
    <li><b>Ruta</b>: <i>/invoice</i></li>
    <li><b>Método</b>: <i>POST</i></li>
    <li>
        <b>Parametros</b>:<i>JSON</li><br/>
        <code>
            {
                "idCustomer": 1,
                "products": 
                    [
                        {"idProduct: 1, "quantity": 2},
                        {"idProduct: 2, "quantity": 10}
                    ]
            }
        </code>
    </li>
</ul>
<h4>Listado de facturas de un cliente</h4>
<ul>
    <li><b>Ruta</b>: <i>/invoices</i></li>
    <li><b>Método</b>: <i>GET</i></li>
    <li><b>Parametros</b>: <i>customerId</li><br/></li>
</ul>
