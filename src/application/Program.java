package application;

import java.util.Scanner;

import modules.PessoaFisica;
import modules.PessoaJuridica;
import repository.RepositoryPessoaFisica;
import repository.RepositoryPessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int binary = 0;
		RepositoryPessoaFisica rpf = new RepositoryPessoaFisica();
		RepositoryPessoaJuridica rpj = new RepositoryPessoaJuridica();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("| Trabalho de gestao e qualidade de software |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("---------------------------------");
		System.out.println("|    Parte 1 da avaliação A3    |");
		System.out.println("---------------------------------\n");
		System.out.println("********************************");
		System.out.println("| Aluno: Zodi Rodrigues Santos |");
		System.out.println("| RA: 12622111617              |");
		System.out.println("********************************\n");
		
		while(binary == 0) {					
		System.out.println("Escolha a opcao de 1 a 9\n");
		System.out.println("1 - Cadastrar Pessoa Fisica");
		System.out.println("2 - Cadastrar Pessoa Juridica");
		System.out.println("3 - Atualizar nome Pessoa Fisica");
		System.out.println("4 - Atualizar nome Pessoa Juridica");
		System.out.println("5 - Remover Pessoa Fisica");
		System.out.println("6 - Remover Pessoa Juridica");
		System.out.println("7 - Listar Pessoas Fisica");
		System.out.println("8 - Listar Pessoas Juridica");
		System.out.println("9 - Sair do menu\n");
		System.out.print("Sua escolha: ");
		int choice = input.nextInt();
		while (choice < 1 || choice > 9) {
			System.out.println("Opcao invalida");
			System.out.print("\nEscolha novamente: ");
			choice = input.nextInt();
		}
		if (choice == 1) {
			System.out.print("\nNome: ");
			String name = input.next();
			input.nextLine();
			System.out.print("CPF: ");
			long cpf = input.nextLong();
			input.nextLine();
			PessoaFisica pf = new PessoaFisica(name, cpf);
			rpf.create(pf);
		}
		else if (choice == 2) {
			System.out.print("\nNome: ");
			String name = input.next();
			input.nextLine();
			System.out.println("CNPJ: ");
			long cnpj = input.nextLong();
			input.nextLine();
			PessoaJuridica pj = new PessoaJuridica(name, cnpj);
			rpj.create(pj);
		} else if (choice == 3) {
			System.out.print("\nEscolha um novo nome: ");
			String name = input.next();
			input.nextLine();
			System.out.println("CPF: ");
			long cpf = input.nextLong();
			input.nextLine();
			PessoaFisica pf = new PessoaFisica(name, cpf);
			rpf.update(pf);
		} else if (choice == 4) {
			System.out.print("\nEscolha um novo nome: ");
			String name = input.next();	
			input.nextLine();
			System.out.println("CNPJ: ");
			long cnpj = input.nextLong();
			input.nextLine();
			PessoaJuridica pj = new PessoaJuridica(name, cnpj);
			rpj.update(pj);
		} else if (choice == 5) {
			System.out.print("\nDigite o CPF da pessoa que quer deletar: ");
			long cpf = input.nextLong();
			input.nextLine();
			rpf.delete(cpf);
		} else if (choice == 6) {
			System.out.print("\nDigite o CNPJ da pessoa que quer deletar: ");
			long cnpj = input.nextLong();
			input.nextLine();
			rpj.delete(cnpj);
		} else if (choice == 7) {
			System.out.println("\nLista:");
			for(int i = 0; i < rpf.read().size(); i++) {
				PessoaFisica pf = (PessoaFisica) rpf.read().get(i);
				System.out.println("\n+++++++++++++++++++++++++++++");
				System.out.println("Nome: " + pf.getName());
				System.out.println("cpf: " + pf.getCpf() + "\n");	
			}
		} else if (choice == 8) {
			System.out.println("Lista:");
			for(int i =0; i < rpj.read().size(); i++) {
				PessoaJuridica pj = (PessoaJuridica) rpj.read().get(i);
				System.out.println("\n+++++++++++++++++++++++++++++");
				System.out.println("Nome: " + pj.getName());
				System.out.println("CNPJ: " + pj.getCnpj() + "\n");	
			}
		} else {
			System.out.println(" ---- Menu out ----");
		}
		System.out.println("\nDigite 1 para voltar ao menu\nDigite 2 para sair");
		System.out.print("\nOpção desejada: ");
		int option = input.nextInt();
		if (option == 2) {
			binary = 1;
		}
		}
		System.out.println("\n+++++++++++++++++++++++");
		System.out.println("|  WE SUPPORT ISRAEL  |");
		System.out.println("+++++++++++++++++++++++");
		input.close();
	}

}
