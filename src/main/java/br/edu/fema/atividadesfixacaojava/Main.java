package br.edu.fema.atividadesfixacaojava;

import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.*;

public class Main
{
    public static void main(String[] args)
    {
        AtividadeIV atv = new AtividadeIVImpl();
        AlunoRepository alunoRepository = new AlunoRepository();

        var alunos = alunoRepository.findAll();

        var alunosComCurso = atv.alunosComCurso(alunos);
        alunosComCurso.forEach(System.out::println);
    }

    public static void AtividadeIMain()
    {
        AtividadeI atv1  = new AtividadeIImpl();

        var alunosSet = atv1.returnListaAlunos();

        alunosSet.forEach(System.out::println);
    }

    public static void AtividadeIIIMain(){
        AtividadeIII atvIII = new AtividadeIIIImpl();

        //Nomes
        var nomes = atvIII.returnNomeAluno();
        nomes.forEach(System.out::println);

        //Data Nascimento
        var data = atvIII.returnNascimentoAluno();
        data.forEach(System.out::println);

        //Idade
        var idades = atvIII.returnIdadeAluno();
        idades.forEach(System.out::println);

    }

    public static void AtividadeIVMain()
    {
        AtividadeIV atv = new AtividadeIVImpl();
        AlunoRepository alunoRepository = new AlunoRepository();

        var alunos = alunoRepository.findAll();


        System.out.println("Alunos nascidos após 2001.");
        var alunos2001 = atv.alunosPos2001(alunos);
        alunos2001.forEach(System.out::println);

        System.out.println("Alunos cadastrados após 18h.");
        var alunos18H = atv.alunosCad18(alunos);
        alunos18H.forEach(System.out::println);

        System.out.println("Alunos sem curso.");
        var alunosSemCurso = atv.alunosSemCurso(alunos);
        alunosSemCurso.forEach(System.out::println);

        System.out.println("Alunos com curso.");
        var alunosComCurso = atv.alunosComCurso(alunos);
        alunosComCurso.forEach(System.out::println);
    }
}
