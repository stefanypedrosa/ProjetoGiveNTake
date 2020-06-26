import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaEmprestanteComponent } from './consulta-emprestante.component';

describe('ConsultaEmprestanteComponent', () => {
  let component: ConsultaEmprestanteComponent;
  let fixture: ComponentFixture<ConsultaEmprestanteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaEmprestanteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaEmprestanteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
