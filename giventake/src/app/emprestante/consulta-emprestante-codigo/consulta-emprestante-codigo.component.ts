import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';
import { Emprestante } from 'src/app/model/Emprestante';

@Component({
  selector: 'app-consulta-emprestante-codigo',
  templateUrl: './consulta-emprestante-codigo.component.html',
  styleUrls: ['./consulta-emprestante-codigo.component.css']
})
export class ConsultaEmprestanteCodigoComponent implements OnInit {
  emprestante:Emprestante = new Emprestante;
  id:number;
  constructor(private rota: ActivatedRoute, private srv: WeblistServiceService, private router: Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
    this.id = this.rota.snapshot.params["id"];
    this.srv.consultaE(this.id).subscribe((res: Emprestante) => {
      this.emprestante = res;

    });
  }
  encerrar() {
    this.router.navigate(['/consultaEmprestante']);
  }

}
