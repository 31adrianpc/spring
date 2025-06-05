/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(
    function(){
        $.ajax({
                url:'api/v1/personas',
                type: 'GET',
                success: function (result) {
                            let lista=null;
                            if(Array.isArray(result)){
                                lista=result;
                            }else{
                                lista=JSON.parse(result);
                            }

                            let tabla ="";

                            lista.forEach(function (usuario){
                                tabla=tabla+"<tr>";
                                tabla=tabla+"<td>"+usuario.user+"</td>";
                                tabla=tabla+"<td>"+usuario.password+"</td>";
                                tabla=tabla+"<td>"+usuario.nombreApellido+"</td>";
                                if(usuario.foto!=null){
                                    tabla=tabla+"<td><img width='50px' height='50px'  src='data:image/jpeg;base64, "+ usuario.fotoBase64+"'/></td>";
                                }else{
                                    tabla=tabla+"<td></td>";
                                }
                                tabla=tabla+"<td>"+"<a class='btn btn-danger' href='eliminarUsuario?idUsuario="+usuario.idUsuario+"'>"
                                                    +"<i class='bi bi-trash'></i>"
                                                  +"</a>"
                                                  +"<a class='btn btn-warning'>"
                                                    +"<i class='bi bi-arrow-clockwise'></i>"
                                                  +"</a>"
                                           +"</td>";
                            });                                        
                            $("#tbodyPersonas").html(tabla);
                         }
                });
});
