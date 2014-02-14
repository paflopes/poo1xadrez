/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cgd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Lincoln
 * @param <T>
 */
public class Persistencia<T extends Serializable> {
    
    public void save(T objeto) {

        try {
            /*Tenta salvar os dados do usuario*/
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("partidas.dat"));           
            out.writeObject(objeto);
            out.close();

        } catch (IOException e) {
        }
    }

    public T load() throws ClassNotFoundException {

        try {
            
            File testeArquivo = new File("partidas.dat");
            System.out.println("1");
            if (testeArquivo.exists()) {
                /*Se o arquivo existir ele faz o load*/
                System.out.println("0");
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("partidas.dat"));
                T partidasReturn = (T) in.readObject();
                in.close();
                return (T) partidasReturn;
            } 
            
        } catch (IOException e) {
        }
        return null;
    }
    
}
