package com.consubanco.api.rest.integration.util;

import com.consubanco.MainApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MainApplication.class)
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
@AutoConfigureWireMock
public abstract class BaseIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper serializer;
}
