package com.sapient.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LeagueControllerTest {
    @InjectMocks
    private LeagueControllerTest leagueControllerTest;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(leagueControllerTest).build();
    }

    @Test
    public void testGetLeagueStandings() throws Exception {

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/leaguestanding")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(" {\n" +
                            "   \t\"leagueId\":148,\n" +
                            "   \t\"countryId\":2,\n" +
                            "   \t\"teamId\":3,\n" +
                            "   \t\"leagueName\":\"test\",\n" +
                            "   \t\"countryName\":\"test\",\n" +
                            "   \t\"teamName\":\"test\"\n" +
                            "   }")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print());
        }

    @Test
    public void testGetLeagueStandingsFail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/leaguestanding")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" {\n" +
                        "   \t\"countryId\":2,\n" +
                        "   \t\"teamId\":3,\n" +
                        "   \t\"leagueName\":\"test\",\n" +
                        "   \t\"countryName\":\"test\",\n" +
                        "   \t\"teamName\":\"test\"\n" +
                        "   }")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

}
