package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendadorDePagamentos {
    private List<PagamentoProgramado> agendamentos = new ArrayList<>();

    public void agendar(PagamentoProgramado pagamento) {
        agendamentos.add(pagamento);
    }

    public void simular(LocalDateTime agora, Conta conta) {
        for (PagamentoProgramado pagamento : agendamentos) {
            if (!pagamento.isExecutado() && pagamento.getDataHora().isBefore(agora)) {
                pagamento.executar(conta);
            }
        }
    }

    public List<PagamentoProgramado> getAgendamentos() {
        return agendamentos;
    }
}