import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { CadastroLivroComponent } from './livro/cadastro-livro/cadastro-livro.component';
import { ConsultaLivroComponent } from './livro/consulta-livro/consulta-livro.component';
import { CadastroEmprestanteComponent } from './emprestante/cadastro-emprestante/cadastro-emprestante.component';
import { ConsultaEmprestanteComponent } from './emprestante/consulta-emprestante/consulta-emprestante.component';
import { DevolucaoComponent } from './devolucao/devolucao.component';
import { EmprestimoComponent } from './emprestimo/emprestimo.component';
import { FormsModule } from '@angular/forms';
import { ConsultaLivroCodigoComponent } from './livro/consulta-livro-codigo/consulta-livro-codigo.component';
import { ConsultaEmprestanteCodigoComponent } from './emprestante/consulta-emprestante-codigo/consulta-emprestante-codigo.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    CadastroLivroComponent,
    ConsultaLivroComponent,
    CadastroEmprestanteComponent,
    ConsultaEmprestanteComponent,
    DevolucaoComponent,
    EmprestimoComponent,
    ConsultaLivroCodigoComponent,
    ConsultaEmprestanteCodigoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
