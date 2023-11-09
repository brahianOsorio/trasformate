package co.edu.uco.trasformate.microservice.login.microservicelogin.controller;

import co.edu.uco.trasformate.microservice.login.microservicelogin.entitys.usuario;
import co.edu.uco.trasformate.microservice.login.microservicelogin.service.IusuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarioLogin")
public class usuarioController {

    @Autowired
    private  IusuarioService usuarioService;


    /*ojo al metodo es de registrar este es para el register*/
    /*CUIDADO CON LA COMUNICACION*/
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void  guardarUsuario(@RequestBody usuario usuario){
        usuarioService.save(usuario);
    }


    /*PARA HACER PRUEBAS*/
    @GetMapping("/all")
    public ResponseEntity<?> listarTodosLosUsuarios(){
        return ResponseEntity.ok(usuarioService.listarTodosLosUsuarios());
    }

    /*PARA HACER PRUEBAS*/
    @GetMapping("/serch/{nombre}")
    public ResponseEntity <?> encontrarPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(usuarioService.encontrarUsuarioPorNombre(nombre));
    }

    /*METODO PARA VALIDAR LOGIN*/
    @GetMapping("/login/{nombre}/{contraseña}")
    public boolean login(@PathVariable String nombre, @PathVariable String contraseña){
        return usuarioService.validarLogin(nombre, contraseña);
    }



}
