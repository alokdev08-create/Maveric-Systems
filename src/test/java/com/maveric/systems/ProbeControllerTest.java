//package com.maveric.systems;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.maveric.systems.controller.ProbeController;
//
//public class ProbeControllerTest {
//	private MockMvc mockMvc;
//
//	@BeforeEach
//	public void setUp() {
//		ProbeController controller = new ProbeController();
//		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//	}
//	
//	@Test
//	public void testControlCommands() throws Exception {
//        mockMvc.perform(post("/api/probe/commands")
//                .content("FORWARD,LEFT,FORWARD,RIGHT")
//                .contentType("application/json"))
//            .andExpect(status().isOk())
//            .andExpect(content().string(org.hamcrest.Matchers.containsString("Position:")))
//            .andExpect(content().string(org.hamcrest.Matchers.containsString("Direction:")));
//    }
//}
