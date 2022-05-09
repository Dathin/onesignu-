package io.github.dathin.onesignup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dathin.boot.dathinstarterauthorizer.model.user.UserToken;
import io.github.dathin.onesignup.model.data.DataExplained;
import io.github.dathin.onesignup.model.data.PatchDataRequest;
import io.github.dathin.onesignup.service.OneSignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OneSignup {

    private final OneSignupService oneSignupService;

    private final ObjectMapper objectMapper;

    public OneSignup(OneSignupService oneSignupService, ObjectMapper objectMapper) {
        this.oneSignupService = oneSignupService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<DataExplained>> getData(@RequestParam String[] data) {
        return ResponseEntity.ok(oneSignupService.getData(data));
    }


    @PatchMapping
    public ResponseEntity<Void> patchData(@RequestBody @Valid PatchDataRequest patchDataRequest) {
        try {
            var a = objectMapper.readValue("{\"iat\":1652059217,\"exp\":1652145617,\"userId\":19}", JsonNode.class);
            System.out.println(a);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        oneSignupService.patchData(patchDataRequest);
        return ResponseEntity.noContent().build();
    }

}
