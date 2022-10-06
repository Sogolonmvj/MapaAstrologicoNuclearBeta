package Service;

import Model.MapaQuantico;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static Service.Signos.signo;
import static Service.Verificador.isWithinRange;

public class OperacaoesAstrologicas {
    public static MapaQuantico criarMapaQuantico(String nome, LocalDateTime dataHoraNascimento, ZoneId zonaNascimento) {
        Period period = Period.between(dataHoraNascimento.toLocalDate(), LocalDate.now());

        String idade = String.valueOf(period.getYears());

        String localNascimento = zonaNascimento.toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataHoraNascimentoFormatada = formatter.format(dataHoraNascimento);

        String anoBissexto = Verificador.verificar(dataHoraNascimento.toLocalDate());

        String signo = signo(dataHoraNascimento.toLocalDate());

        String ascendente;

        if (dataHoraNascimento.getYear() > 1976) {
            ascendente = ascendente(signo(dataHoraNascimento.toLocalDate()), dataHoraNascimento.toLocalTime().minusHours(2));
        } else if (dataHoraNascimento.getYear() > 1946 && dataHoraNascimento.getYear() < 1975) {
            ascendente = ascendente(signo(dataHoraNascimento.toLocalDate()), dataHoraNascimento.toLocalTime().minusHours(1));
        } else {
            ascendente = ascendente(signo(dataHoraNascimento.toLocalDate()), dataHoraNascimento.toLocalTime());
        }

        String signoLunar = signoLunar(dataHoraNascimento.toLocalTime(), zonaNascimento.toString());

        return new MapaQuantico(nome, idade, localNascimento, dataHoraNascimentoFormatada, anoBissexto, signo, ascendente, signoLunar);
    }

    public static String ascendente(String signo, LocalTime horarioNascimento) {
        if ("Aries".equalsIgnoreCase(signo)) {
            if (isWithinRange(horarioNascimento, LocalTime.of(18, 31), LocalTime.of(20,30))) {
                return "Escorpião";
            }
        } else if ("Sagitário".equalsIgnoreCase(signo)) {
            if (isWithinRange(horarioNascimento, LocalTime.of(18, 31), LocalTime.of(12, 30))) {
                return "Peixes";
            }
        }

        return "Não tem ascendente!";
    }

    public static String signoLunar(LocalTime time, String zona) {

        if (zona.contains("Recife")) {
            if (time.isAfter(LocalTime.NOON)) {
                return "Casimiro";
            }
        }

        if (zona.contains("Cuiaba")) {
            if (time.isBefore(LocalTime.NOON)) {
                return "Odin";
            }
        }

        if (zona.contains("São_Paulo")) {
            return "Gandalf";
        }

        return "Dinossauro";
    }
}
