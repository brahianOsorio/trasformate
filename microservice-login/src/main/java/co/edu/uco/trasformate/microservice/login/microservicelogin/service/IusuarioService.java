package co.edu.uco.trasformate.microservice.login.microservicelogin.service;

import co.edu.uco.trasformate.microservice.login.microservicelogin.entitys.usuario;

import java.util.List;

public interface IusuarioService {
    List<usuario> listarTodosLosUsuarios ();
    usuario encontrarUsuarioPorNombre(String nombre);
    void save(usuario usuario);

    boolean validarLogin (String nombre, String contraseña);
    boolean validarUsuario (String nombre);

    boolean validarContraseña(String contraseña);



}
