import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../model/Login';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login:Login = new Login;
  token:string;
  constructor(private router: Router) { }

  ngOnInit() {
    localStorage.removeItem("TOKEN");
  }

  validacao(){
    if(this.login.usuario == "giventake" && this.login.senha == "g1v3n1ak3"){
      this.token = "1234567890";
      localStorage.setItem("TOKEN", this.token);
      this.router.navigate(['home']);
    }
    else{
      alert("Usuario e/ou senha invalidos");
      this.login.senha == "";
    }
    
  }

}
