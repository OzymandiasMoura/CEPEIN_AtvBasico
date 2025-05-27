package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import java.util.List;


public interface AtividadeV
{
    Aluno ultimoAlunoCadastrado(List<Aluno> aluno);
}
