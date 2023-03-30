/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 201401665
 */
public class INF3N212Carro { 
    
    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        
        System.out.println(cadPessoa.getPessoa());
        System.out.println("----");
        System.out.println(cadCarro.getCarros());
        
                
    }// fim metodo main
    
    public static int leiaNumInt(){
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        }catch(InputMismatchException i){
            System.out.println("Erro"+i.getMessage() + "\nTente novamente!");
            leiaNumInt();
        }
        return 99;
        }
    
    public static void  menuP(){
        System.out.println("--MENU PRINCIPAL");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Carro");
        System.out.println("0 - Sair");
        System.out.print("Digite Aqui: ");        
    }//fim MenuP
    
    public static void subMenu(int opM){
        String subM = null;
            if(opM == 1){
                subM = "Pessoa";
            }
            if(opM == 2){
                subM = "Carro";
            }
            
            System.out.println("-- Ger. " + subM + "--");
            System.out.println("1 - Cadastrar" + subM);
            System.out.println("2 - Editar" +subM);
            System.out.println("3 - Listar" +subM + "s");
            System.out.println("4 - Deletar" + subM);
            System.out.println("0 - Voltar");
            System.out.print("Digite Aqui: ");
    }//fim subMenu
    
}// fim classe
