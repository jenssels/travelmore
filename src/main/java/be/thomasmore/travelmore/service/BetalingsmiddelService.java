package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Betalingsmiddel;
import be.thomasmore.travelmore.repository.BetalingsmiddelRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BetalingsmiddelService {
    @Inject
    BetalingsmiddelRepository betalingsmiddelRepository;

    public List<Betalingsmiddel> findAll(){
        return betalingsmiddelRepository.findAll();
    }
}
