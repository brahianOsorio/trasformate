package co.edu.uco.trasformate.microservice.register.microserviceregister.client;

import co.edu.uco.trasformate.microservice.register.microserviceregister.entitys.usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-micros", url = "localhost:8080/api/usuarioLogin")
public interface userClient {

    @PostMapping("/create")
    usuario registrarUsuario (@RequestBody usuario usuario);

}
