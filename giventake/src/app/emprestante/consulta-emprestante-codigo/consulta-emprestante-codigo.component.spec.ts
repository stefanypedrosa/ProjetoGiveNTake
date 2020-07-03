import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaEmprestanteCodigoComponent } from './consulta-emprestante-codigo.component';

describe('ConsultaEmprestanteCodigoComponent', () => {
  let component: ConsultaEmprestanteCodigoComponent;
  let fixture: ComponentFixture<ConsultaEmprestanteCodigoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaEmprestanteCodigoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaEmprestanteCodigoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
