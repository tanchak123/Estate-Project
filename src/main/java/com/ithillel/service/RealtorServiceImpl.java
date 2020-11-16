package com.ithillel.service;

import com.ithillel.dao.interfaces.RealtorDao;
import com.ithillel.model.EstateAgency;
import com.ithillel.model.RealProperty;
import com.ithillel.model.Realtor;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealtorServiceImpl extends GenericServiceImpl<Realtor, Long> implements RealtorService {

    RealtorDao realtorDao;

    @Autowired
    public RealtorServiceImpl(RealtorDao realtorDao) {
        super(realtorDao);
        this.realtorDao = realtorDao;
    }


//    @Override
//    @Transactional
//    public Realtor delete(Realtor realtor) {
//        realtor = getById(realtor.getId());
//        clearEstateAgencies(realtor.getEstateAgencyList(), realtor);
//        clearRealProperties(realtor.getRealPropertyList(), realtor);
//        System.out.println("TRUE DELETE");
//        return realtorDao.delete(realtor);
//    }
//
//    private void clearEstateAgencies(List<EstateAgency> estateAgencies, Realtor realtor) {
//        for (EstateAgency eA : estateAgencies) {
//            List<Realtor> realtorList = eA.getRealtorList();
//            List<Realtor> result = new ArrayList<>();
//            for (Realtor rl : realtorList) {
//                if (!rl.getId().equals(realtor.getId())) {
//                    result.add(rl);
//                }
//            }
//            eA.setRealtorList(result);
//        }
//    }
//
//
//    private void clearRealProperties(List<RealProperty> realPropertyList, Realtor realtor) {
//        for (RealProperty realProperty : realPropertyList) {
//            List<Realtor> realtors = realProperty.getRealtors();
//            List<Realtor> result = new ArrayList<>();
//            for (Realtor rp : realtors) {
//                if (!rp.getId().equals(realtor.getId())) {
//                    result.add(rp);
//                }
//            }
//            realProperty.setRealtors(result);
//        }
//    }
}
