import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {HomeComponent}  from './home/home.component';
import {LoginComponent} from './login/login.component';
import {CadastroEmprestanteComponent}  from './emprestante/cadastro-emprestante/cadastro-emprestante.component';
import {ConsultaEmprestanteComponent}  from './emprestante/consulta-emprestante/consulta-emprestante.component';
import {CadastroLivroComponent} from  './livro/cadastro-livro/cadastro-livro.component';
import {ConsultaLivroComponent} from './livro/consulta-livro/consulta-livro.component';
import {EmprestimoComponent} from './emprestimo/emprestimo.component';
import {DevolucaoComponent} from './devolucao/devolucao.component';
import {ConsultaLivroCodigoComponent} from './livro/consulta-livro-codigo/consulta-livro-codigo.component';


const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home', component:HomeComponent},
  {path: 'cadastroLivro', component:CadastroLivroComponent},
  {path: 'consultaLivro', component:ConsultaLivroComponent},
  {path: 'cadastroEmprestante', component:CadastroEmprestanteComponent},
  {path: 'consultaEmprestante', component: ConsultaEmprestanteComponent},
  {path: 'emprestimo', component: EmprestimoComponent},
  {path: 'devolucao', component: DevolucaoComponent},
  {path: 'login', component: LoginComponent},
  {path: 'consultaLivroCodigo/:id', component: ConsultaLivroCodigoComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
