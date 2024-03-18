//package io.aadeesh;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class UserRegistration1ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}

package io.shraddha;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;




public class UserRegistration1ApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
//	
//	 // Replace with your actual base URL
//
//
//	
//	@Test
//	public void SpringsecurityCustomLoginApplicationTestsMethod() {
//		
//		System.out.print("executing junit text cases");
//	}
//	
//	private final String baseUrl = "http://localhost:8080";
//	
//    @Test
//    void testLoginEndpointReturns200() {
//        String loginEndpoint = "/login"; // Replace with your actual login endpoint
//
//        String url = baseUrl + loginEndpoint;
//
//        try {
//            ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(url, String.class);
//
//            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//            assertTrue(responseEntity.getBody() != null && !responseEntity.getBody().isEmpty());
//        } catch (HttpClientErrorException ex) {
//            // If an exception is thrown due to non-200 status, fail the test
//            assertEquals(HttpStatus.OK, ex.getStatusCode()); // Adjust as needed
//        }
//    }
//
//    @Test
//    void testValidLogin() throws Exception {
//        // Replace "validUsername" and "validPassword" with actual valid credentials
//        String validUsername = "aadeeshjain.91a@yahoo.com";
//        String validPassword = "abcd@234";
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/login")
//                .param("username", validUsername)
//                .param("password", validPassword))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(result -> {
//                    // Print the request details
//                    System.out.println("Request: " + result.getRequest().getMethod() + " " + result.getRequest().getRequestURI());
//                    System.out.println("Status: " + result.getResponse().getStatus());
//                });
//    }
// 
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
