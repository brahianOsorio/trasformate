package co.edu.uco.trasformate.microservice.login.microservicelogin.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "Nombre")
    private  String nombre;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Contraseña")
    private String contraseña;


}
