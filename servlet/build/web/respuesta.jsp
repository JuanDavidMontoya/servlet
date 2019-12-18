<%-- 
    Document   : respuesta
    Created on : 14/11/2018, 08:33:11 PM
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado del Parcial Punto 2</title>
    </head>
    <body>
            <h1>Los Valores Son : </h1>
                <label class="form-group">Moda : </label>
                <input type="text" name="nombre" value="<%=request.getParameter("moda")%>"/><br><br>    

                <label class="form-group">Media : </label>
                <input type="text" name="nombre" value="<%=request.getParameter("media")%>"/><br><br>

            <input type="submit" value="Regresar" onclick="location = 'index.jsp'" />
    </body>
</html>
