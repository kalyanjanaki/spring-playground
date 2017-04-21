package com.example;

import com.example.utils.OMDBService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by trainer20 on 4/17/17.
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(secure = false)
public class RestTemplateControllerTest {

    @Test
    public void testMovies() throws IOException {
        OMDBService mservice = new OMDBService();

        MockRestServiceServer mockServer = MockRestServiceServer.createServer(mservice.getRestTemplate());
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/samplejson")));

        mockServer.expect(requestTo("http://www.omdbapi.com/?s=harry"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(content,MediaType.APPLICATION_JSON));

        assertThat(mservice.getOMDB("harry"),equalTo(content));
        mockServer.verify();
    }
}
