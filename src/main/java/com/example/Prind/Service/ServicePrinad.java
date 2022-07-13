package com.example.Prind.Service;

import com.example.Prind.Domain.Prinad;
import com.example.Prind.Repository.RepositoryPrinad;
import com.example.Prind.exceptionhandler.exceptions.SerialNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicePrinad {
    private final RepositoryPrinad repositoryPrinad;

    public void save(Prinad prinad) throws IOException, SerialNotFoundException {
        if (repositoryPrinad.isExistPrinadBySnum(prinad.getSerialNum())) {
            throw new SerialNotFoundException(String.format("Prinad with serial: %s is already exist", prinad.getSerialNum()));
        }
        repositoryPrinad.savePrinad(prinad);
    }
    public List<Prinad> readAll() throws IOException {
        return repositoryPrinad.findALL();
    }
    public Prinad readSerNum(int snum) throws IOException, SerialNotFoundException {
        if (!repositoryPrinad.isExistPrinadBySnum(snum)) {
            throw new SerialNotFoundException(String.format("Prinad with serial: %s doesn't exist", snum));
        }
        return repositoryPrinad.getBySerialNumber(snum);
    }
    public void updatePrinad(Prinad prinad, int snum) throws IOException, SerialNotFoundException {
        if (!repositoryPrinad.isExistPrinadBySnum(snum)) {
            throw new SerialNotFoundException(String.format("Prinad with serial: %s doesn't exist", snum));
        }
        repositoryPrinad.update(prinad, snum);
    }
    public void deletePrinad(int snum) throws IOException, SerialNotFoundException {
        if (!repositoryPrinad.isExistPrinadBySnum(snum)) {
            throw new SerialNotFoundException(String.format("Prinad with serial: %s doesn't exist", snum));
        }
        repositoryPrinad.deleteByPrinad(snum);
    }

    public int getPrinadsCount() throws IOException {
        return repositoryPrinad.findALL().size();
    }

}