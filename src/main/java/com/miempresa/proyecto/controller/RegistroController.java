package com.miempresa.proyecto.controller;

import com.miempresa.proyecto.service.CodigoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    private final CodigoService codigoService;

    public RegistroController(CodigoService codigoService) {
        this.codigoService = codigoService;
    }

    /*
     * Version anterior del método crearRegistro (sin validación de CUIT)
     * 
     * @PostMapping
     * public ResponseEntity<String> crearRegistro(@RequestBody String cuit) {
     * int nuevoCodigo = codigoService.generarNuevoCodigo(cuit);
     * return ResponseEntity.ok("Registro creado con código: " + nuevoCodigo);
     * }
     */

    @PostMapping
    public ResponseEntity<String> crearRegistro(@RequestBody String cuit) {
        // Eliminar todo lo que no sea número (Por ejemplo, guiones o espacios)
        String cuitLimpio = cuit.replaceAll("[^\\d]", "");

        // Verificar que tenga exactamente 11 dígitos(Solo verifica la longitud, no la
        // validez del CUIT)
        if (cuitLimpio.length() != 11) {
            return ResponseEntity.badRequest().body("CUIT inválido. Debe tener exactamente 11 dígitos.");
        }

        int nuevoCodigo = codigoService.generarNuevoCodigo(cuitLimpio);
        return ResponseEntity.ok("Registro creado con código: " + nuevoCodigo);
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<String> obtenerCuitPorCodigo(@PathVariable int codigo) {
        String cuit = codigoService.obtenerCuitPorCodigo(codigo);
        if (cuit != null) {
            return ResponseEntity.ok("CUIT asociado: " + cuit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró CUIT para el código ingresado: " + codigo);
        }
    }

    /* Metodo anterior sin limpieza del CUIT
     * @GetMapping("/cuit/{cuit}")
     * public ResponseEntity<String> obtenerCodigoPorCuit(@PathVariable String cuit)
     * {
     * int codigo = codigoService.obtenerCodigoPorCuit(cuit);
     * if (codigo != -1) {
     * return ResponseEntity.ok("Código asociado: " + codigo);
     * } else {
     * return ResponseEntity.status(HttpStatus.NOT_FOUND)
     * .body("No se encontró código para el CUIT ingresado: " + cuit);
     * }
     * }
     */

    @GetMapping("/cuit/{cuit}")
      public ResponseEntity<String> obtenerCodigoPorCuit(@PathVariable String cuit)
      {
      String cuitLimpio = cuit.replaceAll("[^\\d]", ""); // elimina todo lo que no sea número
      int codigo = codigoService.obtenerCodigoPorCuit(cuitLimpio);
      if (codigo != -1) {
      return ResponseEntity.ok("Código asociado: " + codigo);
      } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body("No se encontró código para el CUIT ingresado: " + cuit);
      }
      }

}
