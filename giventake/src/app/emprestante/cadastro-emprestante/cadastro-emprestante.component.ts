import { Component, OnInit } from '@angular/core';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';
import { Router } from '@angular/router';
import { Emprestante } from '../../model/Emprestante';

@Component({
  selector: 'app-cadastro-emprestante',
  templateUrl: './cadastro-emprestante.component.html',
  styleUrls: ['./cadastro-emprestante.component.css']
})
export class CadastroEmprestanteComponent implements OnInit {
  emprestante:Emprestante = new Emprestante;
  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  num: any = /^[0-9]+$/;
  data:Date = new Date();
  dia:number;
  mes:number;
  ano:number;
  nasc:any[];
  idade:number;
  _msgErroR: string = null
  _msgErroAR: string = null
  _msgErroN: string = null
  _msgErroC: string = null;
  _msgEnviarE:string = null;
  

  constructor(private srv: WeblistServiceService, private router:Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
  }

  validacao(){
    if(this.emprestante.nomeEmprestante == null || this.emprestante.contato == null || this.emprestante.dataNasc == null){
      alert('Preencha todos os campos');
    }
    if (!this.filtro.test(this.emprestante.nomeEmprestante)) {
      this.emprestante.nomeEmprestante = "";
      this._msgErroN = "Dado inválido";
    }
    else {
      this._msgErroN = null;
    }
    if(this.calculaIdade()<18 && this.emprestante.responsavel == null){
      this._msgErroR = "Campo Obrigatório!";
    }
    else{
      this._msgErroR = null;
    }
    
    if(this.emprestante.tipo1 != "Aluno" && this.emprestante.alunoReferencia == null){
      this._msgErroAR = "Campo obrigatório!"
    }
    else{
      this._msgErroAR = null;
    }
    if (this.emprestante.contato.length < 10 || !this.num.test(this.emprestante.contato)) {
      this.emprestante.contato = null;
      this._msgErroC = `Digite um telefone válido`;
    }
    else {
      this._msgErroC = null;
    }
    
    if(this.emprestante.nomeEmprestante != null && this.emprestante.contato != null && this.emprestante.dataNasc != null && this._msgErroAR == null && this._msgErroR == null){
      this._msgErroR = null
      this._msgErroAR = null
      this._msgErroN = null
      this._msgErroC = null
      this._msgEnviarE = null;
      this.srv.cadastraE(this.emprestante).subscribe(res => {
        alert("Emprestante cadastrado com sucesso")
      this.emprestante.nomeEmprestante = null;
      this.emprestante.contato = null;
      this.emprestante.dataNasc = null;
      this.emprestante.alunoReferencia = null;
      this.emprestante.responsavel = null;
      this.emprestante.tipo1 = "Aluno";
      this.router.navigate(['consultaEmprestante']);
      },
        error => {
          this._msgEnviarE = "Erro ao enviar dados!!";
        })
    }
  }
  calculaIdade(){
    this.nasc = this.emprestante.dataNasc.split('/'),

    this.dia = this.data.getDate();
    this.mes = this.data.getMonth()+1;
    this.ano = this.data.getFullYear();

    if(this.mes>=this.nasc[1]){
      if(this.dia>=this.nasc[0]){
        this.idade = this.ano-this.nasc[2];
      }
      else{
        this.idade = this.ano-this.nasc[2]-1;
      }
    }
    else{
      this.idade = this.ano-this.nasc[2]-1;
    }
    return this.idade;
  }
}
