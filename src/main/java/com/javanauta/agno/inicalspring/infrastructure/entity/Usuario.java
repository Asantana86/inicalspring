package com.javanauta.agno.inicalspring.infrastructure.entity;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// Cria os metodos get e set com a extensão lombok
@Setter
@Getter
//Cria o contrutor com os atibutos e tambem vazio
@NoArgsConstructor
@AllArgsConstructor
//Demonstra que e uma entidade para o Spring
@Entity
//Demosntra que e uma tabela para o Spring
@Table(name  = "usuario")

public class Usuario implements UserDetails {

    //Demosntra de e um coluna e com id primario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    //Column demonstr que e uma coluna da tabela
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;

    //demosntra o relacionamento de um para muitos, no caso que o usuario pode ter mais de um numero de telefone
    @OneToMany(cascade =  CascadeType.ALL)
    //define a coluna de junção estrangeira na tabela
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
