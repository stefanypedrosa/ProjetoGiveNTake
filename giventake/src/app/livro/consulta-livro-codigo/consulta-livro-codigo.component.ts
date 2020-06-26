import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from 'src/app/model/Livro';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';

@Component({
  selector: 'app-consulta-livro-codigo',
  templateUrl: './consulta-livro-codigo.component.html',
  styleUrls: ['./consulta-livro-codigo.component.css']
})
export class ConsultaLivroCodigoComponent implements OnInit {
  livro:Livro = new Livro;
  id:number;
  constructor(private rota: ActivatedRoute, private srv: WeblistServiceService, private router: Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
    this.id = this.rota.snapshot.params["id"];
    this.srv.consulta(this.id).subscribe((res: Livro) => {
      this.livro = res;

    });
  }
  encerrar() {
    this.router.navigate(['/consultaLivro']);
  }
}
