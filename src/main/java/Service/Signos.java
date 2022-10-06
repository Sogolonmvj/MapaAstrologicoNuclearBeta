package Service;

import java.time.LocalDate;
import java.time.MonthDay;

public class Signos {

    public static String signo(LocalDate dataNascimento) {

        MonthDay mesDiaNascimento = MonthDay.from(dataNascimento);

        MonthDay ariesInicio = MonthDay.of(3, 21);
        MonthDay ariesFim = MonthDay.of(4, 20);

        MonthDay touroInicio = MonthDay.of(4, 21);
        MonthDay touroFim = MonthDay.of(5, 20);

        MonthDay gemeosInicio = MonthDay.of(5, 21);
        MonthDay gemeosFim = MonthDay.of(6, 20);

        MonthDay cancerInicio = MonthDay.of(6, 21);
        MonthDay cancerFim = MonthDay.of(7, 20);

        MonthDay leaoInicio = MonthDay.of(7, 23);
        MonthDay leaoFim = MonthDay.of(8,22);

        MonthDay virgemInicio = MonthDay.of(8,23);
        MonthDay virgemFim = MonthDay.of(9,22);

        MonthDay libraInicio = MonthDay.of(9,23);
        MonthDay libraFim = MonthDay.of(10,22);

        MonthDay escorpiaoInicio = MonthDay.of(10,23);
        MonthDay escorpiaoFim = MonthDay.of(11,21);

        MonthDay sagitarioInicio = MonthDay.of(11,22);
        MonthDay sagitarioFim = MonthDay.of(12,21);

        MonthDay capricornioInicio = MonthDay.of(12,22);
        MonthDay capricornioFim = MonthDay.of(1, 20);

        MonthDay aquarioInicio = MonthDay.of(1, 21);
        MonthDay aquarioFim = MonthDay.of(2,19);

        MonthDay peixesInicio = MonthDay.of(2,19);
        MonthDay peixesFim = MonthDay.of(3,20);

        if (mesDiaNascimento.isAfter(ariesInicio) && mesDiaNascimento.isBefore(ariesFim)) {
            return "Aries";
        }

        if (mesDiaNascimento.isAfter(touroInicio) && mesDiaNascimento.isBefore(touroFim)) {
            return "Touro";
        }

        if (mesDiaNascimento.isAfter(gemeosInicio) && mesDiaNascimento.isBefore(gemeosFim)) {
            return "Gemeos";
        }

        if (mesDiaNascimento.isAfter(cancerInicio) && mesDiaNascimento.isBefore(cancerFim)) {
            return "Cancer";
        }

        if (mesDiaNascimento.isAfter(leaoInicio) && mesDiaNascimento.isBefore(leaoFim)) {
            return "Leao";
        }

        if (mesDiaNascimento.isAfter(virgemInicio) && mesDiaNascimento.isBefore(virgemFim)) {
            return "Virgem";
        }

        if (mesDiaNascimento.isAfter(libraInicio) && mesDiaNascimento.isBefore(libraFim)) {
            return "Libra";
        }

        if (mesDiaNascimento.isAfter(escorpiaoInicio) && mesDiaNascimento.isBefore(escorpiaoFim)) {
            return "Escorpiao";
        }

        if (mesDiaNascimento.isAfter(sagitarioInicio) && mesDiaNascimento.isBefore(sagitarioFim)) {
            return "Sagitario";
        }

        if (mesDiaNascimento.isAfter(capricornioInicio) && mesDiaNascimento.isBefore(capricornioFim)) {
            return "Capricornio";
        }

        if (mesDiaNascimento.isAfter(aquarioInicio) && mesDiaNascimento.isBefore(aquarioFim)) {
            return "Aquario";
        }

        if (mesDiaNascimento.isAfter(peixesInicio) && mesDiaNascimento.isBefore(peixesFim)) {
            return "Peixes";
        }

        return "Não tem signo!";
    }

}
