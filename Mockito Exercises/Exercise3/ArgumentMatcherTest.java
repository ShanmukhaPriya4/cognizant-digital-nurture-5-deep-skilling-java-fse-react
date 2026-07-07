package com.example;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ArgumentMatcherTest {

    @Test
    void testArgumentMatcher() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getUser(anyString()))
                .thenReturn("User Found");

        MyService service = new MyService(mockApi);

        service.fetchUser("Shan");

        verify(mockApi).getUser(anyString());

    }

}