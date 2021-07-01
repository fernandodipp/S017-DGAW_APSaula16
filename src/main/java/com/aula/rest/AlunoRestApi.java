package com.aula.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aula.exception.ValidacaoException;
import com.aula.modelo.AlunoModelo;
import com.aula.negocio.AlunoServico;

import com.aula.exception.EntidadeNaoEncontradaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController(value = "API para manipulacao de cadastro de alunos")
@Api("Api de Alunos")
public class AlunoRestApi {

	@Autowired
	private AlunoServico servico;

	@ApiOperation(value = "Salva os alunos", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "sucesso na criação"),
			@ApiResponse(code = 405, message = "erro na validação"), })
	@RequestMapping(value = "/aluno", method = RequestMethod.POST, produces = "text/plain")
	public ResponseEntity<String> salvar(@RequestBody AlunoModelo aluno) {
		ResponseEntity<String> ret = null;
		try {
			servico.salvar(aluno);
			ret = new ResponseEntity<>(aluno.toString(), HttpStatus.OK);
		} catch (Exception e) {
			ret = new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		}
		return ret;
	}

	@ApiOperation(value = "Lista todos os alunos", response = AlunoModelo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "sucesso"), })
	@RequestMapping(value = "/aluno", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<AlunoModelo> listar() {
		return servico.listar();
	}

	@ApiOperation(value = "Busca um aluno pelo id", response = AlunoModelo.class)
	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AlunoModelo> buscar(@PathVariable("id") Integer id) {
		ResponseEntity<AlunoModelo> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(servico.buscar(id), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			System.out.println("Este ID " + id + " não é reconhecido pela minha API");
			return null;
		}
		return responseEntity;
	}

	@ApiOperation(value = "Apaga o aluno pelo ID", response = AlunoModelo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "sucesso na remoção"),
			@ApiResponse(code = 405, message = "erro na remoção"), })
	@DeleteMapping("/aluno/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) throws Exception {
		ResponseEntity<Void> responseEntity;
		try {
			servico.deletar(id);
			responseEntity = ResponseEntity.ok().build();
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return responseEntity;
	}

	@ApiOperation("Atualiza um aluno")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "sucesso na atualização"),
			@ApiResponse(code = 405, message = "erro na atualização"), })
	@RequestMapping(value = "/aluno", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> atualizar(@RequestBody AlunoModelo aluno) throws Exception {
		ResponseEntity<Void> ret = null;
		try {
			servico.atualizar(aluno);
			ret = ResponseEntity.ok().build();
		} catch (Exception e) {
			ret = ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
		return ret;
	}
}
