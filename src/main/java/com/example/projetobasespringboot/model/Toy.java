package com.example.projetobasespringboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Toy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
  /*Qunado é uma relação N para N, o JoinTable precisa ficar na classe toy ao invés da classe dog, pois é nele que vamos fazer o
    post de brinquedos, e nela que será feito o relacionamento, caso invertesse as anotações com o da classe Dog, o spring não colocaria a 
	relação na tabela "dogs_toys", sendo o brigado a colocar o post de toy em dogs, mas não faria sentido por ser uma 
	inserção de toy.*/
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "dogs_toys",
				joinColumns = {@JoinColumn(name = "dog_id")},
				inverseJoinColumns = {@JoinColumn (name = "toy_id")})
	private List<Dog> dogs;

}
