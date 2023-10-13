package br.com.joanicegaspar.todolist.user;


import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {
  /**
   * Atributos = propriedades = informações de uma classe
  */
    // public String name;  
    // public String username;
    // public String password;
  
    // Definir Id como Primary-Key da nossa tabela e gerá-lo de forma automática:
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Getters e Setters - uma forma de acceder aos atributos private e estes getters e setters são escritos por debaixo dos panos atraves da Anotação @Data que surge da dependência ou Lib "projectlombok"


}



