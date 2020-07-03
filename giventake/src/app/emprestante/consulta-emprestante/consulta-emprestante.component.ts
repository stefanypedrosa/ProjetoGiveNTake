import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WeblistServiceService } from 'src/app/service/weblist-service.service';
import { Emprestante } from 'src/app/model/Emprestante';


@Component({
  selector: 'app-consulta-emprestante',
  templateUrl: './consulta-emprestante.component.html',
  styleUrls: ['./consulta-emprestante.component.css']
})
export class ConsultaEmprestanteComponent implements OnInit {

  listaEmprestante:Array<Emprestante> = new Array();
  constructor(private router: Router, private srv: WeblistServiceService) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
    this.consultaTodos();
    
  }

  consultaTodos(){
    this.srv.consultaTodos().subscribe((resp: Emprestante[]) => {
      this.listaEmprestante = resp;
    });
  }

}
