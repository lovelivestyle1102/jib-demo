package com.utry.controller;

import com.utry.bean.StudentBean;
import com.utry.bean.StudentUpdateBean;
import com.utry.common.bean.CommonResponse;
import com.utry.dtos.StudentDTO;
import com.utry.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: yangchenglong
 * Date: 2020/8/31
 * Time: 3:12 下午
 * Description:
 */

@RestController public class StudentController {

    @Autowired private StudentService studentService;

    /**
     * 新增学生信息接口.
     *
     * @param student 学生信息bean
     * @return
     */
    @PostMapping(value = "/student",consumes = "application/json",produces = "application/json") @Operation(method = "POST", summary = "新增学生信息接口", description = "新增学生信息接口", responses = {
        @ApiResponse(responseCode = "2000", description = "请求成功！", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommonResponse.class)))}) public CommonResponse<Boolean> createStudent(@RequestBody
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "学生信息新增请求实体类", required = true, content = @Content(schema = @Schema(implementation = StudentBean.class)))
    @Valid StudentBean student) {

        boolean createResult = studentService.createStudent(student);

        return CommonResponse.buildSuccessBean(createResult);
    }

    /**
     * 根据编号查询学生信息.
     *
     * @param id 学生编号
     * @return
     */
    @Operation(method = "GET", summary = "学生信息查询接口", description = "根据学生编号查询学生信息接口", responses = {
        @ApiResponse(responseCode = "2000", description = "请求成功！", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = CommonResponse.class)))}) @GetMapping("/student/{id}")
    public CommonResponse<StudentDTO> selectStudent(@Parameter(name = "id", description = "学生编号", required = true) @PathVariable(value = "id") int id) {

        StudentDTO student = studentService.selectStudent(id);

        return CommonResponse.buildSuccessBean(student);
    }

    /**
     *
     * 更新学生信息接口.
     *
     * @param studentUpdateBean
     * @return
     */
    @Operation(method = "POST", summary = "学生信息更新接口", description = "学生信息更新接口", responses = {
        @ApiResponse(responseCode = "2000", description = "请求成功！", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = CommonResponse.class, description = "该次请求的结果为boolean", subTypes = {
                Boolean.class})))}) @PostMapping(value = "/student/update",consumes = "application/json",produces = "application/json")
    public CommonResponse<Boolean> updateStudent(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "学生信息更新请求实体类", required = true, content = @Content(schema = @Schema(implementation = StudentUpdateBean.class)))  @Valid StudentUpdateBean studentUpdateBean) {

        Boolean updateResult = studentService.updateStudent(studentUpdateBean);

        return CommonResponse.buildSuccessBean(updateResult);
    }

}