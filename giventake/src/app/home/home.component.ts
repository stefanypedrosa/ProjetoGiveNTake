import { Component, OnInit } from '@angular/core';
//import { WebListServiceService } from 'src/app/service/web-list-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(/*private srv: WebListServiceService,*/ private router:Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você precisa estar logado para acessar")
      this.router.navigate(['login']);
    }
  }

}
