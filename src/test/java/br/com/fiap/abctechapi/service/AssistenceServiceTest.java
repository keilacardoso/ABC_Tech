package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.repository.AssistenceRepository;
import br.com.fiap.abctechapi.service.imp.AssistanceServiceImp;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class AssistenceServiceTest {
    @Mock
    private AssistenceRepository assistenceRepository;
    private AssistanceService assistanceService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImp(assistenceRepository);
    }

    @DisplayName("Listando assistencias disponiveis :: sucesso")
    @Test
    public void list_success(){
        Assistance assistence1 = new Assistance(1L, "Mock Assistance 1", "Description 1");
        Assistance assistence2 = new Assistance(1L, "Mock Assistance 2", "Description 2");
        when(assistenceRepository.findAll()).thenReturn(List.of(assistence1, assistence2));

        List<Assistance> values = assistanceService.getAssistanceList();

        Assertions.assertEquals(values.size(), 2);
        Assertions.assertSame(values.get(0), assistence1);
        Assertions.assertSame(values.get(1), assistence2);
    }
    @DisplayName("Listando assistencias indisponiveis :: erro")
    @Test
    public void list_error(){
        when(assistenceRepository.findAll()).thenReturn((List.of()));

        List<Assistance> values = assistanceService.getAssistanceList();
        Assertions.assertEquals(0, values.size());
    }
}
