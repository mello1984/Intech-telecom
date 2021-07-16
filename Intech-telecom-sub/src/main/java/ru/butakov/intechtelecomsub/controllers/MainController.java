package ru.butakov.intechtelecomsub.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.butakov.intechtelecomsub.aop.Loggable;
import ru.butakov.intechtelecomsub.domain.ChatMessageDto;
import ru.butakov.intechtelecomsub.exceptions.RequestException;
import ru.butakov.intechtelecomsub.service.MainService;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Loggable
public class MainController {
    MainService service;

    @PostMapping("/")
    public ResponseEntity<Object> handleChatMessage(@RequestBody ChatMessageDto dto) {
        var o = service.parseAndSave(dto);
        return ResponseEntity.ok(o);
    }

    @ExceptionHandler(value = {RequestException.class})
    protected ResponseEntity<Object> handleRequestException(RequestException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
