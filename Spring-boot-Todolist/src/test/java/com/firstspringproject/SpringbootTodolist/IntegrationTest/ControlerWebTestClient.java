package com.firstspringproject.SpringbootTodolist.IntegrationTest;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControlerWebTestClient {
    @Autowired
    private WebTestClient webTestClient;


    @Test
    void createTask() {
        // given
        Task task = Task.builder().Message("No Sleep Early").Completed(false).build();
        // when
        Task result = this.webTestClient
                .post()
                .uri("/task")
                .bodyValue(task)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Task.class)
                .getResponseBody()
                .blockFirst();
        // then
        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("uuid")
                .isEqualTo(task);
    }


//
//    @Test
//    void createTask() {
//        this.webTestClient
//                .post()
//                .uri("/task")
//                .bodyValue("""
//                         {
//                        	"message": "No Sleep Early",
//                        	"completed":false
//
//                        }
//                        """)
//                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
//                .exchange()
//                .expectStatus()
//                .isOk();
//    }


    @Test
    void getTak(){
        this.webTestClient
                .get()
                .uri("/task")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk() ;

    }

}
