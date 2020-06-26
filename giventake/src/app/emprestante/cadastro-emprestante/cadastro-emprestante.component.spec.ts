import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroEmprestanteComponent } from './cadastro-emprestante.component';

describe('CadastroEmprestanteComponent', () => {
  let component: CadastroEmprestanteComponent;
  let fixture: ComponentFixture<CadastroEmprestanteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastroEmprestanteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroEmprestanteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
