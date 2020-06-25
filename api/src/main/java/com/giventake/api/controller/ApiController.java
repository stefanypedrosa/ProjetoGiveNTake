package com.giventake.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giventake.api.model.Emprestante;
import com.giventake.api.model.Emprestimo;
import com.giventake.api.model.Livro;
import com.giventake.api.structure.Database;

@RestController
public class ApiController {
	private Database database = new Database();
	
	/*		Rotas do Livro		*/
	@PostMapping("/Livro")
	public ResponseEntity<Livro> inserirLivro(@RequestBody Livro livro) {
		database.inserirLivro(livro);
		return ResponseEntity.ok(livro);
	}
	
	@GetMapping("/Livro/{codigo}")
	public ResponseEntity<Livro> consultarLivro(@PathVariable int codigo) {
		return ResponseEntity.ok(database.consultarLivro(codigo));
	}
	
	@GetMapping("/Livro/Todos")
	public ResponseEntity<String> consultarLivros() {
		return ResponseEntity.ok(database.consultarLivros());
	}
	
	@PutMapping("/Livro/Emprestar")
	public ResponseEntity<Livro> emprestarLivro(@RequestBody Livro livro) {
		database.emprestarLivro(livro);
		return ResponseEntity.ok(livro);
	}
	
	@PutMapping("/Livro/Devolver")
	public ResponseEntity<Livro> devolverLivro(@RequestBody Livro livro) {
		database.devolverLivro(livro);
		return ResponseEntity.ok(livro);
	}
	
	@GetMapping("/Livro/Quantidade")
	public ResponseEntity<Integer> quantidadeLivros() {
		return ResponseEntity.ok(database.quantidadeLivros());
	}
	
	
	
	/*		Rotas do Emprestante		*/
	@PostMapping("/Emprestante")
	public ResponseEntity<Emprestante> inserirEmprestante(@RequestBody Emprestante emprestante) {
		database.inserirEmprestante(emprestante);
		return ResponseEntity.ok(emprestante);
	}
	
	@GetMapping("/Emprestante/{codigo}")
	public ResponseEntity<Emprestante> consultarEmprestante(@PathVariable int codigo) {
		return ResponseEntity.ok(database.consultarEmprestante(codigo));
	}
	
	@GetMapping("/Emprestante/Todos")
	public ResponseEntity<String> consultarEmprestantes() {
		return ResponseEntity.ok(database.consultarEmprestantes());
	}
	
	@GetMapping("/Emprestante/Quantidade")
	public ResponseEntity<Integer> quantidadeEmprestantes() {
		return ResponseEntity.ok(database.quantidadeEmprestantes());
	}
	
	
	
	/*		Rotas do Emprestimo		*/
	@PostMapping("/Emprestimo")
	public ResponseEntity<Emprestimo> inserirLivro(@RequestBody Emprestimo emprestimo) {
		database.inserirEmprestimo(emprestimo);
		return ResponseEntity.ok(emprestimo);
	}
	
	@GetMapping("/Emprestimo/{codigo}")
	public ResponseEntity<Emprestimo> consultarEmprestimo(@PathVariable int codigo) {
		return ResponseEntity.ok(database.consultarEmprestimo(codigo));
	}
	
	@GetMapping("/Emprestimo/Todos")
	public ResponseEntity<String> consultarEmprestimos() {
		return ResponseEntity.ok(database.consultarEmprestimos());
	}
	
	@GetMapping("/Emprestimo/Quantidade")
	public ResponseEntity<Integer> quantidadeEmprestimos() {
		return ResponseEntity.ok(database.quantidadeEmprestimos());
	}
	
	
	
}





//	@GetMapping("/Livro/Todos")
//	public ResponseEntity<ArrayList<Livro>> consultarLivro() {
//		return ResponseEntity.ok(database.consultarLivros());
//	}
//	