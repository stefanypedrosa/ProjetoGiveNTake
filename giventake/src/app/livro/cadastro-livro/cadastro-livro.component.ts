import { Component, OnInit } from '@angular/core';
import { Livro } from 'src/app/model/Livro';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-livro',
  templateUrl: './cadastro-livro.component.html',
  styleUrls: ['./cadastro-livro.component.css']
})
export class CadastroLivroComponent implements OnInit {

  livro: Livro = new Livro();
  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  num: any = /^[0-9]+$/;
  _msgErroA: string = null
  _msgEnviarE: string = null

  constructor(private srv: WeblistServiceService, private router: Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
  }

  validacao() {
    if (this.livro.titulo == null || this.livro.autor == null || this.livro.genero == null || this.livro.dataAquisicao == null) {
      alert('Preencha todos os campos!')
    }
    if (!this.filtro.test(this.livro.autor)) {
      this.livro.autor = "";
      this._msgErroA = "Dado inválido";
    }
    else {
      this._msgErroA = null;
    }
    if (this.livro.titulo != null && this.livro.autor != null && this.livro.genero != null && this.livro.dataAquisicao != null) {
      this._msgErroA = null;
      this._msgEnviarE = null;
      this.srv.cadastra(this.livro).subscribe(res => {
        alert("Livro cadastrado com sucesso")
        this.livro.titulo == null;
        this.livro.autor == null;
        this.livro.genero == null;
        this.livro.dataAquisicao == null;
        this.router.navigate(['consultaLivro']);
      },
        error => {
          this._msgEnviarE = "Erro ao enviar dados!!";
        })
    }
  }
}
