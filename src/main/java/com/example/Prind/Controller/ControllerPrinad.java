package com.example.Prind.Controller;

import com.example.Prind.Domain.Prinad;
import com.example.Prind.Service.ServicePrinad;
import com.example.Prind.exceptionhandler.exceptions.SerialNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/prinads")
@AllArgsConstructor
public class ControllerPrinad {
    private final ServicePrinad servicePrinad;

    @PostMapping()
    public ResponseEntity<?> savedCheck(@RequestBody Prinad prinad) throws IOException, SerialNotFoundException {
        servicePrinad.save(prinad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read")
    public List<Prinad> readChecks() throws IOException {
        return servicePrinad.readAll();
    }

    @GetMapping(value = "/{snum}")
    public ResponseEntity<Prinad> readNum(@PathVariable(name = "snum") int snum) throws IOException, SerialNotFoundException {
        final Prinad prinad = servicePrinad.readSerNum(snum);
        return prinad != null
                ? new ResponseEntity<>(prinad, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{snum}")
    public ResponseEntity<?> updatePrinad(@PathVariable(name = "snum") int snum, @RequestBody Prinad prinad) throws IOException, SerialNotFoundException {
        servicePrinad.updatePrinad(prinad, snum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{snum}")
    public ResponseEntity<?> deletePrinad(@PathVariable(name = "snum") int snum) throws IOException, SerialNotFoundException {
        servicePrinad.deletePrinad(snum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/information")
    public String getInformation() throws IOException {
        return String.format("Проект выполнила Юлия Панкова группа УВА-211. Количество сущностей: %s", servicePrinad.getPrinadsCount());
    }
}