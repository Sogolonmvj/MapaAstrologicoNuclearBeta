package Service;

import java.time.LocalDate;
import java.time.LocalTime;

public class Verificador {

    public static String verificar(LocalDate anoNasceu) {
        if (anoNasceu.isLeapYear()) {
            return "Sim!";
        } else {
            return "Não";
        }
    }

    public static Boolean isWithinRange(LocalTime horarioNascimento, LocalTime horarioInicio, LocalTime horarioFim) {
        return horarioNascimento.isAfter(horarioInicio) && horarioNascimento.isBefore(horarioFim);
    }

}
