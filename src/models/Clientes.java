package models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Clientes extends RecursiveTreeObject<Clientes> {

    private IntegerProperty id;
    private StringProperty nome;
    private StringProperty nome_fantasia;
    private StringProperty razao_social;
    private StringProperty rg;
    private StringProperty ie;
    private StringProperty cpf;
    private StringProperty cnpj;
    private StringProperty telefone1;
    private StringProperty telefone2;
    private StringProperty telefone3;
    private StringProperty email;
    private StringProperty bairro;
    private StringProperty endereco;
    private StringProperty cep;
    private StringProperty estado;
    private StringProperty cidade;
    private StringProperty obs;


    public IntegerProperty getId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getNome() {
        return nome;
    }

    public void setNome(StringProperty nome) {
        this.nome = nome;
    }

    public StringProperty getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(StringProperty nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public StringProperty getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(StringProperty razao_social) {
        this.razao_social = razao_social;
    }

    public StringProperty getRg() {
        return rg;
    }

    public void setRg(StringProperty rg) {
        this.rg = rg;
    }

    public StringProperty getIe() {
        return ie;
    }

    public void setIe(StringProperty ie) {
        this.ie = ie;
    }

    public StringProperty getCpf() {
        return cpf;
    }

    public void setCpf(StringProperty cpf) {
        this.cpf = cpf;
    }

    public StringProperty getCnpj() {
        return cnpj;
    }

    public void setCnpj(StringProperty cnpj) {
        this.cnpj = cnpj;
    }

    public StringProperty getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(StringProperty telefone1) {
        this.telefone1 = telefone1;
    }

    public StringProperty getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(StringProperty telefone2) {
        this.telefone2 = telefone2;
    }

    public StringProperty getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(StringProperty telefone3) {
        this.telefone3 = telefone3;
    }

    public StringProperty getEmail() {
        return email;
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }

    public StringProperty getBairro() {
        return bairro;
    }

    public void setBairro(StringProperty bairro) {
        this.bairro = bairro;
    }

    public StringProperty getEndereco() {
        return endereco;
    }

    public void setEndereco(StringProperty endereco) {
        this.endereco = endereco;
    }

    public StringProperty getCep() {
        return cep;
    }

    public void setCep(StringProperty cep) {
        this.cep = cep;
    }

    public StringProperty getEstado() {
        return estado;
    }

    public void setEstado(StringProperty estado) {
        this.estado = estado;
    }

    public StringProperty getCidade() {
        return cidade;
    }

    public void setCidade(StringProperty cidade) {
        this.cidade = cidade;
    }

    public StringProperty getObs() {
        return obs;
    }

    public void setObs(StringProperty obs) {
        this.obs = obs;
    }
}
