package main.als.user.controller;

import main.als.apiPayload.ApiResult;
import main.als.user.dto.JoinDto;
import main.als.user.service.JoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public ApiResult<Void> join(JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        return ApiResult.onSuccess();

    }
}
