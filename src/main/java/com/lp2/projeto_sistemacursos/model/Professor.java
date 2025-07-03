package com.lp2.projeto_sistemacursos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="Professores")
public class Professor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatória!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotNull(message = "O salário é obrigatório")
    @PositiveOrZero(message = "O salário não pode ser um valor negativo")
    private float salario;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursosMinistrados = new ArrayList<>();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @OneToMany(mappedBy = "professor")
    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    public void setCursosMinistrados(List<Curso> cursosMinistrados) {
        this.cursosMinistrados = cursosMinistrados;
    }

    @Override
    public String toString() {
        return nome;
    }
}
