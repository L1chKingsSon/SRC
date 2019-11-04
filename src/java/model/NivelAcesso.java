///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package model;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// *
// * @author Raphael
// */
//public enum NivelAcesso {
//    ADMIN("Administrador", 0),
//    FUNCIONARIO("Funcionario", 1);
//    
//    private int id;
//    private String nomeNivel;
//    
//    NivelAcesso(int id, String nivel)
//    {
//        this.id = id;
//        this.nomeNivel = nivel;
//    }
//    
//    
//    public String getNivelAcesso() {
//        return this.nomeNivel;
//    }
//
//    public static List<NivelAcesso> obterNiveisAcesso() {
//        ArrayList<NivelAcesso> niveis = new ArrayList<NivelAcesso>();
//        niveis.addAll(Arrays.asList(NivelAcesso.values()));
//        return niveis;
//    }
//
//    public static NivelAcesso obterNivelAcesso(String valor) {
//        return Enum.valueOf(NivelAcesso.class, valor.toUpperCase().replaceAll(" ", ""));
//    }
//
//}
//
//}
