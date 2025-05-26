package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.classesUteis.ConvercaoDataString;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AtividadeIVImpl implements AtividadeIV
{
    private AlunoRepository alunoRepository = new AlunoRepository();

    public List<Aluno> alunosPos2001(List<Aluno> alunos)
    {
        LocalDate filterData = LocalDate.of(2001, 02, 15);

        ConvercaoDataString dtst = new ConvercaoDataString();

        List<Aluno> alunosPos2001 = new ArrayList<>();

        for(Aluno aluno : alunos){
            if (dtst.stringParaData(aluno.getDataNascimento()).isAfter(filterData)){
                alunosPos2001.add(aluno);
            }
        }

        return alunosPos2001;
    }

    public Set<Aluno> alunosCad18(List<Aluno> alunos)
    {
        Set<Aluno> alunosCad18 = new HashSet<>();

        for(Aluno aluno : alunos){
            var horaCad = aluno.getDataHoraCadastro().getHour();

            if(horaCad > 18){
                alunosCad18.add(aluno);
            }
        }
        return alunosCad18;
    }

    public List<Aluno> alunosSemCurso(List<Aluno> alunos)
    {
        List<Aluno> alunosSemCurso = alunos.stream().filter(aluno -> aluno.getCurso() == null).toList();

        return alunosSemCurso;
    }

    public List<Aluno> alunosComCurso(List<Aluno> alunos){

        List<Aluno> alunosComCurso =  alunos.stream().filter(aluno -> !(aluno.getCurso() == null)).toList();

        return alunosComCurso;
    }

}
