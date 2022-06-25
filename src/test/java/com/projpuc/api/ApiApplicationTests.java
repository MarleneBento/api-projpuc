package com.projpuc.api;

import com.projpuc.api.model.Perfil;
import com.projpuc.api.repository.PerfilRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class ApiApplicationTests {

	@Test
	void helloWorldMockito() {
			PerfilRepositorio mock= Mockito.mock(PerfilRepositorio.class);
			List<Perfil> todos = mock.findAll();
			Assert.isTrue(todos.isEmpty());
		}
}
