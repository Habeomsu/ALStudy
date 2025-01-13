package main.als.problem.controller;


import jakarta.validation.Valid;
import main.als.apiPayload.ApiResult;
import main.als.problem.dto.SubmissionRequestDto;

import main.als.problem.dto.SubmissionResponseDto;
import main.als.problem.service.SubmissionService;
import main.als.user.dto.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("/{groupProblemId}")
    public ApiResult<List<SubmissionResponseDto.AllSubmissionDto>> getSubmission(@PathVariable Long groupProblemId, @AuthenticationPrincipal CustomUserDetails UserDetails) {
        String username = UserDetails.getUsername();

        return ApiResult.onSuccess(submissionService.getAll(groupProblemId,username));
    }


    @PostMapping(value = "/{groupProblemId}",consumes = "multipart/form-data")
    public ApiResult<?> submit(@AuthenticationPrincipal CustomUserDetails UserDetails,
                               @RequestPart(value = "language" ) String language ,
                               @RequestPart(value = "file") MultipartFile file,
                               @PathVariable Long groupProblemId) {

        String username = UserDetails.getUsername();
        submissionService.submit(file,language, groupProblemId, username);
        return ApiResult.onSuccess();

    }

}
