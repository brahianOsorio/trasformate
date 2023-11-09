package co.edu.uco.trasformate.microservice.register.microserviceregister.service;

import co.edu.uco.trasformate.microservice.register.microserviceregister.entitys.usuario;

import java.util.List;

public interface IusuarioService {
    List<usuario> listarTodosLosUsuarios ();
    usuario encontrarUsuarioPorNombre(String nombre);
    void save(usuario usuario);

    boolean validarLogin (String nombre, String contraseña);
    boolean validarUsuario (String nombre);

    boolean validarContraseña(String contraseña);

    public boolean validarUnicoUsuario(String nombre);

    void guardarUsuarioEnLogin(usuario user);

}
