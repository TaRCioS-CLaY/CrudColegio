
package crudcolegio;

import Janela.Interface;

/**
 * @author Clayton Garcia
 * Mat: 2016101697
 */
public class CrudColegio {

    public static void main(String[] args) {
        Interface Interface = new Interface(); //Cria o objeto Janela
        Interface.setTitle("Cadastro de Alunos"); //Define o título na Janela
        Interface.setLocationRelativeTo(null); //Coloca a janela no centro da tela
        Interface.setVisible(true); //Mostra a janela   
    }
    
}
