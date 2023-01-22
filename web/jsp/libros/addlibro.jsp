<%-- 
    Document   : addlibro
    Created on : 04/06/2019, 05:54:45 PM
    Author     : Brandon
--%>

<%@page import="bean.Autor"%>
<%@page import="dao.AutorDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="bean.Categoria"%>
<%@page import="dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Bibliotecas</title>
        <link rel="stylesheet" href="<%=ct.urlx%>css/libros/libadd.css" type="text/css">
        <script type="text/javascript">
            function validateForm() {
                var x = document.forms["myForm"]["book_title"].value;
                if (x === null || x === "") {
                    alert("Por favor, ingrese el título del libro");
                    return false;
                }
                var x = document.forms["myForm"]["category_name"].value;
                if (x === null || x === "") {
                    alert("Por favor, ingrese la catergoría del libro");
                    return false;
                }
            }
        </script>


        <script type="text/javascript" >
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
        <div id="añadirdiv">

            <div id="texto1">
                <h3 id="h3add">Añadir Libro</h3>
            </div>

            <div id="formudiv">
                <section id="panelsect">
                    <header id="panelheadxd">Formulario</header>
                    <div id="formok">
                        <form action="../../AddLibro2" method="post" name="myForm" onsubmit="return validateForm()" onkeypress="return anular(event)">
                            <input type="hidden" name="accion" value="AgregarAlumno">
                            <div class="divcaja">
                                <label class="label_1">Título del Libro*</label>                           
                                <div class="cajadtext">
                                    <input class="iprellead" id="book_title" type="text" placeholder="Título del Libro" name="book_title">
                                </div>                     
                            </div>
                            <hr>


                            <div class="divcaja">
                                <label  class="label_1">Categoría*</label>                           
                                <div class="cajadtext">
                                    <select class="iprellead"  name="category_name">

                                        <%
                                            CategoriaDAO cadao = new CategoriaDAO();
                                            /*List<Categoria> list = cadao.ListarCategoria();
                                            Iterator<Categoria> iter = list.iterator();
                                            Categoria cat = null;

                                            while (iter.hasNext()) {
                                                lir = iter.next();      */
                                            for(Categoria cat:cadao.ListarCategoria()){
                                        %>
                                            <option><%= cat.getCategory_name() %></option>
                                            <%}%>
                                    </select>
                                </div>                     
                            </div>
                            <hr>

                            <div class="divcaja">
                                <label class="label_1">Autor</label>                           
                                <div class="cajadtext">
                                    <select class="iprellead" name="autor" data-parsley-required="true" data-parsley-trigger="change">
                                        <%
                                            AutorDAO adao = new AutorDAO();
                                            for(Autor aut:adao.ListarAutores()){
                                        %>
                                        <option><%=aut.getAutor_name()%><%}%></option>
                                    </select>
                                </div>                     
                            </div>
                            <hr>

                            <div class="divcaja">
                                <label class="label_1">Editorial</label>                           
                                <div class="cajadtext">
                                    <input class="iprellead" type="text" placeholder="Editorial" name="editorial">
                                </div>                     
                            </div>
                            <hr>

                            <div class="divcaja">
                                <label class="label_1">Edición</label>                           
                                <div class="cajadtext">
                                    <input class="iprellead" type="text" placeholder="Edición" name="edicion">
                                </div>                     
                            </div>
                            <hr>

                            <div class="divcaja">
                                <label class="label_1">Volumen</label>                           
                                <div class="cajadtext">
                                    <input class="iprellead" type="text" placeholder="Volumen" name="volumen">
                                </div>                     
                            </div>
                            <hr>


                            <div class="divcaja">
                                <label class="label_1">ISBN</label>                           
                                <div class="cajadtext">
                                    <input class="iprellead" type="text" placeholder="ISBN" name="isbn">
                                </div>                     
                            </div>

                            <hr>

                            <div class="divcaja">
                                <label class="label_1">Idioma</label>                           
                                <div class="cajadtext">
                                    <input class="iprellead" type="text" placeholder="Idioma" name="idioma">
                                </div>                     
                            </div>

                            <div class="divcaja">
                                <label class="label_1">Descripción</label>                           
                                <div class="cajadtext">
                                    <textarea id="iprellead2" placeholder="Descripción" name="descrip"></textarea>
                                </div>                     
                            </div>
                            <hr>

                            <div class="divbtnlibro">
                                <input id="btnaddok" type="submit" name="accion" value="Registrar">

                            </div>


                        </form>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
