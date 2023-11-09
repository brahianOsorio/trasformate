package co.edu.uco.trasformate.microservice.register.microserviceregister.service;


import co.edu.uco.trasformate.microservice.register.microserviceregister.client.userClient;
import co.edu.uco.trasformate.microservice.register.microserviceregister.entitys.usuario;
import co.edu.uco.trasformate.microservice.register.microserviceregister.persistance.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioServiceImpl implements IusuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

/*esta variable se crea con el objetivo de apuyar en la validacion de un usuario en el caso de que sea nulo */
    usuario aux ;

    @Autowired
    private userClient userClient;

    @Override
    public List<usuario> listarTodosLosUsuarios() {
        return (List<usuario>) usuarioRepository.findAll();
    }

    @Override
    public usuario encontrarUsuarioPorNombre(String nombre) {
       try {
           /*cargamos aux */
           aux = usuarioRepository.buscarUsuarioPorNombre(nombre);

           if (aux == null){
               aux = new usuario();
           }
       }catch (RuntimeException er){
           System.out.println("ocurrio un error :  "+ er.getMessage());
       }
       return aux;
    }

    @Override
    public void save(usuario usuario) {

        usuarioRepository.save(usuario);

    }

    @Override
    public boolean validarLogin (String nombre , String contraseña) {
        return usuarioRepository.buscarUsuarioPorNombre(nombre).getContraseña().equals(contraseña);
    }

    @Override
    public boolean validarUsuario(String nombre) {
        return false;
    }

    @Override
    public boolean validarContraseña(String contraseña) {
        return false;
    }

    @Override
    public boolean validarUnicoUsuario(String nombre) {
        return false;
    }


    @Override
    public void guardarUsuarioEnLogin(usuario user) {

        userClient.registrarUsuario(user);
    }


}
