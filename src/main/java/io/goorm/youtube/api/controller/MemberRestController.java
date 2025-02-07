package io.goorm.youtube.api.controller;

import io.goorm.youtube.service.MemberService;
import io.goorm.youtube.vo.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{memberId}/duplicate")
    public ResponseEntity<?> duplicateMemberId(@PathVariable("memberId") String memberId) {
        log.info("중복체크");
        Map<String,String> res = new HashMap<>();

        if (memberService.existsById(memberId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("");
//            return ResponseEntity.status(HttpStatus.CONFLICT).ok().build();
        }

        return ResponseEntity.ok(res);
    }


}
