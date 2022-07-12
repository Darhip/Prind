package com.example.Prind.Service;

import com.example.Prind.Domain.Prinad;
import com.example.Prind.Repository.RepositoryPrinad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicePrinad {
    private final RepositoryPrinad repositoryPrinad;

    public void save(Prinad prinad) throws IOException {
        repositoryPrinad.savePrinad(prinad);
    }
    public List<Prinad> readAll() throws IOException {
        return repositoryPrinad.findALL();
    }
    public Prinad readNumCheck(int snum) throws IOException {
        return repositoryPrinad.getBySerialNumber(snum);
    }
    public void updateCheck(Prinad prinad, int snum) throws IOException {
        repositoryPrinad.update(prinad, snum);
    }
    public void deleteCheck(int snum) throws IOException {
        repositoryPrinad.deleteByPrinad(snum);
    }
}