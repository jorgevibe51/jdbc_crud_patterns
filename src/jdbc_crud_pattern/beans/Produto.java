/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc_crud_pattern.beans;

import java.util.Date;

/**
 *
 * @author Jorge
 */
public class Produto {
    
    private int codigo;
    private String nome;
    private double valor;
    private Date dataValidade;

    public Produto() {
    }

    public Produto(int codigo, String nome, double valor, Date dataValidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.dataValidade = dataValidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", dataValidade=" + dataValidade + '}';
    }
}
