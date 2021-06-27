package com.aula.negocio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.aula.modelo.AlunoModelo;

@Service
public class AlunoServico {

	ArrayList<AlunoModelo> lista = new ArrayList<>();
	static int contadorId = 1;

	public Integer salvar(AlunoModelo aluno) {
		System.out.println("--EXECUTANDO MÉTODO SALVAR, PACOTE NEGÓCIO--");
		System.out.println("Cadastrando o id: " + aluno.id + ", nome: " + aluno.nome + ", email: " + aluno.email
				+ " e matricula: " + aluno.matricula);
		if (aluno.nome.equals("")) {
			System.out.println("--Adição de aluno reprovada, nome inválido--");
			return null;
		} else if (aluno.email.equals("")) {
			System.out.println("--Adição de aluno reprovada, email inválido--");
			return null;
		} else if (aluno.matricula.equals("")) {
			System.out.println("--Adição de aluno reprovada, matricula inválido--");
			return null;
		}
		System.out.println("--Adição de aluno aprovada--");
		aluno.id = contadorId++;
		lista.add(aluno);
		return aluno.id;
	}

	public ArrayList<AlunoModelo> listar() {
		System.out.println("--EXECUTANDO MÉTODO LISTAR, PACOTE NEGÓCIO--");
		System.out.println("Listando todas as entradas:");
		for (AlunoModelo i : lista)		
			System.out.println("ID: " + i.id + ", Nome: " + i.nome + ", Email: " + i.email + ", Matricula: " + i.matricula);
		return lista;
	}

	public AlunoModelo buscar(Integer id) {
		System.out.println("--EXECUTANDO MÉTODO BUSCAR, PACOTE NEGÓCIO--");
		System.out.println("Buscando item de id: " + id);
		for (AlunoModelo aluno : lista) {
			if (aluno.id == id) {
				System.out.println("Cadastro encontrado");
				return aluno;
			}
		}
		System.out.println("Cadastro não encontrado");
		return null;
	}

	public void deletar(Integer id) {
		System.out.println("--EXECUTANDO MÉTODO DELETAR, PACOTE NEGÓCIO--");
		System.out.println("Deletando item de id: " + id);
		lista.removeIf(obj -> obj.id == id);
	}

	public void atualizar(AlunoModelo aluno) {
		System.out.println("--EXECUTANDO MÉTODO ATUALIZAR, PACOTE NEGÓCIO--");
		System.out.println("Atualizando o id: " + aluno.id);
		lista.removeIf(obj -> obj.id == aluno.id);
		lista.add(aluno);
	}

}
