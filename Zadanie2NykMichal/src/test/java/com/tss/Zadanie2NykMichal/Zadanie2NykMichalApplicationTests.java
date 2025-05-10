package com.tss.Zadanie2NykMichal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.info.BuildProperties;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
@AutoConfigureMockMvc        
class Zadanie2NykMichalApplicationTests {

        @MockBean
        private BuildProperties buildProperties;
        
        @Autowired
        private ApplicationController controller;
        
	@Test
	void contextLoads() {
            assertThat(controller).isNotNull();
        }
        
        @Autowired
        private MockMvc mockMvc;
        
        @Test
        void mainViewTest() throws Exception{
            
            this.mockMvc.perform(get("/"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("/views/index.jsp"))
                    .andExpect(model().attribute("applicationName", "Zadanie2NykMichal"));
        }

}
