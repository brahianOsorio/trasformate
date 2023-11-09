package co.edu.uco.trasformate.microservice.login.microservicelogin.persistance;

import co.edu.uco.trasformate.microservice.login.microservicelogin.entitys.usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<usuario, Long> {

    @Query("SELECT s FROM usuario s WHERE s.nombre = :nombre")
    List<usuario> listarUsuariosPorNombre(String nombre);

    @Query("SELECT s FROM usuario s WHERE s.nombre = :nombre")
    usuario buscarUsuarioPorNombre(String nombre);

    @Query("SELECT s FROM usuario s WHERE s.contraseña = :contraseña")
    usuario buscarUsuarioPorContraseña(String contraseña);




}
