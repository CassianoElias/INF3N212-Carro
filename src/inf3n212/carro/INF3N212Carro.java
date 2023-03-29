/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;

/**
 *
 * @author 201401665
 */
public class INF3N212Carro { 
    
    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();

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
                
    }
    
}
