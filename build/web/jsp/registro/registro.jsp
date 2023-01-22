<%-- 
    Document   : registrovista
    Created on : 31/05/2019, 10:59:14 AM
    Author     : Brandon
--%>

<%@page import="java.util.Iterator"%>
<%@page import="bean.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="dao.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Bibliotecas</title>
        <link type="text/css" rel="stylesheet" href="<%=ct.urlx%>css/registro/registrovista.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript">
            function anular(e) {
                tecla = (document.all) ? e.keyCode : e.which;
                return (tecla != 13);
            }
        </script>
    </head>



    <body>
        <div class="tab">
            <%@include file="/tab.jsp"%>
        </div>
        <div class="divregistro">
            <section class="main-contenido">
                <div class="contenedor">

                    <div class="fila mg-b">
                        <div class="col-xs-6"> 
                            <h3 class="no-margen">Historial de registro de estudiantes </h3>

                        </div> 
                        <a href="<%=ct.urlx%>jsp/estudiante/addestu.jsp" class="btn btn-info">Añadir Registro</a>
                    </div>             	
                    <div class="col-lg-6">

                        <section class="panel">
                            <header class="panel-encabezado">Buscar registro en historial</header>
                            <div class="panel-body">

                                <form action="../../ListaTotal" class="form-horizontal" method="post" onkeypress="return anular(event)">
                                    <div class="form-grupo">
                                        <label for="inputEmail3" class="col-sm-2 control-label">Buscar</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control ac_input" id="boxbusq" name="search" placeholder="Buscar registro en historial">
                                        </div>    
                                    </div> 
                                    <hr> 
                                </form></div>
                        </section></div> 

                    <div class="fila">
                        
                    </div> 
                    
                    <div>
                        <%= (request.getAttribute("msj")!=null?request.getAttribute("msj"):"") %>
                    </div>

                    <div class="fila">
                        <div class="col-lg-12">
                            <section class="panel">
                                <div class="panel-body">

                                    <div class="col-lg-12">
                                        <section class="panel panel-primario">
                                            <div class="panel-encabezado">Historial de registro

                                            </div>



                                            <table class="table table-hover no-margen" id="tabofi">
                                                <tr id="primtabla">
                                                    <th class="thvis">ID</th>
                                                    <th class="thvis">Nombre</th>
                                                    <th class="thvis">Apellido</th>
                                                    <th class="thvis">Nivel</th>
                                                    <th class="thvis">Grado</th>
                                                    <th class="thvis">Sección</th>
                                                    <th class="thvis">Nombre del Libro</th>
                                                    <th class="thvis">Préstamo</th>
                                                    <th class="thvis">Estado</th>
                                                    <th class="thvis">Acción</th></tr>

                                                <%
                                                    EstudianteDAO edao = new EstudianteDAO();
                                                    for(Estudiante e:edao.ListarEstudiantes()){
                                                %>
                                                <tr >
                                                    <th class="tabofi2"> <%=e.getStudent_id()%></th>
                                                    <th class="tabofi2"> <%=e.getStudent_name()%></th>
                                                    <th class="tabofi2"> <%=e.getStudent_app()%></th>
                                                    <th class="tabofi2"> <%=e.getNivel()%></th>
                                                    <th class="tabofi2"> <%=e.getGrado()%></th>
                                                    <th class="tabofi2"> <%=e.getSeccion()%></th>
                                                    <th class="tabofi2"> <%=e.getBook_name()%></th>
                                                    <th class="tabofi2"> <%=e.getTprest()%></th>
                                                    <th class="tabofi2"> <%=e.getEstado()%></th>
                                                    <th class="tabofi2"> <a id='btnA' href="editar.jsp?cod=<%=e.getStudent_id()%>">Modificar</a>||
                                                                         <a id='btnA' href="../../ActionsRegistro?accion=eliminar&cod=<%=e.getStudent_id()%>">Eliminar</a></th>                                                   
                                                    <%}%>
                                                    
                                                </tr>
                                                <tbody>                   
                                                    <tr>


                                                    </tr>                  


                                                </tbody>
                                                
                                                <div>
                                                    <%= (request.getAttribute("msj")!=null?request.getAttribute("msj"):"") %>
                                                </div>
                                                
                                            </table>

                                        </section> 
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </section>
        </div>

    </body>


    <script>
        $(document).ready(function () {
            $('#boxbusq').keyup(function (event) {

                var nombreVar = $('#boxbusq').val();
                try {
                    $.post('../../ListaTotal', {
                        search: nombreVar
                    }, function (responseText) {
                        $('#tabofi').html(responseText);
                    });

                } catch (e) {
                    alert(e);
                }

            });
        });
    </script>   

</html>
