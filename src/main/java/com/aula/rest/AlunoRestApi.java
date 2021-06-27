package com.aula.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aula.modelo.AlunoModelo;
import com.aula.negocio.AlunoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController(value="API para manipulacao de cadastro de alunos")
@Api("Api de Alunos")
public class AlunoRestApi {

	// injecao de dependencia.
	@Autowired
	AlunoServico servico;
	
	@ApiOperation(value="Salva os alunos", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "sucesso na criação"),
			@ApiResponse(code = 405, message = "erro na validação"),
	})
	@RequestMapping(value= "/aluno", method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Integer> salvar(@RequestBody AlunoModelo aluno){		
		return new ResponseEntity<>(servico.salvar(aluno),HttpStatus.OK);		
	}
	
	@ApiOperation(value="Lista todos os alunos", response = AlunoModelo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "sucesso"),
	})
	@RequestMapping(value= "/aluno", method=RequestMethod.GET, produces = "application/json")
	public ArrayList<AlunoModelo> listar(){
		return servico.listar();
	}
	
	@ApiOperation(value="Busca um aluno pelo id", response = AlunoModelo.class)
	@RequestMapping(value= "/aluno/{id}", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AlunoModelo> buscar(@PathVariable("id") Integer id){
		try {
		return new ResponseEntity<>(servico.buscar(id),HttpStatus.OK);
		}catch(Exception e) {
			System.out.println("Este ID " + id + " não é reconhecido pela minha API");
			return null;
		}
	}
	
	@ApiOperation(value="Apaga o aluno pelo ID", response = AlunoModelo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "sucesso na remoção"),
			@ApiResponse(code = 405, message = "erro na remoção"),
	})
	@RequestMapping(value= "/aluno/{id}", method=RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value="Atualiza um aluno", response = AlunoModelo.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "sucesso na atualização"),
			@ApiResponse(code = 405, message = "erro na atualização"),
	})
	@RequestMapping(value= "/aluno", method=RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> atualizar(@RequestBody AlunoModelo aluno){		
		servico.atualizar(aluno);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
}
