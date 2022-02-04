package com.nugrohosamiyono.studyjam.application.controllers.v1;

import javax.validation.Valid;

import com.nugrohosamiyono.studyjam.application.request.v1.UserCreate;
import com.nugrohosamiyono.studyjam.application.request.v1.UserUpdate;
import com.nugrohosamiyono.studyjam.application.response.ResponseGlobal;
import com.nugrohosamiyono.studyjam.presist.usecases.UserUseCase;
import com.nugrohosamiyono.studyjam.utility.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserUseCase useCase;

    @GetMapping
    public ResponseEntity<ResponseGlobal> index() {
        var data = useCase.getAll();
        return Response.buildV1(data);
    }

    @PostMapping
    public ResponseEntity<ResponseGlobal> create(
        @Valid @RequestBody UserCreate userCreate) throws Exception {        
        useCase.createUser(userCreate);
        return Response.buildV1("Success create user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGlobal> update(@PathVariable Long id,
    @RequestBody UserUpdate userUpdate) throws Exception {
        useCase.updateUser(id, userUpdate);
        return Response.buildV1("Success update user");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseGlobal> delete(@PathVariable Long id) throws Exception {
        useCase.deleteUser(id);
        return Response.buildV1("Success delete user");
    }

}
