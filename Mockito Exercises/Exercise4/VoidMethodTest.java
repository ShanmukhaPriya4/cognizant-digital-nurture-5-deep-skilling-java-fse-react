package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class VoidMethodTest {

    @Test
    void testVoidMethod() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doNothing().when(mockApi)
                .sendNotification("Welcome");

        MyService service = new MyService(mockApi);

        service.notifyUser("Welcome");

        verify(mockApi)
                .sendNotification("Welcome");

    }

}
