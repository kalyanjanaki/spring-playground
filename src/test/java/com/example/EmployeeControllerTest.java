package com.example;

import com.example.entities.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer20 on 4/22/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "boss",roles = {"MANAGER"})
public class EmployeeControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    public void testAdminEmployye() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/admin/employees");

        mvc.perform(request).andExpect(status().isOk());
    }
}
