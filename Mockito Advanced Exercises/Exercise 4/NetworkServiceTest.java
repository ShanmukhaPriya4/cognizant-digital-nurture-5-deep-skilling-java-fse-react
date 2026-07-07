package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NetworkServiceTest {

    @Test
    void testServiceWithMockNetworkClient() {

        NetworkClient mockClient = mock(NetworkClient.class);

        when(mockClient.connect()).thenReturn("Mock Connection");

        NetworkService networkService = new NetworkService(mockClient);

        String result = networkService.connectToServer();

        assertEquals("Connected to Mock Connection", result);

        verify(mockClient).connect();
    }
}