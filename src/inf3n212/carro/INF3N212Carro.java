/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.awt.BorderLayout;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import util.Validadores;

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
        int opM = 99;
        int opSM = 99;
        do {
            System.out.println("\n-- Sistema de Cadastro --");
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                if (opM == 1) {
                                    cadastraPessoa();
                                } else {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println(" -- Editar -- ");
                                if (opM == 1) {
                                    editarPessoa();
                                } else {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                if (opM == 1) {
                                    listarPessoa();
                                } else {
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println(" -- Deletar -- ");
                                if (opM == 1) {
                                    deletarPessoa();
                                } else {
                                    deletarCarro();
                                }
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção invalida, tente novamente");
                        }
                    } while (opSM != 0);
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
            }
        } while (opM != 0);

    }// fim metodo main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro" + i.getMessage() + "\nTente novamente!");
            leiaNumInt();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("--MENU PRINCIPAL");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Carro");
        System.out.println("0 - Sair");
        System.out.print("Digite Aqui: ");
    }//fim MenuP

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }

        System.out.println("-- Ger. " + subM + "--");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar ");
        System.out.print("Digite Aqui: ");
    }//fim subMenu

    private static void cadastraPessoa() {
        System.out.println("-- Cadastre a Pessoa --");
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF> ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (cadPessoa.getPessoaCPF(cpf) != null) {
                    System.out.println("CPF ja esta cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastramento");
                    System.out.println("Digite Aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF Invalido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastramento");
                System.out.println("Digite Aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
                tcpf = true;
            }
        } while (tcpf);
        System.out.print("Inform o nome: ");
        nome = leia.nextLine();
        System.out.print("Inform o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Inform o telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(p.getNome() + " cadastrado(a) com sucesso");
    }

    private static void cadastrarCarro() {
        System.out.println("-- Cadastre Carro  --");
     String placa;
     String marca;
     String modelo;
     int anoFab;
     int anoMod;
     String cor;
     String tpCambio;
     String combustivel;
     Pessoa proprietario;
     boolean pCarro = true;
        do {
            System.out.println("Informe a Placa");
            placa = leia.nextLine();
            pCarro = Validadores.validarPlaca(placa);
            if (pCarro) {
                Carro carro = cadCarro.getCarroPlaca(placa);
                if (carro == null) {
                    //segue fluxo de cadastro
                }else{
                    System.out.println("Placa ja Cadastrada");
                    pCarro = false;
                }
            }else{
                System.out.println("Placa invalida! Tente novamente!");
                pCarro = true;
            }
            
        } while (pCarro);
        
       
    }

    private static void editarPessoa() {
        System.out.println("-- Editar Pessoa --");
        boolean isCPF;
        do {
            System.out.println("Informe o CPF da pessoa a ser editado");
            String cfp = leia.nextLine();
            isCPF = Validadores.isCPF(cfp);
            if (isCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cfp);
                if (p != null) {
                    do {
                        System.out.println("Quais dados de " + p.getNome() + " deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Endereço");
                        System.out.println("3 - Telefone");
                        System.out.println("4 - Todos");
                        System.out.println("0 - Cancelar");
                        System.out.print("Digite Aqui: ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 4) {
                            System.out.println("Informe o novo nome: ");
                            p.setNome(leia.nextLine());

                        }
                        if (op == 2 || op == 4) {
                            System.out.println("Informe o novo endereço: ");
                            p.setEndereco(leia.nextLine());

                        }
                        if (op == 3 || op == 4) {
                            System.out.println("Informe o novo telefone: ");
                            p.setTelefone(leia.nextLine());

                        }
                        if (op == 0) {
                            System.out.println("Operação cancelada pelo usuário");
                            isCPF = false;
                        }
                        //if (op == 0) { alterar para if == 4
                            //System.out.println("Operação cancelada pelo usuário");
                            //isCPF = false;
                        
                        if (op <0 || op > 4) {
                            System.out.println("opção invalida, tente novamente!");
                            
                            
                        }
                    } while (isCPF);
                  }else{
                    System.out.println("CPF não cadastrado!");
                    isCPF = false;
                    }
                

            } else {
                System.out.println("CPF Invalido");
                System.out.print("Deseja tentar novamente? \n 1 -Sim | 2 - Não");
                int op = leiaNumInt();
                if (op == 1) {
                    isCPF = true;
                } else {
                    isCPF = false;
                }
            }
                    
        }while (isCPF);
    }

    private static void editarCarro() {
        System.out.println("Editar");
    }

    private static void listarPessoa() {
        System.out.println("-- Lista de Pessoas --");
        for (Pessoa pessoa : cadPessoa.getPessoa()) {
            System.out.println(pessoa.toString());
        }
    }

    private static void listarCarro() {
        System.out.println("-- Lista de Carros --");
        for (Carro carro : cadCarro.getCarros()) {
            System.out.println(carro.toString());
        }

    }

    private static void deletarPessoa() {
        System.out.println("-- Deletar Pessoa --");
        boolean delCPF = false;
        do {

            System.out.print("Informe o CPF da Pessoa a ser deletada: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Desena realmente deletar " + p.getNome() + "?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        cadPessoa.removePessoa(p);
                        System.out.println("Pessoa deletada com sucesso!");
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário!");
                        delCPF = false;
                    }
                } else {
                    System.out.println("CPF não cadastrado");
                    System.out.println("Deseja tentar novamente?");
                    System.out.println("1 - Sim | 2 - Não ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delCPF = true;
                    } else {
                        delCPF = false;

                    }

                }
            } else {
                System.out.println("CPF inválido!"
                        + "\nTente novamente.");
                delCPF = false;
            }
        } while (delCPF);

    }

    private static void deletarCarro() {
        System.out.println("");
    }

    private static void toUpperCase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}// fim classe
