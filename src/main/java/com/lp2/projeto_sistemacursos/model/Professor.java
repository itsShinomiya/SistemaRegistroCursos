package com.lp2.projeto_sistemacursos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
@Table (name="Professores")
public class Professor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatória!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    @NotNull(message = "O salário é obrigatório")
    @PositiveOrZero(message = "O salário não pode ser um valor negativo")
    private float salario;

    @NotNull(message = "O número de cursos ministrados não pode ser nulo")
    @Min(value = 0, message = "O número de cursos não pode ser negativo")
    private int cursosministrados;

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

    public int getCursosministrados() {
        return cursosministrados;
    }

    public void setCursosministrados(int cursosministrados) {
        this.cursosministrados = cursosministrados;
    }
}
