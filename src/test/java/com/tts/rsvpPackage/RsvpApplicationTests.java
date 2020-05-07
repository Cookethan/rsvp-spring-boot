package com.tts.rsvpPackage;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tts.rsvpPackage.model.User;
import com.tts.rsvpPackage.repository.UserRepository;
import com.tts.rsvpPackage.service.UserServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class RsvpApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserRepository userRepo;
	
	@InjectMocks
	private UserServiceImpl mockUserService;
	
	@Mock
	private UserRepository mockUserRepo;
	
	@After
	public void tearDown() {
		userRepo.deleteAll();
	}
	
	@Test
	public void integrationTestUsingService() {
		User testUser = new User("Miles Davis", "Kinda@blue.com");
		
		userServiceImpl.saveUser(testUser);
		List<User> testUsers = userServiceImpl.findAllUsers();
		assertEquals(1, testUsers.size());
	}
	
	@Test
	public void unitTestUsingService() {
		User testUser = new User("Miles Davis", "Kinda@blue.com");
		
		Mockito.when(mockUserRepo.findUserById(1L)).thenReturn(testUser);
		
		User actual  = mockUserService.findUserById(1L);
				
		assertEquals(testUser, actual);
	}
	
	@Test
	public void validateUserEndPoint() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/users"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void validateEventEndPoint() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/events"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}


}
