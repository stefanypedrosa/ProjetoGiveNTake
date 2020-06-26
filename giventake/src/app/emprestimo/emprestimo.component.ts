import { Component, OnInit } from '@angular/core';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';
import { Router } from '@angular/router';
import { Emprestimo } from '../model/Emprestimo';
import { Livro } from '../model/Livro';
import { Emprestante } from '../model/Emprestante';

@Component({
  selector: 'app-emprestimo',
  templateUrl: './emprestimo.component.html',
  styleUrls: ['./emprestimo.component.css']
})
export class EmprestimoComponent implements OnInit {
  emprestimo: Emprestimo = new Emprestimo();
  livro: Livro = new Livro();
  emprestante: Emprestante = new Emprestante();
  data: Date = new Date();
  dia: number;
  mes: number;
  ano: number;
  nasc: any[];
  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  num: any = /^[0-9]+$/;
  idade: number;
  _msgErroCL: string = null
  _msgErroCE: string = null
  _msgErroR: string = null
  _msgEnviarE: string = null

  constructor(private srv: WeblistServiceService, private router: Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
    this.calculaDevolucao();
  }
  calculaDevolucao() {
    this.dia = this.data.getDate() + 7;
    if (this.dia >= 30) {
      this.dia = this.dia - 30;
      this.mes = this.data.getMonth() + 3;
      if (this.mes > 12) {
        this.mes = 1;
        this.ano = this.data.getFullYear() + 1;
      }
      else {
        this.mes = this.data.getMonth() + 2;
        this.ano = this.data.getFullYear();
      }
    }
    this.emprestimo.dataDevolucao = this.dia + "/" + this.mes + "/" + this.ano;
  }

  calculaIdade() {
    this.nasc = this.emprestimo.dataNasc.split('/'),

      this.dia = this.data.getDate();
    this.mes = this.data.getMonth() + 2;
    this.ano = this.data.getFullYear();

    if (this.mes >= this.nasc[1]) {
      if (this.dia >= this.nasc[0]) {
        this.idade = this.ano - this.nasc[2];
      }
      else {
        this.idade = this.ano - this.nasc[2] - 1;
      }
    }
    else {
      this.idade = this.ano - this.nasc[2] - 1;
    }
    return this.idade;
  }

  validacao() {
    if (this.livro.codLivro == null || this.emprestante.codEmprestante == null || this.emprestimo.dataNasc == null) {
      alert('Preencha todos os campos!')
    }

    if (!this.num.test(this.livro.codLivro)) {
      this._msgErroCL = "Dado inválido";
    }
    else {
      this._msgErroCL = null;
    }
    if (!this.num.test(this.emprestante.codEmprestante)) {
      this._msgErroCE = "Dado inválido";
    }
    else {
      this._msgErroCE = null;
    }
    if (this.calculaIdade() < 18 && this.emprestimo.responsavel == null) {
      this._msgErroR = "Campo Obrigatório!";
    }
    else {
      this._msgErroR = null;
    }
    if (this.livro.codLivro != null && this.emprestante.codEmprestante!= null && this.emprestimo.dataNasc != null && this._msgErroR == null) {
      this._msgErroCL = null
      this._msgErroCE = null
      this._msgErroR = null
      this._msgEnviarE = null;
      this.emprestimo.codLivro = this.livro;
      this.emprestimo.codEmprestante = this.emprestante;
      this.srv.empresta(this.emprestimo).subscribe(res => {
        alert("Livro emprestado com sucesso")
        this.livro = null;
        this.emprestante = null;
        this.emprestimo.codLivro = null
        this.emprestimo.codEmprestante = null
        this.emprestimo.dataNasc = null
        this.emprestimo.responsavel = null
        this.router.navigate(['home']);
      },
        error => {
          this._msgEnviarE = "Erro ao enviar dados!!";
        })
    }
  }
}
