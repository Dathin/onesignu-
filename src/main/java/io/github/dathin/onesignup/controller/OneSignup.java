package io.github.dathin.onesignup.controller;

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

    public OneSignup(OneSignupService oneSignupService) {
        this.oneSignupService = oneSignupService;
    }

    @GetMapping
    public ResponseEntity<List<DataExplained>> getData(@RequestParam String[] data) {
        return ResponseEntity.ok(oneSignupService.getData(data));
    }


    @PatchMapping
    public ResponseEntity<Void> patchData(@RequestBody @Valid PatchDataRequest patchDataRequest) {
//        String userId = "625e15dd3f99da226dd54ef3";
        oneSignupService.patchData(patchDataRequest);
        return ResponseEntity.noContent().build();
    }

}
