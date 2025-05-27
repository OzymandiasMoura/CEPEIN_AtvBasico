package br.edu.fema.atividadesfixacaojava;

import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.*;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        AtividadeVMain();
    }

    public static void AtividadeIMain()
    {
        AtividadeI atv1  = new AtividadeIImpl();

        var alunosSet = atv1.returnListaAlunos();

        alunosSet.forEach(System.out::println);
    }
    public static void AtividadeIIIMain()
    {
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

        System.out.println("Alunos com curso matutino e com mais de 30 anos.");
        var alunosMatutino30 = atv.alunosMatutino30(alunos);
        alunosMatutino30.forEach(System.out::println);

        System.out.println("Primeiro aluno de 2021.");
        var aluno = atv.primeiroDe2021(alunos);
        System.out.println(aluno);
    }
    public static void AtividadeIV7Main()
    {
        AtividadeIV atv7 = new AtividadeIVImpl();
        AlunoRepository alunoRepository = new AlunoRepository();
        var alunos = alunoRepository.findAll();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o mes:");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o dia:");
        int dia = Integer.parseInt(sc.nextLine());

        var aluno = atv7.encontrarAlunos(dia, mes, alunos);

        aluno.forEach(System.out::println);
    }
    public static void AtividadeVMain()
    {
        System.out.println("Ultimo aluno cadastrado.");

        AtividadeV atvV = new AtividadeVImpl();
        AlunoRepository alunoRepository = new AlunoRepository();
        var alunos = alunoRepository.findAll();

        var ultimoAlunoCadastrado = atvV.ultimoAlunoCadastrado(alunos);
        System.out.println(ultimoAlunoCadastrado);

    }
}
