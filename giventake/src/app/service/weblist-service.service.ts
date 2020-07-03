import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Livro } from '../model/Livro';
import { Emprestante } from '../model/Emprestante';
import { Emprestimo } from '../model/Emprestimo';

@Injectable({
  providedIn: 'root'
})
export class WeblistServiceService {

  constructor(private http: HttpClient) { }

  //backend livro
  public cadastra(livro: Livro) {
    return this.http.post("http://localhost:8080/Livro", livro);
  }
  public consulta(codLivro: number) {
    return this.http.get(`http://localhost:8080/Livro/${codLivro}`);
  }
  public consultaTudo() {
    return this.http.get("http://localhost:8080/Livro/Todos")
  }

  //backend emprestante
  public cadastraE(emprestante: Emprestante) {
    return this.http.post("http://localhost:8080/Emprestante", emprestante);
  }
  public consultaE(codEmprestante: number) {
    return this.http.get(`http://localhost:8080/Emprestante/${codEmprestante}`);
  }
  public consultaTodos() {
    return this.http.get("http://localhost:8080/Emprestante/Todos")
  }

  //backend emprestimo e devolucao
  public empresta(emprestimo:Emprestimo){
    return this.http.post("http://localhost:8080/Emprestimo", emprestimo)
  }
  

  //backend devolucao
  public devolve(livro:Livro){
    return this.http.put("http://localhost:8080/Livro/Devolver", livro)
  }


}
