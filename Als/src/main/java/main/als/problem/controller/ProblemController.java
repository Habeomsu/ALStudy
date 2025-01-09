package main.als.problem.controller;

import jakarta.validation.Valid;
import main.als.apiPayload.ApiResult;
import main.als.problem.dto.ProblemRequestDto;
import main.als.problem.dto.ProblemResponseDto;
import main.als.problem.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problems")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public ApiResult<List<ProblemResponseDto.AllProblemDto>> allProblems(){
        return ApiResult.onSuccess(problemService.getAllProblems());
    }


    @PostMapping
    public ApiResult<?> createProblem(@Valid @RequestBody ProblemRequestDto.createProblemDto createProblemDto) {
        problemService.createProblem(createProblemDto);
        return ApiResult.onSuccess();
    }

}
