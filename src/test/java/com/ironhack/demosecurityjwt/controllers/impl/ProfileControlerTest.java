package com.ironhack.demosecurityjwt.controllers.impl;

import com.ironhack.demosecurityjwt.models.profile.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import com.ironhack.demosecurityjwt.models.profile.Enquiry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileControlerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetProfileById() throws Exception {
        long profileId = 1;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/profile/{id}", profileId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }
    @Test
    @WithMockUser(username = "user3", password = "Abc123@")
    public void testUpdateProfile() throws Exception {
        long profileId = 1;
        Profile profile = new Profile();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/profile/{id}/edit", profileId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("..."))
                .andReturn();

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }
@Test
    @WithMockUser(username = "user3", password = "Abc123@")
    public void testAddEnquiry() throws Exception {
        long profileId = 1;
        Enquiry enquiry = new Enquiry();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/profile/{id}/enquiry", profileId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("..."))
                .andReturn();
        Assertions.assertEquals(201, mvcResult.getResponse().getStatus());
    }
    @Test
    @WithMockUser(username = "user3", password = "Abc123@")
    public void testGetAllEnquiries() throws Exception {
        long profileId = 1;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/profile/{id}/enquiry", profileId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }
    @Test
    @WithMockUser(username = "user3", password = "Abc123@")
    public void testDeleteEnquiry() throws Exception {
        long profileId = 1;
        long enquiryId = 1;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/profile/{profileId}/enquiry/{enquiryId}", profileId, enquiryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(204, mvcResult.getResponse().getStatus());
    }
}