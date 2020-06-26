import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Devolucao } from '../model/Devolucao';
import { WeblistServiceService } from '../service/weblist-service.service';
import { Livro } from '../model/Livro';

@Component({
  selector: 'app-devolucao',
  templateUrl: './devolucao.component.html',
  styleUrls: ['./devolucao.component.css']
})
export class DevolucaoComponent implements OnInit {
  num: any = /^[0-9]+$/;
  _msgErroCL:string=null;
  _msgEnviarE:string = null
  devolucao:Devolucao = new Devolucao(); 
  livro:Livro = new Livro();
  constructor(private srv: WeblistServiceService, private router:Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
  }

  validacao(){
    
    if (this.devolucao.codLivro == null || this.devolucao.dataDevolucao == null) {
      alert('Preencha todos os campos!')
    }
    if (!this.num.test(this.devolucao.codLivro)) {
      this._msgErroCL = "Dado inválido";
    }
    else {
      this._msgErroCL = null;
    }
    this.livro.codLivro = this.devolucao.codLivro;
    if(this.devolucao.codLivro != null && this.devolucao.dataDevolucao != null){
      this._msgErroCL = null;
      this._msgEnviarE = null;
      this.srv.devolve(this.livro).subscribe(res => {
        alert("Livro devolvido com sucesso")
      this.devolucao.codLivro == null;
      this.devolucao.dataDevolucao == null;
      this.router.navigate(['home']);
      },
        error => {
          this._msgEnviarE = "Erro ao enviar dados!!";
        })


    }

  }
}
