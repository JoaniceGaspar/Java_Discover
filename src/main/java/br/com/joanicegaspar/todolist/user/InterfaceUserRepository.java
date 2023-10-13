package br.com.joanicegaspar.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InterfaceUserRepository extends JpaRepository<UserModel, UUID> {
  UserModel findByUsername(String username);
  
}
