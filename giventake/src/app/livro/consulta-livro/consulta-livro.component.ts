import { Component, OnInit } from '@angular/core';
import { Livro } from '../../model/Livro';
import { Router } from '@angular/router';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';

@Component({
  selector: 'app-consulta-livro',
  templateUrl: './consulta-livro.component.html',
  styleUrls: ['./consulta-livro.component.css']
})
export class ConsultaLivroComponent implements OnInit {
  listaLivro:Array<Livro> = new Array();
  constructor(private router: Router, private srv: WeblistServiceService) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
    this.consultaTudo();
    
  }

  consultaTudo(){
    this.srv.consultaTudo().subscribe((resp: Livro[]) => {
      this.listaLivro = resp;
    });
  }
}
