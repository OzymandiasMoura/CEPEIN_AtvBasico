package br.edu.fema.atividadesfixacaojava.services.utilities;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class ConvercaoDataString
{
    public LocalDate stringParaData(String dataString){

        int day = parseInt(dataString.substring(0, 2));
        int month = parseInt(dataString.substring(3, 5));
        int year = parseInt(dataString.substring(6));
        LocalDate data = LocalDate.of(year, month, day);

        return data;
    }

    public String dataParaString(LocalDate data)
    {
        return data.toString();
    }
}
