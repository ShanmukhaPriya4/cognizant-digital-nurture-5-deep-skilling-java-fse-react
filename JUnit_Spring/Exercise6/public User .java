public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
}

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.NoSuchElementException;

@Test
void testUserNotFound() {

    when(userRepository.findById(1L))
            .thenReturn(Optional.empty());

    assertThrows(NoSuchElementException.class,
            () -> userService.getUserById(1L));
}