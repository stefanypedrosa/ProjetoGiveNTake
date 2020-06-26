import { Livro } from './Livro';
import { Emprestante } from './Emprestante';

export class Emprestimo{
    codEmprestimo:number;
    codLivro: Livro;
    codEmprestante: Emprestante;
    dataNasc:string;
    responsavel:string;
    dataDevolucao:string;
}