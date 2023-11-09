package co.edu.uco.trasformate.microservice.register.microserviceregister.controller;


import co.edu.uco.trasformate.microservice.register.microserviceregister.entitys.usuario;
import co.edu.uco.trasformate.microservice.register.microserviceregister.service.IusuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarioRegister")
public class usuarioController {

    @Autowired
    private IusuarioService usuarioService;

/*ESTE METODO HAY QUE REVISARLO MEJOR */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>  guardarUsuario(@RequestBody usuario usuario){

        /*la validacion es que si el nombre del usuario ingresado existe en la base de datos */
        if (usuario.getNombre().equals(usuarioService.encontrarUsuarioPorNombre(usuario.getNombre()).getNombre())){

            try {
                System.out.println("va a cargar el mensage de error  ");
                throw new RuntimeException("ya existe el usuario.");
            } catch (RuntimeException error) {
                System.out.println("va amostarr el mensage de error  ");
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Mensaje de error: " + error.getMessage());
            }

        }else {

            usuarioService.guardarUsuarioEnLogin(usuario);
            usuarioService.save(usuario);
            return ResponseEntity.ok(usuario);
        }

    }

    /*PARA HACER PRUEBAS*/

    @GetMapping("/all")
    public ResponseEntity<?> listarTodosLosUsuarios(){
        return ResponseEntity.ok(usuarioService.listarTodosLosUsuarios());
    }

    /*PARA HACER PRUEBAS*/
    @GetMapping("/serch/{nombre}")
    public ResponseEntity<?> encontrarPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(usuarioService.encontrarUsuarioPorNombre(nombre));
    }

}
