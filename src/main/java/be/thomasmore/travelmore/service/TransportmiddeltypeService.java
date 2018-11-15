package be.thomasmore.travelmore.service;



import be.thomasmore.travelmore.domain.Transportmiddeltype;
import be.thomasmore.travelmore.repository.TransportmiddeltypeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TransportmiddeltypeService {
    @Inject
    private TransportmiddeltypeRepository transportmiddeltypeRepository;

    public List<Transportmiddeltype> findAll(){
        return transportmiddeltypeRepository.findAll();
    }
}
