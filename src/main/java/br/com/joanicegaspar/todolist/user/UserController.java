package br.com.joanicegaspar.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificador de classe (Tipos de acesso à uma classe) : 
 * Public --> qualquer um (método/atributo) pode acessar essa classe
 * Private --> mais restrito (O atributo pode ser acessado apenas pela própria classe)
 * Protected --> só quem está na mesma estrutura do pacote pode ter acesso
 */


@RestController
@RequestMapping("/users")
public class UserController {
/**
 * Tipos de Modificadores, ou seja, modificadores do tipo:
  * Class
  * Interface
  * etc.
*/

// Chamar a Interface User que criamos
// Gerenciar o ciclo de vida (setters, getters, construtores...) dos atributos e métodos automaticamente na nossa interface ()

  @Autowired
  private InterfaceUserRepository userRepository;

// Vamos colocar as infos dentro do Body
  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if (user != null) {
      // Mensagem de erro
      // Status Code
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
    }

    var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

    userModel.setPassword(passwordHashred);

    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
  }

}

/*
@RequestBody - Indica que os dados da requisição estarão no corpo da mensagem e serão convertidos para o objeto especificado no parâmetro do método.

*Lombok no contexto do Java:
É Uma biblioteca que facilita a criação de getters e setters no Java, entre outros métodos.

@Data do Lombok mencionada na aula:
Facilita a criação de getters e setters para todos os atributos de uma classe.

* Spring Data JPA :
É uma biblioteca de persistência que facilita a comunicação com o banco de dados em uma aplicação Spring Boot
*/