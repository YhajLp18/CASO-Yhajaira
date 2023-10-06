package com.proyecto.demo.controller;
import com.proyecto.demo.entity.Libros;


import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.service.impl.ServiceimplLibros;

@RestController
@RequestMapping("/api/LIBROS")
@CrossOrigin(origins = "*")


public class ControllerLibros {

    @Autowired
    @Qualifier("librosServiceImpl")

    private ServiceimplLibros librosService;

    //Listar Libros
        @GetMapping(path="/list", produces = {"application/json"})
        public List<Libros> listLibros(){

            return librosService.listAllLibros();

        }

         @GetMapping(path="/get/{id}", produces = {"application/json"})
        public Optional<Libros> getLibros(@PathVariable String id){

            return librosService.findByIdLibros(id);

        }

         @PutMapping(path="/update/{id}", produces = {"application/json"})
        public Libros updLibros(@RequestBody Libros libros ){

            return librosService.updateLibros(libros);

        }

        //Eliminar Libro
        @DeleteMapping(path="/delete/{id}")
        public int delLibros(@PathVariable String id ){

            return librosService.removeLibros(id);

        }


        //Añadir Libro
        @PostMapping(path="/add", produces = {"application/json"})

        public Libros newLibros(@RequestBody Libros libros ){
            try {
                return librosService.addLibros(libros);
            }catch (Error e){
                System.out.println("El error es:" + e);
            }
            return null;

        }






    
}
