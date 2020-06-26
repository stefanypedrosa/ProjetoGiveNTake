import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaLivroCodigoComponent } from './consulta-livro-codigo.component';

describe('ConsultaLivroCodigoComponent', () => {
  let component: ConsultaLivroCodigoComponent;
  let fixture: ComponentFixture<ConsultaLivroCodigoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaLivroCodigoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaLivroCodigoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
