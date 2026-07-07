@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found");
    }
}
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Test
void testExceptionHandler() throws Exception {

    when(userService.getUserById(1L))
            .thenThrow(new NoSuchElementException());

    mockMvc.perform(get("/users/1"))
            .andExpect(status().isNotFound())
            .andExpect(content().string("User not found"));
}